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
#include <unordered_map>\
#include <stack>\
using namespace std;\
static int ServerCount = 0;\
static int demServerPP = 0;\
static int nReq = 0;\
class Point\
\{\
    public:\
    float x; float y;\
    \
    Point (float x = 0, float y = 0)\{\
        this->x = x; this->y = y;\
    \}\
    float EuclidDistance (Point b)\
    \{\
        return sqrt((x-b.x)*(x-b.x) + (y-b.y)*(y-b.y));\
    \}\
    void Nhap()\
    \{\
        cin>>x>>y;\
    \}\
\};\
class Request\
\{\
    public:\
    int ID;\
    int weight;\
    Point position;\
    int svID;\
    bool haveSV;\
    void Nhap()\
    \{\
        haveSV = 0;\
        cin>>ID>>weight;\
        position.Nhap();\
    \}\
\};\
class Server\
\{\
  public:\
  int ID;\
  float RAM; float CPU;\
  Point position;\
  bool isBusy;\
  \
  void Nhap()\
  \{\
      isBusy = 0;\
      cin>>ID>>RAM>>CPU;\
      position.Nhap();\
  \}\
\};\
class LB\
\{\
    public:\
    int ID; Point position;\
    int nServer; int nChildLB;\
    vector <Server> ServerList;\
    vector <LB*> LBList;\
    \
    virtual void loadBalance(vector <Request> &ReqList, int &k) = 0;\
    void Nhap();\
\};\
\
class RR:public LB\
\{\
    public:\
    void loadBalance(vector <Request> &ReqList, int &k)\
    \{\
        if (k >= nReq)\
        \{\
            return;\
        \}\
        \
        for (int i = nServer - 1; i >=0&& k<nReq; i-- )\
        \{\
            for (int j = nReq - 1; j>=0; j--)\
            \{\
                if (ReqList[j].haveSV == 0)\
                \{\
                    ReqList[j].svID = ServerList[i].ID;\
                    ReqList[j].haveSV = 1;\
                    ServerList[i].isBusy = 1;\
                    break;\
                \}\
            \}\
            k++;\
            demServerPP++;\
        \}\
        if (demServerPP==ServerCount)\
        \{\
            for (int j = 0; j<nReq; j++)\
            \{\
                if (ReqList[j].haveSV == 0)\
                \{\
                    ReqList[j].svID = ServerList[nServer-1].ID;\
                    ReqList[j].haveSV = 1;\
                \}\
            \}\
            return;\
        \}\
        for (int i = nChildLB - 1; i>=0; i--)\
        \{\
            LBList[i]->loadBalance(ReqList, k);\
        \}\
    \}\
\};\
class WRR:public LB\
\{\
    public:\
    pair <int, int> bestReq(vector <Request> ReqList)\
    \{\
        int start = 0;\
        int startJ = 0;\
        for (int i = nReq - 1; i>=0; i--)\
        \{\
           if (ReqList[i].haveSV == 0) \{start = i; break;\}\
        \}\
        for (int i = 0; i<nServer; i++)\
        \{\
           if (ServerList[i].isBusy == 0) \{startJ = i; break;\}\
        \}\
        \
        float lcW = abs(ReqList[start].weight - ServerList[startJ].RAM * ServerList[startJ].CPU);\
        pair <int, int> result;\
        for (int i = nReq - 1; i>=0; i--)\
        \{\
            for (int j = 0; j<nServer; j++)\
            if (abs(ReqList[i].weight - ServerList[j].RAM * ServerList[j].CPU) < lcW\
            && ReqList[i].haveSV==0 && ServerList[j].isBusy == 0)\
            \{\
               result.first = i; result.second = j;\
               lcW = abs(ReqList[i].weight - ServerList[j].RAM * ServerList[j].CPU);\
            \}\
        \}\
        //cout<<ReqList[result.first].ID<<ServerList[result.second].ID<<" 2"<<endl;\
        return result;\
    \}\
    void loadBalance(vector <Request> &ReqList, int &k)\
    \{\
        if (k >= nReq)\
        \{\
            return;\
        \}\
        \
        for (int i = 0; i < nServer && k<nReq; i++ )\
        \{\
                pair<int, int> pos = bestReq(ReqList);\
                ReqList[pos.first].svID = ServerList[pos.second].ID;\
                ReqList[pos.first].haveSV = 1;\
                ServerList[pos.second].isBusy = 1;\
                k++;\
                demServerPP++;\
        \}\
        \
        if (demServerPP==ServerCount)\
        \{\
            for (int j = 0; j<nReq; j++)\
            \{\
                if (ReqList[j].haveSV == 0)\
                \{\
                    ReqList[j].svID = ServerList[nServer-1].ID;\
                    ReqList[j].haveSV = 1;\
                \}\
            \}\
            return;\
        \}\
        \
        for (int i = nChildLB - 1; i>=0; i--)\
        \{\
            LBList[i]->loadBalance(ReqList, k);\
        \}\
        \
    \}\
\};\
class FRT:public LB\
\{\
    public:\
    float khoangCach (Request req, Server server)\
    \{\
        float kq;\
        kq = req.position.EuclidDistance(server.position) + server.position.EuclidDistance(position);\
        return kq;\
    \}\
    pair <int, int> bestReq(vector <Request> ReqList)\
    \{\
        int start = 0;\
        int startJ = 0;\
        for (int i = nReq - 1; i>=0; i--)\
        \{\
           if (ReqList[i].haveSV == 0) \{start = i; break;\}\
        \}\
        for (int i = 0; i<nServer; i++)\
        \{\
           if (ServerList[i].isBusy == 0) \{startJ = i; break;\}\
        \}\
        \
        float lcW = khoangCach(ReqList[start],ServerList[startJ]);\
        \
        pair <int, int> result;\
        \
        for (int i = nReq - 1; i>=0; i--)\
        \{\
            for (int j = 0; j<nServer; j++)\
            if (khoangCach(ReqList[i], ServerList[j]) < lcW\
            && ReqList[i].haveSV==0 && ServerList[j].isBusy == 0)\
            \{\
               result.first = i; result.second = j;\
               lcW = khoangCach(ReqList[i], ServerList[j]);\
            \}\
        \}\
        //out<<ReqList[result.first].ID<<ServerList[result.second].ID<<" 3"<<endl;\
        return result;\
    \}\
    void loadBalance(vector <Request> &ReqList, int &k)\
    \{\
      if (k >= nReq)\
        \{\
            return;\
        \}\
\
        for (int i = 0; i < nServer && k<nReq; i++ )\
        \{\
                pair<int, int> pos = bestReq(ReqList);\
                ReqList[pos.first].svID = ServerList[pos.second].ID;\
                ReqList[pos.first].haveSV = 1;\
                ServerList[pos.second].isBusy = 1;\
                k++;\
                demServerPP++;\
        \}\
        \
        if (demServerPP==ServerCount)\
        \{\
            for (int j = 0; j<nReq; j++)\
            \{\
                if (ReqList[j].haveSV == 0)\
                \{\
                    ReqList[j].svID = ServerList[nServer-1].ID;\
                    ReqList[j].haveSV = 1;\
                \}\
            \}\
            return;\
        \}\
        \
        for (int i = nChildLB - 1; i>=0; i--)\
        \{\
            LBList[i]->loadBalance(ReqList, k);\
        \}\
\
    \}\
\};\
\
void LB::Nhap()\
    \{\
        \
        position.Nhap();\
        cin>>nServer>>nChildLB;\
        ServerCount += nServer;\
        for (int i = 0; i<nServer; i++)\
        \{\
            \
            Server temp;\
            temp.Nhap();\
            ServerList.push_back(temp);\
        \}\
        for (int i = 0; i<nChildLB; i++)\
        \{\
            int tID; cin>>tID;\
            int type; cin>>type;\
            \
            LB *temp;\
            switch (type)\
            \{\
                case 1:\
                temp = new RR;\
                break;\
                case 2:\
                temp = new WRR;\
                break;\
                case 3:\
                temp = new FRT;\
                break;\
                default:\
                temp = new RR;\
                i--;\
                break;\
            \}\
            temp->ID = tID;\
            temp->Nhap();\
            LBList.push_back(temp);\
        \}\
    \}\
int main() \{\
    LB *firstLB;  \
    int tID; cin>>tID;\
    int type; cin>>type;\
    switch (type)\
    \{\
        case 1:\
        firstLB = new RR;\
        break;\
        case 2:\
        firstLB = new WRR;\
        break;\
        case 3:\
        firstLB = new FRT;\
        break;\
        default:\
        firstLB = new RR;\
        break;\
    \}\
    firstLB->ID = tID;\
    firstLB->Nhap();\
    \
    int k; cin>>k;\
    nReq = k;\
    vector<Request> ReqList;\
    for (int i = 0; i<k; i++)\
    \{\
        Request temp;\
        temp.Nhap();\
        ReqList.push_back(temp);\
    \}\
\
    int count = 0;\
    firstLB->loadBalance(ReqList, count);\
    \
    \
    for ( int i = 0; i<nReq; i++)\
    \{\
        cout<<ReqList[i].ID<<" "<<ReqList[i].svID<<endl;\
    \}\
    \
    return 0;\
\}\
}