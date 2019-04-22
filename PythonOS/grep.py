import sys

lines = sys.stdin.readlines()

if len(sys.argv) >= 2:
	for line in lines:
		if str.find(line, sys.argv[1]) > -1:
			print(line, end="")
else:
	print("Pass pattern as an argument")
