import sys
import binascii

if len(sys.argv) >= 2:
	with open(sys.argv[1], 'rb') as f:
    		data = f.read()
	print(binascii.hexlify(data))
else:
	print("Pass filename as an argument")
