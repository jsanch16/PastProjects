/**********************************************************************
Author: Jung Hwan Kim
Class: CSC 340
Instructor: Professor Dujmovic, Jozo
Homework 08-01
Step 1: solve the area by using trapozoid method
Step 2: then solve the area by Monte Carlos method
        
*********************************************************************/
#include <iostream>
#include <cmath>
#include <stdlib.h>
using namespace std;

long int size,n;
double Area_Trapozoid;
double h;
double Arbitrary_Area = exp(1) - 1; // A = e-1 = from intgeral(e^x)
                                    // and range 0<= x <=1
double Monte_Area; 

double urn(){ 
    return double(rand())/double(RAND_MAX); // random generation 0<=rand()<=1
}

void check_error(double error){
    if(error <0)
        error = -error; // if error percent <0 then convert to error >0

    if(error < 0.00001 )// if very small and close state 
                        // because I do not want to see ugly precent to read..
       cout << " Very Close or Accurate Result!";
    else
       cout << " The Error Percent: " << error <<"%";
}

void Trapozoid_Version(double a, double b){
    // a  == 0 b == 1 : the range
    cout << "===Trapozoid Version===" << endl; 
    for( size = 10; size <=1000; size *=10 ){
       // size does matter to spaek with accuracy! n = 10, 100, 1000
       
       a =0; // you must to initialize 0 or accumulated from previous result
       h = (b-a)/double(size); // the interval gap!
       Area_Trapozoid = (exp(a) + exp(b))/2.;
       a = a+h;// the next x point
       for(cout<< endl, n =1; n < size; n++){ // we skip index 0 and index n
             
           Area_Trapozoid += (exp(a)); // the y component result from x compo 
           a = a+h;
       
       }// the solving problem is in chapter 14.3.1 Random  
       Area_Trapozoid *=h; 
       
       cout <<"===The Area Trapozoid in=== " << size 
            <<" : "<<  Area_Trapozoid;
       double error = (Area_Trapozoid -Arbitrary_Area)/Area_Trapozoid*100;
       // to have error percentage!
       check_error(error); // check error to see result!
    }
    cout << endl; 
}
// this line Monte Carlos!!!
void Monte_Carlos(double a, double b){
     // a == 0, b == 1
     int k =0;
     double x, y;// need a local for generating randomness!

     cout << "\n===Monte Carlos===" << endl;
     for(size = 100; size <=1000000; size*=100){// size does matter!
     // but you see! Monte Carlos requires more size and memory!
        k =0; // you have to reinitialize again otherwise accumulative!!!
        Monte_Area = exp(1);
        srand(time(NULL));// randomly!!!
        for (cout << endl,n=0; n<size; n++){
            
            x = urn(); // x will be randomly generated
            y = exp(1)*urn(); // y is randomly generated
            if(exp(x) >= y) k++; // is component under the function's curve?
            
        }
        Monte_Area *= double(k)/double(n); // the ratio: n/N
        
        cout <<"===The Area Monte Carlos in=== " << size 
            <<" : "<<  Monte_Area;
        double error = (Monte_Area -Arbitrary_Area)/Monte_Area*100;
       check_error(error); // check the error to see
        
     }
         
}

int main(void){
    
    double a =0, b=1;// interval!!!
    cout << "Arbitrary_Area: " << Arbitrary_Area << endl; 
    
    Trapozoid_Version(a,b);
    Monte_Carlos(a,b);
    
    cout << endl;
    
    cout <<"\n\nTherefore, Monte Carlos require more points in order to have " 
         <<"accurate result to compare with Trapozoid method!\n" << endl; 
    // my final statement :/
    system("pause");
    return 0;
}
