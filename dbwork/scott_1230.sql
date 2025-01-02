--emp테이블로 연습
--job 컬럼의 데이터 중 중복되는 데이터는 한번만 출력해보자
select DISTINCT job from emp;
select DISTINCT job,ename from emp; --다른 컬럼하고 같이 쓸 경우 적용이 안되거나 오류가 날 수 있음
SELECT * from emp; --전체 컬럼 데이터 조회
select ename,job from emp; -- 일부 컬럼만 조회
select ename,job from emp order by ename; --ename의 오름차순 조회(asc는 생략가능)
select ename,job from emp order by ename desc;--ename의 내림차순 조회(desc인 경우는 생략불가) 

--job의 오름차순, 같은 job은 ename의 내림차순 조회
select job,ename from emp order by job,ename desc;
--job의 오름차순, 같은 job은 ename도 오름차순 조회
select job,ename from emp order by job,ename;
--순서를 정할때 컬럼명 대신 컬럼번호로 해도 됨(첫번째 컬럼은 1),job과 ename이니까 job이 1, ename이 2
select job,ename from emp order by 1,2; --job(1), ename(2)

-- sal의 오름차순 정렬, 아래 두 경우는 같은 결과값 출력
select * from emp order by 6;
select * from emp order by sal;

--empno의 오름차순 조회
select ename,sal,comm,job,empno from emp order by 5;
select ename,sal,comm,job,empno from emp order by empno;

--ename의 내림차순
select ename,sal,comm,job,empno from emp order by 1 desc;
select ename,sal,comm,job,empno from emp order by ename desc;

--where 조건문
select ename,job,sal,comm from emp where sal>=1500;
select ename,job,sal,comm from emp where ename='allen'; --데이터는 대소문자 정확히 해야함
select ename,job,sal,comm from emp where ename='ALLEN';

--ename이 A로 시작하는 데이터를 조회
select ename,job,sal,comm from emp where ename like 'A%';
--ename에 A가 포함되는 데이터를 조회
select ename,job,sal,comm from emp where ename like '%A%';
--ename에 A로 시작하거나 S로 시작하는 데이터 조회, 컬럼명까지 정확하게 넣어줘야함
select ename,job,sal,comm from emp where ename like 'A%' or ename like 'S%';
--ename에 A와 S를 모두 포함하는 데이터만 출력
select ename,job,sal,comm from emp where ename like '%A%' and ename like '%S%';

--ename의 두번째 글자가 'A'인 사람만 조회
select ename,job,sal,comm from emp where ename like '_A%';
--ename의 두번째 글자가 'A'이거나 세번째 A인 사람만 조회
select ename,job,sal,comm from emp where ename like '_A%' or ename like '__A%';

--ename이 N이나 K로 끝나는 사람만 조회
select ename,job,sal,comm from emp where ename like '%N' or ename like '%K';

--job이 analyst이면서 sal이 1500이상인 사람을 조회
select ename,job,sal,comm from emp where job='ANALYST' AND SAL>=1500;

--sal이 1200~2000 사이값 조회
select ename,job,sal,comm from emp where sal>=1200 and sal<=2000; --방법1
select ename,job,sal,comm from emp where sal between 1200 and 2000; --방법2

--job이 manager, salesman, analyst 이 3가지 직업의 사람을 조회
select ename,job,sal,comm from emp where job='MANAGER' OR JOB='SALESMAN' OR JOB='ANALYST';--방법1
select ename,job,sal,comm from emp where JOB IN('MANAGER', 'SALESMAN', 'ANALYST');--방법2

--EMPNO가 7654,7788,7844,7902인 사람만 조회
select empno,ename,job,sal,comm from emp where EMPNO IN(7654,7788,7844,7902);

--COMM이 NULL인 데이터만 조회
select ename,job,sal,comm from emp where COMM IS NULL;
--COMM이 NULL이 아닌 데이터만 조회
select ename,job,sal,comm from emp where COMM IS NOT NULL;

--MGR이 NULL이 아닌 경우만 조회
select * from emp where mgr is not null;

--comm이 null인 경우는 0으로 출력, MGR은 NULL인 경우 100으로
select ename,job,sal,NVL(mgr,100),NVL(comm,0) from emp;

select sal,comm,sal+comm from emp; --comm이 null인 경우 sal+comm도 null
--위의 경우 sal+comm 이 경우 comm이 null이면 0으로 계산
select sal,comm,sal+NVL(comm,0) from emp;

--컬럼제목에 별칭 주기(alias)
select ename as "사원명",sal as "월급여" from emp;--생략없이 alias 지정하는 방법
select ename "사원명",sal  "월급여" from emp;--as 생략하고 alias 지정하는 방법
select ename 사원명,sal  월급여 from emp;--alias에 공백이 없는 경우는 ""도 생략 가능
select ename "사원 이름",sal "월 급여" from emp;--중간에 공백이 있는 경우 ""반드시 넣어야함

--총 레코드 갯수(데이터 갯수)
select count(*) from emp; --이 경우는 컬럼명이 count(*)
select count(*) count from emp; --이 경우는 컬럼명이 count
select count(*) 총갯수 from emp; --이 경우는 컬럼명이 총갯수

select sal,comm,sal+NVL(comm,0) sum from emp; --sal+NVL(comm,0)열의 컬럼명은 sum으로 변경
select sal 월급여,comm 커미션,sal+NVL(comm,0) 총금액 from emp;--컬럼명을 한글로
select sal 월급여,NVL(comm,5) 커미션,sal+NVL(comm,0) 총금액 from emp;
--문자열을 컬럼에 추가 시 || 연산자 사용
select '내이름은 '||ename||'입니다.' 자기소개 from emp; --자기소개가 빠지면'내이름은 '||ename||'입니다.' 이게 컬럼명이 됨
--내 직업은 salesman이고 내 월 급여는 1600입니다 라고 컬럼명 "자기소개"에 나오도록 작성
select '내 직업은 '||job||'이고 내 월 급여는 '||sal|| '입니다.' 자기소개 from emp;

--sal이 1500~2000이 아닌 경우만 조회
select * from emp where sal not between 1500 and 2000;

--not in을 사용하여 job이 salesman,clerk가 아닌 경우만 조회
select * from emp where job not in('SALESMAN', 'CLERK');

--GROUP 함수(COUNT,SUM,AVG,MAX,MIN)
select count(*) from emp;--전체 데이터 수 
select sum(sal) from emp;--sal의 총 합계
select avg(sal) from emp;--sal의 평균,소숫점 이하가 너무 많이 나옴
select round(avg(sal),2) from emp;--sal의 평균을 구하는데 소숫점 이하 2자리로 구함
select max(sal) from emp;--최고 급여액수
select min(sal) from emp;--최소 급여액수

--평균급여보다  sal이 더 높은 사람을 조회하시오(서브쿼리문)
--내가 함 select * from emp where sal in >=(select round(avg(sal),2) from emp);
select * from emp where sal >(select avg(sal) from emp);

--scott의 직업과 같은 직업을 가진 사람을 조회
select * from emp where job=(select job from emp where ename='SCOTT');

--SCOTT의 MGR과 같은 MGR을 가진 사람 조회
select * from emp where mgr=(select mgr from emp where ename='SCOTT');

--group by 
select job from emp group by job;--job이 그룹별로 나열

--job의 그룹별로 인원수를 구하자
select job,count(*) from emp group by job;

--제목에 별칭을 부여
select job 직업,count(*) 인원수 from emp group by job;

--job의 그룹별로 인원수를 구하보자(인원이 3명이상인 경우만 조회), 그룹함수 이용한 조건이면 having으로!
select job 직업,count(*) 인원수 from emp group by job having count(job)>=3;

--job의 그룹별로 인원수를 구하보자(인원이 3명이상인 경우만 조회)-인원순으로 조회(오름차순)
select job 직업,count(*) 인원수 from emp group by job having count(job)>=3 order by 인원수;--방법1
select job 직업,count(*) 인원수 from emp group by job having count(job)>=3 order by 2;--방법2

--직업별 인원수,최저연봉,최고연봉,평균연봉(소숫점이하없이)을 구하시오
select job 직업,count(*) 인원수,min(sal) 최저연봉, max(sal) 최고연봉, round(avg(sal),0) 평균연봉 
from emp group by job order by 직업;

--48p 숫자함수
select abs(-5),abs(5) from dual; --5 5 절대값 출력

--round:반올림, ceil:무조건 올림, floor:무조건 내림
select round(3.6,0),ceil(3.6),floor(3.6) from dual; --4 4 3
select round(3.4,0),ceil(3.4),floor(3.4) from dual; --3 4 3
select round(328947,-2) from dual;--328900 
select round(328467,-2) from dual;--328500

select round(avg(sal),0),ceil(avg(sal)),floor(avg(sal)) from emp;

--power(m,n):m의n승 값을 구함, mod(m,n):m을 n으로 나눈 나머지
select power(3,3), mod(10,3) from dual; --27 1

--문자함수 concat(두문자더하기), lower(소문자), upper(대문자), initcap(첫글자만대문자)
select ename,concat(ename,'님'),lower(ename),upper(ename),initcap(ename) from emp;

select lpad(sal,10,'*') from emp;--총 10자리에 남는 부분을 *로 채움(왼쪽부터 채움)
select rpad(sal,10,'*') from emp;--총 10자리에 남는 부분을 *로 채움(오른쪽부터 채움)

select substr('happy day',7,3) from dual;--7번 글자부터 3글자 추출
select substr('happy day',-6,3) from dual;--뒤에서부터 6번째글자부터 3글자 추출

--emp테이블의 ename에서 왼쪽에서 3글자 추출 후 총 7자리 중 우측 빈공간은 *로 채워서 출력
select rpad(substr(ename,1,3),7,'*'),sal from emp;

--length 길이구하기
select ename 이름,length(ename) 문자길이 from emp;

--replace -happy를 good으로 변경
select replace('HAPPY DAY','HAPPY','GOOD') from dual;

--trim: 앞뒤 공백제거
select '*'||'  lee su ji  '||'*' from dual;
select '*'||trim('  lee su ji  ')||'*' from dual;--앞뒤 공백제거됨

--현재 날짜를 나타내는 sysdate
select sysdate from dual;--현재 날짜
select sysdayte+7 from dual; --오늘부터 7일 뒤 날짜
select sysdate+1 from dual;--내일 날짜

--to_char 함수를 이용해서 원하는 날짜 모양으로 출력해보자
select to_char(sysdate,'yyyy-mm-dd') from dual;--2024-12-30
--mm:월, mi:분, hh:12시간표시 am또는pm:오전이나 오후 표시
select to_char(sysdate,'yyyy-mm-dd am hh:mi') from dual;--2024-12-30 오후04:41 
select to_char(sysdate,'yyyy-mm-dd hh24:mi') from dual;--2024-12-30 16:42

select to_char(sysdate,'month') from dual; --12월(지역화에 따라 다르게 나오므로 잘 사용안함)

--현재 년도 4자리만 추출
select to_char(sysdate, 'yyyy') from dual;
--현재 월도 추출
select to_char(sysdate, 'mm') from dual;
select to_char(to_date('2024-5-10'), 'mm') from dual;--05

--emp 의 hiredate 는 날짜타입이다
select to_char(hiredate,'yyyy-mm-dd') 입사일 from emp;

SELECT TO_CHAR(SYSDATE,'YYYY')||'년'||TO_CHAR(SYSDATE,'MM')||'월' FROM DUAL;

select to_char(hiredate,'yyyy년mm월') 입사일 from emp;--오류 발생
