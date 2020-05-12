#include <iostream>
#include <string>

using namespace std;

class Person
{
protected:
    string name;
    int groupID;

public:
    Person(string _name, int _groupID)
        : groupID(_groupID)
    {
        name = _name;
    }
    Person(const Person &copy)
        : Person(copy.name, copy.groupID)
    {
    }
};

class Student : public Person
{
private:
    int id;
    int year;
    string major;

public:
    Student(string _name, int _groupID, int _id, int _year, string _major)
        : Person(_name, _groupID), id(_id), year(_year)
    {
        major = _major;
    }
    Student(const Student &copy)
        : Student(copy.name, copy.groupID, copy.id, copy.year, copy.major)
    {
    }

    void ShowStudent(void)
    {
        cout << " 이름 "
             << "  그룹 ID   "
             << " ID "
             << " 입학년도 "
             << " 전공 " << endl;
        cout << "------------------------------------------------" << endl;
        cout << name << "    " << groupID << "       " << id << "     " << year << "     " << major << endl;
        cout << "------------------------------------------------" << endl;

        return;
    }
};

int main(void)
{
    Student student = Student("이지호", 15, 1, 2019, "컴퓨터공학부 컴퓨터공학전공");

    student.ShowStudent();

    return 0;
}