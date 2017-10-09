# -*- coding: UTF-8 -*-
#divide doc into train doc and test doc
import shutil
import os
from getPath import *

pardir = getparentdir()
rootdir = pardir+'/train'
dst = pardir+'/test'

dir = os.walk(rootdir)
for parent,dirnames,filenames in dir:    #�����������ֱ𷵻�1.��Ŀ¼ 2.�����ļ������֣�����·���� 3.�����ļ�����
    i=0
    if not parent==rootdir:
        index = parent.rfind("\\")
        classfolder = parent[(index+1):]
        newfolder = os.path.join(dst,classfolder)
        if not os.path.exists(newfolder):
            os.mkdir(newfolder)
    for filename in filenames:
        if i%2==0:
            path_name=os.path.join(parent,filename)
            dest_path=os.path.join(newfolder,filename)
            if os.path.exists(dest_path):
                os.remove(dest_path)
            shutil.move(path_name,newfolder)
        i+=1