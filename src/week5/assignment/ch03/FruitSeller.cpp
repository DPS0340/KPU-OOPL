#include "FruitSeller.h"
#include <iostream>

using namespace std;

void FruitSeller::InitMembers(int apple_price, int orange_price, int apple_num, int orange_num, int money)
{
    APPLE_PRICE = apple_price;
    ORANGE_PRICE = orange_price;
    numOfApples = apple_num;
    numOfOranges = orange_num;
    myMoney = money;
}

int FruitSeller::SaleApples(int money)
{
    int num = money / APPLE_PRICE;
    numOfApples -= num;
    myMoney += money;
    return num;
}
int FruitSeller::SaleOranges(int money)
{
    int num = money / ORANGE_PRICE;
    numOfOranges -= num;
    myMoney += money;
    return num;
}
void FruitSeller::ShowSalesResult(void)
{
    cout << "남은 사과: " << numOfApples << endl;
    cout << "남은 오렌지: " << numOfOranges << endl;
    cout << "판매 수익: " << myMoney << endl
         << endl;
}