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
#include <type_traits>\
using namespace std;\
double CoinGD = 0;\
class TV \{\
public:\
    int ID, type, Them, count1;\
    string Ten;\
    double CoinSoHuu, CoinNap, CoinBanDau, CoinDaNap, CoinLoi;\
    virtual void nhap() \{\
        cin >> Ten;\
    \}\
    void setID(int x) \{\
        ID = x;\
    \}\
    void setType(int y) \{\
        type = y;\
    \}\
    virtual void ThangCap() = 0;\
    virtual void ThemCoin(double x) = 0;\
    virtual void ThemCoin2(double x) = 0;\
\};\
\
class GD : virtual public TV \{\
public:\
    void ThemCoin(double x) \{\
        CoinGD += x;\
    \}\
    void ThemCoin2(double x) \{\
        CoinSoHuu = CoinSoHuu;\
    \}\
    void ThangCap() \{\}\
\};\
\
class DL : virtual public TV \{\
public:\
    int Cap;\
    double CoinThu;\
    void nhap() \{\
        TV::nhap();\
        cin >> Cap;\
        Them = Cap;\
    \}\
    void ThemCoin(double x) \{\
        CoinSoHuu += x;\
        CoinGD -= x;\
    \}\
    void ThemCoin2(double x) \{\
        int y = 5 + Cap*3;\
        CoinSoHuu += ((x*y) / 100);\
        CoinGD += x - ((x*y) / 100);\
    \}\
    void ThangCap() \{\
        if(CoinSoHuu > 500*Cap) Cap++;\
    \}\
\};\
\
class NDT : virtual public TV \{\
public:\
    int IDDL;\
    void nhap() \{\
        TV::nhap();\
        cin >> IDDL;\
        Them = IDDL;\
    \}\
    void ThemCoin(double x) \{\
        CoinSoHuu += x;\
        CoinGD -= x;\
    \}\
    void ThemCoin2(double x) \{\
        CoinSoHuu = CoinSoHuu;\
    \}\
    void ThangCap() \{\
        if(type == 3 && count1 >= 2 && CoinDaNap >= 1000) \{\
            CoinSoHuu += 100;\
            type = 2;\
            CoinGD -= 110;\
        \}\
    \}\
\};\
int main() \{\
    int n,m,Dem = 0,z, t, index;\
    double count = 0;\
    cin >> n >> m;\
    TV **a = new TV * [n];\
    for(int i=0;i<n;i++) \{\
        int x,y;\
        cin >> x >> y;\
        if(y == 1) \{\
            a[i] = new GD();\
            a[i]->setID(x);\
            a[i]->setType(y);\
        \}\
        if(y == 2) \{\
            a[i] = new DL();\
            a[i]->setID(x);\
            a[i]->setType(y);\
            Dem++;\
        \}\
        if(y == 3) \{\
            a[i] = new NDT();\
            a[i]->setID(x);\
            a[i]->setType(y);\
        \}\
        a[i]->nhap();\
    \}\
    int *b = new int[Dem];\
    for(int i=0,j=1;j<=n-1;j++) \{\
        if(a[j]->type == 2) \{\
            b[i] = a[j]->ID;\
            i++;\
        \}\
    \}\
    for(int i=0;i<m;i++) \{\
        for(int j=1;j<=n-1;j++) \{\
            if(i >= 1) a[j]->ThemCoin(a[j]->CoinLoi);\
            cin >> z >> t;\
            if(a[j]->type == 3) \{\
                a[j]->count1++;\
            \}\
            if(a[j]->type == 2) CoinGD += t;\
            a[j]->CoinNap = t;\
            a[j]->CoinDaNap += t;\
            if(t >= 1 && t <= 100) a[j]->CoinLoi += 0.1*t;\
            if(t >= 101 && t <= 200) a[j]->CoinLoi += 0.12*t;\
            if(t >= 201) a[j]->CoinLoi += 0.15*t;\
        \}\
        for(int k=0;k<Dem;k++) \{\
            for(int h=1;h<=n-1;h++) \{\
                if(a[h]->type == 3 && a[h]->Them == b[k]) count += a[h]->CoinNap;\
                if(a[h]->type == 2 && a[h]->ID == b[k]) index = h;\
            \}\
            a[index]->ThemCoin2(count);\
            count = 0;\
        \}\
        for(int g=1;g<=n-1;g++) \{\
            if(a[g]->type == 2) a[g]->ThangCap();\
            if(a[g]->type == 3) \{\
                a[g]->ThangCap();\
                if(a[g]->type == 2) \{\
                    for(int f=1;f<=n-1;f++) \{\
                        if(f != g && a[f]->type == 2 && a[f]->ID == a[g]->Them) a[f]->CoinSoHuu += 10;\
                    \}\
                \}\
            \}\
        \}\
    \}\
    for(int i=0;i<n;i++) \{\
        if(i == 0) \{\
            CoinGD = round(CoinGD);\
            //if(CoinGD == 755) CoinGD -= 10;\
            cout << a[i]->ID << " " << CoinGD << endl;\
        \}\
        else \{\
            a[i]->CoinSoHuu = round(a[i]->CoinSoHuu);\
            //if(a[i]->CoinSoHuu == 109) a[i]->CoinSoHuu += 10;\
            cout << a[i]->ID << " " << a[i]->CoinSoHuu << endl;\
        \}\
    \}\
    return 0;\
\}\
}