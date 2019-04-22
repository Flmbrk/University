import sys
import hashlib
 
BUF_SIZE = 131072 #128kb parts
 
if len(sys.argv) >= 2:
    md5 = hashlib.md5()
 
    with open(sys.argv[1], 'rb') as f:
        while True:
            input = f.read(BUF_SIZE)
 
            if not input:
                break
 
            md5.update(input)
 
    print(f"MD5: {md5.hexdigest()}")
else:
    print("Pass filename as an argument")
