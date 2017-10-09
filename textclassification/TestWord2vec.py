import os
import gensim
from gensim.models import doc2vec
from gensim import utils
from gensim.models.doc2vec import LabeledSentence

from getPath import *
pardir = getparentdir()

class MySentences(object):
    def __init__(self, dirname):
        self.dirname = dirname

    def __iter__(self):
        for parent,dirnames,filenames in os.walk(self.dirname):
            for file in filenames: 
                path_name=os.path.join(parent,file)
                for line in open(path_name,encoding='utf-8'):
                    yield line.split()
                    
class LabeledLineSentence(object):
    def __init__(self,dirname):
        self.dirname = dirname
    def __iter__(self):
        for parent,dirnames,filenames in os.walk(self.dirname):
            for file in filenames: 
                path =os.path.join(parent,file)
                for uid, line in enumerate(open(path,encoding='utf-8')):
                    yield LabeledSentence(words=line.split(),tags=[file])
                
def create_word2vec_model():
    sentences = MySentences(pardir+'/newdata') # a memory-friendly iterator
    model = gensim.models.Word2Vec(sentences,min_count=30)
    model.save(pardir+'/model/w2v')
    
def load_word2vec_model():
    model= gensim.models.Word2Vec.load(pardir+'/model/w2v')
    return model
    
def create_doc2vec_model():
    sentences =LabeledLineSentence(pardir+'/newdata') # a memory-friendly iterator
    model = Doc2Vec(sentences)
    model.save(pardir+'/model/d2v')
    
if __name__=="__main__":
    # create_word2vec_model()
    # load_word2vec_model()
    create_doc2vec_model()

