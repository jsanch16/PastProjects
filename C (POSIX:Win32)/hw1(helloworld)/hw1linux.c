#include<stdio.h>
#include<unistd.h>
#include <string.h>

#define _POSIX_SOURCE 1
#define NAME "Juan Sanchez"


int main()
{
    char str[80];
    
    sprintf(str,"Hello %s, welcome to 415!", NAME);
    
    write(1,str, strlen(str));
    
    getchar();//keep from closing
    return(0);
    
}




