# 모듈 임포트 
import os
import sys
import requests
from konlpy.tag import Okt
from collections import Counter
from bs4 import BeautifulSoup as bs
from wordcloud import WordCloud
from time import strftime

# 워드 클라우드 이미지가 저장될 경로 체크 및 생성
path = sys.argv[1] if sys.argv[1] else "c:/tmp"

if not os.path.isdir(path):
    os.mkdir(path)

# 원격 컨텐츠 로드 
url = "https://news.naver.com/"
html = requests.get(url).text
soup = bs(html, 'html.parser')
body = soup.select_one("body")
text = body.get_text().strip().replace("\n", " ")
stopwords = ['본문', '바로가기', 'NAVER', '검색', '이슈', '닫기', '구독'] # 불용어


# 명사, 형용사, 동사의 단어로 형태소 분리
okt = Okt()
words = []
for word, pos in okt.pos(text):
    if word not in stopwords and pos in ['Noun', 'Verb', 'Adjective']:
        words.append(word)

# 가장 많이 등장하는 키워드를 상위 50개 추출 
stat = Counter(words).most_common(50)

# 워드 클라우드 이미지 생성 
wc = WordCloud(font_path='C:/trend/NanumGothic-ExtraBold.ttf', 
               background_color='white', 
               max_font_size=100, 
               width=500, height=300)
cloud = wc.generate_from_frequencies(dict(stat))
cloud.to_file(f"{path}/{strftime("%Y%m%d%H")}_news.jpg")