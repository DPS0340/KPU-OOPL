#include <iostream>
#include <cstring>

using namespace std;

class Student
{
private:
    int id;
    char *name;
    int subjID;
    char subjectName[41];

public:
    Student(int _id, const char *_name, int _subjID, char *_subjectName)
        : id(_id), subjID(_subjID)
    {
        if (strlen(_subjectName) > 20)
        {
            cerr << "Error: Subject 이름이 20자를 초과함" << endl;
            exit(1);
        }
        if (_id <= 0)
        {
            cerr << "Error: 학생 id가 0보다 작거나 같음" << endl;
            exit(1);
        }
        if (_subjID <= 0)
        {
            cerr << "Error: 과목 id가 0보다 작거나 같음" << endl;
            exit(1);
        }
        name = new char(strlen(_name) + 1);

        strcpy(name, _name);
        strcpy(subjectName, _subjectName);
    }

    void ShowStudent(void)
    {
        cout << " 학생ID "
             << "  이름   "
             << " Subject ID "
             << " Subject 이름" << endl;
        cout << "----------------------------------------------" << endl;
        cout << id << "  " << name << "   " << subjID << "           " << subjectName << endl;
        cout << "----------------------------------------------" << endl;

        return;
    }
};

int main(void)
{
    Student student = Student(2018123, "김객체", 1, "객체지향언어");

    student.ShowStudent();

    return 0;
}