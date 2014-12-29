#include<stdio.h>
#include<windows.h>

int main(int argc, char *argv[])
{
    if (argc != 3)//check for two args, first arg is program name
    {
        fprintf(stderr,"Error, wrong number of arguments\n");
        return(1);
    }
    
	//open file1
	HANDLE file1 = CreateFile(argv[1],
							GENERIC_READ,
							0,
							NULL,
							OPEN_EXISTING,
							FILE_ATTRIBUTE_NORMAL,
							NULL);
    
    
    if (file1 == INVALID_HANDLE_VALUE)//if opening of first file was not sucessful
    {
        fprintf(stderr,"Error opening first file\n");
        return(1);
    }
        
    //create outputfile based on second argument,writeonly
	HANDLE file2 = CreateFile(argv[2],
							GENERIC_WRITE,
							0,
							NULL,
							CREATE_NEW,
							FILE_ATTRIBUTE_NORMAL,
							NULL);	
    if (file2 == INVALID_HANDLE_VALUE)
    {
        fprintf(stderr,"Error creating second file\n");
        return(1);
    }
    
	//start at 1 so that its not already at 0
    DWORD bytesRead =1;
	DWORD bytesWritten;
    DWORD totalBytes = 0;
    BYTE data[256];
                

        //readFile returns nonzero with success
		//bytesRead tells you how many got read
		// !readFile is an actual error
        while (bytesRead >0)
		{
			if (ReadFile(file1,data,sizeof(data),&bytesRead,NULL) == FALSE)
			{
			    fprintf(stderr,"Error reading file\n");
				return(1);
			}
		
			if (WriteFile(file2,data,bytesRead,&bytesWritten,NULL) == FALSE)
			{
				fprintf(stderr,"Error writing file\n");
				return(1);
			}
			totalBytes = totalBytes + bytesRead;
		}
	
        //success!!
        CloseHandle(file1);
        CloseHandle(file2);
                
        fprintf(stdout,"copied %d bytes\n", totalBytes);
        return(0);
    

}//end main

