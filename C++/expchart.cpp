/*********************************************\
Program: expchart.cpp
Problem: print table of y=2^n
Purpose: controlling overflow
Author:Juan Sanchez
Date: 9/30/2013
\*********************************************/
#include <iostream>
using namespace std;

int main(void){
    cout << "Unsigned Integer:\n";
    unsigned int i =1;
    int exponent =0;
	//when overflow has occured "i" will become 0, thus exiting loop
    while( i>0){
       cout <<"2^"<< exponent << " = " << i << endl;
       i *=2;
       exponent++;
     }


     cout << "\nSigned Integer:\n";
    int j = 1;  
    exponent =0; 
    while( j>0){
       cout << "2^"<< exponent << " = " << j << endl;
       j *=2;
       exponent++;
     }
    system("pause");
    return 0;
}
