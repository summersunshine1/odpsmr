import os
import sys
import time

def getparentdir():
    pwd = sys.path[0]
    abs_path = os.path.abspath(pwd)
    return abs_path   
 
if __name__ == "__main__":
    par = getparentdir()
    path = par + '/data/C000007/0.txt'
    dir = os.path.abspath(path)
    print(dir)
    dirarr = dir.split('\\')
    print(dirarr[-2])