#pragma once

#include "FruitSeller.h"

class FruitBuyer
{
private:
    int numOfApples;
    int numOfOranges;
    int myMoney;

public:
    void InitMembers(int);
    void BuyApples(FruitSeller &seller, int money);
    void BuyOranges(FruitSeller &seller, int money);
    void ShowBuyResult(void);
};