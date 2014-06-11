/****************************************************************************
Question 1
Program:Student.cpp
Problem: create a student class and functions to manipulate it
Purpose: to learn how to use classes
Author:Juan Sanchez
Date:11/15/2013
****************************************************************************/
#include <iostream>
#include <fstream>
#include <string>
#include <iomanip>
#define w setw 
using namespace std;


class student
{
      private:
              string name;
              int age;
              double gpa;
              
      public:
             student()
             {
                string name ="";
                age =0;
                gpa = 0.0;
             }
             student(string N, int AGE, int GPA)
			 {
                 name = N;
                 age = AGE;
                 gpa = GPA;
             }
             int read(void);
             void show(void);
             void writefile(ofstream &);
             double getgpa(void);
             int readfile(ifstream &);
};


int student:: read()
{
    cin >> name >> age >> gpa;
    return !(cin.eof());  // read input from users
}

void student:: show(){
     cout <<w(5) << name<<' ' << w(3) << ' ' <<age<<' ' <<w(4) << gpa << endl;
} // display the values
void student:: writefile(ofstream& OS)
{
     OS <<w(5) << name<<' ' << w(3) << ' ' <<age<<' ' <<w(4) << gpa << endl;
}// write on the file
double student::getgpa(){
    return gpa;
}
int student::readfile(ifstream& IS){
    IS >> name >> age >> gpa;
    return !(IS.eof());
}// read the file
// these are the members of the class
int main(void)
{
    int i =0; 
	double avgGPA =0.;
    char filename[] = "student.dat";

    ofstream OS(filename, ios::out);
    ifstream IS(filename, ios::in);
    student std;
    
    cout <<"Input number Name, Age, GPA: "<< endl;
    while (std.read()){std.writefile(OS); i++;}
    cout <<"\n===To display===\n";
    while(std.readfile(IS)) {
        avgGPA += std.getgpa();
        std.show();
    }
    OS.close();
    IS.close();
    avgGPA=avgGPA/i;
    cout <<"The Average: " << avgGPA << endl; // display the result!
    
    
    
    system("pause");
    return 0;
}
