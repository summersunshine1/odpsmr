# -*- coding: UTF-8 -*-
import jieba
import os
import codecs
import re
import shutil
import jieba.posseg
import _thread
from getPath import *

pardir = getparentdir()


def isnumorletter(num):
    regex = re.search('[a-zA-Z0-9]',num)
    if regex:
        return True
    else:
        return False
        
def mkdir(dir, folder):
    directory = dir+folder
    if os.path.exists(directory):
        return directory
    try:
        os.mkdir(directory)
    except OSError as exc:
        if exc.errno != errno.EEXIST:
            raise
    return directory
    
newdir = mkdir(pardir,'/newdata')

def create_txt(file_path, content):
    # if os.path.exists(file_path):
        # os.remove(file_path)
    index = file_path.split("\\")
    directory = index[-2]
    filename = index[-1]
    dir = mkdir(newdir, '/'+directory)
    new_path =dir + '/'+ filename
    f=codecs.open(new_path,'w','utf-8')
    for x in content:
        f.write(x)
    f.close()

def remove_words(file_path):
    stop = []
    for line in codecs.open(pardir+"/stop_words_ch.txt",'r','gbk'):  
        stop.append(line)
    
    file_object = codecs.open(file_path,'r','utf-8')
    try:
        all_the_text = file_object.read()
    except:
        print("error")
        file_object.close()
        try:
            file_object = codecs.open(file_path,'r','GB18030')
            all_the_text = file_object.read()
        except:
            print("again error")
            file_object.close()
            return        
    finally:
        file_object.close()
    segs = jieba.posseg.cut(all_the_text)
    final=''
    for seg in segs:
        tempseg=seg.word
        tempflg=seg.flag
        if tempflg.find('n')==-1:#only handle with noun
            continue
        if isnumorletter(seg.word):
            continue
        tempseg+='\n'
        if tempseg not in stop:
            if not len(final)==0:
                seg.word+=' '
            final+=seg.word
    create_txt(file_path, final)

def removeoncata(rootdir1):
    dir = os.walk(rootdir1)
    for parent,dirnames,filenames in dir:    #三个参数：分别返回1.父目录 2.所有文件夹名字（不含路径） 3.所有文件名字
        for filename in filenames:                        #输出文件信息
            path_name=os.path.join(parent,filename)
            
            remove_words(path_name)

import threading,time
from time import sleep, ctime
if __name__=="__main__":
    rootdir = pardir+'/data'
    dir = os.walk(rootdir)

    for parent,dirnames,filenames in dir:
        if len(filenames) == 0:
            continue
        th = _thread.start_new_thread(removeoncata,(parent,))
        # threadpool.append(th)
    while(True):
        time.sleep(10)
        print(10)