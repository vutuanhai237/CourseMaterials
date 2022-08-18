#include <iostream>
#include <string>
#include <algorithm> 
#include <vector>
static int numberOfHuman = 0;
static int numberOfDevil = 0;

using namespace std;
class Champion {
public:
	int type;
	string name;
	float currentHP;
	float HP;
	float ATK;
	float DEF;
	virtual void Input() {
		cin >> name >> HP >> ATK >> DEF;
		currentHP = HP;
	}

	void Output() {
		cout << name << " " << currentHP << endl;
	}

	virtual void Buff() { };
};

class Human : public Champion {
public:
	string jobClass;
	Human() { type = 1; numberOfHuman++; }
	void Input() {
		Champion::Input();
		cin >> jobClass;
	}
};

class Elf : public Human {
public:
	string jobClass;
	Elf() { type = 2; }
	void Buff() { this->DEF *= 1.5; }
};

class HybridHuman : public Champion {
public:
	string racialClass;
	HybridHuman() { }
	void Input() {
		Champion::Input();
		cin >> racialClass;
	}
};

class Orc : public HybridHuman {
public:
	Orc() { type = 3; }
	void Buff() { this->HP *= 1.5; }
};

class Golbin : public HybridHuman {
public:
	Golbin() { type = 4; }
	void Buff() { this->ATK *= 1.1; }
};

class Vampire : public Champion {
public:
	Vampire() { type = 5; }
	void Buff() { this->HP *= (1 + 0.1*numberOfHuman); }
};

class Devil : public Champion {
public:
	Devil() { type = 6; numberOfDevil++; }
	void Buff() { 
		this->ATK *= (1 + 0.1 * (numberOfDevil - 1));
		this->DEF *= (1 + 0.1 * (numberOfDevil - 1));
	}
};

bool compareHP(Champion* c1, Champion* c2)
{
	return (c1->HP < c2->HP);
}

int main() {
	int n;
	cin >> n;
	vector<Champion*> champions;
	for (int i = 0; i < n; i++) {
		int type; cin >> type;
		Champion* temp = new Champion;
		switch (type) {
		case 1:
			temp = new Human;
			break;
		case 2:
			temp = new Elf;
			break;
		case 3:
			temp = new Orc;
			break;
		case 4:
			temp = new Golbin;
			break;
		case 5:
			temp = new Vampire;
			break;
		case 6:
			temp = new Devil;
			break;
		}
		temp->Input();
		
		champions.push_back(temp);
	}
	for (int i = 0; i < champions.size(); i++) {
		champions[i]->Buff();
	}

	sort(champions.begin(), champions.end(), compareHP);
	
	Champion* boss = new Champion;
	boss->Input();

	while (true) {
		float sumATK = 0;
		for (int i = 0; i < champions.size(); i++) {
			sumATK += champions[i]->ATK;
		}
		// Attack boss
		boss->currentHP -= (sumATK - boss->DEF) > 0 ? (sumATK - boss->DEF) : 0;
		if (boss->currentHP <= 0) {
			for (int i = 0; i < champions.size(); i++) {
				champions[i]->Output();
			}
			return 0;
		}
		
		// Boss attack
		champions[0]->currentHP -= (boss->ATK - champions[0]->DEF) > 0 ? (boss->ATK - champions[0]->DEF) : 0;
		
		if (champions[0]->currentHP <= 0) {
			champions.erase(champions.begin());
		}

		if (champions.size() == 0) {
			boss->Output();
			return 0;
		}
	}

	return 0;
}