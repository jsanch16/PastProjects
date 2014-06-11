/*********************************************************************
Autor: Jung Hwan Kim
Date: 10/15/2012
Instructor: Professor Dujmovic, Jozo
Class: CSC 340
Problem: Homework 01: counting number from user prompt based on containing
the array numbers
************************************************************************/

#include<iostream>
using namespace std;
int it_array(int a[],int size, int x){
     int i, count =0;
     for(i =0; i< size ; i++)
           if(x == a[i])
              count++; // count the number if the number is same as user prompt
     return count; // return count        
} // Iterative method
int recur_array(int a[],int size, int x){
    int count =0;
    if (x == a[size-1])
          count++; // count the number if the number is same as user prompt
    if (size <=0) return 0;
    return recur_array(a, size-1, x ) + count; // decreament size for recursive
} // recursive method

int main(void){
    int array[] = {1,2,3,4,5,6,7,8,9,9};
    int size = sizeof(array)/sizeof(array[0]);
    int x;
    cout << "Input number for detect number: ";
    cin >> x; // user prompt
    
    cout << "Iterative Version" << endl; 
    cout << "Your input " << x << " occurs " 
    <<it_array(array, size, x)<< " Times!"
    << endl; // dispaly result from iterative method
    
    cout << "\nRecursive Version" << endl; 
    cout << "Your input " << x << " occurs " 
    <<recur_array(array, size, x)<< " Times!" 
    << endl;// display result from iterative method
    
    system("pause");
    return 0;
}
