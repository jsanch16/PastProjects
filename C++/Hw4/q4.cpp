/*********************************************************************
Program:carReader.cpp
Problem: reads data from keyboard and inserts and reads from text file
Purpose: learn how to output to and read from created files
Author:Juan Sanchez
Date:10/23/2013
************************************************************************/

#include <iostream>
#include <iomanip>
#include <string>
#include <fstream>
using namespace std;
int main(void)
{
    char fileName[] = "usedCar.txt";
    ofstream OS(fileName, ios::out);
    string manufacturer, model;
    int miles, year, cost;
	char userInput;
	miles =0;
	year = 0;
	cost = 0;


    cout << "To start entering Car Information, press 'y' or 'n': "; 
    cin >> userInput;
	//end program on user's request
    if(userInput == 'n'){system("pause"); return 0;} 
    while(1)
	{
        cout << "Manufacturer: ";
        cin >> manufacturer;

        cout << "Model: ";
        cin >> model;
        
        cout << "Year: ";
        cin >> year;
        
        cout << "Miles: ";
        cin >> miles;
       
        cout << "Cost: ";
        cin >> cost;
        
		//write to file
        OS <<manufacturer<< ' '<< model<< ' ' <<year<< ' ' <<miles 
        <<' ' <<cost << endl;

        cout << "Add another entry? press 'y' or 'n': "; 
        cin >> userInput;
        if(userInput == 'n') break; //if yes loop again
    }
    OS.close(); //close to update file
    ifstream IS(fileName, ios::in); // open stream/read file
    cout << "\n\nDisplaying contents on file that satisfy conditions: "<< endl; 
    while(IS >>manufacturer >> model >> year >> miles >>cost )
	{
		//prevent 0 input error
       if (miles <= 0 || cost <=0) continue;
       else if(miles <50000 && cost <9000)
	   { //display results under given conditions
          cout << "Manufacturer: " << manufacturer<< "\nModel: " << model   
               << "\nYear: " << year << "\nMiles: " << miles << "\nCost: " 
               <<cost <<"\n\n" << endl; 
       }
    }

    IS.close();
    system("pause");
    return 0;
    
}