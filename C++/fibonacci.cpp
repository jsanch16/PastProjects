/*********************************************\
Program: fibonacci.cpp
Problem: tell if number is fibonacci or not
Purpose: using loops
Author:Juan Sanchez
Date: 9/30/2013
\*********************************************/

#include <iostream>

using namespace std;


    int FiboTest(int n)
	{
		double decimalResult1 = sqrt((5*pow((double)n, 2))-4);
		int intResult1 = (int)decimalResult1;
		double decimal1 = decimalResult1 - intResult1;
 
		double decimalResult2 = sqrt((5*pow((double)n, 2))+4);
		int intResult2 = (int)decimalResult2;
		double decimal2 = decimalResult2 - intResult2;
 
	if( !decimal1 || !decimal2 )
		return 1;
	else
		return 0;
         
}
int main(void)
{
    int n;
    cout <<"Input any number to see if it is a Fibonacci number: ";
    cin >> n;
    if(FiboTest(n) ==1)
        cout << n << " is a Fibonacci number.\n";
    else 
        cout << n << " is not a Fibonacci number.\n";
         
        
    
 
    system("pause");
    return 0;
}
