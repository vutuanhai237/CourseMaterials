#include <iostream>
#include <string>
using namespace std;

class Beverage {
public:
	string name;
	float price;
	Beverage() {
		name = "";
		price = 0.0;
	}

	virtual void Input() {
		cin >> name;
		cin >> price;
	}
};

class Coffee : public Beverage {
public:
	string IsHasIce;
	void Input() {
		Beverage::Input();
		cin >> IsHasIce;
	}
};

class Tea : public Beverage {
public:
	string IsManySugar;
	void Input() {
		Beverage::Input();
		cin >> IsManySugar;
	}
};

class OtherBeverage : public Beverage {

};

int main() {
	Beverage* beverages[100];
	int n;
	float totalPrice = 0;
	int numberOfMilk = 0;
	cin >> n;
	for (int i = 0; i < n; i++) {
		int type;
		cin >> type;
		if (type == 1) {
			beverages[i] = new Coffee;
		} 
		if (type == 2) {
			beverages[i] = new Tea;
		}
		if (type == 3) {
			beverages[i] = new OtherBeverage;
		}
		beverages[i]->Input();
		totalPrice += beverages[i]->price;
		if (beverages[i]->name.find("Sua") != std::string::npos) numberOfMilk++;
	}

	string customerName;
	int day, month, year;
	cin >> customerName >> day >> month >> year;
	if (month == 7) totalPrice *= 0.9;
	cout << "Tong gia tri hoa don: " << totalPrice << endl;
	cout << "Tong so mon co sua: " << numberOfMilk << endl;
	return 0;
}