#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <queue>
#include <time.h>

using namespace std;

int** makeTable(int, int);

const int maxScore = 5;

int main()
{
	int x, y;
	cout << "Enter X" << endl;
	cin >> x;
	cout << "Enter Y" << endl;
	cin >> y;
	//int **arr = makeTable(x, y);
	int arr[7][3] = { {5,3,4},{4,5,5},{4,5,6},{4,5,3},{4,3,6},{5,3,1},{4,4,2} };
	for (int i = 0; i < x; i++) {
		cout << "X" << (i + 1) << ": { ";
		for (int j = 0; j < y; j++) {
			cout << arr[i][j] << " ";
		}
		cout << "}" << endl;
	}
	int *Q = new int[x];

	cout << "\t";
	for (int i = 0; i < x; i++) {
		cout << "X'" << i + 1 << "\t";
	}
	cout << endl;
	for (int i = 0; i < x; i++) {
		int max = 0;
		cout << "X" << i + 1 << ": ";
		for (int j = 0; j < x; j++) {
			int counter = 0;
			bool strong = false;
			for (int l = 0; l < y; l++) {
				if (arr[i][l] <= arr[j][l]) {
					counter++;
					if (arr[i][l] < arr[j][l]) {
						strong = true;
					}
				}
			}
			cout << "\t" << counter;
			if (!strong) {
				counter = 0;
			}
			if (counter > max) {
				max = counter;
			}
		}
		cout << endl;
		Q[i] = max;
		cout << "Q(x" << i + 1 << "): " << max << endl;
	}

	int min = 99999;

	for (int i = 0; i < x; i++) {
		if (Q[i] < min) {
			min = Q[i];
		}
	}

	cout << "ANSWER: ";

	for (int i = 0; i < x; i++) {
		if (Q[i] == min) {
			cout << i + 1 << " ";
		}
	}

	cout << endl;
}

int** makeTable(int x, int y) {
	int **res = new int*[x];
	for (int i = 0; i < x; i++) {
		res[i] = new int[y];
	}
	srand(time(NULL));
	for (int i = 0; i < x; i++) {
		for (int j = 0; j < y; j++) {
			res[i][j] = 1 + (rand() % static_cast<int>(maxScore));
		}
	}
	return res;
}