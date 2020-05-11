#include <iostream>
#include <cstring>

using namespace std;

class Book
{
protected:
    char *title;
    char *isbn;
    int price;

public:
    Book(char *_title, char *_isbn, int _price)
        : price(_price)
    {
        title = new char[strlen(_title) + 1];
        isbn = new char[strlen(_isbn) + 1];

        strcpy(title, _title);
        strcpy(isbn, _isbn);
    }
    Book(const Book &copy)
        : Book(copy.title, copy.isbn, copy.price)
    {
    }

    virtual ~Book(void)
    {
        cout << "Book destructor called" << endl;
        delete[] title;
        delete[] isbn;
    }

    void ShowBookInfo(void)
    {
        cout << "제목   : " << title << endl;
        cout << "ISBN  : " << isbn << endl;
        cout << "가격   : " << price << endl;
    }
};

class EBook : public Book
{
private:
    char *DRMKey;

public:
    EBook(char *_title, char *_isbn, int _price, char *_DRMKey)
        : Book(_title, _isbn, _price)
    {
        DRMKey = new char[strlen(_DRMKey) + 1];

        strcpy(DRMKey, _DRMKey);
    }
    EBook(const EBook &copy)
        : EBook(copy.title, copy.isbn, copy.price, copy.DRMKey)
    {
    }

    ~EBook(void)
    {
        cout << "EBook destructor called" << endl;
        delete[] DRMKey;
    }

    void ShowEBookInfo(void)
    {
        ShowBookInfo();
        cout << "인증키  : " << DRMKey << endl;
    }
};

class PaperBook : public Book
{
private:
    int serial;

public:
    PaperBook(char *_title, char *_isbn, int _price, int _serial)
        : Book(_title, _isbn, _price), serial(_serial)
    {
    }
    PaperBook(const PaperBook &copy)
        : PaperBook(copy.title, copy.isbn, copy.price, copy.serial)
    {
    }

    void setSerial(int _serial)
    {
        serial = _serial;
    }

    void ShowPBookInfo(void)
    {
        ShowBookInfo();
        cout << "시리얼  : " << serial << endl;
    }
};

int main(void)
{
    EBook eBook("좋은C++ eBook", "555-1234-123-1", 10000, "asd123kbf");
    eBook.ShowEBookInfo();
    cout << endl;

    PaperBook pBook("좋은C++ pBook", "555-1234-123-1", 10000, 12345);
    pBook.ShowPBookInfo();
    cout << endl;

    PaperBook pBookCopy = pBook;
    pBookCopy.setSerial(23456);
    pBookCopy.ShowPBookInfo();
    cout << endl;

    return 0;
}