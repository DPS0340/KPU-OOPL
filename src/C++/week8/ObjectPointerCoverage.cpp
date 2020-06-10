#include <iostream>

using namespace std;

class First
{
public:
    void FirstFunc()
    {
        cout << "FirstFunc" << endl;
    }
};

class Second : public First
{
public:
    void SecondFunc()
    {
        cout << "SecondFunc" << endl;
    }
};

class Third : public Second
{
public:
    void ThirdFunc()
    {
        cout << "ThirdFunc" << endl;
    }
};

int main(void)
{
    Third *tptr = new Third();
    Second *sptr = tptr;
    First *fptr = sptr;

    tptr->FirstFunc();
    tptr->SecondFunc();
    tptr->ThirdFunc();

    sptr->FirstFunc();
    sptr->SecondFunc();
    sptr->ThirdFunc();

    fptr->FirstFunc();
    fptr->SecondFunc();
    fptr->ThirdFunc();

    return 0;
}