# app

메인화면 : 추천과 상세검색 중 선택, 선택 시 해당 화면으로 넘어감

activity_mainmenu.xml
Mainmenu.kt

상세검색 화면 : 선택한 옵션들을 하단에 표시, 적용 버튼 누르면 결과 화면으로 넘어감

activity_search_screen.xml
SearchScreen.kt

결과 화면 : 상세검색 화면에서 선택한 옵션에 해당하는 노트북 출력

activity_result_screen.xml
ResultScreen.kt

메인화면-> 추천 누른 뒤 다음 화면
Recommend_menu.kt
activity_recommend_menu.xml

게임 선택화면
Game_screen.kt
activity_game_screen.xml

과제 선택화면
Study_screen.kt
activity_study_screen.xml

게임용/과제용/편집용/가정,사무용의 상세검색화면
Recommend_search_screen.kt
activity_recommend_search_screen.xml

**메인화면->추천화면-> 1. 가정, 사무용 2. 게임용 3. 과제용 4. 편집용 일 때 만약 1,4번 선택 시 바로 상세검색화면으로 갔다가 결과화면 출력
**만약 2,3 번 선택 시 2번은 각각 게임, 과제 선택화면 갔다가 상세검색화면 갔다가 결과화면 출력
