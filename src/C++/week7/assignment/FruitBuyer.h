#ifndef __FSB__
#define __FSB__
class FruitSeller;

class FruitBuyer
{
	int myMoney;		// private:
	int numOfApples;	// private:
	int numOfOranges;	// private:

public:
	FruitBuyer(int money);
	void BuyApples(FruitSeller &seller, int money);
	void BuyOranges(FruitSeller &seller, int money);
	void ShowBuyResult();
};

#endif
