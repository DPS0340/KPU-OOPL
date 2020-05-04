#include <iostream>

using namespace std;

class First
{
public:
    void MyFunc()
    {
        cout << "FirstFunc" << endl;
    }
};

class Second : public First
{
public:
    void MyFunc()
    {
        cout << "SecondFunc" << endl;
    }
};

class Third : public Second
{
public:
    void MyFunc()
    {
        cout << "ThirdFunc" << endl;
    }
};

int main(void)
{
    Third *tptr = new Third();
    Second *sptr = new Second();
    First *fptr = new First();

    tptr->MyFunc();

    sptr->MyFunc();

    fptr->MyFunc();

    return 0;
}