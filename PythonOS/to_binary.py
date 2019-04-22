import sys

if len(sys.argv) >= 2:
	try:
		x = int(sys.argv[1])
		print(f"{x:32b}")
	except:
		print("Pass integer as an argument")
else:
	print("Pass integer as an argument")
