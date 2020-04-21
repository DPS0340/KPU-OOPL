#include "FruitBuyer.h"
#include <iostream>
#include "FruitSeller.h"

using namespace std;

void FruitBuyer::InitMembers(int money)
{
    myMoney = money;
    numOfApples = 0;
    numOfOranges = 0;
}
void FruitBuyer::BuyApples(FruitSeller &seller, int money)
{
    numOfApples += seller.SaleApples(money);
    myMoney -= money;
}
void FruitBuyer::BuyOranges(FruitSeller &seller, int money)
{
    numOfOranges += seller.SaleOranges(money);
    myMoney -= money;
}
void FruitBuyer::ShowBuyResult(void)
{
    cout << "현재 잔액: " << myMoney << endl;
    cout << "사과 개수: " << numOfApples << endl;
    cout << "오렌지 개수: " << numOfOranges << endl
         << endl;
}