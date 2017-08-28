import numpy as np
import re
fa = open("F:/javeworkspace/a.txt",'r',encoding = 'utf-8')
fb = open("F:/javeworkspace/a.txt",'r',encoding = 'utf-8')
alines = fa.readlines()
blines = fb.readlines()
s = set()
file_path = "F:/javeworkspace/stopword.txt"
for line in alines:
    # res = re.findall("[\u4e00-\u9fa5]+",line)
    # if not len(res) == 0:
    r = line.strip('\n')
    s.add(r)
s = list(s)
file = open(file_path,'w',encoding='utf-8')
file.writelines("\n".join(s))
file.close()
