/****************************************************************************
Author: Jung Hwan KIm
Class: CSC 340
Instructor: Professor Dujmovic, Jozo
Homework: 05 - Distribution
Algorithm: read the number from the random.dat
 and count number if the number is within the ranges
****************************************************************************/
#include<iostream>
#include<fstream>
#include<iomanip>
#define w setw
using namespace std;

int main(void){
    char filename[] = "random.dat";
    int i,j,k;
    double num;
    
    ifstream IS(filename, ios::in);
    double min=100., max=0.;
    int array[20];
    int size = sizeof(array)/sizeof(array[0]);
    for(i =0; i <size; i++)
          array[i] = 0;
    
    
    while(IS >> num){
        if(num > max )
             max = num;
        else if(num < min){
             min = num;
        }
    }
    
    ifstream IS1(filename, ios::in);
    while(IS1 >> num){
       k=int(20*(num - min)/(max - min));
       array[k]++;
        
    }
    i =0;
    for(k =0; k<size; k++){
       cout <<w(3)<< i << '-' <<w(3) << i+5 <<"| "; 
       for(j =0; j <array[k]; j++)
          cout << '*';
       cout << endl;
       i = i+5;
    }
    
    
    cout << "\n========== Exiting Distribution ============" << endl;

    system("pause"); // doesn't matter if you have or not.
    return 0; // because we have finished
}
