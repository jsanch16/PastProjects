/*********************************************************************
Question 3
Program:textCopy.cpp
Problem: process an inputfile to outputfile
Purpose: learn how to process input and output file
Author:Juan Sanchez
Date:10/23/2013
************************************************************************/

#include <iostream>
#include <fstream>
#include <iomanip> 
using namespace std;
int main(void)
{
    int i =0;
	char s[90];
    char inputFile[] = "input.txt";
    char outputFile[] = "output.txt";
  
	//open file
    ifstream IS(inputFile, ios::in);
    if(IS.fail())
	{
       cout <<"File not Found." << endl;
       system("pause");
       return 0;
    }
    
    // open file
    ofstream OS(outputFile, ios::out);
    
    while (!(IS.eof()))
	{ 
       i++;
	   // get input from file
       IS.getline(s,90); 
       OS << i<< setw(4)<<' ' << s << endl;
    }
    IS.close();
    OS.close();

	cout<< "Done. File has been processed and new file has been created." <<endl;
    
    
    system("pause");
    return 0;
    
}
