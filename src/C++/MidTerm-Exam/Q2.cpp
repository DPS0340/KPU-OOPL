#define _CRT_SECURE_NO_WARNINGS
#include <cstring>
#include <iostream>

using namespace std;

class Menu;
class MainCtrl;

class Menu {
public:
  static void show() { 
      int command;
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
        cout << " 1. �л� �߰�" << endl;
        break;
      case 2:
        cout << " 2. ������ �߰�" << endl << endl;
        break;
      case 3:
        cout << " 3. �л� ��� ��ȸ" << endl;
        break;
      case 4:
        cout << " 4. ������ ��� ��ȸ" << endl;
        break;
      case 5:
        cout << " 5. ��� ���� ��ȸ" << endl << endl;
        break;
      case 6:
        cout << " 6. �����׷� �߰�" << endl;
        break;
      case 7:
        cout << " 7. �����׷� ����" << endl;
        break;
      case 8:
        cout << " 8. �����׷� ��� ��ȸ" << endl;
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
    MainCtrl() { Menu::show();

  }
};

int main() {
  MainCtrl mainCtrl;
  return 0;
}