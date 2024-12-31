--EQUI JOIN 또는 INNER JOIN : 두 테이블의 결합

--방법1, 컬럼명 앞에 테이블명이나 테이블별칭을 붙인다.
select 
    e.ename,e.job,e.sal,d.dname,d.loc
from emp e,dept d
where e.deptno=d.deptno;

--방법2, 조인 할 테이블에 컬럼명이 겹치지 않는 경우 테이블명이나 별칭을 붙이지 않아도 된다.
select 
    E.DEPTNO, ENAME,job,sal,dname,loc
from emp e,dept d
where e.deptno=d.deptno;

--DECODE 함수-다중IF문 같은 함수이다.
SELECT ENAME, DEPTNO,DECODE(DEPTNO,10,'홍보부',20,'교육부',30,'인사부') 부서명 FROM EMP;--DEPTNO가 10이면 홍보부...