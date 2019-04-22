import sys
import shutil

if len(sys.argv) >= 2:
	shutil.unpack_archive(sys.argv[1], 'zip')
else:
	print("Pass filename as an argument")
