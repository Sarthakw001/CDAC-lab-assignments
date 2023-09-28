#include <iostream>

using namespace std;

class Array {
private:
    int* elements;
    int size;

public:
    Array(int sz) : size(sz) {
        elements = new int[size];
        for (int i = 0; i < size; ++i) {
            elements[i] = 0;
        }
    }

    Array(const Array& other) : size(other.size) {
        elements = new int[size];
        for (int i = 0; i < size; ++i) {
            elements[i] = other.elements[i];
        }
    }

    ~Array() {
        delete[] elements;
    }

    Array& operator=(const Array& other) {
        if (this != &other) {
            delete[] elements;
            size = other.size;
            elements = new int[size];
            for (int i = 0; i < size; ++i) {
                elements[i] = other.elements[i];
            }
        }
        return *this;
    }

    int getSize() const {
        return size;
    }

    int& operator[](int index) {
        if (index >= 0 && index < size) {
            return elements[index];
        } else {
            cout << "Index out of bounds." << endl;
            exit(1);
        }
    }

    const int& operator[](int index) const {
        if (index >= 0 && index < size) {
            return elements[index];
        } else {
            cout<< "Index out of bounds." << endl;
            exit(1);
        }
    }
};

int main() {
    Array arr1(5);
    arr1[0] = 1;
    arr1[1] = 2;
    arr1[2] = 3;
    arr1[3] = 4;
    arr1[4] = 5;

    const Array& refArr1 = arr1; // Reference to a constant Array object

    for (int i = 0; i < refArr1.getSize(); ++i) {
        cout << refArr1[i] << " ";
    }
    cout << endl;

    return 0;
}
