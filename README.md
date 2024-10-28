# Spring Data JPA를 활용한 수강신청 시스템 구현하기

## 과제 제출 요구 사항
* 보안에 민감한 정보들은 숨김 처리해서 제출합니다.
* 각 API에 대한 요청을 포스트맨을 통해 테스트하여 요청 및 응답의 캡쳐를 제출합니다.
* 본인의 이름으로 폴더를 하나 만든 후, 그 아래에 프로젝트 파일을 업로드하여 제출합니다.

## 기능 요구 사항
1. 학생 CRUD 기능
2. 강의 CRUD 기능
3. 학생과 강의 간의 중간 매핑 테이블을 활용한 수강신청 기능
   * 학생이 강의를 수강신청하고 조회, 취소할 수 있는 기능
4.  추가 기능을 구현하고 싶으신 분들은 구현하셔도 됩니다. (검색 등)
5. 설계는 처음부터 끝까지 자유입니다.
6. `@ManyToMany`를 사용하면 안 됩니다.
   