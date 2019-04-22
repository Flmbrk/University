import sys
from urllib.parse import urlencode
from urllib.request import Request, urlopen
import json

if len(sys.argv) >= 3:
	try:
		request = Request(sys.argv[1], urlencode(json.loads(sys.argv[2])).encode())
		json = urlopen(request).read().decode()
		print(json)
	except:
		print("Can't open link")
else:
	print("Pass link and data as arguments")
