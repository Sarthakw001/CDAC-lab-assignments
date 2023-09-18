/*
Given an array of n integers, find the smallest element and return if from function.
int findMin(int nums[], int n);
*/

#include <iostream>
#include <limits.h>
using namespace std;

int findMin(int *arr, int n);
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

    int *arr = new int[size];
    takeInput(size, arr);

    int ans = findMin(arr, size);
    cout << "The minimum is : " << ans << endl;

    return 0;
}

int findMin(int *arr, int size)
{
    int mn = INT_MAX;
    for (int i = 0; i < size; i++)
    {
        if (arr[i] < mn)
            mn = arr[i];
    }
    return mn;
}
