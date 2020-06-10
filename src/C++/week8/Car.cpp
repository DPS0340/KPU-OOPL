#include <iostream>

using namespace std;

class Car
{
private:
    int gasolineGauge;

public:
    int GetGasGauge()
    {
        return gasolineGauge;
    }
};

class HybridCar : public Car
{
private:
    int electricGauge;

public:
    int GetElecGauge()
    {
        return electricGauge;
    }
};

class HyBridWaterCar : public HybridCar
{
private:
    int waterGauge;

public:
    void ShowCurrentGauge()
    {
        cout << "잔여 가솔린: " << GetGasGauge() << endl;
        cout << "잔여 전기량: " << GetElecGauge() << endl;
        cout << "잔여 워터량: " << waterGauge << endl;
    }
};