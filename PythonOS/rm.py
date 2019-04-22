import os
import sys

if len(sys.argv) >= 2:
	try:
		os.remove(sys.argv[1])
	except:
		print("File not found")
else:
	print("Pass filename as an argument")
