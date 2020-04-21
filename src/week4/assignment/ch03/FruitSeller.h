#pragma once

class FruitSeller
{
private:
    int APPLE_PRICE;
    int numOfApples;
    int ORANGE_PRICE;
    int numOfOranges;
    int myMoney;

public:
    void InitMembers(int, int, int, int, int);
    int SaleApples(int);
    int SaleOranges(int);
    void ShowSalesResult(void);
};