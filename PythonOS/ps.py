import os
import psutil

print("PID\t\t\tNAME")

for p in psutil.process_iter():
	try:
		psinfo = p.as_dict(attrs=['pid', 'name'])
	except psutil.NoSuchProcess:
		pass
	else:
		print(f"{psinfo['pid']}\t\t\t{psinfo['name']}")

