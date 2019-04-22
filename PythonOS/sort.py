import sys

if len(sys.argv) >= 2:
	lines = []
	with open(sys.argv[1], 'r') as file:
		lines = file.readlines()
	lines  = [line.strip() for line in lines]
	for line in sorted(lines):
		print(line)
else:
	print("Pass filename as an argument")
