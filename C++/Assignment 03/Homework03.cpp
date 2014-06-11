/*********************************************************************
Autor: Jung Hwan Kim
Date: 10/15/2012
Instructor: Professor Dujmovic, Jozo
Class: CSC 340
Problem: Homework 03: use binary search with iterative and recursive
and measure the time to compare each other
************************************************************************/
#include <iostream>
using namespace std;

double sec(void){
       return double(clock())/CLOCKS_PER_SEC;
}

int it_binary(int a[], int size, int x){
    int low =0;
    int high = size-1;
    int mid;
    for(;;){ // use unlimited loop until it's has no more array contetns
        mid = (low +high)/2;        
        if(x >a[mid]) // is prompt greater than mid 
            low = mid+1; // then low suppose to go mid+1
        else if(x <a[mid])// is prompt less than mid
            high = mid-1;// then high supposse to move on mid-1
        else if(x == a[mid]) // same and found??
            return mid; // return mid as found
        else
            return -1; // otherwise, not found
    }
} // binary search from iterative
int recur_binary(int a[], int low, int high, int x){
        int mid = (low+high)/2;
        if(low>high) return -1; // not found
        if(x<a[mid]) return recur_binary(a, low, mid-1, x); // high = mid-1
        if(x>a[mid]) return recur_binary(a, mid+1, high, x);// low = mid+1
        return mid; // return found
}// recursive one!!


int main(void){
    int i,j;
    int a[100000];
    for(i=0; i<100000; i++)
        a[i] = i; // I used tremendous number to have 3 sec time
    int size = sizeof(a)/sizeof(a[0]);
    
    double start_time = sec(); // start time
    for(j = 0; j<200; j++) // I cannot use megaboom number... 
        for(i=0; i<size; i++) // because it exceed over 20 sec...
           if (a[i]!=a[it_binary(a,size,i)]) cout << "ERROR\n"; 
           // starting to call iterative method
           // we shall not display "ERROR message.
    
    double last_time = sec(); // last time
    
    
    cout << "Running time from Iterative Binary Search: " <<
    last_time-start_time << endl; // display iterative time 
    
    start_time = last_time;    
    for(j = 0; j<200; j++)    
        for(i=0; i<size; i++) // start to call recursive method
           if (a[i]!=a[recur_binary(a,0,size,i)]) cout <<"ERROR\n";
    last_time = sec();
    
    cout << "Running time from Recursive Binary Search: " <<
    last_time-start_time << endl; // display recursive time
    
    // this will display similar time esplase between iterative and recursive
    // but depending on your machine!! and compiling optimization
    
    
    system("pause");
    return 0;
}
