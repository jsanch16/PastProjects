/*********************************************************************
Question 1a
Program:dataReaderCString.cpp
Problem: process a date using cString
Purpose: learn how to output and input with cstring
Author:Juan Sanchez
Date:10/23/2013
************************************************************************/

#include <iostream>
#include <cstring>
using namespace std;
int main(void)
{
    
    char date[80];
    int i=0;
	int month=0;
	int day = 0;
	int year =0;
    cout << "Input date in the format mm/dd/yy : ";
    cin.getline(date,80);

    
    while(date[i] != '/')//stop at '/'
	{ 
           month = 10*month+ date[i]-'0';
           i++;
        
    }
    i++; // skip '/' 
    while(date[i] != '/')
	{
           day = 10*day +date[i] -'0';
           i++;
    } 
    i++;// skip '/'
    while(date[i] != '\0')
	{
           year = 10*year +date[i] - '0';
           i++;
    }
    
    
    char* months[] = { '\0', "January", "February", "March", "April", "May", "June", 
    "July", "August", "September", "October", "November", "December"};

    if (year <= 30) //differentiate between 1900 and 2000 year
        year=year + 2000;
    else
        year= year+ 1900;
    cout << months[month] << ' ' << day << ", " << year << endl; 
    
    system("pause");
    return 0;
    
}