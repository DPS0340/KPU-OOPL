#include <iostream>

using namespace std;

void SwapByValue(int n1, int n2);
void SwapByPointer(int* n1, int* n2);
void SwapByReference(int& n1, int& n2);

int main(void) {
    int num1 = 1, num2 = 2;

    cout << "num1=" << num1 << " num2=" << num2 << endl;

    SwapByValue(num1, num2);
    cout << "SwapByValue: num1=" << num1 << " num2=" << num2 << endl;
    cout << "num1=" << num1 << " num2=" << num2 << endl;
    SwapByPointer(&num1, &num2);
    cout << "SwapByPointer: num1=" << num1 << " num2=" << num2 << endl;
    cout << "num1=" << num1 << " num2=" << num2 << endl;
    SwapByReference(num1, num2);
    cout << "SwapByReference: num1=" << num1 << " num2=" << num2 << endl;
}

void SwapByValue(int n1, int n2) {
    int temp = n1;
    n1 = n2;
    n2 = temp;
}

void SwapByPointer(int* n1, int* n2) {
    int temp = *n1;
    *n1 = *n2;
    *n2 = temp;
}

void SwapByReference(int& n1, int& n2) {
    int temp = n1;
    n1 = n2;
    n2 = temp;
}
