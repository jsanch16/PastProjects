/*********************************************************************** 
Author: Jung Hwan KIm
Class: CSC 340
Instructor: Professor Dujmovic, Jozo
Homework: 05 - Homework01
Algorithm: this is guess game for Human vs Machine
step 1: input number 1 - 99 to guess to Human or 
the computer will tell you too big, too small or corret.
detect the cheating from user prompt
**************************************************************************/
#include <iostream>

using namespace std;

int randomNum(void){
    srand(time(NULL));
    return rand()%99+1;

}

int compare_Guess_User (int guess, int input, int count){
    
    while (input > 0 && input <100)
       if (input > guess){
             cout << "Too Big!!! " << endl;
             count ++;
             cout << "Guess? number 1 to 99: ";
             cin >> input;
       }
       else if(input < guess){
             cout << "Too Small!!!" << endl;
             count++;
             cout << "Guess? number 1 to 99: ";
             cin >> input;
       }
       else{
             cout <<"Found!" << endl;
             count++;
             return count;
       }
     
             
       
   
}

int compare_Guess_Computer(int guess, int count){
    char check;
    int max = 99;
    int min = 1;
    int mid = (max + min)/2;
    while(1){
         cout << "The guess from computer: "<< guess << endl;
         cout << "Is it correct press '>','<',or '=': "<< endl;
         cin >> check;
         mid /= 2;
         
         if(check == '>'){
             guess = guess+ (mid+1);
             count++;
             max = max- (mid+1);
             
         }
         else if(check == '<'){
             guess = guess- (mid+1);
             count++;
             min = min+ (mid+1);
             
         }
         else if(check == '='){
             count++;
             cout << "I found it!" << endl;
             break;
         }
         if(!(max > min)){
             cout << "You are cheating!" << endl;
             return 0;
             break;
         }
              
    
    }
    return count;
}

void man_Vs_Machine(int count_User ,int count_Computer){
     if(count_User == count_Computer)
         cout << "Ties!" << endl;
     else if(count_User < count_Computer)
         cout << "User WinS!" << endl;
     else
         cout << "Computer Wins!" << endl;

}

int main(void){
    
    
    int input,guess, count_User =0, count_Computer =0;
   
    guess = randomNum();
    
    
    cout << "Welcome to guessing game 'HUMAN VS MACHINE'!" << endl;
    
    cout << "Guess? number 1 to 99: ";
    cin >> input;
    
    count_User =  compare_Guess_User(guess,input,count_User);
    
    cout << "That's correct " << endl;
    cout << "You 've tried : " << count_User << endl;
    cout << "Okay It's my turn!" << endl;
    
    guess = randomNum();
    
    count_Computer = compare_Guess_Computer(guess,count_Computer );
                  
    cout << "I've tried : " << count_Computer<< endl;
    man_Vs_Machine(count_User, count_Computer);
    cout << "Score HUMAN vs MACHINE: " << count_User <<" : " << count_Computer
         << endl;
    system("pause");
    return 0;
}
