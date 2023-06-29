#include <iostream>
#include <vector>
using namespace std;
static float totalPrice = 0;
class Clothes {
public:
    string name;
    string type;
    string producer;
    float price;
    virtual void Input() {
        cin >> name >> price >> producer;
    }

    string getType() {
        return type;
    }

    void setPrice(float _price) {
        price = _price;
    }
    virtual float getPrice() {
        return price;
    }
};

class Pant : public Clothes {
public:
    float length;
    Pant() {
        this->type = "pant";
    }
    void Input() {
        Clothes::Input();
        cin >> length;
    }
};

class JeanPant : public Pant {
public:
    float getPrice() {
        return price * 0.8;
    }
};

class Kaki : public Pant {
public:
    float getPrice() {
        return price * 1.5;
    }
};

class Skirt : public Clothes {
public:
    string color;
    Skirt() {
        this->type = "skirt";
    }
    void Input() {
        Clothes::Input();
        cin >> color;
    }
};


class ShortSkirt : public Skirt {
public:
    bool isHasNeck;
    void Input() {
        Skirt::Input();
        cin >> isHasNeck;
    }
};

class LongSkirt : public Skirt {
public:
    float length;
    void Input() {
        Skirt::Input();
        cin >> length;
    }
};


class Cap : public Clothes {
public:
    int level;
    int buffLevel;
    enum BuffLevel {
        iron,
        silver,
        gold
    };
    Cap() {
        this->type = "cap";
    }
    void Input() {
        Clothes::Input();
        cin >> level;
    }

    virtual float Buff(Clothes* clothes) = 0;
};

class IronCap : public Cap {
public:
    IronCap() {
        buffLevel = BuffLevel::iron;
    }
    float Buff(Clothes* clothes) {
        return clothes->getPrice();
    }
    float getPrice() {
        return 0;
    }
};

class SilverCap : public Cap {
public:
    SilverCap() {
        buffLevel = BuffLevel::silver;
    }
    float Buff(Clothes* clothes) {
        float originPrice = clothes->getPrice();
        clothes->setPrice(originPrice * 1.5);
        return originPrice * 1.5;
    }
};

class GoldCap : public Cap {
public:
    GoldCap() {
        buffLevel = BuffLevel::gold;
    }
    float Buff(Clothes* clothes) {
        float originPrice = clothes->getPrice();
        clothes->setPrice(originPrice * 3);
        return originPrice * 3;
    }
};

class Human {
public:
    string name;
    int num_clothes;
    Clothes** clothes;
    vector<Cap*> caps;
    float totalPrice;
    Human() {
        totalPrice = 0;
    }
    void UpdateCaps() {
        for (int i = 0; i < num_clothes; i++) {
            if (clothes[i]->getType() == "cap") {
                caps.push_back(dynamic_cast<Cap*>(clothes[i]));
            }
        }
    }

    void Input() {
        cin >> num_clothes;
        clothes = new Clothes * [num_clothes];
        for (int i = 0; i < num_clothes; i++) {
            int type;
            cin >> type;
            switch (type) {
            case 1:
                clothes[i] = new JeanPant;
                break;
            case 2:
                clothes[i] = new Kaki;
                break;
            case 3:
                clothes[i] = new ShortSkirt;
                break;
            case 4:
                clothes[i] = new LongSkirt;
                break;
            case 5:
                clothes[i] = new IronCap;
                break;
            case 6:
                clothes[i] = new SilverCap;
                break;
            case 7:
                clothes[i] = new GoldCap;
                break;
            }
            clothes[i]->Input();
        }
        this->UpdateCaps();
        this->CalculateRawPrice();
    }

    void CalculateRawPrice() {
        int bestBuffLevel = Cap::BuffLevel::iron;
        int indexBestBuffLevel = -1;
        for (int i = 0; i < caps.size(); i++) {
            if (caps[i]->buffLevel > bestBuffLevel) {
                bestBuffLevel = caps[i]->buffLevel;
                indexBestBuffLevel = i;
            }
        }

        if (indexBestBuffLevel != -1) {
            for (int i = 0; i < num_clothes; i++) {
                if (clothes[i]->getType() != "cap") {
                    totalPrice += caps[indexBestBuffLevel]->Buff(clothes[i]);
                }
                else {
                    totalPrice += clothes[i]->getPrice();
                }
            }
        }
        else {
            for (int i = 0; i < num_clothes; i++) {
                totalPrice += clothes[i]->getPrice();
            }
        }
    }

    void Output() {
        cout << totalPrice;
    }
};

int main() {
    Human* siro = new Human;
    siro->Input();
    siro->Output();

    return 0;
}