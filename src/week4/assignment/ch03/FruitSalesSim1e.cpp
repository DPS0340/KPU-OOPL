#include <iostream>
#include "FruitSeller.h"
#include "FruitBuyer.h"

using namespace std;

int main(void)
{
    FruitSeller sellerABC;
    FruitSeller sellerXYZ;
    sellerABC.InitMembers(1000, 1500, 20, 10, 0);
    sellerXYZ.InitMembers(1000, 1500, 20, 10, 0);
    FruitBuyer buyerKim;
    FruitBuyer buyerLee;
    buyerKim.InitMembers(5000);
    buyerLee.InitMembers(3000);
    buyerKim.BuyApples(sellerABC, 2000);
    buyerKim.BuyOranges(sellerXYZ, 3000);
    buyerLee.BuyApples(sellerXYZ, 2000);

    cout << "과일 판매자 sellerABC의 현황" << endl;
    sellerABC.ShowSalesResult();
    cout << "과일 판매자 sellerXYZ의 현황" << endl;
    sellerXYZ.ShowSalesResult();
    cout << "과일 구매자 buyerKim의 현황" << endl;
    buyerKim.ShowBuyResult();
    cout << "과일 구매자 buyerLee의 현황" << endl;
    buyerLee.ShowBuyResult();

    return 0;
}