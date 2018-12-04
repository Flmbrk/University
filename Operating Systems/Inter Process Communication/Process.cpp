#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <iostream>
#include <signal.h>
#include <sys/types.h>
#include <sys/wait.h>

bool f(int);
bool g(int);

int main(int argc, char** argv)
{
	int child_to_parent[2];
	int parent_to_child[2];
	bool res1, res2;
	int val;	
	int status1 = 0, status2 = 0;

	pipe(child_to_parent);
	pipe(parent_to_child);

	pid_t firstChild, secondChild, wpid;

	int x;
	printf("Enter data:\n");
	scanf("%d", &x);


	if((firstChild = fork()) < 0)
	{
		perror("Can't fork process");
		exit(EXIT_FAILURE);
	}

	//Parent control
	if(firstChild == 0)
	{	
		read(parent_to_child[0],&val, sizeof(val));
		printf("Child 1 received %d\n", val);
		res1 = f(val);
		write(child_to_parent[1], &res1, sizeof(res1));
		printf("Child 1 send %d\n", res1);
		exit(EXIT_SUCCESS);
	}
	else
	{	
		write(parent_to_child[1], &x, sizeof(x));
		write(parent_to_child[1], &x, sizeof(x));

		if((secondChild = fork()) < 0)
		{
			perror("Can't fork process");
			exit(EXIT_FAILURE);
		}

		if(secondChild == 0)
		{
			read(parent_to_child[0],&val, sizeof(val));
			printf("Child 2 received %d\n", val);
			res2 = g(val);
			write(child_to_parent[1], &res2, sizeof(res2));
			printf("Child 2 send %d\n", res2);
			exit(EXIT_SUCCESS);
		}
		else
		{
			int time = 1;
			while (true)
			{	
				pid_t firstCheck = waitpid(firstChild, &status1, WNOHANG);
				pid_t secondCheck = waitpid(secondChild, &status2, WNOHANG);
				
				std::cout << firstCheck << ' ' << secondCheck << std::endl;

				if(firstCheck > 0 && secondCheck > 0)
				{
					break;
				}

				if(time % 5 == 0)
				{
					printf("Do you want to continue calculations: y\\n?\n");
					char response;
					scanf(" %c", &response);
					if(response != 'y')
					{
						kill(firstChild, SIGKILL);
						kill(secondChild, SIGKILL);
						return 0;					
					}
				}
				sleep(1);
				time++;
			}
			read(child_to_parent[0], &res1, sizeof(res1));
			read(child_to_parent[0], &res2, sizeof(res2));

			printf("%d and %d\n", res1, res2);
			printf("Result: %d || %d = %d\n", res1, res2, res1 || res2); 
		}
	}
}

bool f(int x)
{
	return x > 0;
}

bool g(int x)
{
	if (x == 0)
	{
		while(true);
	}
	return (x * x - x) > 1;
}
