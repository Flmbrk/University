import os
import sys

if len(sys.argv) >= 2:
	if os.path.exists(sys.argv[1]):
		os.utime(sys.argv[1], None)
	else:
		open(sys.argv[1], 'a').close()
else:
	print("Pass filename as an argument")

