import numpy as np
import os
import gensim
from sklearn.svm import SVR,SVC
from sklearn.metrics import accuracy_score
from sklearn.model_selection import cross_val_score
from xgboost import XGBClassifier

from getPath import *
pardir = getparentdir()

trainpath = pardir+'/train'
testpath = pardir+'/test'

def load_word2vec_model():
    model= gensim.models.Word2Vec.load(pardir+'/model/w2v')
    return model

def get_source_data(path):
    classdoc = {}
    model = load_word2vec_model()
    for parent,dirnames,filenames in os.walk(path):
        for file in filenames: 
            path_name=os.path.join(parent,file)
            index = parent.rfind('\\')
            label = int(parent[(index+1):][1:])
            docvec = []
            count = 0
            for line in open(path_name,encoding='utf-8'):
                arr = line.split()
                for word in arr:
                    if not word in model:
                        continue
                    docvec.append(model[word])
                    count+=1
            if len(docvec)==0:
                continue
            meanres = np.mean(docvec,axis=0)
            if not label in classdoc:
                classdoc[label] = [meanres]
            else:
                classdoc[label].append(meanres)
    return classdoc
    
def get_train_from_dic(classdoc):
    train = []
    labels = []
    for k,v in classdoc.items():
        for i in v:
            train.append(i)
            labels.append(k)
    # print(np.shape(train))
    # print(len(labels))
    return train,labels
    
def createmodel():
    classdoc = get_source_data(trainpath)
    train,labels = get_train_from_dic(classdoc)
    clf = XGBClassifier()
    train = np.array(train)
    labels = np.array(labels)
    clf.fit(train,labels) 
    # scores = cross_val_score(clf, train,labels, cv=5)
    # print(np.mean(scores))
    classdoc = get_source_data(testpath)
    test,labels = get_train_from_dic(classdoc)
    predict_value = clf.predict(test)
    print(accuracy_score(labels,predict_value))
        
if __name__=="__main__":
    # get_source_data(train)
    createmodel()
            
    
                    
    
