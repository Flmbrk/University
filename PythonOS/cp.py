import sys
import shutil

if len(sys.argv) >= 3:
	shutil.copy(sys.argv[1], sys.argv[2])
else:
	print("Pass filename and path as arguments")
