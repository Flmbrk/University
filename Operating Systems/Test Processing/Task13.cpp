#include "Task13.h"

Task13::Task13(std::string inputFileName, std::string outputFileName)
	: FileReader(inputFileName, outputFileName)
{
}

void Task13::calculate() 
{
	for (const auto& elem : m_textData)
	{
		std::cout << elem << std::endl;
	}

	size_t maxDistance = 0;
	std::set<std::string>::const_iterator it;
	std::map<std::pair<std::string, std::string>, size_t> distanceMap;
	
	for (it = m_textData.cbegin(); it != m_textData.cend(); it++)
	{
	
		std::string word = *it;
		std::cout << word << std::endl;	
	std::set<std::string>::const_iterator nextIt = std::next(it, 1);
		
		
		for (nextIt; nextIt != m_textData.cend(); nextIt++)
		{
			std::string nextWord = *nextIt;
			
			std::cout << nextWord << std::endl;
			size_t dist = wordDistance(word, nextWord);

			if (maxDistance < dist) 
			{
				maxDistance = dist;
			}

			distanceMap.insert({ { word, nextWord }, dist });
		}
	}

	for (auto& element : distanceMap)
	{
		if (element.second == maxDistance)
		{
			std::string temp = element.first.first + " : " + element.first.second + " : " + std::to_string(element.second);
			m_result.emplace_back(temp);
		}
	}

	std::cout << maxDistance << std::endl;
}

size_t Task13::wordDistance(std::string word1, std::string word2)
{
	size_t result = intAbs(word1.length() - word2.length());
	size_t minLength = std::min(word1.length(), word2.length());


	for (int i = 0; i < minLength; i++)
	{
		if (word1[i] != word2[i])
		{
			result++;
		}
	}
	return result;
}

size_t Task13::intAbs(int a)
{
	return (a < 0) ? a * -1 : a;
}
