#include <iostream>
#include <string>

namespace COMP_POS {
    enum {
        CLERK,
        SENIOR,
        ASSIST,
        MANAGER
    };
}

class NameCard {
private:
std::string name;
std::string companyName;
std::string phoneNumber;
int position;

void ShowPosition(void) {
    if(position == COMP_POS::CLERK) {
        std::cout << "직급: 사원" << std::endl;
    } else if(position == COMP_POS::SENIOR) {
        std::cout << "직급: 주임" << std::endl;
    } else if(position == COMP_POS::ASSIST) {
        std::cout << "직급: 대리" << std::endl;
    } else if(position == COMP_POS::MANAGER) {
        std::cout << "직급: 과장" << std::endl;
    }
}
public:
NameCard(std::string _name, std::string _companyName, std::string _phoneNumber, int _position) {
    name = _name;
    companyName = _companyName;
    phoneNumber = _phoneNumber;
    position = _position;
}
void ShowNameCardInfo(void) {
    std::cout << "이름: " << name << std::endl;
    std::cout << "회사: " << companyName << std::endl;
    std::cout << "전화번호: " << phoneNumber << std::endl;
    ShowPosition();
    std::cout << std::endl;
}
};

int main(void) {
    NameCard manClerk("Lee", "ABCEng", "010-1111-2222", COMP_POS::CLERK);
    NameCard manSENIOR("Hong", "OrangeEng", "010-3333-4444", COMP_POS::SENIOR);
    NameCard manAssist("Kim", "SoGoodComp", "010-5555-6666", COMP_POS::ASSIST);
    manClerk.ShowNameCardInfo();
    manSENIOR.ShowNameCardInfo();
    manAssist.ShowNameCardInfo();
    return 0;
}