/*****************************************************************************
Author: Jung Hwan Kim
Class: CSC 340
Instructor: Professor Dujmovic, Jozo
Homework 07 -01
Step 1: Create static array and dynamic array
Step 2: Create static array's function and dynamic array's function
Step 3: Display the result!
******************************************************************************/

#include <iostream>
#include <iomanip>
#define w setw

using namespace std;
const int SIZE=4;
void static_matrix(int n, int a[][SIZE],  int b[][SIZE], int c[][SIZE]){
    int i,j,k;
    for (i =0; i<n; i++ )
       for(j =0; j<n; j++)
          for(c[i][j]=k=0; k<n; k++)
             c[i][j] += a[i][k]*b[k][j];
    
}

void dynamic_matirx(int n, int* a, int* b, int *c){
     int i,j,k;
     for(i =0; i<n; i++)
        for(j =0; j<n; j++)
           for(*(c+i*n+j)=k=0; k<n; k++)
              *(c+i*n+j)+= *(a+i*n+k) * *(b+n*k+j);
}

int main(void){
    cout << "=== Static Version ===" << endl; 
    int i,j;
    int a[SIZE][SIZE]; // static array's must be constant
    int b[SIZE][SIZE]; 
    int c[SIZE][SIZE];
    
    
    cout << "For A: " << endl;
    for(i =0; i<SIZE; i++){
      for(j =0; j<SIZE; j++){
        a[i][j] = rand()%20;
        cout <<w(3)<< a[i][j] <<' ';
        } 
      cout << endl;
    }// we randomly generate the MATRIX A
    cout << endl;
    cout <<"For B: " << endl;
    for(i =0; i<SIZE; i++){
      for(j =0; j<SIZE; j++){
        b[i][j] = rand()%20;
        cout <<w(3)<< b[i][j] <<' ';
        }
      cout << endl;
    }// we randomly generate the MATRIX B
    
    cout << endl;
    
    static_matrix(SIZE,a,b,c); // compute
    cout <<"For C: " << endl;
    
    for(i=0; i< SIZE; i++){
      for(j=0; j<SIZE; j++)
        cout <<w(3)<<c[i][j] <<' ';
      cout << endl;  // show result
    }
    cout << endl;
    cout << "=== Dynamic Version ===" << endl;
    
    int size =16; // dynamic array is hard to have multi dimintional array
    int* dynamic_a = new int[size]; // so 4*4 is 16 == size
    int* dynamic_b = new int[size];
    int* dynamic_c = new int[size];
    cout << "For dynamic A: " << endl;
    for(i =0; i<SIZE; i++){
      for(j =0; j<SIZE; j++){
        *(dynamic_a+i*SIZE+j) = rand()%20; // random generation for matrix A
        cout <<w(3)<< *(dynamic_a+i*SIZE+j) <<' ';
        }
      cout << endl;
    }
    cout << endl;
    cout << "For dynamic B: " << endl; 
    for(i =0; i<SIZE; i++){
      for(j =0; j<SIZE; j++){
        *(dynamic_b+i*SIZE+j) = rand()%20;// random generation for matrix B
        cout <<w(3)<< *(dynamic_b+i*SIZE+j) <<' ';
        }
      cout << endl;
    }
    cout << endl;
    
    
    dynamic_matirx(SIZE, dynamic_a,dynamic_b,dynamic_c ); // compute
    
    cout << "For dynamic C: " << endl;    
    for(i=0; i< SIZE; i++){
      for(j=0; j<SIZE; j++)
        cout <<w(3)<<*(dynamic_c+i*SIZE+j) <<' '; // display the matrix C
      cout << endl;  
    }
    cout << endl; 
    
    system("pause");
    return 0;
    
}
