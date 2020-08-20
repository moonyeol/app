#크롤링한 랩탑의 이름, 가격 데이터를 묶어서 출력하는 코드입니다.

import re
from bs4 import BeautifulSoup
from urllib.request import urlopen

laptop_name = []

page = list(range(1,10,1))
for page_number in page:
    
    url = "https://search.shopping.naver.com/search/all?exrental=true&exused=true&frm=NVSHATC&origQuery=%EB%85%B8%ED%8A%B8%EB%B6%81&pagingIndex=" + str(page_number) + "&pagingSize=40&productSet=total&query=%EB%85%B8%ED%8A%B8%EB%B6%81&sort=rel&timestamp=&viewType=list"
    html = urlopen(url)
    bsObject = BeautifulSoup(html, "html.parser")
    
    for a_bo3 in bsObject.find_all('div', 'basicList_title__3P9Q7'):
        for b in a_bo3.find_all('a', 'basicList_link__1MaTN'):
            # print(b)
            
            laptop_name.append(re.sub('<.+?>', '',str(b),0).strip())
            
            
print(laptop_name)
