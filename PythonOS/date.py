import datetime

time = datetime.datetime.now()
tz = datetime.datetime.now(datetime.timezone.utc).astimezone().tzname()

print(time.strftime(f"%a %b %d %H:%M:%S {tz} %Y"))
