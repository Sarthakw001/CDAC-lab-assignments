#include <iostream>

using namespace std;

class Date
{
private:
    int day;
    int month;
    int year;

public:
    Date() : day(0), month(0), year(0) {}
    Date(int d, int m, int y) : day(d), month(m), year(y) {}

    void Read()
    {
        cout << "Enter day, month, and year (DD MM YYYY): ";
        cin >> day >> month >> year;
    }

    void Write() const
    {
        cout << day << "/" << month << "/" << year;
    }

    bool operator==(const Date &obj2) const
    {
        return (day == obj2.day) && (month == obj2.month) && (year == obj2.year);
    }

    bool operator!=(const Date &obj2) const
    {
        return !(*this == obj2);
    }

    bool operator<(const Date &obj2) const
    {
        if (year < obj2.year)
            return true;
        if (year > obj2.year)
            return false;
        if (month < obj2.month)
            return true;
        if (month > obj2.month)
            return false;
        return day < obj2.day;
    }

    bool operator<=(const Date &obj2) const
    {
        return (*this < obj2) || (*this == obj2);
    }

    bool operator>(const Date &obj2) const
    {
        return !(*this <= obj2);
    }

    bool operator>=(const Date &obj2) const
    {
        return !(*this < obj2);
    }
};

int main()
{
    Date date1, date2;

    cout << "Enter date 1:\n";
    date1.Read();

    cout << "Enter date 2:\n";
    date2.Read();

    cout << "Date 1: ";
    date1.Write();
    cout << "\nDate 2: ";
    date2.Write();

    if (date1 == date2)
    {
        cout << "\nDate 1 is equal to Date 2." << endl;
    }
    else if (date1 != date2)
    {
        cout << "\nDate 1 is not equal to Date 2." << endl;
    }

    if (date1 < date2)
    {
        cout << "Date 1 is earlier than Date 2." << endl;
    }
    else if (date1 <= date2)
    {
        cout << "Date 1 is earlier than or equal to Date 2." << endl;
    }

    if (date1 > date2)
    {
        cout << "Date 1 is later than Date 2." << endl;
    }
    else if (date1 >= date2)
    {
        cout << "Date 1 is later than or equal to Date 2." << endl;
    }

    return 0;
}
