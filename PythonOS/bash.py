import sys
import subprocess

if len(sys.argv) >= 2:
	subprocess.check_call(sys.argv[1:])
else:
	print("Pass arguments to the script")
