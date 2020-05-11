#include <iostream>

using namespace std;

// 부모 클래스 선언
class Base
{
public:
    Base()
    {
        cout << "Base Constructor" << endl;
    }
    void SimpleFunc()
    {
        cout << "BaseOne" << endl;
    }
};

// Base 클래스를 상속받는 두개의 자식 클래스 선언
// 손자 클래스에서 다중 상속을 하기 때문에 virtual 상속을 해야한다.
class MiddleDerivedOne : virtual public Base
{
public:
    MiddleDerivedOne() : Base()
    {
        cout << "MiddleDerivedOne Constructor" << endl;
    }
    void MiddleFuncOne()
    {
        SimpleFunc();
        cout << "MiddleDerivedOne" << endl;
    }
};

class MiddleDerivedTwo : virtual public Base
{
public:
    MiddleDerivedTwo() : Base()
    {
        cout << "MIddleDerivedTwo Constructor" << endl;
    }
    void MiddleFuncTwo()
    {
        SimpleFunc();
        cout << "MiddleDerivedTwo" << endl;
    }
};

// 다중 상속을 사용하는 손자 클래스
// 자식 클래스에서 부모 클래스를 virtual 상속을 했기 때문에 다중 상속에 문제가 없음
class LastDerived : public MiddleDerivedOne, public MiddleDerivedTwo
{
public:
    LastDerived() : MiddleDerivedOne(), MiddleDerivedTwo()
    {
        cout << "LastDerived Constructor" << endl;
    }
    void ComplexFunc()
    {
        MiddleFuncOne();
        MiddleFuncTwo();
        SimpleFunc();
    }
};

int main(void)
{
    // void 매개변수 생성자 호출됨
    LastDerived ldr;
    ldr.ComplexFunc();
    return 0;
}