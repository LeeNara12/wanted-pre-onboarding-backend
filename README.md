# wanted-pre-onboarding-backend
README.md 파일에는 다음과 같은 사항들이 포함되어야 합니다:

### 지원자의 성명 : 이나라

### 애플리케이션의 실행 방법 (엔드포인트 호출 방법 포함) : 세팅환경과 dependencies 설명 + 애플리케이션 페이지 이동 설명
세팅환경 : 자바 jdk 17.0.8 version, 인텔리제이
dependencies : Spring Web, Spring Data JPA, MySQL Driver, Lombok, Thymeleaf, Validation
/login or /join => /board/list

### 데이터베이스 테이블 구조 : 테이블 구조 설명
CREATE TABLE `user_info` (
	`user_id`	int(11)	NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`email`	varchar(100) UNIQUE NOT NULL,
	`pwd`	varchar(20)	NOT NULL
);

CREATE TABLE `board` (
	`board_id`	int(11)	NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`title`	varchar(100)	NOT NULL,
	`content`	text	NOT NULL,
    `user_id`	int(11)	NOT NULL,
    foreign key (user_id) references user_info(user_id)
);


### 구현한 API의 동작을 촬영한 데모 영상 링크 : 동작 동영상 촬영 후 링크 올리기(window + g)
링크 : ~~

### 구현 방법 및 이유에 대한 간략한 설명 : java springboot + thymeleaf + lombok + 왜 이것들을 사용했는지
로그인 없이도 게시글을 볼 수는 있는 게시판을 구현하고자 하였습니다.
spring boot와 thymeleaf, lombok, validation 등을 사용하였고,
특히, Validation은 로그인, 회원가입의 유효성검사를 클라이언트 뿐 아니라 서버에서도 막아주기 위해 사용하였습니다.

### API 명세(request/response 포함) : 

로그인
request : 아이디와 비밀번호 유효성 검사 후 로그인이 가능한지를 여부 
response : 가능여부 확인 후 로그인 (세션은 아직 미완성) 후 리스트로 페이지 이동

회원가입
request : 아이디와 비밀번호 유효성 검사 후 회원가입이 가능한지를 여부
response : 가능여뷰 확인 후 회원정보 데이터 저장 후 로그인 페이지로 이동

게시판(리스트)
request : board_id, title, email(작성자) 요청
response : Board 테이블과 UserInfo 테이블 조인한 데이터 리스트로 출력

게시판(작성)
request : title, content 요청 (전부 not null)
response : Board 테이블에 저장

게시판(삭제)
request : board_id 요청
response : board_id의 row delete

게시판(수정)
request : board_id 요청
response : board_id의 row update


