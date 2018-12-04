#pragma once
#include "AbstractFileReader.h"
#include <algorithm>
#include <map>

class Task13 : public FileReader 
{
public:
	Task13(std::string inputFileName, std::string outputFileName);
	~Task13() = default;
	
	void calculate();
private:
	size_t wordDistance(std::string word1, std::string word2);
	size_t intAbs(int a);
};
