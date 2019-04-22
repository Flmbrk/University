import sys
import shutil

if len(sys.argv) >= 3:
	shutil.make_archive(sys.argv[2], 'zip', sys.argv[1])
else:
	print("Pass directory name as an argument")
