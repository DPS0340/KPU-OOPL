#include <iostream>
#include <cstring>

using namespace std;

class MyFriendInfo
{
private:
    char *name;
    int age;

public:
    MyFriendInfo(void)
        : name(NULL), age(0)
    {
    }
    MyFriendInfo(char *_name, int _age)
        : age(_age)
    {
        name = new char[strlen(_name) + 1];
    }
    void ShowMyFriendInfo()
    {
        cout << "이름: " << name << endl;
        cout << "나이: " << age << endl;
    }
    ~MyFriendInfo()
    {
        if (name != NULL)
        {
            delete[] name;
        }
    }
};

class MyFriendDetailInfo : public MyFriendInfo
{
private:
    char *addr;
    char *phone;

public:
    MyFriendDetailInfo(void)
        : MyFriendInfo(), addr(NULL), phone(NULL)
    {
    }
    MyFriendDetailInfo(char *_name, int _age)
        : MyFriendInfo(_name, _age), addr(NULL), phone(NULL)
    {
    }
    MyFriendDetailInfo(char *_name, int _age, char *_addr, char *_phone)
        : MyFriendInfo(_name, _age)
    {
        addr = new char[strlen(_addr) + 1];
        phone = new char[strlen(_phone) + 1];
    }
    ~MyFriendDetailInfo()
    {
        if (addr != NULL)
        {
            delete[] addr;
        }
        if (phone != NULL)
        {
            delete[] phone;
        }
    }
    void ShowMyFriendDetailInfo()
    {
        ShowMyFriendInfo();
        cout << "주소: " << addr << endl;
        cout << "전화: " << phone << endl
             << endl;
    }
};