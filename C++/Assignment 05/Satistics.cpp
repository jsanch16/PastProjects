/****************************************************************************
Author: Jung Hwan KIm
Class: CSC 340
Instructor: Professor Dujmovic, Jozo
Homework: 05 - Satistics
Algorithm: read 200 numbers from the random.dat 
compute for avarage, standard deviation, and coefficient variable 
****************************************************************************/
#include <iostream>
#include <fstream>
#include <cmath>

using namespace std;

int main(void){
    cout<<"\n=======Entering Satistics ======="<<endl <<endl; 
    // to show enter this file
    double num, sum =0.;
    double mean =0., stdev = 0., coeffcient_var =0.;
    int count =0;
    char filename[] = "random.dat";
    cout << "\n program statistics started\n";
    ifstream IS(filename, ios::in);
    while(IS >> num){sum +=num; stdev+=pow(num,2.0); count++;}
    // read the file and compute
    
    mean = sum/count;
    stdev = stdev- pow(mean, 2.);
    stdev = sqrt(stdev);  
    coeffcient_var=stdev/mean;
    
    
    cout << "Mean: " << mean << endl;
    cout << "Standard Deviation: " << stdev << endl;
    cout << "Coefficient_Var: " <<  coeffcient_var << endl;
    // display the number
    cout <<"\n=======Exiting Satistics ======="<<endl;
    // eliminate the system("pause") and return 0;
    // because you did not reenter the MakeFile.cpp
    system("pause");
    return 0;
}
