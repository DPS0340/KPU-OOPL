#ifndef __FSH__
#define __FSH__

class FruitSeller
{
private:
	const int APPLE_PRICE;
	const int ORANGE_PRICE;
	int numOfApples;
	int numOfOranges;
	int myMoney;

public:
    FruitSeller(int, int, int, int, int);
	int SaleApples(int money);
	int SaleOranges(int money);
	void ShowSalesResult();
};

#endif
