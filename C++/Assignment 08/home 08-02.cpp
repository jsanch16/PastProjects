/**********************************************************************
Author: Jung Hwan Kim
Class: CSC 340
Instructor: Professor Dujmovic, Jozo
Homework 08-02
Purpose: imagine if your beloved parter get your message secretly 
         from internet intruders
Step 1: type message on input file (in.txt)
Step 2: generate encrypt file (en.txt) 
step 3: generate decrypt file (de.txt)
*********************************************************************/
#include <iostream>
#include <fstream>
#include <stdlib.h>

using namespace std;

ifstream IOS;
ifstream IS1;
ofstream OS;
ofstream OS1;

char key[50];

char infile[50];
char outfile_encrypt[50];
char outfile_decrypt[50];
char reading_char[200];
void write_encrypt_file(char);

int random_number(){
    
     
    return rand()%128; 
}

void user_prompt(){
    cout <<"Input Key: ";
    cin >> key;
    cout <<"Input for input filename: ";
    cin >>infile;
    cout <<"Input for output filename for encrypt: ";
    cin >> outfile_encrypt; 
    cout <<"Input for output filename for decrypt: ";
    cin >> outfile_decrypt;
}

void get_key(){
    cout << "Input key to see the real message: "; 
    cin >> key; // reciever must answer the key
}

void write_encrypt_file(){
     int i =0;
    
     IOS.open(infile, ios::in|ios::out|ios::binary);
     OS.open(outfile_encrypt, ios::out);
     while(IOS.get(reading_char[i])){ // read characters one by one
        reading_char[i]^= (char)random_number(); // 1 eor 1 = 0  0 eor 1 =1
        OS << reading_char[i]; // write one character on file
        i++; // to point next character
        
        
     }
     IOS.close();
     OS.close();
}


void write_decrypt_file(){
     int i =0;
     IS1.open(outfile_encrypt,ios::in|ios::binary);
     OS1.open(outfile_decrypt, ios::out);
     
     while (IS1.get(reading_char[i])){
           reading_char[i]^= (char)random_number();
           OS1 << reading_char[i];
           i++;
     }
     IS1.close();
     OS1.close();
     
}
// program start here!
int main(void){
    unsigned long int i,num=0; // unsigned long int might be needed
                               // if users input long characters as key
    user_prompt(); // tell user to do
    
    for (i =0; key[i];  i++)
        num += (int)key[i]; // the key will be compute to integer value
        
    
   
        
    srand(num); // the num from key will be generated and num will pointing 
                // at the specific position of random generation  
    write_encrypt_file(); // wrtie the encrpt file
    
    get_key(); // get key for receiver!
    num =0; // num should be reinitialized!
    
    for (i =0; key[i];  i++)
        num += (int)key[i];
   
    
    srand(num);
    write_decrypt_file(); // decode the alienated message
    
    system("pause");
    return 0;
}
