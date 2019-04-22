import os
import sys
import signal

if len(sys.argv) >= 2:
	pid = int(sys.argv[1])
	try:
		os.kill(pid, signal.SIGKILL)
	except ProcessLookupError as err:
		print(f"{pid} - process not found")
else:
	print("Pass PID as an argument")
