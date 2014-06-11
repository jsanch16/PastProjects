/*****************************************************************************
Author: Jung Hwan Kim
Class: CSC 340
Instructor: Professor Dujmovic, Jozo
Homework 07 -02
Step 1: Create 1st string and 2nd string
Step 2: concatenate them
******************************************************************************/

#include <iostream>
#include <cstring>
using namespace std;
char *append(char *str, char *add){
     static char buffer[100]; // be sure it is static becuase of local var err 
     char *p = buffer; // copy the address of buffer
     while(*p++ =*str++); 
     p--; // to eliminate the null '\0'  
     while(*p++ =*add++);
     // do not eliminate '\0'  
     return buffer; 
}

int main(void)
{
    int size = 50;
    char *str = new char[size]; 
    char *add =  new char[size];
    char name[] =  "Juan Sanchez ";
    char description[] = "As a Computer Science Student!";
    str = name;
    add = description; 
    str = append(str, add); // concatenate them
    cout << str << endl; // display the result
    
    system("pause");
    return 0;
}
