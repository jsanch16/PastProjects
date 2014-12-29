#include<stdio.h>
#include<windows.h>
#include <string.h>

#define NAME "Juan Sanchez"


int main()
{
    char str[80];
    
    sprintf(str,"Hello %s, welcome to 415!", NAME);
    
    
	WriteFile(GetStdHandle(-11),str,strlen(str),NULL,NULL);
    
    
    getchar();//keep from closing
    return(0);
    
}


