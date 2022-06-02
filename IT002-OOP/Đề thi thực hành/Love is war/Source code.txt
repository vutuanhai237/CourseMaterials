#include<iostream>
#include<string>
#include <vector>
using namespace std;
static int num_friends = 0;

class Friend {
public:
    string name;
    string loai;
    int age;

    virtual void Input() {
        cin >> name >> age;
    }

    virtual void Output() {
        cout << "Ten: " << name << ", tuoi: " << age;
    }
    virtual float CalculatingTime() = 0;
};

class BestFriend: public Friend {
    string phone;
    void Input() {
        Friend::Input();
        cin >> phone;
        loai = "best_friend";
    }

    void Output() {
        Friend::Output();
        cout << ", so dien thoai: " << phone << endl;
    }
    float CalculatingTime() {
        return 5;
    }
};

class BoyFriend : public Friend {
    int income;
    void Input() {
        Friend::Input();
        cin >> income;
        loai = "boy_friend";
    }

    void Output() {
        Friend::Output();
        cout << ", thu nhap: " << income << "d" << endl;
    }


    float CalculatingTime() {
        return 5 * income / 10000000.0;
    }
};

class OtherBoy : public Friend {
    float attractiveness;
    void Input() {
        Friend::Input();
        cin >> attractiveness;
        loai = "otherboy_friend";
    }

    void Output() {
        Friend::Output();
        cout << ", do thu hut: ";
        if (attractiveness >= 0.7) {
            cout << "cao" << endl;
        }
        else if (attractiveness >= 0.4 && attractiveness < 0.7) {
            cout << "trung binh" << endl;
        }
        else {
            cout << "thap" << endl;
        }
    }

    float CalculatingTime() {
        return attractiveness * 20 / num_friends;
    }
};

int main() {
    int n; cin >> n;
    num_friends = n;
    float timeBestFriend = 0, timeBoyFriend = 0, timeOtherBoy = 0;
    bool hasBestFriend = false, hasBoyFriend = false, hasOtherBoy = false;
    Friend** friends = new Friend * [n];
    for (int i = 0; i < n; i++) {
        int loai; cin >> loai;
        if (loai == 1) {
            friends[i] = new BestFriend; hasBestFriend = true;
        }
        if (loai == 2) {
            friends[i] = new BoyFriend;
            hasBoyFriend = true;
        }

        if (loai == 3) {
            friends[i] = new OtherBoy;
            hasOtherBoy = true;
        }

        friends[i]->Input();
    }

    
    for (int i = 0; i < n; i++) {
        float time = friends[i]->CalculatingTime();
        if (friends[i]->loai == "best_friend") timeBestFriend += time;
        if (friends[i]->loai == "boy_friend") timeBoyFriend += time;
        if (friends[i]->loai == "otherboy_friend") timeOtherBoy += time;
    }

    cout << "Thong ke:" << endl;
    if (hasBestFriend) cout << "-Thoi gian cho ban than: " << timeBestFriend << " h" << endl;
    if (hasBoyFriend) cout << "-Thoi gian cho ban trai: " << timeBoyFriend << " h" << endl;
    if (hasOtherBoy) cout << "-Thoi gian cho ban trai khac: " << timeOtherBoy << " h" << endl;

    Friend* importantFriend = friends[0];
    for (int i = 1; i < n; i++) {
        if (importantFriend->CalculatingTime() < friends[i]->CalculatingTime()) {
            importantFriend = friends[i];
        }
    }

    cout << "Nguoi ban quan trong nhat:" << endl;
    for (int i = 0; i < n; i++) {
        if (importantFriend->CalculatingTime() == friends[i]->CalculatingTime()) {
            friends[i]->Output();
        }
    }

    
    return 0;
}