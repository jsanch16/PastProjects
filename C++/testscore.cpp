/*********************************************\
Program: testscore.cpp
Problem:Print out the letter grade of a test score
Purpose: to us if and switch statements
Author:Juan Sanchez
Date: 9/30/2013
\*********************************************/

#include <iostream>

using namespace std;

int main(void)
{
	double score;
	cout << "Enter number of points:";

	cin >> score;

	if (score <0)
	{
         exit(1);
    }

	if (score >= 90)
		cout << "Your grade is an A" << endl;
	else if (score >= 80)
		cout << "Your grade is a B" << endl;
	else if (score >= 70)
		cout << "Your grade is a C" << endl;
	else if (score >= 60)
		cout << "Your grade is a D" << endl;
	else
		cout << "Your grade is an F" << endl;


	
	
    int letterGrade = (int)(score/10);
    
    
    switch(letterGrade)
    {
      case 10:
	  case 9:
           cout << "Your grade is an A\n" << endl;
           break;
      case 8:
           cout << "Your grade is a B\n" << endl;
           break;
      case 7:
           cout << "Your grade is a C\n" << endl;
           break;
      case 6:
           cout << "Your grade is a D\n" << endl;
      default:
           cout << "Your grade is an F\n" << endl;
           break;
     
      }

	system("pause");
	return 0;
}

