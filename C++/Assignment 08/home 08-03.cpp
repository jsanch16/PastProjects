/**********************************************************************
Author: Jung Hwan Kim
Class: CSC 340
Instructor: Professor Dujmovic, Jozo
Homework 08-03
Purpose: this is for banking account record
Step 1: assume users have inputed already... 
Step 2: show the screen all banking accounts  
step 3: when users access his or her account the interest will add sup!!(cool)
*********************************************************************/
#include <iostream>
#include <fstream>
#include <iomanip>
#include <cstring>
#define w setw
using namespace std;


struct client
{
       int account;
       char name[20];
       double balance;
};

void make_file(char* filename)   
{
    client person = {0,"",0.0}; // initializing the person from client class
    // 32 bytes ==  sizeof (person)
    int i=0;
    // assuming all users already inputted!
    char* name_list[] = {"Jung","Jee","Helen","Migael","Megamen",
                         "Ra'el","Clinton","Barack","Mitt","Mike"};
                         // don't tell to Mr. president.... 
    double balance_list[] = {1000,3000,3533,3535,9000,
                             10000,6000,5000,4000,2100};
    
    ofstream OS;
    OS.open(filename,ios::out);
    do{
      person.account = i+1; // write the account number 1~10!!!
      strcpy(person.name, name_list[i]);
      person.balance = balance_list[i];
      OS.write((char*) &person, sizeof(person)); // you don't need positioning 
      i++; 
    }while(i<10);
    OS.close();
}// creating file

void show_file( int n, char* filename)
{
     client person;
     ifstream IS(filename, ios::in);
     int i =1;
     // show all account records in public!!! Bad banking manager!!!
     cout << w(3)<<"account"<<' '<<w(15) << "name"<<' '<<w(10)<< "balance" 
          << endl;
     
     while(IS.read((char*) &person, sizeof(person))){ // just read!
        person.account =i;     
        cout << w(3)<< person.account << ' '<< w(20) << person.name<<' ' 
             <<w(8)<< person.balance<< endl;
        i++;
     }
     IS.close();
     
    
     
      
}

        
void selecting(int n, char* filename)
{    client person;
     fstream IOS(filename, ios::in|ios::out); // both read and writing avaiable 
                                              // but only existing file 
     int p; 
     while(1){
         
         cout <<"Please input account number 1-10: "; // ask users to 
         cin >> p; // input banking account and recommand to press 1!!!
         if (p<=0 || p >10) break;
         // sentinal value to break
         IOS.seekg((p-1)*sizeof(person)); // you need positioning on the file
         IOS.read((char*) &person, sizeof(person));
          cout << w(3)<<"account"<<' '<<w(15) << "name"<<' '<<w(10)<< "balance" 
               << endl;
          cout << w(3)<< person.account << ' '<< w(20) << person.name<<' ' 
               <<w(8)<< person.balance<< endl;
         person.balance += person.balance*0.05;
         IOS.seekp((p-1)*sizeof(person)); // you need positioning on the file
         IOS.write((char*) &person, sizeof(person));
              
     }
     IOS.close();
       
     
}

int main(void){
    
    
    char filename[20] = "Banking_Record.txt";
    
       
    
    make_file(filename);
    show_file(10, filename);
    selecting(10, filename);
    show_file(10, filename);
    
    // Have a great final exams and great winter break!
    // And, see you on next Spring 2013!!
    
    
    system("pause");
    return 0;
} 
