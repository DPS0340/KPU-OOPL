#include <iostream>
#include <cstring>

using namespace std;

class MainMenu
{
public:
    int IssueMenu(void)
    {
        int command;

        cout << "----- 메 뉴 -----" << endl;
        cout << " 1. 학생 추가" << endl;
        cout << " 2. 학생목록 출력" << endl;
        cout << " 0. 종료" << endl;
        cout << "---------------" << endl;
        cout << " 선택>>";
        cin >> command;

        return command;
    }
};
class Subject
{
private:
    int id;
    char *title;

public:
    Subject(int _id, const char *_title)
        : id(_id)
    {
        title = new char[strlen(_title) + 1];

        strcpy(title, _title);
    }
    Subject(const Subject &copy)
        : Subject(copy.id, copy.title)
    {
    }

    ~Subject(void)
    {
        delete[] title;
    }
};

class Student
{
private:
    int id;
    char *name;
    Subject &subj;

public:
    Student(int _id, const char *_name, Subject &_subj)
        : id(_id), subj(_subj)
    {
        name = new char[strlen(_name) + 1];
    }
    Student(const Student &copy)
        : Student(copy.id, copy.name, copy._subj)
    {
    }
    ~Student(void)
    {
        delete[] name;
    }
};

class PManager
{
private:
    Student *pList[50];
    int index;

public:
    PManager(void)
    {
        index = 0;
    }
    int GetIndexFromOne(void)
    {
        return index + 1;
    }
    bool AddStudent(const char *name, Subject *subj)
    {
        if (index < 50)
        {
            Student *stud = new Subject(index + 1, name, subj);
            pList[index++] = stud;
            return true;
        }
        else
        {
            cout << "인덱스 초과" << endl;
            return false;
        }
    }
    Student *FindStudent(int _id)
    {
        bool find = false;
        Student *result = NULL;
        for (int i = 0; i < index; i++)
        {
            if (sList[i]->GetID() == id)
            {
                find = true;
                result = sList[i];
            }
        }

        if (!find)
        {
            cout << " >> 그런 ID의 Student는 없습니다." << endl;
            return NULL;
        }
        else
        {
            return result;
        }
    }
};
class SManager
{
private:
    Subject *sList[10];
    int index;

public:
    SManager(void)
    {
        index = 0;
    }
    bool AddSubject(int _id, const char *_title)
    {
        if (index < 10)
        {
            Subject *subj = new Subject(_id, _title);
            sList[index++] = subj;
            return true;
        }
        else
        {
            cout << "인덱스 초과" << endl;
            return false;
        }
    }
    Subject *FindSubject(int _id)
    {
        bool find = false;
        Subject *result = NULL;
        for (int i = 0; i < index; i++)
        {
            if (sList[i]->GetID() == id)
            {
                find = true;
                result = sList[i];
            }
        }

        if (!find)
        {
            cout << " >> 그런 ID의 Subject는 없습니다." << endl;
            return NULL;
        }
        else
        {
            return result;
        }
    }
};

class MainCtrl
{
public:
    MainCtrl(void)
    {
        Main();
    }
    static void Main(void)
    {
        MainMenu mainMenu;
        SManager sManager;
        PManager pManager;
        int command;
        while (1)
        {
            command = mainMenu.IssueMenu();
            if (command == 0)
            {
                cout << "프로그램을 종료합니다." << endl;
                break;
            }
            else if (command == 1)
            {
                int index = pManager.GetIndexFromOne();
                char name[101];
                cout << "<<학생정보입력>>" << endl;
                cout << " - I D: " << index << endl;
                cout << " - 이름:";
            }
            else if (command == 2)
            {
            }
            else
            {
                cout << "잘못된 입력값" << endl;
                continue;
            }
        }

        return 0;
    }
};