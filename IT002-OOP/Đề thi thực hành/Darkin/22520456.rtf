{\rtf1\ansi\ansicpg1252\cocoartf2709
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf0 #include <cmath>\
#include <cstdio>\
#include <vector>\
#include <iostream>\
#include <algorithm>\
using namespace std;\
\
class Diem \{\
public:\
    float x;\
    float y;\
    Diem() \{\
        x = y = 0;\
    \}\
    void Nhap() \{\
        cin >> x;\
        cin >> y;\
    \}\
    float KhoangCach(Diem b) \{\
        return sqrt(pow(x - b.x, 2) + pow(y - b.y, 2));\
    \}\
\};\
\
class Tuong \{\
public:\
    float HPgoc;\
    float HP;\
    float ATK;\
    float DEF;\
    string name;\
    Diem toado;\
    float Mana;\
    int loai;\
    Tuong() \{\
        HP = ATK = DEF = HPgoc = 0;\
        Mana = 0;\
        name = "\\0";\
        toado = Diem();\
        loai = 0;\
    \}\
    virtual void Nhap() \{\
        toado.Nhap();\
        cin >> HP;\
        HPgoc = HP;\
        cin >> ATK;\
    \}\
    virtual void Damage(Tuong* a) = 0;\
    virtual void Damage(Tuong* a,Tuong*b) = 0;\
    virtual bool KtTDT(Diem a) = 0;\
\};\
class Varus :public Tuong \{\
public:\
    Varus() \{\
        name = "Varus";\
        loai = 1;\
    \}\
    void Nhap() \{\
        Tuong::Nhap();\
    \}\
    virtual void Damage(Tuong* a) \{\
        if (Mana >= 20) \{ // Skill\
            Mana = 0;\
            float x = ATK + a->HPgoc * 0.2 - a->DEF;\
            if (x < 0) \{\
                HP += x;\
            \}\
            else \{\
                a->HP -= x;\
            \}\
        \}\
        else \{// Danh thuong\
            float x = ATK - a->DEF;\
            if (x < 0) \{\
                HP += x;\
            \}\
            else \{\
                Mana += x;\
                a->HP -= x;\
            \}\
        \}\
    \}\
    void Damage(Tuong* a, Tuong* b) \{\
        if (Mana >= 20) \{ // Skill\
            Mana = 0;\
            float x = ATK + a->HPgoc * 0.2 - a->DEF;\
            if (x < 0) \{\
                HP += x;\
            \}\
            else \{\
                a->HP -= x;\
                if (KtTDT(b->toado) == false) \{\
                    float x1 = a->toado.x - b->toado.x;\
                    float y1 = a->toado.y - b->toado.y;\
                    if ((abs(x1) <= 4) && (abs(y1) <= 4)) \{\
                        float x2 = toado.x - a->toado.x;\
                        float y2 = toado.y - a->toado.y;\
                        if (x1 * y2 == x2 * y1)\
                            b->HP -= x;\
                    \}\
                \}\
            \}\
        \}\
        else \{// Danh thuong\
            float x = ATK - a->DEF;\
            if (x < 0) \{\
                HP += x;\
            \}\
            else \{\
                Mana += x;\
                a->HP -= x;\
            \}\
        \}\
    \}\
    bool KtTDT(Diem a) \{\
        if (abs(toado.x - a.x) <= 2 && abs(toado.y - a.y) <= 2)\
            return true;\
        return false;\
    \}\
\};\
class Kayn :public Tuong \{\
public:\
    Kayn() \{\
        name = "Kayn";\
        loai = 2;\
    \}\
    void Nhap() \{\
        Tuong::Nhap();\
        cin >> DEF;\
    \}\
    void Damage(Tuong* a) \{\
        if (Mana >= 20) \{ // Skill\
            Mana = 0;\
            float x = ATK * 2 - a->DEF;\
            if (x < 0) \{\
                HP += x;\
            \}\
            else \{\
                a->HP -= x;\
            \}\
        \}\
        else \{// Danh thuong\
            float x = ATK - a->DEF;\
            if (x < 0) \{\
                HP += x;\
            \}\
            else \{\
                Mana += x;\
                a->HP -= x;\
            \}\
        \}\
    \}\
    void Damage(Tuong* a,Tuong* b) \{\
        if (Mana >= 20) \{ // Skill\
            Mana = 0;\
            float x = ATK * 2 - a->DEF;\
            if (x < 0) \{\
                HP += x;\
            \}\
            else \{\
                a->HP -= x;\
                if (KtTDT(b->toado) == true)\
                    b->HP -= x;\
            \}\
        \}\
        else \{// Danh thuong\
            float x = ATK - a->DEF;\
            if (x < 0) \{\
                HP += x;\
            \}\
            else \{\
                Mana += x;\
                a->HP -= x;\
            \}\
        \}\
    \}\
    bool KtTDT(Diem a) \{\
        if (abs(toado.x - a.x) <= 1 && abs(toado.y - a.y) <= 1)\
            return true;\
        return false;\
    \}\
\};\
\
class Aatrox :public Tuong \{\
public:\
    float tlHoiHP;\
    Aatrox() \{\
        name = "Aatrox";\
        tlHoiHP = 0;\
        loai = 3;\
    \}\
    void Nhap() \{\
        Tuong::Nhap();\
        cin >> DEF;\
        cin >> tlHoiHP;\
    \}\
    void Damage(Tuong* a) \{\
        if (Mana >= 20) \{ // Skill\
            Mana = 0;\
            float x = ATK + DEF - a->DEF;\
            if (x < 0) \{\
                HP += x;\
            \}\
            else \{\
                HP += (x * tlHoiHP);// Hoi HP\
                if (HP > HPgoc)\
                    HP = HPgoc;\
                a->HP -= x;\
            \}\
        \}\
        else \{// Danh thuong\
            float x = ATK - a->DEF;\
            if (x < 0) \{\
                HP += x;\
            \}\
            else \{\
                Mana += x;\
                a->HP -= x;\
            \}\
        \}\
    \}\
    void Damage(Tuong* a,Tuong* b) \{\
        if (Mana >= 20) \{ // Skill\
            Mana = 0;\
            float x = ATK + DEF - a->DEF;\
            if (x < 0) \{\
                HP += x;\
            \}\
            else \{\
                HP += (x * tlHoiHP);// Hoi HP\
                if (HP > HPgoc)\
                    HP = HPgoc;\
                a->HP -= x;\
            \}\
        \}\
        else \{// Danh thuong\
            float x = ATK - a->DEF;\
            if (x < 0) \{\
                HP += x;\
            \}\
            else \{\
                Mana += x;\
                a->HP -= x;\
            \}\
        \}\
    \}\
    bool KtTDT(Diem a) \{\
        if (Mana < 20) \{\
            if (abs(toado.x - a.x) <= 1 && abs(toado.y - a.y) <= 1)\
                return true;\
        \}\
        if (Mana >= 20) \{\
            if (abs(toado.x - a.x) <= 2 && abs(toado.y - a.y) <= 2)\
                return true;\
        \}\
        return false;\
    \}\
\};\
\
void Nhap(int& n,vector<Tuong*> &T) \{\
    cin >> n;\
    for (int i = 0; i < n; i++) \{\
        int x;\
        cin >> x;\
        Tuong* temp;\
        switch (x)\
        \{\
        case 1: temp = new Varus;\
            break;\
        case 2: temp = new Kayn;\
            break;\
        case 3: temp = new Aatrox;\
            break;\
        default: temp = NULL;\
            break;\
        \}\
        if (temp != NULL) \{\
            temp->Nhap();\
            T.push_back(temp);\
        \}\
    \}\
\}\
\
float KhoangCach(Tuong* a, Tuong* b) \{\
    return a->toado.KhoangCach(b->toado);\
\}\
void DiChuyen(Tuong* a, Tuong* b) \{\
    if (b->toado.x - a->toado.x > 0 && b->toado.y - a->toado.y > 0) \{\
        a->toado.x += 1;\
        a->toado.y += 1;\
    \}\
    else if (b->toado.x - a->toado.x > 0 && b->toado.y - a->toado.y < 0) \{\
        a->toado.x += 1;\
        a->toado.y -= 1;\
    \}\
    else if (b->toado.x - a->toado.x < 0 && b->toado.y - a->toado.y < 0) \{\
        a->toado.x -= 1;\
        a->toado.y -= 1;\
    \}\
    else if (b->toado.x - a->toado.x < 0 && b->toado.y - a->toado.y > 0) \{\
        a->toado.x -= 1;\
        a->toado.y += 1;\
    \}\
    else if (b->toado.x - a->toado.x == 0 && b->toado.y - a->toado.y > 0) \{\
        a->toado.y += 1;\
    \}\
    else if (b->toado.x - a->toado.x == 0 && b->toado.y - a->toado.y < 0) \{\
        a->toado.y -= 1;\
    \}\
    else if (b->toado.x - a->toado.x > 0 && b->toado.y - a->toado.y == 0) \{\
        a->toado.x += 1;\
    \}\
    else if (b->toado.x - a->toado.x < 0 && b->toado.y - a->toado.y == 0) \{\
        a->toado.x -= 1;\
    \}\
\}\
bool KtThuTuDanh(Tuong* a, Tuong* b) \{\
    if (a->HP == b->HP) \{\
        if (b->loai < a->loai)\
            return false;\
    \}\
    if (a->HP > b->HP) \{\
        return false;\
    \}\
    return true;\
\}\
\
int main() \{\
    int n;\
    vector<Tuong*> T;\
    Nhap(n, T);\
    while (T.size() >= 2) \{\
        for (int i = 0; i < n - 1; i++)\
            for (int j = i + 1; j < n; j++)\
                if (KtThuTuDanh(T[i], T[j]) == false)\
                    swap(T[i], T[j]);\
        for (int i = 0; i < T.size(); i++) \{\
            if (T[i]->HP <= 0) \{\
                T.erase(T.begin() + i);\
                i--;\
                n--;\
            \}\
        \}\
        if (T.size() == 3) \{\
            for (int i = 0; i < n; i++) \{\
\
                if (T[i]->KtTDT(T[(i + 1) % n]->toado) == false && T[i]->KtTDT(T[(i + 2) % n]->toado) == false) \{\
                    float kc1 = KhoangCach(T[i], T[(i + 1) % n]);\
                    float kc2 = KhoangCach(T[i], T[(i + 2) % n]);\
                    if (kc1 == kc2) \{\
                        if (T[(i + 1) % n]->HP > T[(i + 2) % n]->HP) \{\
                            DiChuyen(T[i], T[(i + 2) % n]);\
                            if (T[i]->KtTDT(T[(i + 2) % n]->toado) == true)\
                                T[i]->Damage(T[(i + 2) % n], T[(i + 1) % n]);\
                        \}\
                        else \{\
                            DiChuyen(T[i], T[(i + 1) % n]);\
                            if (T[i]->KtTDT(T[(i + 1) % n]->toado) == true)\
                                T[i]->Damage(T[(i + 1) % n], T[(i + 2) % n]);\
                        \}\
                    \}\
                    else if (kc1 < kc2) \{\
                        DiChuyen(T[i], T[(i + 1) % n]);\
                        if (T[i]->KtTDT(T[(i + 1) % n]->toado) == true)\
                            T[i]->Damage(T[(i + 1) % n], T[(i + 2) % n]);\
                    \}\
                    else \{\
                        DiChuyen(T[i], T[(i + 2) % n]);\
                        if (T[i]->KtTDT(T[(i + 2) % n]->toado) == true)\
                            T[i]->Damage(T[(i + 2) % n], T[(i + 1) % n]);\
                    \}\
                \}\
                else if (T[i]->KtTDT(T[(i + 1) % n]->toado) == true || T[i]->KtTDT(T[(i + 2) % n]->toado) == true) \{\
                    float kc1 = KhoangCach(T[i], T[(i + 1) % n]);\
                    float kc2 = KhoangCach(T[i], T[(i + 2) % n]);\
                    if (kc1 == kc2) \{\
                        if (T[(i + 1) % n]->HP > T[(i + 2) % n]->HP) \{\
                            T[i]->Damage(T[(i + 2) % n], T[(i + 1) % n]);\
                        \}\
                        else \{\
                            T[i]->Damage(T[(i + 1) % n], T[(i + 2) % n]);\
                        \}\
                    \}\
                    else if (kc1 < kc2) \{\
                        T[i]->Damage(T[(i + 1) % n], T[(i + 2) % n]);\
                    \}\
                    else \{\
                        T[i]->Damage(T[(i + 2) % n], T[(i + 1) % n]);\
                    \}\
                \}\
            \}\
        \}\
        if (T.size() == 2) \{\
            for (int i = 0; i < n; i++) \{\
                if (T[i]->KtTDT(T[(i + 1) % n]->toado) == false) \{\
                    DiChuyen(T[i], T[(i + 1) % n]);\
                    if (T[i]->KtTDT(T[(i + 1) % n]->toado) == true)\
                        T[i]->Damage(T[(i + 1) % n]);\
                \}\
                else \{\
                    T[i]->Damage(T[(i + 1) % n]);\
                \}\
            \}\
        \}\
    \}\
    if (T.size() == 1) \{\
        cout << T[0]->name << " " << T[0]->HP;\
    \}\
    return 0;\
\}\
}