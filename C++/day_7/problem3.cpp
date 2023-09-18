/*
Given an array of n integers, find the second largest element and return if from function.
int findSecondLargest(int nums[], int n);
*/

#include <iostream>
#include <limits.h>
using namespace std;

int findSecondLargest(int *arr, int n);
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

    int ans = findSecondLargest(arr, size);
    cout << "The second largest is : " << ans << endl;

    return 0;
}

int findSecondLargest(int *arr, int size)
{
    int mx = INT_MIN, s_mx = INT_MIN;
    for (int i = 0; i < size; i++)
    {
        if (arr[i] > mx && arr[i] > s_mx)
            mx = arr[i];
        else if (arr[i] > s_mx)
            s_mx = arr[i];
    }
    return s_mx;
}
