/**************************************************************************
Author: Jung Hwan KIm
Class: CSC 340
Instructor: Professor Dujmovic, Jozo
Homework: 05 - MakeFile
Algorithm: Create the file and generate 200 number
Call Satistics.cpp and Distribution.cpp

************************************************************************/
// Makefile.cpp
#include <iostream>
#include <fstream>
using namespace std;

int urn(void){
    return rand()%9; // generate the number thourgh  0 - 8
}

int main(void){
    
    char filename[] = "random.dat";
    int sum =0,num =0,i,j;
    ofstream OS(filename, ios::out); // create file random.dat
    
    srand(time(NULL));
    for (i=0; i<200; i++){
       for(j=0; j <12; j++){ 
           num += urn(); // generate 12 numbers and sum them
       }// wrtie the number after computing 12 and continue until 200 numbers
       OS << num << endl;
       num = 0; // don't forget to initialize number again before accumulation
    }
    OS.close(); // close the file for update
    cout <<"=====We created files for 200 numbers=====" <<endl <<endl;
    system("Satistics"); // enter Satistics.cpp
    system("Distribution");// enter Distribution.cpp
    
       
    
    system("pause");
    return 0;
}
