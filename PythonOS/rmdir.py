import sys
import shutil

if len(sys.argv) >= 2:
	try:
		shutil.rmtree(sys.argv[1])
	except:
		print("Enter path to the folder")
else:
	print("Pass folder path as an argument")
