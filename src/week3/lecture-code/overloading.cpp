#include <iostream>

int MyFunc(int);
int MyFunc(int, int);

int main(void)
{
    MyFunc(20);
    MyFunc(30, 40);

    return 0;
}

int MyFunc(int a)
{
    a++;

    return a;
}

int MyFunc(int a, int b)
{
    return a + b;
}