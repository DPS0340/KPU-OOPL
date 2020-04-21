#include <iostream>

using namespace std;

int main(void) {
    int n;

    while (true) {
        cout << "-------"
             << "<Menu>"
             << "-------";
        cout << endl;
        cout << "1.   Menu item1" << endl;
        cout << "2.   Menu item2" << endl;
        cout << "3.   Menu item3" << endl;
        cout << "0.   Exit" << endl;
        cout << "-------"
             << "------"
             << "-------";
        cout << endl;
        cout << "Your choice> > ";
        cin >> n;
        switch (n) {
            case 1:
                cout << "Menu item" << n << " is selected." << endl << endl;
                break;
            case 2:
                cout << "Menu item" << n << " is selected." << endl << endl;
                break;
            case 3:
                cout << "Menu item" << n << " is selected." << endl << endl;
                break;
            case 0:
                return 0;
                break;
            default:
                cout << "no such menu item." << endl;
        }
    }
    return 0;
}
