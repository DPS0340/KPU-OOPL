#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <cstring>

class Student;

class Student {
private:
  int id; 
  char *name;
  char *major;
  char *number;

public:
  Student(int _id, const char *_name, const char *_major, const char *_number) : id(_id) {
      name = new char[strlen(_name) + 1];
      major = new char[strlen(_major) + 1];
      number = new char[strlen(_number) + 1];
      strcpy(name, _name);
      strcpy(major, _major);
      strcpy(number, _number);
    }
  ~Student() {
    delete name;
    delete major;
    delete number;
  }
  void show() { printf("%-3d %-5s %-7s %-8s\n", id, name, major, number);
  }
};

int main() {
  // ����Ʈ ��� ���
  Student std = Student(1, "��ö��", "��ǻ�Ͱ���", "0101112222");
  printf("----------------------------------\n");
  printf("%-5s %-5s %-7s %-8s\n", "ID", "�̸�", "����", "����ó");
  printf("----------------------------------\n");
  std.show();
  printf("----------------------------------\n");
  return 0;
}