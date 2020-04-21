#include <iostream>
#include "FruitBuyer.h"
#include "FruitSeller.h"
using namespace std;

FruitBuyer::FruitBuyer(int money)
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

void FruitBuyer::ShowBuyResult()
{
	cout << " -현재 잔액: " << myMoney << "원" << endl;
	cout << " -사과 개수: " << numOfApples << "개" << endl;
	cout << " -오렌지 개수: " << numOfOranges << "개" << endl << endl;
}

