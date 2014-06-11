/*********************************************************************
Autor: Jung Hwan Kim
Date: 10/15/2012
Instructor: Professor Dujmovic, Jozo
Class: CSC 340
Problem: Homework 04: the histogram must be display based on number of
containing number
************************************************************************/
#include <iostream>
using namespace std;

int line(int n){
    cout <<'*'; // put star until less than 1
    if (n<=1) return 0; // the condition is my personal adjustment
    return line(n-1);// and it works..
    
}
int main(void){
    int i;
    int a[] = {2,4,7,5,1}; // array that contain number
    int size = sizeof(a)/sizeof(a[0]);    
    for(i =0; i< size; i++){ // loop until there is no array
        line(a[i]); // call recrusive number
        cout <<"\n";
    }
    system("pause");
    return 0;
}
