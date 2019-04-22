import sys

if len(sys.argv) >= 3:
	with open(sys.argv[1], 'a') as file:
		with open(sys.argv[2], 'r') as merge:
			for line in merge:
				file.write(line)
else:
	print("Pass filenames as arguments")
