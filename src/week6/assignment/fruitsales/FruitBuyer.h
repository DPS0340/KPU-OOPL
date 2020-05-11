#pragma once

#include "FruitSeller.h"

class FruitBuyer
{
private:
    int numOfApples;
    int myMoney;

public:
    void InitMembers(int);
    void BuyApples(FruitSeller &seller, int money);
    void ShowBuyResult(void);
};