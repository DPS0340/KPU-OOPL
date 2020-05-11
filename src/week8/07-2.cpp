#include <iostream>

using namespace std;

class Rectangle
{
protected:
    int width;
    int height;

public:
    Rectangle(int _width, int _height)
        : width(_width), height(_height)
    {
    }
    void ShowAreaInfo(void)
    {
        cout << "면적: " << width * height << endl;
    }
};

class Square : public Rectangle
{
public:
    Square(int length)
        : Rectangle(length, length)
    {
    }
};

int main(void)
{
    Rectangle rec(4, 3);
    rec.ShowAreaInfo();

    Square sqr(7);
    sqr.ShowAreaInfo();

    return 0;
}