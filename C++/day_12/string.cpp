#include <iostream>
#include <cstring>

using namespace std;

class String {
private:
    char* data;

public:
    String() : data(nullptr) {}

    String(const char* str) {
        data = new char[strlen(str) + 1];
        strcpy(data, str);
    }

    String(const String& other) {
        if (other.data) {
            data = new char[strlen(other.data) + 1];
            strcpy(data, other.data);
        } else {
            data = nullptr;
        }
    }

    ~String() {
        delete[] data;
    }

    String& operator=(const String& other) {
        if (this != &other) {
            delete[] data;
            if (other.data) {
                data = new char[strlen(other.data) + 1];
                strcpy(data, other.data);
            } else {
                data = nullptr;
            }
        }
        return *this;
    }

    int length() const {
        return data ? strlen(data) : 0;
    }

    const char* c_str() const {
        return data ? data : "";
    }

    void display() const {
        cout << c_str();
    }
};

int main() {
    String str1("Hello");
    String str2("World");

    const String& refStr1 = str1; // Reference to a constant String object

    String str3 = refStr1;
    cout << "str3: ";
    str3.display();
    cout << endl;

    String str4;
    str4 = str2;
    cout << "str4: ";
    str4.display();
    cout << endl;

    return 0;
}
