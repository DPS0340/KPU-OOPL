#include <iostream>
#include <cstring>

using namespace std;

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

    int GetID(void)
    {
        return id;
    }
    const char *GetTitle(void)
    {
        return title;
    }
    void SetId(int _id)
    {
        id = _id;
    }
    void SetTitle(const char *_title)
    {
        delete[] title;

        title = new char[strlen(_title) + 1];

        strcpy(title, _title);
    }
    void Show(void)
    {
        cout << GetID() << "            " << GetTitle() << endl;
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
    bool Add(const int sID, const char *sName)
    {
        if (index < 10)
        {
            Subject *sbj = new Subject(sID, sName);
            sList[index++] = sbj;
            BubbleSort();

            return true;
        }
        else
        {
            cout << "인덱스 초과" << endl;
            return false;
        }
    }
    Subject *Find(int id)
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

    void ShowAll(void)
    {
        cout << "Subject ID          Subject 이름" << endl;
        cout << "-----------------------------------" << endl;
        for (int i = 0; i < index; i++)
        {
            sList[i]->Show();
        }
        cout << "-----------------------------------" << endl;
    }

    void BubbleSort(void)
    {
        for (int i = 0; i < index; i++)
        {
            for (int j = 0; j < index - i - 1; j++)
            {
                if (sList[j]->GetID() > sList[j + 1]->GetID())
                {
                    SwapSubject(*sList[j], *sList[j + 1]);
                }
            }
        }

        return;
    }

    void SwapSubject(Subject &a, Subject &b)
    {
        Subject temp = a;
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
        SManager sManager;
        sManager.Add(3, "웹프로그래밍");
        sManager.Add(1, "객체지향언어");
        sManager.Add(2, "C++");
        sManager.Add(4, "Java");

        sManager.ShowAll();

        int index;
        do
        {
            cout << "- Subject ID: ";
            cin >> index;

            if (index == 0)
            {
                break;
            }

            Subject *res = sManager.Find(index);
            if (res == NULL)
            {
                continue;
            }
            cout << "Subject ID          Subject 이름" << endl;
            cout << "-----------------------------------" << endl;
            res->Show();
            cout << "-----------------------------------" << endl;
        } while (true);

        return 0;
    }
};

int main(void)
{
    MainCtrl mainCtrl;

    return 0;
}