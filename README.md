
## 1. 책 목록 조회하기

접속 주소: http://ec2-13-125-11-186.ap-northeast-2.compute.amazonaws.com:8080/api/v1/book/list

책의 제목, 저자 등을 조회
Book(many) - Author(one)


## 2. 병원 및 병원 리뷰 조회하기
Hospital(one) - Review(many)

### A. 병원 목록 조회하기
url: http://localhost:8080/api/v1/hospitals

### B. 리뷰 조회하기
url: http://localhost:8080/api/v1/hospitals/{id}