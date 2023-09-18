/*
Given an array of n integers, find the second smallest element and return if from function.
int findSecondSmallest(int nums[], int n);
*/

#include <iostream>
#include <limits.h>
using namespace std;

int findSecondMin(int *arr, int n);
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

    int ans = findSecondMin(arr, size);
    cout << "The second Minimum is : " << ans << endl;

    return 0;
}

int findSecondMin(int *arr, int size)
{
    int mn = INT_MAX, s_mn = INT_MAX;
    for (int i = 0; i < size; i++)
    {
        if (arr[i] < mn && arr[i] < s_mn)
            mn = arr[i];
        else if (arr[i] < s_mn)
            s_mn = arr[i];
    }
    return s_mn;
}