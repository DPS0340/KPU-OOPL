#pragma once

class Point
{
private:
    int x;
    int y;

public:
    bool InitMembers(int, int);
    int GetX() const;
    int GetY() const;
    bool SetX(int);
    bool SetY(int);
};