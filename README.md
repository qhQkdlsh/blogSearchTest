# blogSearchTest
블로그 검색 API를 활용한 검색 웹사이트

구성
- 메인(초기 검색만 지원)
- 리스트(기능 요구사항 전부 지원)

추가 기능
- 타임리프 템플릿 (프론트단 공통 레이아웃 활용)
- WebClient (외부 API 연동 활용)
- bootstrap.css (프론트단 마크업에 활용)

요구 사항
1. 블로그 검색
- 키워드를 통해 블로그를 검색
- 검색 결과에서 Sorting(정확도순, 최신순) 기능을 지원
- 검색 결과는 Pagination 형태로 제공
- 검색 소스는 카카오 API의 키워드로 블로그 검색(https://developers.kakao.com/docs/latest/ko/daum-search/dev-guide#search-blog)을 활용
- 추후 카카오 API 이외에 새로운 검색 소스가 추가될 수 있음을 고려

2. 인기 검색어 목록
- 사용자들이 많이 검색한 순서대로, 최대 10개의 검색 키워드를 제공
- 검색어 별로 검색된 횟수도 함께 표기

3. 구현 사항
- JAVA 11 이상 또는 Kotlin 사용
- Spring Boot 사용
- Gradle 기반의 프로젝트
- 블로그 검색 API는 서버(백엔드)에서 연동 처리
- DB는 인메모리 DB(예: h2)를 사용하며 DB 컨트롤은 JPA로 구현

jar Download url
https://github.com/qhQkdlsh/blogSearchTest/blob/main/blogSearch-0.0.1-SNAPSHOT.jar