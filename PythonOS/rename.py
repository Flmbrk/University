import os
import sys

if len(sys.argv) >= 3:
	os.rename(sys.argv[1], sys.argv[2])
else:
	print("Pass old filename and new filename as arguments")
