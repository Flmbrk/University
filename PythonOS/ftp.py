import sys
from ftplib import FTP

if len(sys.argv) >= 4:
	ftp = FTP(sys.argv[1])
	ftp.login(user=sys.argv[2], passwd = sys.argv[3])
	ftp.retrlines('LIST')
	ftp.quit()
else:
	print("Pass server, login and password as parameters")
