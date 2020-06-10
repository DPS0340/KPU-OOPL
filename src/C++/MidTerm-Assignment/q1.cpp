#include <iostream>
#include <string>

// 객체지향언어 과제1
// 2019152038 이지호

using namespace std;

class Person
{
protected:
    // 작성자의 컴파일러에서의 한글의 표현 3바이트와 cstring 라이브러리의 strlen이 호환되지 않아 std::string으로 대체
    string name;
    int groupID;

public:
    Person(string _name, int _groupID)
        : name(_name), groupID(_groupID)
    {
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
        : Person(_name, _groupID), id(_id), year(_year), major(_major)
    {
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