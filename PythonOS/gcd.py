
import sys
 
def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a % b)
 
if len(sys.argv) >= 3:
    a, b = int(sys.argv[1]), int(sys.argv[2])
    print(gcd(a, b))
else:
    print("Pass two numbers as an arguments")
