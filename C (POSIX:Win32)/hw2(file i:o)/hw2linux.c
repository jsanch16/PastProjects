#include<stdio.h>
#include<unistd.h>
#include <sys/stat.h>
#include <fcntl.h>

#define _POSIX_SOURCE 1

int main(int argc, char *argv[])
{
    if (argc != 3)
    {
        fprintf(stdout,"Error, wrong number of arguments\n");
        return(1);
    }
    
    //argv[0] stores the name of the program
    int fd1 = open(argv[1],O_RDONLY);
    
    if (fd1 == -1)//if opening of first file was not sucessful(-1 means error)
    {
        fprintf(stderr,"Error opening first file\n");
        return(1);
    }
    
    //create outputfile based on second argument,writeonly
    int fd2 = open(argv[2],O_WRONLY | O_CREAT | O_EXCL, S_IRWXU);
    
    if (fd2 == -1)//(-1 means error)
    {
        fprintf(stderr,"Error creating second file\n");
        return(1);
    }
    
    //start at 1 so that its not already at 0
    int bytesRead = 1;
    int bytesWritten;
    int totalBytes = 0;
    char data[256];
    
    while(bytesRead > 0)
    {
        bytesRead = read(fd1,data,256);
        
        if ((bytesWritten = write(fd2,data,bytesRead)) < bytesRead)
        {
            fprintf(stderr, "Error writing to file\n");
            return (1);
        }
        totalBytes = totalBytes + bytesWritten;
    }
    
    if (bytesRead == -1)
    {
        fprintf(stderr,"Error reading file\n");
        return(1);
    }
    else
    {
        //success!!
        close(fd1);
        close(fd2);
        
        fprintf(stdout,"copied %d bytes\n", totalBytes);
        return(0);
    }
    
}