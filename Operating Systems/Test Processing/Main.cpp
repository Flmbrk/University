#include "Task13.h"

int main(int argc, char** argv)
{
	Task13 task("input.txt", "output.txt");

	task.readDataFromFile();
	task.calculate();
	task.printResult();

//	system("pause");
}
