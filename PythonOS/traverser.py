import os

for root, dirs, files in os.walk("."):
    path = root.split(os.sep)
    for file in files:
        print(len(path) * '---', file)
