/*****************************************************************************
Question 2
Program:upperLower.cpp
Problem: read from text and display number of upper and lower case and digits
Purpose: learn how process input string
Author:Juan Sanchez
Date:10/23/2013
******************************************************************************/
#include <iostream>
#include <iostream>
#include <cstring>

using namespace std;

int isUpper(char chr)
{ 
    if (chr>= 'A' && chr <= 'Z')
      return 1;
    else 
      return 0;
}

int isLower(char chr)
{
    if (chr>= 'a' && chr <= 'z')
      return 1;
    else 
      return 0;
}
int isDigit(char chr)
{
    if (chr >= '0' && chr<= '9')
       return 1;
    else
      return 0;
}

//for input
void getLine(char* chr, int size)
{ 
    int i=0;
    while( i< size && (chr[i]=cin.get())!='\n') i++;
    chr[i] = '\0';    
    
}

int main(void)
{
    char line[100];
    int i;
    int upper =0;
    int lower =0;
    int digit = 0;
    cout << "Input as many numbers and upper and lower \ncase letters as you wish: ";
    getLine(line, 100);
    for(i =0; line[i] != '\0'; i++){//count occurences
        if(isUpper(line[i]))
            upper++; 
        else if(isLower(line[i]))
            lower++; 
        else if(isDigit(line[i]))
            digit++; 
               
    }
    cout << " Number of uppercase letters: " << upper<< endl;
    cout << "Number of lowercase letters: " << lower<< endl;
    cout << "Number of digits: " << digit<< endl;
    system("pause"); 
    return 0;
}

