class FruitSeller
{
private:
    int APPLE_PRICE;
    int numOfApples;
    int myMoney;

public:
    void InitMembers(int, int, int);
    int SaleApples(int);
    void ShowSalesResult(void);
};