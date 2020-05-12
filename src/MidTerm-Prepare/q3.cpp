#include <iostream>
#include <string>

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
    string title;

public:
    Subject(int _id, string _title)
        : id(_id)
    {
        title = _title;
    }
    Subject(const Subject &copy)
        : Subject(copy.id, copy.title)
    {
    }

    int GetID(void)
    {
        return id;
    }

    string GetTitle(void)
    {
        return title;
    }
};

class Student
{
private:
    int id;
    string name;
    Subject &subj;

public:
    Student(int _id, string _name, Subject &_subj)
        : id(_id), subj(_subj)
    {
        name = _name;
    }
    Student(const Student &copy)
        : Student(copy.id, copy.name, copy.subj)
    {
    }
    void Show(void)
    {
        cout << " " << GetID() << "            " << GetName() << "      " << subj.GetID() << "          " << subj.GetTitle() << endl;
    }
    int GetID(void)
    {
        return id;
    }

    string GetName(void)
    {
        return name;
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
    ~PManager(void)
    {
        for (int i = 0; i < index; i++)
        {
            delete pList[i];
        }
    }
    int GetIndexFromOne(void)
    {
        return index + 1;
    }
    bool AddStudent(string name, Subject &subj)
    {
        if (index < 50)
        {
            Student *stud = new Student(GetIndexFromOne(), name, subj);
            pList[index++] = stud;
            return true;
        }
        else
        {
            cout << "인덱스 초과" << endl;
            return false;
        }
    }
    Student *FindStudent(int id)
    {
        bool find = false;
        Student *result = NULL;
        for (int i = 0; i < index; i++)
        {
            if (pList[i]->GetID() == id)
            {
                find = true;
                result = pList[i];
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

    void ShowAll(void)
    {
        cout << "---------------------------------------------------" << endl;
        cout << " 학생ID       이름    Subject ID       Subject 이름" << endl;
        cout << "---------------------------------------------------" << endl;
        for (int i = 0; i < index; i++)
        {
            pList[i]->Show();
        }
        cout << "---------------------------------------------------" << endl;
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
    ~SManager(void)
    {
        for (int i = 0; i < index; i++)
        {
            delete sList[i];
        }
    }
    bool AddSubject(int _id, string _title)
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
    Subject *FindSubject(int id)
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
    static int Main(void)
    {
        MainMenu mainMenu;
        SManager sManager;
        PManager pManager;

        sManager.AddSubject(1, "객체지향언어");
        sManager.AddSubject(2, "C++");
        sManager.AddSubject(3, "웹프로그래밍");
        sManager.AddSubject(4, "Java");

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
                int sID;
                cout << "<<학생정보입력>>" << endl;
                cout << " - I D: " << index << endl;
                cout << " - 이름: ";
                cin >> name;
                cout << " - Subject ID: ";
                cin >> sID;
                cout << endl;

                Subject *subject = sManager.FindSubject(sID);
                if (subject == NULL)
                {
                    cout << "ID에 맞는 Subject를 찾지 못함" << endl;
                    continue;
                }

                pManager.AddStudent(name, *subject);
            }
            else if (command == 2)
            {
                pManager.ShowAll();
                cout << endl;
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

int main(void)
{
    MainCtrl mainCtrl;

    return 0;
}