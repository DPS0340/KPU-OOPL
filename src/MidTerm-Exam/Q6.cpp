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
            return "사람";
        case ID::STUDENT:
            return "학생";
        case ID::STAFF:
            return "교직원";
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
        printf("%-5s %-5s %-5s %-7s %-8s\n", "구분", "ID", "이름", "소속/전공",
               "연락처");
        printf("----------------------------------------\n");

        for (int i = 0; i < length; i++) {
            if (list[i]->getIdentifier() == ID::STUDENT) {
                cout << "학생   ";
            } else if (list[i]->getIdentifier() == ID::STAFF) {
                cout << "교직원  ";
            }
            list[i]->show();
        }
        printf("----------------------------------------\n");
    }
    void showStudents() {
        printf("-------------------------------------\n");
        printf("%-5s %-5s %-7s %-8s\n", "ID", "이름", "전공", "연락처");
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
        printf("%-5s %-5s %-7s %-8s\n", "ID", "이름", "소속", "연락처");
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
        printf("----------------------------------------\n");
        printf("%-5s %-5s %-5s %-7s %-8s\n", "추적자", "ID", "이름",
               "소속/전공", "연락처");
        printf("----------------------------------------\n");
        for (int i = 0; i < length; i++) {
            Contact *p = candidates[i];
            printf("%-5s %-5d %-5s %-6s %-10s\n",
                   ContactTypeShower::show(p->getIdentifier()), p->getId(),
                   p->getName(), p->getMajorOrOrg(), p->getNumber());
        }
        printf("----------------------------------------\n");
    }
    Contact *getConf() { return confirmed; }
    int getLength() { return length; }
    Contact *getElementByName(const char *name) {
        for (int i = 0; i < length; i++) {
            if (strcmp(candidates[i]->getName(), name) == 0) {
                return candidates[i];
            }
        }
        return nullptr;
    }
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
    TraceGroup *getElementByName(const char *name) {
        for (int i = 0; i < index; i++) {
            if (strcmp(traceGroupList[i]->getConf()->getName(), name) == 0) {
                return traceGroupList[i];
            }
        }
        return nullptr;
    }
    void show() {
        Contact *p;
        printf("----------------\n");
        printf("ID    확진자   추적자 수\n");
        printf("----------------\n");
        for (int i = 0; i < index; i++) {
            p = traceGroupList[i]->getConf();
            printf("%-4d   %-6s %-4d\n", i + 1, p->getName(),
                   traceGroupList[i]->getLength());
        }
        printf("----------------\n");
    }
    int getNextIndex() { return index + 1; }
};

class Menu {
  public:
    static void show(ContactList pList, TraceGroupList tList) {
        int command;
        int id;
        int temp;
        char name[50];
        char arg2[50];
        char arg3[50];
        Contact *p;
        TraceGroup *t;
        while (1) {
            cout << "---------< 메 뉴 >----------" << endl;
            cout << " 1. 학생 추가" << endl;
            cout << " 2. 교직원 추가" << endl << endl;
            cout << " 3. 학생 목록 조회" << endl;
            cout << " 4. 교직원 목록 조회" << endl;
            cout << " 5. 모든 컨택 조회" << endl << endl;
            cout << " 6. 추적그룹 추가" << endl;
            cout << " 7. 추적그룹 구성" << endl;
            cout << " 8. 추적그룹 목록 조회" << endl;
            cout << " 9. 추적그룹별 조회" << endl;
            cout << " 99.화면정리" << endl;
            cout << " 0. 종료" << endl;
            cout << "--------------------------" << endl;
            cout << " 선택>>";
            cin >> command;
            cout << endl << "=> ";
            switch (command) {
            case 1:
                id = pList.getNextIndex();
                cout << " 1. 학생 추가" << endl;
                cout << "====학생정보입력====" << endl;
                cout << " - ID: " << id << endl;
                cout << " - 이름: ";
                cin >> name;
                cout << " - 전화: ";
                cin >> arg2;
                cout << " - 전공: ";
                cin >> arg3;
                pList.add(new Student(id, name, arg3, arg2));
                cout << "===================" << endl;
                break;
            case 2:
                id = pList.getNextIndex();
                cout << " 2. 교직원 추가" << endl << endl;
                cout << "====교직원정보입력====" << endl;
                cout << " - ID: " << id << endl;
                cout << " - 이름: ";
                cin >> name;
                cout << " - 전화: ";
                cin >> arg2;
                cout << " - 소속: ";
                cin >> arg3;
                pList.add(new Staff(id, name, arg3, arg2));
                cout << "====================" << endl;
                break;
            case 3:
                cout << " 3. 학생 목록 조회" << endl;
                pList.showStudents();
                break;
            case 4:
                cout << " 4. 교직원 목록 조회" << endl;
                pList.showStaffs();
                break;
            case 5:
                cout << " 5. 모든 컨택 조회" << endl << endl;
                pList.showAll();
                break;
            case 6:
                cout << " 6. 추적그룹 추가" << endl;
                cout << "- 확진자 이름 : ";
                cin >> name;
                p = pList.getPersonByName(name);
                if (tList.getElementByName(name) != nullptr) {
                    cout << "이 확진자는 이미 있습니다." << endl;
                    break;
                }
                if (p == nullptr) {
                    cout << "그런 이름을 가진 사람은 없습니다." << endl;
                    break;
                }
                tList.Add(new TraceGroup(p));
                cout << "=> Successfully added..." << endl;
                break;
            case 7:
                cout << " 7. 추적그룹 구성" << endl;
                tList.show();
                cout << "- 추적그룹 ID: ";
                cin >> id;
                t = tList.getElemByIdx(id - 1);
                if (t == nullptr) {
                    cout << "그런 그룹은 없습니다." << endl;
                    break;
                }
                while (true) {
                    cout << "- 추적 대상자 이름: ";
                    cin >> name;
                    if (t->getElementByName(name) != nullptr) {
                        cout << "이 대상자는 이미 그룹에 있습니다." << endl;
                    } else {
                        p = pList.getPersonByName(name);
                        if (p == nullptr) {
                            cout << "그런 이름을 가진 사람은 없습니다." << endl;
                        } else {
                            t->add(p);
                        }
                    }
                    cout << "계속 추가? (1 for Yes / 0 for No): ";
                    cin >> temp;
                    if (temp == 1) {
                        continue;
                    } else {
                        break;
                    }
                }
                break;
            case 8:
                cout << " 8. 추적그룹 목록 조회" << endl;
                tList.show();
                break;
            case 9:
                cout << " 9. 추적그룹별 조회" << endl;
                tList.show();
                cout << "- 추적대상 그룹 ID 입력: ";
                cin >> id;
                t = tList.getElemByIdx(id - 1);
                if (t == nullptr) {
                    cout << "그런 그룹은 없습니다." << endl;
                    break;
                }
                t->showCand();
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

        pList.add(new Student(1, "김철수", "컴퓨터공학", "0101112222"));
        pList.add(new Student(2, "홍길동", "컴퓨터공학", "0101113333"));
        pList.add(new Student(3, "김동수", "소프트웨어", "0101114444"));
        pList.add(new Student(4, "이철희", "소프트웨어", "0101115555"));
        pList.add(new Staff(5, "이영희", "교무처", "0102221234"));
        pList.add(new Staff(6, "박진희", "학생처", "0102221235"));
        pList.add(new Staff(7, "김일동", "국제처", "0102221236"));
        pList.add(new Staff(8, "정진선", "기획처", "0102221237"));
        pList.add(new Staff(9, "전두원", "입학처", "0102221238"));
        pList.add(new Student(10, "김학생", "IT경영", "01012341234"));
        pList.add(new Staff(11, "김직원", "학생처", "01033331111"));

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