/*********************************************\
Program: asterik.cpp
Problem: print triangle of asteriks
Purpose: using for loops
Author:Juan Sanchez
Date: 9/30/2013
\*********************************************/

#include <iostream>

using namespace std;

void triangle(int n)
{
    int r, c;
    for(r=1; r <= n*2-1 ; r++, cout << endl)
       for(c = 1; c <= n ; c++)
          cout << (r + c >=n+1 && r-c <n ? '*': ' ');    
}

int main(void)
{
    int n;
	int counter = 1;
    cout << "Input the length of the longest line of the triangle: ";
    cin >> n;
	while ( counter <=n)
	{
    triangle(counter);
	counter++;
	}
    
    system("pause");
    return 0;
}
