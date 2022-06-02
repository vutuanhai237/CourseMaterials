#include <iostream>
using namespace std;

class Engine {
public:
    int hp;
    float lit;
    float origin_lit;
    void Input() {
        cin >> lit;
        origin_lit = lit;
    }

    void decreaseLit(float _lit) {
        this->lit -= _lit;
    }
    virtual float Consume(float, float) = 0;
};





class EngineV2 : public Engine {
public:
    EngineV2() { hp = 500; }
    float Consume(float weight, float ammos) {
        // 15 lit / 100 km
        return 10*45 / weight;
    }
};

class EngineV2K : public EngineV2 {
public:
    EngineV2K() { hp = 600; }

};

class Engine2DG8M : public Engine {
public:
    Engine2DG8M() { hp = 1000; }
    float Consume(float weight, float ammos) {
        // 12 lit / 100 km
        return 10* 40 / weight;
    }
};

class Gun {
public:
    float radius;
    int num_ammos;
    int origin_num_ammos;
    void Input() {
        cin >> num_ammos;
        origin_num_ammos = num_ammos;
    }

    void decreaseNumAmmos(int _num_ammos) {
        this->num_ammos -= _num_ammos;
    }
    virtual float Damage(int num_crews) = 0;

};

class GunML20S: public Gun {
public:
    GunML20S() { radius = 152; }
    float Damage(int num_crews) {
        return (float) num_crews / 4 * radius * num_ammos;
    }
};

class GunF34 : public Gun {
public:
    GunF34() { radius = 76.2; }
    float Damage(int num_crews) {
        return (float) 3 * radius * num_ammos;
    }
};

class GunD25T : public GunF34 {
public:
    GunD25T() { radius = 122; }
};

class GunM65L : public GunML20S {
public:
    GunM65L() { radius = 130; }
};


class Tank {
public:
    string name;
    float weight;
    int num_crews;
    Gun* gun;
    Engine* engine;
    void Input() {
        cin >> weight >> num_crews;
        gun->Input();
        engine->Input();
    }

    void Output() {
        cout << this->name << ", weight: " << weight << ", number of crews: " << num_crews << ", damage: " << this->gun->Damage(this->num_crews) << ", performance: " << this->CalculatingPerformance() << "%" << endl;

    }
    virtual float CalculatingPerformance() = 0;
};

class SU152 : public Tank {
public:
    SU152() {
        this->name = "SU152";
        this->gun = new GunML20S;
        this->engine = new EngineV2K;
    }

    float CalculatingPerformance() {
        return (float) (this->gun->num_ammos) / this->gun->origin_num_ammos * 100;
    }
};

class KV2 : public Tank {
public:
    KV2() {
        this->name = "KV2";
        this->gun = new GunF34;
        this->engine = new EngineV2;
    }

    float CalculatingPerformance() {
        return float(this->gun->num_ammos) / this->gun->origin_num_ammos * 100;
    }
};

class IS : public Tank {
public:
    IS() {
        this->name = "IS";
        this->gun = new GunD25T;
        this->engine = new EngineV2K;
    }

    float CalculatingPerformance() {
        return (float) this->engine->lit / this->engine->origin_lit * 100;
    }
};

class Object279 : public Tank {
public:
    Object279() {
        this->name = "Object279";
        this->gun = new GunM65L;
        this->engine = new Engine2DG8M;
    }

    float CalculatingPerformance() {
        return (float) this->num_crews / 4 * 100;
    }

};

int main() {
    int n; cin >> n;
    Tank** tanks = new Tank * [n];
    for (int i = 0; i < n; i++) {
        int loai; cin >> loai;
        if (loai == 1) {
            tanks[i] = new SU152;
        }

        if (loai == 2) {
            tanks[i] = new KV2;
        }

        if (loai == 3) {
            tanks[i] = new IS;
        }

        if (loai == 4) {
            tanks[i] = new Object279;
        }

        tanks[i]->Input();

    }

    // 
    float km; cin >> km; 
    int shoted_ammos; cin >> shoted_ammos;
    for (int i = 0; i < n; i++) {
        tanks[i]->engine->decreaseLit(
            tanks[i]->engine->Consume(tanks[i]->weight, 
            tanks[i]->gun->num_ammos
        )* km / 100);

        tanks[i]->gun->decreaseNumAmmos(shoted_ammos);
    }

    //
    for (int i = 0; i < n; i++) {
        tanks[i]->Output();
    }
    
}