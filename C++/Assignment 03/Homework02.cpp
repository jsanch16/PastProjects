/*********************************************************************
Autor: Jung Hwan Kim
Date: 10/15/2012
Instructor: Professor Dujmovic, Jozo
Class: CSC 340
Problem: Homework 02: produce the random number between 0 and 1
 use summation use loop as much as I can until I got more than
 3 second elapse
 display our friendly user 
************************************************************************/

#include <iostream>
#include <ctime>
using namespace std;

double rando(void){
       return double(rand())/double(RAND_MAX);
}// produce the number between 0 and 1

double sec(void){
       return double(clock())/CLOCKS_PER_SEC;
} // produce the time eslpase

double it_sum(double a[], int size){
       int i;
       double sum =0.0;
       for(i =0; i < size ; i++)
             sum+=a[i]; // acumulate the number as adding
       return sum;
}// the iterative sum method
double recur_sum(double a[], int size){
       
       if (size<=0) return 0; // return if size is less than 1
       return recur_sum(a, size-1)+a[size-1]; // call method for recursive
}

int main(void){
    
    double a[100];
    int i;
    int size = sizeof(a)/sizeof(a[0]);
    for(i =0; i<100 ;i++)
          a[i] = rando();
          
    
    double start_time = sec(); // start the time
    for(i =0; i<10000000; i++) // I use megaboom number to have at least 3 sec
          it_sum(a, size);  // calling iterative sum method
    double last_time = sec(); // bring the last time from iterative sum method
    cout << "The result: " << it_sum(a, size)<< endl;
    cout << "The time elapse from iterative summation: " 
    << last_time-start_time << endl; // display the time
    
    start_time = last_time; // start time become last time for new start time
    for(i =0; i<10000000; i++) // I use megaboom number to have at least 3 sec
          recur_sum(a,size); // calling recursive sum method
    last_time = sec(); // new last time for recursive method
    cout << "The result: "<<  recur_sum(a,size)<< endl;
    cout << "The time elapse from recursive summation: " 
    << last_time-start_time << endl; // display the time
    
    system("pause");
    return 0;
}
