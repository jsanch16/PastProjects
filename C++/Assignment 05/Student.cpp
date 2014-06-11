/****************************************************************************
Author: Jung Hwan KIm
Class: CSC 340
Instructor: Professor Dujmovic, Jozo
Homework: 05 - Student
Algorithm: read the name, birth, and GPA and display the average, standard 
deviation, and cofficient for Age, and GPA
****************************************************************************/
#include <iostream>
#include <fstream>
#include <string>
#include <fstream>
#include <cstring>
#include <cmath>
using namespace std;
char filename[] = "students.txt";
ifstream IS(filename, ios:: in); // create the read file 

struct Date
{
       int month;
       int day;
       int year;
};

struct Student
{
       string name;
       Date dob;// the Date typed object
       double GPA;
}S[200];

int main(void){
    int i =0;
    
    double meanGPA =0.;
    double stdevGPA =0.;
    double coef_GPA =0.;
    
    double meanAge =0.;
    double stdevAge =0.;
    double coef_Age =0.;
    double age =0.;
    // I initialized... too many
    while(IS >>S[i].name >> S[i].dob.month>> S[i].dob.day>> S[i].dob.year 
          >> S[i].GPA) // read the all number
    { 
         
         
         
         meanAge += 2012- S[i].dob.year; // to get age from current year
         stdevAge+=pow(2012-S[i].dob.year,2.0);
         
         meanGPA+=S[i].GPA;
         stdevGPA +=pow(S[i].GPA, 2.0);
         
         
         i++;// count for ave
         
    }
    
    meanAge = meanAge/i;
    stdevAge =stdevAge - pow(meanAge,2.0);
    stdevAge = sqrt(stdevAge);
    coef_Age = stdevAge/meanAge;
    // Age section
    
    
    meanGPA = meanGPA/i;
    stdevGPA = stdevGPA- pow(meanGPA,2.0);
    stdevGPA = sqrt(stdevGPA);
    coef_GPA = stdevGPA/meanGPA;    
    // GPA section
    
    
    cout <<"====== Age ===== " << endl;
    cout <<"The average: "<< meanAge << endl;
    cout <<"The standard deviation: " << stdevAge << endl;
    cout <<"The coefficient of variation: " << coef_Age << endl;
    
    cout <<"\n====== GPA ======" << endl;
    cout <<"The average: " << meanGPA << endl;
    cout <<"The standard deviation: " <<  stdevGPA << endl;
    cout <<"The coefficient of variation: " << coef_GPA << endl;
    // display!!! 
    system("pause");
    return 0;
}  
