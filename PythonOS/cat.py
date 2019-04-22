import os
import sys

if len(sys.argv) >= 2:
	with open(sys.argv[1], 'r') as f:
		print(f.read(), end="")
else:
	print("Pass filename as an argument")
