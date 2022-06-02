#include <iostream>
using namespace std;
static int buffDefend = 0;
static int num_brawler = 0;
static int num_technology = 0;
static int num_attacker = 0;

class Champion {
public:
    int attack;
    int defend;
    int level;
    int price;
    string name;
    bool isBrawler = false;
    virtual void activeGrant() = 0;
    virtual float calculatingDamage(int m) = 0;
    void buffDefend(int _defend) {
        if (this->isBrawler) this->defend += _defend;
    }

    void Input() {
        cin >> attack >> defend;
    }
    void Ouput(int m) {
        cout << this->name << " - sat thuong gay ra: " << this->calculatingDamage(m) << endl;
    }
};


class Attacker : public Champion {
public:

    void activeGrant() {
        if (num_attacker == 2) attack += 30;
    }

    float calculatingDamage(int m) {
        if (name == "Reksai") {
            float totalDamage = 0;
            for (int i = 1; i <= m; i++) {
                if (i % 4 == 0) {
                    totalDamage += this->attack * 2;
                }
                else {
                    totalDamage += this->attack;
                }
            }
            return totalDamage;
        }
        if (name == "Illaoi") {
            return (float)(attack + defend) / 2 * m;
        }
        
        return 0;
    }
};

class Technology : public Champion {
public:
    
    void activeGrant() {
        if (num_technology == 2) {
            
            this->attack += 15;
            this->defend += 15;
        }
    }
    float calculatingDamage(int m) { 
        if (name == "Jarvan") {
            return m * this->defend * 2;
        }
        if (name == "Sivir") {
            return m * this->attack * 2;
        }
        return 0;
    }
};


void activeType() {
        
        if (num_brawler == 2) {
            buffDefend += 15;
        }
        if (num_brawler == 3) {
            buffDefend += 30;
        }
    }


class Jarvan : public Technology {
public:
    Jarvan() { 
        this->price = 1; 
        this->isBrawler = true; 
        this->name = "Jarvan";

    }

    
};

class Reksai : public Attacker {
public:
    Reksai() {
        this->price = 2; 
        this->isBrawler = true;
        this->name = "Reksai";

    }

    
};


class Sivir : public Technology {
public:
    Sivir() { 
        this->price = 4; 
        this->isBrawler = false;
        this->name = "Sivir";
    }

};

class Illaoi : public Attacker {
public:
    Illaoi() {
        this->price = 1;
        this->isBrawler = true;
        this->name = "Illaoi";

    }
};


int main() {

    int n, m;
    int totalMoney = 0;
    cin >> n >> m;
    bool hasJarvan = false, hasReksai = false, hasSivir = false, hasIllaoi = false;
    Champion** champs = new Champion * [n];
    for (int i = 0; i < n; i++) {
        int type; cin >> type;
        if (type == 1) {
            champs[i] = new Jarvan;
            if (!hasJarvan) {
                num_technology += 1;
                num_brawler += 1;
                hasJarvan = true;
            }
        }
        if (type == 2) {
            champs[i] = new Reksai;
            if (!hasReksai) {
                num_attacker += 1;
                num_brawler += 1;
                hasReksai = true;
            }
        
        }
        if (type == 3) {
            champs[i] = new Sivir;
            if (!hasSivir) {
                num_technology += 1;
                hasSivir = true;
            }
            
        }
        if (type == 4) {
            champs[i] = new Illaoi;
            if (!hasIllaoi) {
                num_attacker += 1;
                num_brawler += 1;
                hasIllaoi = true;
            }
            
        }
        champs[i]->Input();
    }

    activeType();
    for (int i = 0; i < n; i++) {
        champs[i]->activeGrant();
        champs[i]->buffDefend(buffDefend);
    }
    for (int i = 0; i < n; i++) {
        champs[i]->Ouput(m);
        totalMoney += champs[i]->price;
    }
    cout << "Tong gia tri: " << totalMoney << endl;

    return 0;
}