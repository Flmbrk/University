import sys
import hashlib
 
BUF_SIZE = 131072 #128kb parts
 
if len(sys.argv) >= 2:
        sha1 = hashlib.sha1()
 
        with open(sys.argv[1], 'rb') as f:
                while True:
                        input = f.read(BUF_SIZE)
 
                        if not input:
                                break
 
                        sha1.update(input)
 
        print(f"SHA1: {sha1.hexdigest()}")
else:
        print("Pass filename as an argument")
