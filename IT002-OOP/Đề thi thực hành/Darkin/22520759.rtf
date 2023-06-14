{\rtf1\ansi\ansicpg1252\cocoartf2709
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\froman\fcharset0 Times-Bold;}
{\colortbl;\red255\green255\blue255;\red20\green90\blue241;\red56\green122\blue243;}
{\*\expandedcolortbl;;\cssrgb\c8235\c45490\c95686;\cssrgb\c27451\c56863\c96471\c5098;}
\paperw11900\paperh16840\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\deftab720
\pard\pardeftab720\partightenfactor0

\f0\b\fs32 \cf2 \cb3 \expnd0\expndtw0\kerning0
\outl0\strokewidth0 \strokec2 #include <cmath>\
#include <cstdio>\
#include <vector>\
#include <iostream>\
#include <algorithm>\
#include <unordered_map>\
#include <stack>\
\
using namespace std;\
\
static int nDarkin = 0;\
\
class Point\
\{\
    public:\
    float x; float y;\
    \
    Point (float x = 0, float y = 0)\{\
        this->x = x; this->y = y;\
    \}\
    float ManhattanX (Point b)\
    \{\
        return x-b.x;\
    \}\
    float ManhattanY (Point b)\
    \{\
        return y-b.y;\
    \}\
    float ChebyshevDistance (Point b)\
    \{\
        if (abs(ManhattanX(b)) > abs(ManhattanY(b)))\
            return abs(ManhattanX(b));\
        return abs(ManhattanY(b));\
    \}\
    float EuclidDistance (Point b)\
    \{\
        return sqrt((x-b.x)*(x-b.x) + (y-b.y)*(y-b.y));\
    \}\
    void ChebyshevChase (Point b)\
    \{\
        if (ManhattanX(b)!= 0)\
          x -= ManhattanX(b)/abs(ManhattanX(b));\
        if (ManhattanY(b)!= 0)\
          y -= ManhattanY(b)/abs(ManhattanY(b));\
    \}\
    float angle (Point b)\
    \{\
        int dx = b.x - x;\
        int dy = b.y - y;\
        return atan2(dy, dx);\
        \}\
    void Nhap()\
    \{\
        cin>>x>>y;\
    \}\
\};\
class Darkin\
\{\
    public:\
    int type;\
    string name[4] = \{"","Varus", "Kayn", "Aatrox"\};\
    int range;\
    float HP;\
    float MaxHP;\
    float ATK, DEF;\
    int congDonDMG = 0;\
    Point position;\
    \
    virtual void Nhap()\
    \{\
        position.Nhap();\
        cin>>HP>>ATK;\
        MaxHP = HP;\
    \}\
    virtual void skill (Darkin *aite)\
    \{ congDonDMG = 0;\}\
    \
    virtual bool inRange (Darkin *aite, float sampleAngle) \{return 0;\}\
    void normalAttack (Darkin *aite)\
    \{\
            if (ATK > aite->DEF)\
            \{\
                aite->HP -= (ATK - aite->DEF);\
                congDonDMG += (ATK - aite->DEF);\
            \}\
            else\
            HP -= (aite->DEF - ATK);\
    \}\
    bool isDead()\
    \{\
        return (HP <= 0);\
    \}\
    void Xuat()\
    \{\
        cout<<name[type]<<" "<<HP<<endl;\
    \}\
\};\
\
class Varus:public Darkin\
\{\
  public:\
  void Nhap()\
  \{\
      Darkin::Nhap();\
      range = 2;\
      DEF = 0;\
      type = 1;\
  \}\
  void skill (Darkin *aite)\
  \{\
        Darkin::skill(aite);\
        float dmg = ATK + aite->MaxHP*0.2;\
        if (dmg > aite->DEF)\
            aite->HP -= (dmg - aite->DEF);\
        else\
            HP -= (aite->DEF - dmg);\
  \}\
  bool inRange(Darkin *aite, float sampleAngle)\
    \{\
        return (position.angle(aite->position) == sampleAngle && position.ChebyshevDistance(aite->position) <= 4);\
    \}\
\};\
\
class Kayn: public Darkin\
\{\
    public:\
    void Nhap()\
    \{\
        Darkin::Nhap();\
        range = 1;\
        cin>>DEF;\
        type = 2;\
    \}\
    void skill (Darkin *aite)\
    \{\
        Darkin::skill(aite);\
        float dmg = ATK*2;\
        if (dmg > aite->DEF)\
        aite->HP -= (dmg - aite->DEF);\
        else\
        HP -= (aite->DEF - dmg);\
    \}\
    bool inRange(Darkin *aite, float sampleAngle)\
    \{\
        return (position.ChebyshevDistance(aite->position) <= 1);\
    \}\
\};\
\
class Aatrox: public Darkin\
\{\
    public:\
    float healRate;\
    void Nhap()\
    \{\
        Darkin::Nhap();\
        range = 1;\
        cin>>DEF>>healRate;\
        type = 3;\
    \}\
    void skill (Darkin *aite)\
    \{\
       Darkin::skill(aite);\
        float dmg = ATK+DEF;\
        if (dmg > aite->DEF)\
        \{    aite->HP -= (dmg - aite->DEF);\
            HP += healRate*dmg;\
        \}\
        else\
            HP -= (aite->DEF - dmg);\
    \}\
    \
    bool inRange(Darkin *aite, float sampleAngle)\
    \{\
        return (position.angle(aite->position) == sampleAngle && position.ChebyshevDistance(aite->position) <= 2);\
    \}\
\};\
\
bool cmp (Darkin* a, Darkin *b)\
\{\
    if (a->HP == b->HP) return (a->type < b->type);\
    return (a->HP < b->HP);\
\}\
\
bool isOneLeft (vector <Darkin*> darkinList)\
\{\
    int alive = 0;\
    for (int i = 0; i<nDarkin; i++)\
    \{\
        if (!(darkinList[i]->isDead())) alive++;\
    \}\
    if (alive <= 1) return 1;\
    return 0;\
\}\
\
Darkin *findNearest (vector <Darkin*> darkinList, Darkin* darkin)\
\{\
    Darkin *result = darkin;\
    for (int i = 0; i<nDarkin; i++)\
    \{\
        if (darkinList[i]->type != darkin->type && !(darkinList[i]->isDead()))\
        \{\
            result = darkinList[i];\
            break;\
        \}\
    \}\
    \
    float lcW = darkin->position.EuclidDistance(result->position);\
    for (int i = 0; i<nDarkin; i++)\
    \{\
        if (darkinList[i]->type != darkin->type && !(darkinList[i]->isDead()) \
        && darkin->position.EuclidDistance(darkinList[i]->position) < lcW)\
        \{\
            result = darkinList[i];\
            lcW = darkin->position.EuclidDistance(darkinList[i]->position);\
        \}\
    \}\
    return result;\
\}\
\
\
int main() \{\
    vector <Darkin*> darkinList;\
    int n; cin>>n;\
    nDarkin = n;\
    for (int i = 0; i<n; i++)\
    \{\
        int type; cin>>type;\
        Darkin *temp;\
        switch (type)\{\
            case 1:\
            temp = new Varus;\
            break;\
            case 2:\
            temp = new Kayn;\
            break;\
            case 3:\
            temp = new Aatrox;\
            break;\
        \};\
        temp-> Nhap();\
        darkinList.push_back(temp);\
    \}\
\
    while (!isOneLeft(darkinList))\
    \{\
        sort(darkinList.begin(), darkinList.end(), cmp);\
        for (int i = 0; i<n; i++)\
        \{\
            if (darkinList[i]->isDead()) continue;\
            Darkin *nearest = findNearest (darkinList, darkinList[i]);\
            if (darkinList[i]->position.ChebyshevDistance(nearest->position) > darkinList[i]->range)\
                darkinList[i]->position.ChebyshevChase(nearest->position);\
            if (darkinList[i]->congDonDMG >= 20)\
            \{\
                float sampleAngle = darkinList[i]->position.angle(nearest->position);\
                for (int j = 0; j<n; j++)\
                \{\
                    if (j!=i && darkinList[i]->inRange(darkinList[j], sampleAngle))\
                        darkinList[i]->skill(darkinList[j]);\
                \}\
                \}\
            else if (darkinList[i]->position.ChebyshevDistance(nearest->position) <= darkinList[i]->range)\
            \{\
                    darkinList[i]->normalAttack(nearest);\
            \}\
        \}\
    \}\
    \
    for (int i = 0;  i<n; i++)\
    \{\
        if (darkinList[i]->isDead() == 0)\
            darkinList[i]->Xuat();\
    \}\
    return 0;\
\}\
}