import sys

if len(sys.argv) >= 2:
	try:
		x = int(sys.argv[1])
		res = 1
		for i in range(2, x + 1):
			res *= i
		print(res)
	except:
		print("Wrong parameter passed")
else:
	print("Pass integer as an argument")
