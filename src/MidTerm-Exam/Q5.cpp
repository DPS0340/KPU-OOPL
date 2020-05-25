#define _CRT_SECURE_NO_WARNINGS
#include <cstring>
#include <iostream>

using namespace std;

namespace ID {
enum { PERSON = 0, STUDENT, STAFF };
};

class ContactTypeShower;
class Contact;
class Student;
class Staff;
class ContactList;
class TraceGroup;
class TraceGroupList;
class MainCtrl;
class Menu;

class ContactTypeShower {
  public:
    static const char *show(int id) {
        switch (id) {
        case ID::PERSON:
            return "���";
        case ID::STUDENT:
            return "�л�";
        case ID::STAFF:
            return "������";
        default:
            return "";
        }
    }
};

class Contact {
  protected:
    int id;
    char *name;
    char *number;

  public:
    Contact(int _id, const char *_name, const char *_number) : id(_id) {
        name = new char[strlen(_name) + 1];
        number = new char[strlen(_number) + 1];
        strcpy(name, _name);
        strcpy(number, _number);
    }
    virtual ~Contact() {
        delete name;
        delete number;
    }
    virtual void show() { return; }
    virtual int getIdentifier() { return ID::PERSON; }
    int getId() { return id; }
    const char *getName() { return name; }
    const char *getNumber() { return number; }
    virtual const char *getMajorOrOrg() { return nullptr; }
};

class Student : public Contact {
  private:
    char *major;

  public:
    Student(int _id, const char *_name, const char *_major, const char *_number)
        : Contact(_id, _name, _number) {
        major = new char[strlen(_major) + 1];
        strcpy(major, _major);
    }
    ~Student() { delete major; }
    void show() { printf("%-3d %-5s %-7s %-8s\n", id, name, major, number); }
    virtual int getIdentifier() { return ID::STUDENT; };
    const char *getMajor() { return major; }
    const char *getMajorOrOrg() { return getMajor(); }
};

class Staff : public Contact {
  private:
    char *org;

  public:
    Staff(int _id, const char *_name, const char *_org, const char *_number)
        : Contact(_id, _name, _number) {
        org = new char[strlen(_org) + 1];
        strcpy(org, _org);
    }
    ~Staff() { delete org; }
    void show() { printf("%-3d %-5s %-7s %-8s\n", id, name, org, number); }
    virtual int getIdentifier() { return ID::STAFF; };
    const char *getOrg() { return org; }
    const char *getMajorOrOrg() { return getOrg(); }
};

class ContactList {
  private:
    Contact *list[50];
    int length;

  public:
    ContactList() { length = 0; }
    int getNextIndex() { return length + 1; }
    void add(Contact *p) { list[length++] = p; }
    void showAll() {
        printf("----------------------------------------\n");
        printf("%-5s %-5s %-5s %-7s %-8s\n", "����", "ID", "�̸�", "�Ҽ�/����",
               "����ó");
        printf("----------------------------------------\n");

        for (int i = 0; i < length; i++) {
            if (list[i]->getIdentifier() == ID::STUDENT) {
                cout << "�л�   ";
            } else if (list[i]->getIdentifier() == ID::STAFF) {
                cout << "������  ";
            }
            list[i]->show();
        }
        printf("----------------------------------------\n");
    }
    void showStudents() {
        printf("-------------------------------------\n");
        printf("%-5s %-5s %-7s %-8s\n", "ID", "�̸�", "����", "����ó");
        printf("-------------------------------------\n");

        for (int i = 0; i < length; i++) {
            if (list[i]->getIdentifier() == ID::STUDENT) {
                list[i]->show();
            }
        }
        printf("-------------------------------------\n");
    }
    void showStaffs() {
        printf("-------------------------------------\n");
        printf("%-5s %-5s %-7s %-8s\n", "ID", "�̸�", "�Ҽ�", "����ó");
        printf("-------------------------------------\n");

        for (int i = 0; i < length; i++) {
            if (list[i]->getIdentifier() == ID::STAFF) {
                list[i]->show();
            }
        }
        printf("-------------------------------------\n");
    }
    Contact *getPersonByIndex(int idx) {
        if (length <= idx) {
            return nullptr;
        } else {
            return list[idx];
        }
    }
    Contact *getPersonByName(const char *name) {
        for (int i = 0; i < length; i++) {
            if (strcmp(list[i]->getName(), name) == 0) {
                return list[i];
            }
        }

        return nullptr;
    }
};

class TraceGroup {
  private:
    int id;
    int length;
    Contact *confirmed;
    Contact *candidates[100];

  public:
    TraceGroup(Contact *conf) {
        id = 0;
        confirmed = conf;
        length = 0;
    }
    void add(Contact *newly) { candidates[length++] = newly; }
    void showCand() {
        for (int i = 0; i < length; i++) {
            Contact *p = candidates[i];
            printf("%-5s %-5d %-5s %-6s %-10s\n",
                   ContactTypeShower::show(p->getIdentifier()), p->getId(),
                   p->getName(), p->getMajorOrOrg(), p->getNumber());
        }
    }
    Contact *getConf() { return confirmed; }
    int getLength() { return length; }
};

class TraceGroupList {
  private:
    TraceGroup *traceGroupList[100];
    int index;

  public:
    TraceGroupList() { index = 0; }
    void Add(TraceGroup *traceGroup) { traceGroupList[index++] = traceGroup; }
    TraceGroup *getElemByIdx(int idx) {
        if (idx >= index) {
            return nullptr;
        } else {
            return traceGroupList[idx];
        }
    }
    void show() {
        Contact *p;
        printf("----------------\n");
        printf("ID    Ȯ����   ������ ��\n");
        printf("----------------\n");
        for (int i = 0; i < index; i++) {
            p = traceGroupList[i]->getConf();
            printf("%-4d   %-6s %-4d\n", p->getId(), p->getName(),
                   traceGroupList[i]->getLength());
        }
        printf("----------------\n");
    }
    TraceGroup *getElementByName(const char *name) {
        for (int i = 0; i < index; i++) {
            if (strcmp(traceGroupList[i]->getConf()->getName(), name) == 0) {
                return traceGroupList[i];
            }
        }
        return nullptr;
    }
};

class Menu {
  public:
    static void show(ContactList pList, TraceGroupList tList) {
        int command;
        int id;
        char name[50];
        char arg2[50];
        char arg3[50];
        Contact *p;
        while (1) {
            cout << "---------< �� �� >----------" << endl;
            cout << " 1. �л� �߰�" << endl;
            cout << " 2. ������ �߰�" << endl << endl;
            cout << " 3. �л� ��� ��ȸ" << endl;
            cout << " 4. ������ ��� ��ȸ" << endl;
            cout << " 5. ��� ���� ��ȸ" << endl << endl;
            cout << " 6. �����׷� �߰�" << endl;
            cout << " 7. �����׷� ����" << endl;
            cout << " 8. �����׷� ��� ��ȸ" << endl;
            cout << " 9. �����׷캰 ��ȸ" << endl;
            cout << " 99.ȭ������" << endl;
            cout << " 0. ����" << endl;
            cout << "--------------------------" << endl;
            cout << " ����>>";
            cin >> command;
            cout << endl << "=> ";
            switch (command) {
            case 1:
                id = pList.getNextIndex();
                cout << " 1. �л� �߰�" << endl;
                cout << "====�л������Է�====" << endl;
                cout << " - ID: " << id << endl;
                cout << " - �̸�: ";
                cin >> name;
                cout << " - ��ȭ: ";
                cin >> arg2;
                cout << " - ����: ";
                cin >> arg3;
                pList.add(new Student(id, name, arg3, arg2));
                cout << "===================" << endl;
                break;
            case 2:
                id = pList.getNextIndex();
                cout << " 2. ������ �߰�" << endl << endl;
                cout << "====�����������Է�====" << endl;
                cout << " - ID: " << id << endl;
                cout << " - �̸�: ";
                cin >> name;
                cout << " - ��ȭ: ";
                cin >> arg2;
                cout << " - �Ҽ�: ";
                cin >> arg3;
                pList.add(new Staff(id, name, arg3, arg2));
                cout << "====================" << endl;
                break;
            case 3:
                cout << " 3. �л� ��� ��ȸ" << endl;
                pList.showStudents();
                break;
            case 4:
                cout << " 4. ������ ��� ��ȸ" << endl;
                pList.showStaffs();
                break;
            case 5:
                cout << " 5. ��� ���� ��ȸ" << endl << endl;
                pList.showAll();
                break;
            case 6:
                cout << " 6. �����׷� �߰�" << endl;
                cout << "- Ȯ���� �̸� : ";
                cin >> name;
                if (tList.getElementByName(name) != nullptr) {
                    cout << "�� Ȯ���ڴ� �̹� �ֽ��ϴ�." << endl;
                    break;
                }
                p = pList.getPersonByName(name);
                if (p == nullptr) {
                    cout << "�׷� �̸��� ���� ����� "
                            "�����ϴ�."
                         << endl;
                    break;
                }
                tList.Add(new TraceGroup(p));
                cout << "=> Successfully added..." << endl;
                break;
            case 7:
                cout << " 7. �����׷� ����" << endl;
                break;
            case 8:
                cout << " 8. �����׷� ��� ��ȸ" << endl;
                tList.show();
                break;
            case 9:
                cout << " 9. �����׷캰 ��ȸ" << endl;
                break;
            case 99:
                system("CLS");
                break;
            case 0:
                exit(0);
            }
        }
    }
};

class MainCtrl {
  public:
    MainCtrl() {

        ContactList pList;
        TraceGroupList tList;

        pList.add(new Student(1, "��ö��", "��ǻ�Ͱ���", "0101112222"));
        pList.add(new Student(2, "ȫ�浿", "��ǻ�Ͱ���", "0101113333"));
        pList.add(new Student(3, "�赿��", "����Ʈ����", "0101114444"));
        pList.add(new Student(4, "��ö��", "����Ʈ����", "0101115555"));
        pList.add(new Staff(5, "�̿���", "����ó", "0102221234"));
        pList.add(new Staff(6, "������", "�л�ó", "0102221235"));
        pList.add(new Staff(7, "���ϵ�", "����ó", "0102221236"));
        pList.add(new Staff(8, "������", "��ȹó", "0102221237"));
        pList.add(new Staff(9, "���ο�", "����ó", "0102221238"));
        pList.add(new Student(10, "���л�", "IT�濵", "01012341234"));
        pList.add(new Staff(11, "������", "�л�ó", "01033331111"));

        TraceGroup *tg1 = new TraceGroup(pList.getPersonByIndex(0));
        TraceGroup *tg2 = new TraceGroup(pList.getPersonByIndex(2));

        tg1->add(pList.getPersonByIndex(1));
        tg1->add(pList.getPersonByIndex(4));
        tg2->add(pList.getPersonByIndex(5));
        tg2->add(pList.getPersonByIndex(6));
        tg2->add(pList.getPersonByIndex(7));

        tList.Add(tg1);
        tList.Add(tg2);

        Menu::show(pList, tList);
    }
};

int main() {
    MainCtrl mainCtrl;
    return 0;
}