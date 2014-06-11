/*********************************************\
Program: triangle.cpp
Problem: compute area of triangle and rectangle
Purpose: using functions and sentinel values
Author:Juan Sanchez
Date: 9/30/2013
\*********************************************/

#include <iostream>
#include <cmath>
using namespace std;

double triangle(double a, double b, double c)
{
	//area of triangle
       double result =  (a+b+c)/2;
       result = result*(result-a)*(result-b)*(result-c);
       
       return sqrt(result);
}

double rectangle( double a, double b)
{
     // area of rectangle
     return a*b;
}

bool triangleCheck(double a, double b, double c)
{
     // To check if it is a triangle
     if (a+b>c && a+c>b && b+c>a)
        return true;
     return false;
}

int main(void){
    double triA, triB, triC;
    double recA, recB; 
	double triResult, recResult;
    
    do{
        cout << "Input 3 sides of the triangle or press 0 or negative number to exit: ";
        cin >> triA >> triB >> triC;
        if(triA <= 0|| triB <=0 || triC <= 0)
           break;
        cout << "Input 2 sides of the rectagle or press 0 or negative number to exit: ";
        cin >> recA >> recB;  
        
        //exit if user wishes
        if(recA <=0 || recB <=0)
           break; 
        
        
        if (triangleCheck(triA,triB,triC))   
               triResult = triangle(triA, triB, triC);
        else 
		{
              cout << "Triangle was not created, sides were not input correctly." << endl;
              break;
        } 
       
        recResult = rectangle(recA,recB);


    // compare areas of triangle and rectangle   
	if (triResult - recResult > 0)
        cout <<"The area of triangle is greater than the area of rectangle." << endl;
     else if(triResult-recResult ==0)
        cout <<"The area of triangle is equal to the area of rectangle." << endl;
     else
        cout <<"The area of triangle is less than the area of rectangle." << endl;
        
        
    }while(1);
    
    system("pause");
    return 0;
}
