#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <windows.h>
#include <ctype.h>
#include <sys/types.h>

#define BUFFSIZE 81920 //80 kb
#define NUM_THREADS 8

int wordCount = 0;//global variable
char data[BUFFSIZE];//global buffer


struct bufferPartition
{
    DWORD start;
    DWORD end;
};

DWORD WINAPI countWords(void* arg)
{
    //bring in the current partition struct from arg
    struct bufferPartition *currentPart = arg;
	HANDLE mutex = CreateMutex(NULL,TRUE,NULL);
	WaitForSingleObject(mutex,100);
    //if the lower bound of current partition is a word,
    //should always count a word at start of partition,
    if(isalnum(data[currentPart->start]))
    {
        wordCount++;
    }
    //beginning from second char of partition(since first one was already counted)
    //up to the upperbound of partition -1
    for(DWORD i = (currentPart->start) + 1; i < (currentPart->end) - 1; i++)
    {
        DWORD j = i + 1;
        //increment if word char is found after a nonword char
        if(!isalnum(data[i]) && isalnum(data[j]))
        {
            wordCount++;
        }
    }
	ReleaseMutex(mutex);
    return 0;
}

int main(int argc, char *argv[])
{
    struct bufferPartition partitions[NUM_THREADS];
	//struct bufferPartition *partitions = malloc(sizeof(struct bufferPartition));
    HANDLE tid[NUM_THREADS];//array of thread ids
    DWORD i;
	DWORD totalBytes = 0;
	DWORD thread_id;
    

    if (argc != 2)//check for two args, first arg is program name
    {
        fprintf(stderr,"Error, wrong number of arguments\n");
        return(1);
    }
    
	//open file1
	HANDLE file1 = CreateFile(argv[1],GENERIC_READ,0,NULL,OPEN_EXISTING,FILE_ATTRIBUTE_NORMAL,NULL);
    if (file1 == INVALID_HANDLE_VALUE)
    {
        fprintf(stderr,"Error opening first file\n");
        return(1);
    }
	    DWORD bytesRead = 1;
        while (bytesRead >0)
		{
			if (ReadFile(file1,data,BUFFSIZE,&bytesRead,NULL) == FALSE)
			{
			    fprintf(stderr,"Error reading file\n");
				return(1);
			}
			totalBytes = totalBytes + bytesRead;
		}	
        CloseHandle(file1);
    
    
    DWORD partitionSizes[NUM_THREADS];    
    //evenly as possible divide partitions----
    for (i=0; i < NUM_THREADS;i++)
    {
        partitionSizes[i] = totalBytes/NUM_THREADS;
    }
    for (i = 0; i < totalBytes % NUM_THREADS;i++)
    {
        partitionSizes[i] += 1;
    }
    //----------------------------------------
    
    
   for(DWORD i = 0; i < NUM_THREADS; i++)
     {
	  partitions->start = i * (sizeof(data)/NUM_THREADS);
	  partitions->end = partitions->start + (sizeof(data)/NUM_THREADS);
          tid[i] = CreateThread(NULL, 0, &countWords, partitions, 0, &thread_id);
          if(tid[i] != NULL)
               WaitForSingleObject(tid[i], INFINITE);
     }
    
    printf("Running with %d threads,\n", NUM_THREADS);
    printf("The file contains %d words.\n", wordCount);
	CloseHandle(tid);
    return 0;
}


