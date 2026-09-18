# Board Project

Spring Boot(Mustache + Spring Data JPA + H2)로 만든 게시판 CRUD 예제 및 Spring 실습 모음입니다.

## 주요 기능 (게시판)

- 글 목록/상세 조회, 새 글 작성 — `ArticleController`, `ArticleService`, `ArticleRepository`
- REST API 버전 — `ArticleApiController`
- Controller / Service / Repository / Entity / DTO 계층 분리

## 기술 스택

Spring Boot 4 · Spring Data JPA · Mustache · H2(in-memory) · Lombok · Gradle · Java 21

## 실행

```bash
./gradlew bootRun
```

`http://localhost:8080/articles` 에서 게시판을 확인할 수 있습니다. (H2 인메모리 DB라 재시작하면 데이터는 초기화됩니다.)

## 구성

이 저장소는 강의를 따라가며 누적한 여러 실습을 포함합니다.

- `articles/`, `members/` — Mustache 템플릿 기반 게시판/회원 CRUD
- `api/` — REST API 컨트롤러 실습 (Article, Coffee, First)
- `edu/` — Java Stream API 연습 코드
