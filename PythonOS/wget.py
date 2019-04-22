import sys
import requests
import pprint

if len(sys.argv) >= 2:
	try:
		result = requests.get(sys.argv[1])
		pprint.pprint(result.content)
	except:
		print("Site not found")
else:
	print("Pass link as an argument")
