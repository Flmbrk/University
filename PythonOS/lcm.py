import sys

def gcd(a, b):
	while b > 0:
		a, b = b, a % b
	return a

if len(sys.argv) >= 3:
	try:
		a, b = int(sys.argv[1]), int(sys.argv[2])
		print (abs(a * b) // gcd(a, b))
	except:
		print("Wrong arguments")
else:
	print("Pass two positive integers as arguments")
