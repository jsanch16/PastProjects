/*****************************************************************************
Author: Jung Hwan Kim
Class: CSC 340
Instructor: Professor Dujmovic, Jozo
Homework 07 -03-00 (Master.cpp)
Step 1: display the what this program is
Step 2: Activate engine in different command line
******************************************************************************/
#include <iostream>
#include <fstream>
#include <iomanip>
#define w setw
using namespace std;

int main(void){
    double x1, x2;
    cout << "=== Quadradic Calculation === " << endl;
    cout << "ax^2+bx +c " << endl;
    
    system("engine");
    system("engine 1 -6 8");
    system("engine 1 4 4 filename.dat");
    ifstream IS("filename.dat", ios::in); // they enter in silent mode
    IS >> x1 >> x2;// read the filename        
    cout <<" x1 = "<<w(3)<< x1<<" x2 = "<<w(3) << x2<< endl;
    // display in master.cpp
    system("pause");
    return 0;
}
