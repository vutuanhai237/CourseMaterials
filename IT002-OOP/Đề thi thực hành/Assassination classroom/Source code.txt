#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

class Human {
public:
    string name;
    virtual void Input() {
        cin >> name;
    }

    virtual void Output() {
        cout << name;
    }
};


class Teacher : public Human {
public:
    int yearOfExp;
    virtual void Input() {
        Human::Input();
        cin >> yearOfExp;
    }

    virtual int CalculatingSalary() = 0;

};
class MainTeacher : public Teacher {
public:
    string class_name;
    void Input() {
        Teacher::Input();
        cin >> class_name;
    }
    int CalculatingSalary() {
        return yearOfExp * 2000000 + 1000000;
    }
};

class SubjectTeacher : public Teacher {
public:
    string subject;
    void Input() {
        Teacher::Input();
        cin >> subject;
    }
    int CalculatingSalary() {
        return yearOfExp * 2000000;
    }
};

class Student : public Human {
public:
    string class_name;
    int scores[3];
    void Input() {
        Human::Input();
        cin >> class_name >> scores[0] >> scores[1] >> scores[2];
    }

    void Output() {
        cout << "Ten: " << name << ", diem 3 mon: " << scores[0] << ", " << scores[1] << ", " << scores[2] << endl;
    }


    virtual int CountingFee() = 0;
    float CalculatingAverageScore() {
        float average_score = 0;
        for (int i = 0; i < 3; i++) {
            average_score += scores[i];
        }
        return (float)average_score / 3;
    }
};

class NormalStudent : public Student {
public:
    int CountingFee() {
        int fee = 0;
        for (int i = 0; i < 3; i++) {
            if (this->scores[i] < 5) {
                fee += 1000000;
            }
        }
        return fee;
    }

};

class SelectedStudent : public Student {
public:
    int CountingFee() {
        return 0;
    }

};

vector<string> findDistinct(vector<string> arr)
{
    // Pick all elements one by one
    vector<string> result;
    for (int i = 0; i < arr.size(); i++)
    {
        int j;
        for (j = 0; j < i; j++)
            if (arr[i] == arr[j])
                break;
        if (i == j) {
            result.push_back(arr[i]);
        }

    }
    return result;
}

int getIndex(vector<string> v, string K)
{
    auto it = find(v.begin(), v.end(), K);
    if (it != v.end())
    {

        int index = it - v.begin();
        return index;
    }
    else {
        return -1;
    }
}

int main() {
    int num_student, num_teacher;
    int totalFee = 0, totalSalary = 0;
    cin >> num_teacher;
    Teacher** teacher = new Teacher * [num_teacher];
    for (int i = 0; i < num_teacher; i++) {
        int loai; cin >> loai;
        if (loai == 1) teacher[i] = new MainTeacher;
        if (loai == 2) teacher[i] = new SubjectTeacher;
        teacher[i]->Input();
        totalSalary += teacher[i]->CalculatingSalary();
    }



    cin >> num_student;
    Student** students = new Student * [num_student];
    vector<string> class_names;
    for (int i = 0; i < num_student; i++) {
        int loai; cin >> loai;
        if (loai == 1) students[i] = new NormalStudent;
        if (loai == 2) students[i] = new SelectedStudent;
        students[i]->Input();
        class_names.push_back(students[i]->class_name);

    }

    class_names = findDistinct(class_names);

    int* num_pass = new int[class_names.size()];
    int* num_fail = new int[class_names.size()];
    for (int i = 0; i < class_names.size(); i++) {
        num_pass[i] = 0;
        num_fail[i] = 0;
    }
    for (int i = 0; i < num_student; i++) {
        int index = getIndex(class_names, students[i]->class_name);
        totalFee += students[i]->CountingFee();
        if (students[i]->CalculatingAverageScore() > 5.0) {

            num_pass[index]++;
        }
        else {
            num_fail[index]++;
        }
    }

    for (int i = 0; i < class_names.size(); i++) {
        cout << "Lop: " << class_names[i] << ", so hoc sinh len lop: " << num_pass[i] << ", so hoc sinh dup: " << num_fail[i] << endl;
    }

    if (totalSalary > totalFee) {
        cout << "Khong du chi tra luong";
    }
    else {
        cout << "Du " << totalFee - totalSalary << "d";
    }
    return 0;
}