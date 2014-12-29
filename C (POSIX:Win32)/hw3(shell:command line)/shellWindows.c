#include <stdio.h>
#include <string.h>
#include <windows.h>

#define BUFFSIZE 2048

int main()
{
	char input[BUFFSIZE];
    STARTUPINFO si;
    PROCESS_INFORMATION pi;

	ZeroMemory(&si,sizeof(STARTUPINFO));
	si.cb = sizeof(	STARTUPINFO);
	ZeroMemory(&pi,sizeof(pi));

    while(1)
	{
		//preproccess
		char c[] = "/c ";

		printf("\nMyShell> ");
    
		//exit shell
		fgets(input,BUFFSIZE,stdin);
		if (strcmp(input,"exit\n")==0)
		{
			return 0;
		}
		
		strcat(c,input);

		if( !CreateProcess("C:\\Windows\\System32\\cmd.exe",
			c,        
			NULL,           
			NULL,           
			0,          	
			0,              
			NULL,           
			NULL,           
			&si,           
			&pi ))          
			{
				printf( "CreateProcess failed (%d).\n", GetLastError() );
				return 1;
			}

		WaitForSingleObject( pi.hProcess, INFINITE );

        CloseHandle( pi.hProcess );
		CloseHandle( pi.hThread );
	}
	
    return 0;
}