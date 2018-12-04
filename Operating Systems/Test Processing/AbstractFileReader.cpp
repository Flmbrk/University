#include "AbstractFileReader.h"

const std::unordered_set<char> FileReader::mc_delimiters = {'.', ' ', ',', '(', ')'};

FileReader::FileReader(std::string inputFileName, std::string outputFileName)
	: m_inputFileName(inputFileName)
	, m_outputFileName(outputFileName)
	, m_textData()
{
}

void FileReader::readDataFromFile() 
{
	std::ifstream inputFile(m_inputFileName);
	std::string line;
	std::vector<std::string> textData;


	while (std::getline(inputFile, line))
	{
		textData.emplace_back(line);
	}

	inputFile.close();

	for (const auto& line : textData)
	{
		std::string newWord = "";
		for (int i = 0; i < line.length(); i++)
		{
			if (mc_delimiters.find(line[i]) != mc_delimiters.end())
			{
				if (!newWord.empty())
				{
					m_textData.insert(newWord);
					newWord = "";
				}
			}
			else
			{
				newWord += line[i];
			}
		}
		if (!newWord.empty())
		{
			m_textData.insert(newWord);
		}
	}
}

void FileReader::writeDataToFile()
{
	std::ofstream outputFile(this->m_outputFileName);

	for (const auto& line : m_result)
	{
		outputFile << line << '\n';
	}
}

void FileReader::printResult()
{
	for (const auto& element : m_result)
	{
		std::cout << element << std::endl;
	}
}
