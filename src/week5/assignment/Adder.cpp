#include <iostream>

using namespace std;

int Adder(const int &, const int &);

int main(void) {
    int a, b;
    while(true) {
        cout << "더할 두 개의 숫자를 차례로 입력하시오: ";
        cin >> a >> b;
        cout << a << " + " << b << " = " << Adder(a, b) << endl;
    }
}

int Adder(const int &num1, const int &num2) {
    return num1 + num2;
}
