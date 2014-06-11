/*************************************************************************
Author: Jung Hwan Kim
Problem: 06-02
Instructor: Professor Dujmovic, Jozo
Date: Nov 14, 2012
Class: CSC 340
step 1: create data and members(functions and constructors)
step 2: create file and input 3 sides of triangle on file
step 3: compute area primeter
*****************************************************************************/

#include <iostream>
#include <cmath>
#include <fstream>
#include <iomanip>
#define w setw


using namespace std;

class triangle{
      private:
              double a;
              double b;
              double c;
      public: 
              triangle(){double a =0.; double b =0.; double c =0.;}// default
              triangle(double A, double B, double C){
                  a = A;
                  b = B;
                  c = C;
              }// define and initializatoin
      int readfile(ifstream &);
      void show(void);
      int isequilateral();
       // prototype! I will implement in different location    
           
      
};

int triangle::readfile(ifstream &IS){
     IS >> a >> b >> c;
     return !(IS.eof());
} // this function is member of class triangle

void triangle::show(void){
     double s =0.;
     cout <<w(4) <<a << ' ' << w(4)<< b <<' ' <<w(4)<< c <<' ' << endl;
     cout <<"Primeter: "<<w(3) << a+b+c << endl;
     s = (a+b+c)/2;
     s=sqrt(s*(s-a)*(s-b)*(s-c));
     cout <<"Area: " <<w(3) <<s << endl;     
}
int triangle::isequilateral(){
    if(a<b+c && b<a+c && c < a+b ) return 1;
    return 0;

}

int main(void){
    char filename[] = "triangle.dat";
    triangle trg;
    
    ifstream IS(filename, ios::in);
    
    
             // trg will handle to connet all data and function!
    while (trg.readfile(IS))
          if(trg.isequilateral()) trg.show();
          else
              cout <<"This input cannot make triangle!" << endl; 
          // very simple right??? 
    
    system("pause");
    return 0;
}
