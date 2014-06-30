/*********************************************************************
Question 1b
Program:dataReaderStringClass.cpp
Problem: process a date using string class
Purpose: learn how to output and input with string class
Author:Juan Sanchez
Date:10/23/2013
************************************************************************/
#include <iostream>
#include <string>

using namespace std;

int main(void)
{
    
    string line; //input
    cout <<"Input the date in the format mm/dd/yy: ";
    
    getline(cin,line);
    char* months[] = { '\0', "January", "February", "March", "April", "May",  
    "June","July", "August", "September", "October", "November", "December"};
    int i =0;
    int month =0;
    int year =0;
    int day =0;
    while(line[i] != '/')
	{
      month = 10* month + line[i] - '0';
      i++;
    }
    i++;// to skip '/'
    while(line[i] !='/')
	{
      day = 10*day+line[i] - '0';
      i++;
    } 
    i++;//to skip '/'
    while(line[i] !='\0')
	{ 
      year = 10*year + line[i] - '0';
      i++;
    }
    i++;
    if (year <= 30)//differentiates between 1900 and 2000 year
        year=year + 2000;
    else
        year= year+ 1900;
    cout << months[month] << ' ' << day << ", " << year << endl; 
    system("pause");
    return 0;
}

