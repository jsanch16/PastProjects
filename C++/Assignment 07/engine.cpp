/*****************************************************************************
Author: Jung Hwan Kim
Class: CSC 340
Instructor: Professor Dujmovic, Jozo
Homework 07 -engine.cpp
Step 1: if has no argument in command line then aks user prompt
Step 2: else if command line has argument then compute and show display
Step 3: else if command line has argument+filename then
        write the result on the filename and display on the screen
******************************************************************************/

#include <iostream>
#include <fstream>
#include <iomanip>
#include <cmath>
#define w setw
using namespace std;

int quadratic(double &a,double &b,double &c, double &x1, double &x2, int t ){
// for compute     
     
     if(b*b - 4*a*c>=0){
         x1 = (-b+sqrt(b*b -4*a*c ))/(2*a);
         x2 = (-b-sqrt(b*b -4*a*c ))/(2*a);
         return 1; // true if b*b - 4*a*c>=0
     }
     x1 = -b/(2*a);
     x2 = (4*a*c - b*b)/(2*a);
     return 0; // false if b*b - 4*a*c<0 
}

int main(int argcnt, char *argvec[]){
    double a =0, b =0, c =0 ;
    double x1, x2;
    int t;
    
    if (argcnt == 1){ // if has no argument in command line then aks user prompt
       cout << " === User Prompt Ver === " << endl;
       cout <<"Please input number coefficnet a, b, c: ";
       cin >> a >> b >> c;
       
       if(quadratic(a,b,c,x1,x2,t)) // compute
          cout <<" x1 = "<<w(3)<< x1<<" x2 = "<<w(3) << x2<< endl; 
       else{
          cout <<"x1 = "<<w(3)<< x1 <<" + " <<"i * "<<w(3) << x2 << endl;
          cout <<"x2 = "<<w(3)<< x1 <<" - " <<"i * "<<w(3) << x2 << endl;
       }
    }
    else if(argcnt == 4){
        //else if command line has argument then compute and show display
        cout << " === Three Command line Arguments === " << endl; 
        a=atof(argvec[1]);
        b=atof(argvec[2]);
        c=atof(argvec[3]);
        
        if(quadratic(a,b,c,x1,x2,t)) // compute
           cout <<" x1 = "<<w(3)<< x1<<" x2 = "<<w(3) << x2<< endl;
        else{ 
           cout <<"x1 = "<<w(3)<< x1 <<" + " <<"i * "<<w(3) << x2 << endl;
           cout <<"x2 = "<<w(3)<< x1 <<" - " <<"i * "<<w(3) << x2 << endl;
        }    
    }
    else if(argcnt == 5){
        // else if command line has argument+filename then
        // write the result on the filename
        cout << " === Silent Mode === " << endl;
        a = atof(argvec[1]);
        b = atof(argvec[2]);
        c = atof(argvec[3]);
        ofstream OS(argvec[4], ios::out); // create outfile
        
        quadratic(a,b,c,x1,x2,t); // compute
        OS << w(3)<< x1<<' '<<w(3) << x2<< endl;
        
         
        
    }
    
    
    
}
    
