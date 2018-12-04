#pragma once
#include <string>
#include <vector>
#include <set>
#include <sstream>
#include <fstream>
#include <unordered_set>
#include <iostream>

class FileReader {
public:
	FileReader(std::string inputFileName, std::string outputFileName);
	~FileReader() = default;

	virtual void calculate() = 0;
	void readDataFromFile();
	void writeDataToFile();
	void printResult();

protected:
	std::string m_inputFileName;
	std::string m_outputFileName;
	std::set<std::string> m_textData;
	std::vector<std::string> m_result;

	static const std::unordered_set<char> mc_delimiters;
};
