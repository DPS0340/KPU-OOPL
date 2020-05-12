#include <iostream>
#include <string>

// 객체지향언어 과제6
// 2019152038 이지호

using namespace std;

namespace ID
{
    enum
    {
        PERSON = 0,
        STUDENT,
        MENTOR
    };
};

class MainMenu
{
public:
    int IssueMenu(void)
    {
        int command;

        cout << "----- 메 뉴 -----" << endl;
        cout << " 1. 학생 추가" << endl;
        cout << " 2. 멘토 추가" << endl;
        cout << " 3. 학생목록 출력" << endl;
        cout << " 4. 멘토목록 출력" << endl;
        cout << " 5. 사람목록 전체출력" << endl;
        cout << " 6. 그룹목록 출력" << endl;
        cout << " 0. 종료" << endl;
        cout << "---------------" << endl;
        cout << " 선택>>";
        cin >> command;

        cout << endl;

        return command;
    }
};
class Person
{
protected:
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
    virtual ~Person()
    {
    }

    virtual int GetType(void)
    {
        return ID::PERSON;
    }

    string GetName(void)
    {
        return name;
    }
    int GetGroupID(void)
    {
        return groupID;
    }
    virtual void Show(string groupTitle)
    {
        return;
    }
    virtual int GetID(void)
    {
        return 0;
    }
};

class Group
{
private:
    int id;
    string title;

public:
    Group(int _id, string _title)
        : id(_id)
    {
        title = _title;
    }
    Group(const Group &copy)
        : Group(copy.id, copy.title)
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
    void SetId(int _id)
    {
        id = _id;
    }
    void SetTitle(string _title)
    {
        title = _title;
    }
    void Show(void)
    {
        cout << GetID() << "            " << GetTitle() << endl;
    }
};

class GroupList
{
private:
    Group *labList[50];
    int index;

public:
    GroupList(void)
    {
        index = 0;
    }
    ~GroupList(void)
    {
        for (int i = 0; i < index; i++)
        {
            delete labList[i];
        }
    }
    int GetIndexFromOne(void)
    {
        return index + 1;
    }
    bool Add(const int gID, string sName)
    {
        if (index < 50)
        {
            Group *sbj = new Group(gID, sName);
            labList[index++] = sbj;
            BubbleSort();

            return true;
        }
        else
        {
            cout << "인덱스 초과" << endl;
            return false;
        }
    }
    Group *Find(int id)
    {
        bool find = false;
        Group *result = NULL;
        for (int i = 0; i < index; i++)
        {
            if (labList[i]->GetID() == id)
            {
                find = true;
                result = labList[i];
            }
        }

        if (!find)
        {
            cout << " >> 그런 ID의 Group는 없습니다." << endl;
            return NULL;
        }
        else
        {
            return result;
        }
    }

    void ShowAll(void)
    {
        cout << "그룹 ID   그룹명" << endl;
        cout << "-----------------------------------" << endl;
        for (int i = 0; i < index; i++)
        {
            labList[i]->Show();
        }
        cout << "-----------------------------------" << endl;
    }

    void BubbleSort(void)
    {
        for (int i = 0; i < index; i++)
        {
            for (int j = 0; j < index - i - 1; j++)
            {
                if (labList[j]->GetID() > labList[j + 1]->GetID())
                {
                    SwapGroup(*labList[j], *labList[j + 1]);
                }
            }
        }

        return;
    }

    void SwapGroup(Group &a, Group &b)
    {
        Group temp = a;
        a = b;
        b = temp;
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

    int GetType(void)
    {
        return ID::STUDENT;
    }

    void Show(string groupTitle)
    {
        cout << name << "    " << groupID << "   " << groupTitle
             << "       " << id << "     " << year << "     " << major << endl;
    }

    int GetID(void)
    {
        return id;
    }
    int GetYear(void)
    {
        return year;
    }
    string GetMajor(void)
    {
        return major;
    }
};

class Mentor : public Person
{
private:
    int id;
    string company;

public:
    Mentor(string _name, int _groupID, int _id, string _company)
        : Person(_name, _groupID), id(_id), company(_company)
    {
    }
    Mentor(const Mentor &copy)
        : Mentor(copy.name, copy.groupID, copy.id, copy.company)
    {
    }

    int GetType(void)
    {
        return ID::MENTOR;
    }

    void Show(string groupTitle)
    {
        cout << name << "    " << groupID << "   " << groupTitle << "   " << id << "     " << company << endl;
    }

    int GetID(void)
    {
        return id;
    }
    string GetCompany(void)
    {
        return company;
    }
};

class PersonList
{
private:
    // HAS-A 관계
    Person *pList[50];
    int index;

public:
    PersonList(void)
    {
        index = 0;
    }
    ~PersonList(void)
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
    bool Add(Person *person)
    {
        if (index < 50)
        {
            pList[index++] = person;

            return true;
        }
        else
        {
            cout << "인덱스 초과" << endl;
            return false;
        }
    }
    Person *Find(int id)
    {
        bool find = false;
        Person *result = NULL;
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
            cout << " >> 그런 ID의 Person은 없습니다." << endl;
            return NULL;
        }
        else
        {
            return result;
        }
    }

    void ShowAll(GroupList &groupList)
    {
        BubbleSort();
        ShowMentors(groupList);
        ShowStudents(groupList);
    }

    void ShowStudents(GroupList &groupList)
    {
        cout << "멘토 출력 " << endl;
        cout << " 이름 "
             << "  그룹 ID   "
             << "  그룹 이름   "
             << " ID "
             << " 입학년도 "
             << " 전공 " << endl;
        cout << "-----------------------------------" << endl;
        for (int i = 0; i < index; i++)
        {
            if (pList[i]->GetType() == ID::STUDENT)
            {
                Group *group = groupList.Find(pList[i]->GetGroupID());
                string title = group->GetTitle();
                pList[i]->Show(title);
            }
        }
        cout << "-----------------------------------" << endl;
    }

    void ShowMentors(GroupList &groupList)
    {
        cout << " 이름 "
             << "  그룹 ID   "
             << "  그룹 이름   "
             << " ID "
             << " 회사명" << endl;
        cout << "-----------------------------------" << endl;
        for (int i = 0; i < index; i++)
        {
            if (pList[i]->GetType() == ID::MENTOR)
            {
                Group *group = groupList.Find(pList[i]->GetGroupID());
                string title = group->GetTitle();
                pList[i]->Show(title);
            }
        }
        cout << "-----------------------------------" << endl;
    }

    void BubbleSort(void)
    {
        for (int i = 0; i < index; i++)
        {
            for (int j = 0; j < index - i - 1; j++)
            {
                if (pList[j]->GetType() < pList[j + 1]->GetType() || pList[j]->GetID() > pList[j + 1]->GetID())
                {
                    SwapPerson(*pList[j], *pList[j + 1]);
                }
            }
        }

        return;
    }

    void SwapPerson(Person &a, Person &b)
    {
        Person temp = a;
        a = b;
        b = temp;
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
        PersonList pList;
        GroupList gList;

        gList.Add(1, "객체지향언어");
        gList.Add(2, "C++");
        gList.Add(3, "웹프로그래밍");
        gList.Add(4, "Java");

        int command;

        gList.ShowAll();
        cout << endl
             << endl;

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
                int index = pList.GetIndexFromOne();
                string name = "";
                string major = "";
                int gID;
                int sYear;
                cout << "<<학생정보입력>>" << endl;
                cout << " - I D: " << index << endl;
                cout << " - 이름: ";
                cin >> name;
                cout << " - Group ID: ";
                cin >> gID;
                cout << " - 입학년도: ";
                cin >> sYear;
                cout << " - 전공: ";
                cin >> major;

                cout << endl
                     << endl;

                Group *group = gList.Find(gID);
                if (group == NULL)
                {
                    cout << "ID에 맞는 Group을 찾지 못함" << endl
                         << endl;
                    continue;
                }

                Student *std = new Student(name, gID, index, sYear, major);

                bool res = pList.Add(std);
                if (res == true)
                {
                    cout << "학생 추가 성공" << endl
                         << endl;
                }
            }
            else if (command == 2)
            {
                int index = pList.GetIndexFromOne();
                string name;
                string company;
                int gID;
                cout << "<<멘토정보입력>>" << endl;
                cout << " - I D: " << index << endl;
                cout << " - 이름: ";
                cin >> name;
                cout << " - 회사명: ";
                cin >> company;
                cout << " - Group ID: ";
                cin >> gID;

                cout << endl
                     << endl;

                Group *group = gList.Find(gID);
                if (group == NULL)
                {
                    cout << "ID에 맞는 Group을 찾지 못함" << endl
                         << endl;
                    continue;
                }

                Mentor *std = new Mentor(name, gID, index, company);

                bool res = pList.Add(std);
                if (res == true)
                {
                    cout << "멘토 추가 성공" << endl
                         << endl;
                }
            }
            else if (command == 3)
            {
                pList.ShowStudents(gList);
                cout << endl;
            }
            else if (command == 4)
            {
                pList.ShowMentors(gList);
                cout << endl;
            }
            else if (command == 5)
            {
                pList.ShowAll(gList);
                cout << endl;
            }
            else if (command == 6)
            {
                gList.ShowAll();
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