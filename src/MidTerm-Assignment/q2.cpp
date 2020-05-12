#include <iostream>
#include <string>

// 객체지향언어 과제2
// 2019152038 이지호

using namespace std;

class Lab
{
private:
    int id;
    string title;

public:
    Lab(int _id, string _title)
        : id(_id), title(_title)
    {
    }
    Lab(const Lab &copy)
        : Lab(copy.id, copy.title)
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

class LabList
{
private:
    Lab *labList[50];
    int index;

public:
    LabList(void)
    {
        index = 0;
    }
    ~LabList(void)
    {
        for (int i = 0; i < index; i++)
        {
            delete labList[i];
        }
    }
    bool Add(const int lID, string sName)
    {
        if (index < 50)
        {
            Lab *lab = new Lab(lID, sName);
            labList[index++] = lab;
            BubbleSort();

            return true;
        }
        else
        {
            cout << "인덱스 초과" << endl;
            return false;
        }
    }
    Lab *Find(int id)
    {
        bool find = false;
        Lab *result = NULL;
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
            cout << " >> 그런 ID의 Lab는 없습니다." << endl;
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
                    SwapLab(*labList[j], *labList[j + 1]);
                }
            }
        }

        return;
    }

    void SwapLab(Lab &a, Lab &b)
    {
        Lab temp = a;
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
        LabList labList;
        labList.Add(3, "웹그룹");
        labList.Add(1, "객체지향그룹");
        labList.Add(2, "Cpp그룹");
        labList.Add(4, "Java그룹");

        labList.ShowAll();

        int index;
        do
        {
            cout << "- Lab ID: ";
            cin >> index;

            if (index == 0)
            {
                break;
            }

            Lab *res = labList.Find(index);
            if (res == NULL)
            {
                continue;
            }
            cout << "그룹 ID   그룹명" << endl;
            cout << "-----------------------------------" << endl;
            res->Show();
            cout << "-----------------------------------" << endl
                 << endl;
        } while (true);

        return 0;
    }
};

int main(void)
{
    MainCtrl mainCtrl;

    return 0;
}