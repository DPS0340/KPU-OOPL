#include <iostream>
#include "FruitSeller.h"
#include "FruitBuyer.h"
using namespace std;

int main(void)
{
	FruitSeller sellerABC = FruitSeller(1000, 1500, 20, 10, 0);
	FruitSeller sellerXYZ = FruitSeller(1000, 1500, 20, 10, 0);

	FruitBuyer buyerKim = FruitBuyer(5000);
	FruitBuyer buyerLee = FruitBuyer(3000);

	buyerKim.BuyApples(sellerABC, 2000);
	buyerKim.BuyOranges(sellerXYZ, 3000);

	buyerLee.BuyApples(sellerXYZ, 2000);

	cout << "���� �Ǹ��� sellerABC�� ��Ȳ" << endl;
	sellerABC.ShowSalesResult();
	cout << "���� �Ǹ��� sellerXYZ�� ��Ȳ" << endl;
	sellerXYZ.ShowSalesResult();

	cout << "���� ������ buyerKim�� ��Ȳ" << endl;
	buyerKim.ShowBuyResult();
	cout << "���� ������ buyerLee�� ��Ȳ" << endl;
	buyerLee.ShowBuyResult();

	return 0;
}
