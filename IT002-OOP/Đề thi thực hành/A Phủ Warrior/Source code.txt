#include <iostream>
#include <string>

using namespace std;

static int maxhp = 0;
static int current_hp = 0;
class Weapon {
public:
    float damage;
    int num_turns;
    virtual void Input() {
        cin >> damage >> num_turns;
    }
    virtual float CalculatingDamage() = 0;

};
class Sword: public Weapon {
public:
    float length;
    void Input() {
        Weapon::Input();
        cin >> length;
    }
    float CalculatingDamage() {
        num_turns -= 1;
        return (float) damage * length;
    }
};

class Archie : public Weapon {
public:
    int num_arrows;
    void Input() {
        Weapon::Input();
        cin >> num_arrows;
    }
    float CalculatingDamage() {
        num_turns -= 2;
        return damage * num_arrows / 2;
    }
};

class Nothing : public Weapon {
public:
    Nothing() {
        this->num_turns = 10000000;
    }
    float CalculatingDamage() {
        current_hp -= (float)maxhp * 0.1;
        return maxhp % 10;
    }
};

class Animal {
public:
    float hp;
    float damage;
    bool status;

    void DecreaseHP(float _deHP) {
        hp -= _deHP;
    }

    virtual float CalculatingDamage() {
        return damage;
    }

    virtual void Input() {
        cin >> hp >> damage;
    }

    virtual void CheckDie() {
        if (hp <= 0) status = false;
        else status = true;
    }
};


class Boson: public Animal {
public:
    int num_turns;
    void Input() {
        Animal::Input();
        cin >> num_turns;
    }
    void CheckDie() {
        this->num_turns -= 1;
        if (this->num_turns <= 0 || this->hp <= 0) this->status = false;
        else this->status = true;
    }
};

class Tiger : public Animal {
public:
    

    float CalculatingDamage() {
        return (float) this->damage * 1.5;
    }
};


int main () {
    cin >> maxhp;
    current_hp = maxhp;
    int n; cin >> n;
    int indexWeapon = 0; 
    Weapon** weapons = new Weapon * [n + 1];
    for (int i = 0; i < n; i++) {
        int loai; cin >> loai;
        if (loai == 1) {
            weapons[i] = new Sword;
        }

        if (loai == 2) {
            weapons[i] = new Archie;
        }
        
        weapons[i]->Input();

    }
    weapons[n] = new Nothing;
    int m; cin >> m;
    Animal** animals = new Animal * [m];
    for (int i = 0; i < m; i++) {
        int loai; cin >> loai;
        if (loai == 1) animals[i] = new Boson;
        if (loai == 2) animals[i] = new Tiger;
        animals[i]->Input();
    }

    int indexAnimal = 0;
    if (m == 0) {
        cout << "A Phu chien thang, hp con lai: " << current_hp << ", so vu khi con lai: " << (n - indexWeapon) << endl;
        return 0;
    }
    while (indexAnimal < m && indexWeapon < n + 1 && current_hp > 0) {
        float damage = weapons[indexWeapon]->CalculatingDamage();
        if (weapons[indexWeapon]->num_turns <= 0) {
            indexWeapon++;
        }

        
        animals[indexAnimal]->DecreaseHP(damage);
        animals[indexAnimal]->CheckDie();
        if (animals[indexAnimal]->status) {
            current_hp -= animals[indexAnimal]->CalculatingDamage();
        }
        else {
            indexAnimal++;
        }

        if (current_hp <= 0) {
            cout << "A Phu that bai, so thu du con lai: " << (m - indexAnimal) << endl;
            break;
        }

        if (indexAnimal == m) {
            cout << "A Phu chien thang, hp con lai: " << current_hp << ", so vu khi con lai: " << (n - indexWeapon) << endl;
            break;
        }    
    }
    return 0;
}