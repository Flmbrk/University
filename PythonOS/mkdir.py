import os
import sys

if len(sys.argv) >= 2:
	try:
		os.makedirs(sys.argv[1])
	except FileExistsError:
		print(f"Directory {sys.argv[1]} already exists")
else:
	print("Pass directory name as an argument")
