/*
Problem statement 2: Problem Statement: Student Exam Scores
You are tasked with creating a C++ program to manage and analyze student exam scores. The program should allow the user to input exam scores for a class of students, perform calculations, and display results.


Here are the specific requirements for your program:
Use 2-D Array:
Input:
Create a 2-D array to store exam scores for multiple subjects (e.g., Math, Science, English) for each student.
Input the exam scores for each student in each subject.
Calculation:
Calculate the average score for each subject.
Determine the highest and lowest scores in each subject.
Output:
Display the average score for each subject.
Display the highest and lowest scores in each subject.
Additional Requirements:
Use functions to modularize your code.
Handle input validation (e.g., ensure scores are within a valid range).
Provide clear prompts and user-friendly messages.

*/

#include <bits/stdc++.h>
using namespace std;

void take_input(int n, vector<vector<int>> &marks_of_subjects)
{
    for (int i = 0; i < n; i++)
    {
        cout << "Enter Score for Student " << i + 1 << endl;
        for (int j = 0; j < 3; j++)
        {
            if (j == 0)
            {
                cout << "Enter the score of maths between 0 and 100" << endl;
                cin >> marks_of_subjects[i][j];
            }
            else if (j == 1)
            {
                cout << "Enter the score of Science between 0 and 100" << endl;
                cin >> marks_of_subjects[i][j];
            }
            else if (j == 2)
            {
                cout << "Enter the score of English between 0 and 100" << endl;
                cin >> marks_of_subjects[i][j];
            }
        }
    }
}

void avg_score_subject_wise(int n, int &avg_math, int &avg_science, int &avg_eng, vector<vector<int>> &marks_of_subjects)
{
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            if (j == 0)
            {
                avg_math += marks_of_subjects[i][j];
            }
            else if (j == 1)
            {
                avg_science += marks_of_subjects[i][j];
            }
            else if (j == 2)
            {
                avg_eng += marks_of_subjects[i][j];
            }
        }
    }
    avg_math /= n;
    avg_science /= n;
    avg_eng /= n;
}

void max_score_subject_wise(int n, int &math_max, int &science_max, int &eng_max, vector<vector<int>> &marks_of_subjects)
{
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            if (j == 0)
            {
                if (marks_of_subjects[i][j] > math_max)
                    math_max = marks_of_subjects[i][j];
            }
            else if (j == 1)
            {
                if (marks_of_subjects[i][j] > science_max)
                    science_max = marks_of_subjects[i][j];
            }
            else
            {
                if (marks_of_subjects[i][j] > eng_max)
                    eng_max = marks_of_subjects[i][j];
            }
        }
    }
}

int main()
{
    int number_of_students;
    cout << "Enter the number of Students";
    cin >> number_of_students;

    vector<vector<int>> marks_of_subjects(number_of_students, vector<int>(3));
    take_input(number_of_students, marks_of_subjects);                                                      // Input from User

    int avg_math = 0, avg_science = 0, avg_eng = 0;
    avg_score_subject_wise(number_of_students, avg_math, avg_science, avg_eng, marks_of_subjects);          // Calculating average score subject wise

    int math_max = -1, science_max = -1, eng_max = -1;
    max_score_subject_wise(number_of_students,math_max,science_max,eng_max,marks_of_subjects);             // Calculating Maximum score subject wise

    cout << endl;
    cout << "Avg Score for each Subject" << endl;
    cout << "Math : " << avg_math << endl;
    cout << "Science : " << avg_science << endl;
    cout << "English : " << avg_eng << endl;
    cout << endl;
    cout << "Max Score for each Subject" << endl;
    cout << "Math : " << math_max << endl;
    cout << "Science : " << science_max << endl;
    cout << "English : " << eng_max << endl;

    return 0;
}