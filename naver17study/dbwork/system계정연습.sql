--system에 등록된 table틀 확인하기
--커서가 있는 곳의 sql문 실행 단축키 : ctrl+enter
select * from tab;

--등록된 user(계정)들 확인
select username from dba_users; --dba_users테이블에서 username이라는 컬럼만 확인하기

--dba_users라는 테이블에는 어떤 컬럼이 있을까
desc dba_users; --기본 구조만 확인(데이터 확인 불가)
select username, account_status from dba_users; --계정과 lock상태 알아보기

--scott계정의 비번은 tiger(오라클은 알파벳으로 시작해야함)로 생성해보자 
create user scott identified by tiger; --오류 발생, 12버전부터 오류 발생

--12버전부터는 user명에 공통문자열 c##이 들어가야함
--일단 c##scott/비번은 tiger로 만들어보자
create user c##scott identified by tiger;

--c##scott 계정을 삭제 후 공통문자열을 안넣고도 생성하는 방법으로 생성해보자
drop user c##scott;

alter SESSION set "_ORACLE_SCRIPT"=TRUE; --SESSION변경

--C## 공통문자열을 빼고 다시 생성해보자(SCOTT/TIGER)
create user scott identified by tiger;

--angel/a1234(연습용 계정)로 만들어보자
create user angel IDENTIFIED by a1234;

select username, account_status from dba_users; --lock상태가 open이면 사용가능함

--angel계정에 lock설정
alter user angel ACCOUNT lock;

--angel계정에 lock설정해제
alter user angel ACCOUNT UNLOCK;

--scott와 angel계정에 기본 권한을 주자
--connect: 접속할 수 있는 권한
--resource:데이터 관리를 할 수 있는 권한
grant connect,RESOURCE to angel;
grant connect,resource to scott;

--생성된 계정에서 테이블을 생성하고 데이터를 추가하려고 하면 table space에 대한 오류 발생
--table space를 unlimit로 설정(system 계정에서만 할 수 있다) 
--이건 알고만 있어도 되는 명령어
alter user angel default TABLESPACE users quota unlimited on users;
alter user scott default TABLESPACE users quota unlimited on users;

--angel의 비번을 a1234에서 pw1234로 변경해보자
alter user angel identified by pw1234;



