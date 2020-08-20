import re
from bs4 import BeautifulSoup
from urllib.request import urlopen

book_name = []
page = list(range(1,40,1))
for page_number in page:
    
    url = "https://search.shopping.naver.com/search/all?exrental=true&exused=true&frm=NVSHATC&origQuery=%EB%85%B8%ED%8A%B8%EB%B6%81&pagingIndex=" + str(page_number) + "&pagingSize=40&productSet=total&query=%EB%85%B8%ED%8A%B8%EB%B6%81&sort=rel&timestamp=&viewType=list"
    html = urlopen(url)
    bsObject = BeautifulSoup(html, "html.parser")
    
    for a_bo3 in bsObject.find_all('span', 'price_num__2WUXn'):
        for b in a_bo3:
            # print(b)
            
            book_name.append(re.sub('<.+?>', '',str(b),0).strip())
            
            
print(book_name)

