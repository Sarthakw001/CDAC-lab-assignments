/*
Problem Statement 1: Student Grade Calculator


You are tasked with creating a C++ program to calculate and display the final grades of a class of students. The program should allow the user to input the number of students, their names, and their scores for three assignments.


Here are the specific requirements for your program:
Input:


Ask the user to input the number of students in the class.
For each student, input their name and three assignment scores (score range: 0-100).
Grading:


Calculate the average score for each student based on their assignment scores.
Use the following grading scale:
A: 90-100
B: 80-89
C: 70-79
D: 60-69
F: Below 60
Output:


Display each student's name, assignment scores, average score, and corresponding letter grade.
Control Structures:


NOTE: Use appropriate control structures (if, else if, switch, for, while, do while) to achieve the desired functionality.
Handle situations where the user enters invalid scores (e.g., scores below 0 or above 100).

*/

#include <bits/stdc++.h>
using namespace std;

int main()
{
    int number_of_students;

    cout << "Enter the number of students" << endl;
    cin >> number_of_students;

    string names[number_of_students];

    for (int i = 0; i < number_of_students; i++)
    {
        string name;

        cout << "Enter the name of student" << endl;
        cin >> name;

        int assignment_1, assignment_2, assignment_3;

        do
        {
            cout << "Enter the score for all three assinments betweem 0 and 100" << endl;
            cin >> assignment_1 >> assignment_2 >> assignment_3;
        } while (assignment_1 < 0 || assignment_1 > 100 || assignment_2 < 0 || assignment_2 > 100 || assignment_3 < 0 || assignment_3 > 100);

        int avg_score = (assignment_1 + assignment_2 + assignment_3) / 3;

        char grade;

        if (avg_score >= 90 && avg_score <= 100)
            grade = 'A';
        else if (avg_score >= 80 && avg_score <= 89)
            grade = 'B';
        else if (avg_score >= 70 && avg_score <= 79)
            grade = 'C';
        else if (avg_score >= 60 && avg_score <= 69)
            grade = 'D';
        else
            grade = 'F';

        cout << name << "  " << assignment_1 << "  " << assignment_2 << "  " << assignment_3 << "  " << avg_score << "  " << grade << endl;
    }
    return 0;
}