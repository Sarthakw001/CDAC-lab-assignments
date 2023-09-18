/*
Given an array of n integers, find the given element. Return true if element is present in the array else return false.
bool search(int nums[], int n, int element);
*/

#include <iostream>
#include <limits.h>
using namespace std;

bool search(int *arr, int n, int element);
void takeInput(int size, int *arr)
{
    for (int i = 0; i < size; i++)
        cin >> arr[i];
}

int main()
{
    int size;
    cout << "Enter the size of Array" << endl;
    cin >> size;
    cout << "Enter " << size << " elements" << endl;
    int *arr = new int[size];
    takeInput(size, arr);

    cout << "enter element to search" << endl;
    int element;
    cin >> element;

    bool ans = search(arr, size, element);
    if (ans)
        cout << "Voila! Element found" << endl;
    else
        cout << "Element not found" << endl;

    return 0;
}

bool search(int *arr, int size, int element)
{
    for (int i = 0; i < size; i++)
    {
        if (arr[i] == element)
            return true;
    }
    return false;
}