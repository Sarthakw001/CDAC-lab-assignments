/*
Given an array of n integers, find the largest element and return if from function.
int findMax(int nums[], int n);
*/

#include <iostream>
#include <limits.h>
using namespace std;

int findMax(int *arr, int n);
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

    int ans = findMax(arr, size);
    cout << "The maximum is : " << ans << endl;

    return 0;
}

int findMax(int *arr, int size)
{
    int mx = INT_MIN;
    for (int i = 0; i < size; i++)
    {
        if (arr[i] > mx)
            mx = arr[i];
    }
    return mx;
}
