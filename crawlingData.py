#8/24 오후 4:25 
이미지 제외 json 파일로 출력하는 코드입니다.

import json
import re
from bs4 import BeautifulSoup
from urllib.request import urlopen
from collections import OrderedDict

#IMG = []
PRODUCT_NAME = []
PRICE = []
Ect = []
DISPLAY = []
#CPU_COMPANY = []
CPU_NAME = []
RESOLUTION = []
RAM = []
#STORAGE_TYPE = []
STORAGE_SIZE = []
#ODD_TYPE = []
WEIGHT = []


page = list(range(1, 50, 1))
for page_number in page:
    
    url = "https://search.shopping.naver.com/search/all?exrental=true&exused=true&frm=NVSHATC&origQuery=%EB%85%B8%ED%8A%B8%EB%B6%81&pagingIndex=" + str(page_number) + "&pagingSize=40&productSet=total&query=%EB%85%B8%ED%8A%B8%EB%B6%81&sort=rel&timestamp=&viewType=list"
    html = urlopen(url)
    bsObject = BeautifulSoup(html, "html.parser")

    
    for a_bo3 in bsObject.find_all('div', 'basicList_title__3P9Q7'):
        for b in a_bo3.find_all('a', 'basicList_link__1MaTN'):
            PRODUCT_NAME.append(re.sub('<.+?>', '',str(b),0).strip())
            
    for a_bo3 in bsObject.find_all('span', 'price_num__2WUXn'):
        for b in a_bo3:
            PRICE.append(re.sub('<.+?>', '',str(b),0).strip())
    
    for a_bo3 in bsObject.find_all('div', 'basicList_desc__2-tko'):
        for b in a_bo3.find_all('a', 'basicList_detail__27Krk'):
            Ect.append(re.sub('<.+?>', '',str(b),0).strip())
                
    for i in range(0, len(Ect)):
        if str('화면크기') in Ect[i]:
            DISPLAY.append(Ect[i])
            
    for i in range(0, len(Ect)):
        if str('CPU') in Ect[i]:
            CPU_NAME.append(Ect[i])
            
    for i in range(0, len(Ect)):
        if str('CPU') in Ect[i]:
            CPU_NAME.append(Ect[i])
            
    for i in range(0, len(Ect)):
        if str('해상도') in Ect[i]:
            RESOLUTION.append(Ect[i])
            
    for i in range(0, len(Ect)):
        if str('램') in Ect[i]:
            RAM.append(Ect[i])
            
    for i in range(0, len(Ect)):
        if str('HDD') in Ect[i]:
            STORAGE_SIZE.append(Ect[i])
            
    #for i in range(0, len(Ect)):
    #   if str('ODD') in Ect[i]:
    #      ODD_TYPE.append(Ect[i])
            
    for i in range(0, len(Ect)):
        if str('무게') in Ect[i]:
            WEIGHT.append(Ect[i])
            
            
    matrix = [PRODUCT_NAME, PRICE, DISPLAY, CPU_NAME, RESOLUTION, RAM, STORAGE_SIZE, WEIGHT]
    file_data = list(zip(*matrix))

    print(json.dumps(file_data, ensure_ascii = False, indent = "\t"))
