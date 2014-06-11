/*********************************************\
Program: pi.cpp
Problem:Approximate the value of pi 
Purpose:learn how to use a while and do loop
Author:Juan Sanchez
Date: 9/30/2013
\*********************************************/

#include <iostream>
#include <math.h>
using namespace std;

int main(void)
{
	double n = 0;
	double pi=0;

	//calculate pi with while loop
	while (n < 20)
	{
		pi = pi + (pow(-1,n)*(1/(2*n+1)));
		n++;
	}
	pi = 4 * pi;
	cout << " Pi in a while loop is : " << pi;
	cout<< endl;

	//reset values
	n=0;
	pi=0;

	//calculate pi with do loop
	do
	{
		pi = pi + (pow(-1,n)*(1/(2*n+1)));
		n++;
	}
	while(n < 20);

	pi = 4 * pi;
	cout << " Pi in a do loop is : " << pi;
	cout<< endl;

	system("pause");
	return 0;
}