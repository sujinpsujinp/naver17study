--12월 30일 오라클 문제
--1. 어떤 종류의 직업이 있는지 job을 한번씩만 출력하는데 직업의 오름차순으로 출력하시오
select job, count(job) from emp group by job;--내가 함
select distinct job from emp order by job;

--2. ename에 대소문자 상관없이 's'를 포함하고 있는데이터 출력(컬럼: ename,job,sal) 로어 어퍼
--select ename,job,sal from emp where ename like '%s%' or ename like '%S%';
select ename,job,sal from emp where lower(ename) like '%s%';--내가 함 upper로 하면 '%S%'로 해야함

--3. ename의 3번째 글자가 L인 사람을 조회하시오(컬럼:ename, sal, comm)
select ename,sal,comm from emp where ename like '__L%';

--4. comm이 null이 아닌 사람 중에 sal이 1500이상인 사람 출력(컬럼: ename, sal, comm)
select ename, sal, comm from emp where comm not like 'null' and sal>=1500;--내가 한 것
select ename, sal, comm from emp where comm is not null and sal>=1500; --강사님이 한 것

--5. hiredate 입사일이 5월인 사람은 모두 출력(컬럼: ename, hiredate,sal)
select ename,to_char(hiredate,'yyyy-mm-dd'),sal from emp where to_char(hiredate,'mm')=05;--도움받아서 내가 함
select ename,hiredate,sal from emp where to_char(hiredate,'mm')=5;--강사님이 해주심

--6. hiredate 입사일이 1985-01-01 이후에 입사한 사람 출력(컬럼: ename, hiredate,sal)
select ename,hiredate, sal from emp group by hiredate;-- having hiredate>='1985-01-01';--내가함
select ename, hiredate,sal from emp where hiredate>='1985-01-01';--강사님이 알려주신 것

--7. sal이 1500-3000 사이인 사람을 출력하는데 관계연산자와 and를 이용해서 출력
select * from emp where sal in(1500,3000);
select * from emp where sal>=1500 and sal<=3000;

--8. 7번 결과를 between을 이용해서 출력(컬럼:ename, sal, mgr)
select * from emp where sal between 1500 and 3000;

--9. in을 이용해서 job이 clerk,presidentm,manager 인 사람의 전체 컬럼을 모두 출력
select * from emp where job in('CLERK','PRESIDENT','MANAGER');

--10. ename, sal, comm,sal*comm을 출력하는데 comm이 null인 경우 1로 변경해서 출력하고 계산하기
select ename,sal,NVL(comm,1),sal*NVL(comm,1) from emp; 

--11. ename이 adams인 사람의 sal보다 더 많이 많는 사람출력(컬럼명:ename, job,sal)
select ename,job,sal from emp where sal>(select sal from emp where ename='ADAMS');

--12. 평균sal보다 작은 사람의 전체 컬럼 출력
select * from emp where sal<(select avg(sal) from emp);

--13. ename이 A나 S나 M으로 시작하는 모든 사람 출력(컬럼:ename, job,sal)
select ename,job,sal from emp where ename like'A%' or ename like'S%' or ename like'M%';
select ename,job,sal from emp where ename in ('A%','s%','M%');--오류 발생함 IN으로 할거면 정확한 값을 입력!

--14. mgr을 group로 인원수와 평균sal을 구하시오(평균sal은 무조건 올림으로)
select mgr,count(*),ceil(avg(sal)) from emp group by mgr;
select MGR,count(*) 인원수,round(avg(sal),-1) 평균급여 from emp where mgr is not null group by mgr; --1원단위는 반올림

--15. scott의 sal과 같은 sal을 받는 사람을 조회하시오(컬럼:ename,sal)
select ename,sal from emp where sal=(select sal from emp where ename='SCOTT');

--16. ename의 글자길이가 4글자인 사람만 조회(컬럼:ename,job)
select ename,job from emp where length(ename)=4;

--17.ename의 3번째 글자가 R이거나 A인 사람 조회(컬럼:ename,job)
select ename,job from emp where ename like '__R%' or ename like '__A%';

--18. job직업별로 인원수와 최고연봉을 출력하는데 직업의 오름차순으로 출력
select job,count(*),max(sal) from emp group by job order by job;

--19. || 연산자를 이용하여 다음과 같이 하나의 컬럼으로 출력하시오(EMP테이블로)
----    (예) SCOTT 의 직업은 CLERK 이며 입사년도는 1989년 05월입니다(컬럼명은 자기소개)
select ename||'의 직업은 '||job||'이며 입사년도는 '||hiredate|| '입니다.' 자기소개 from emp;--내가함
select ename||'의 직업은 '||job||'이며 입사년도는 '||to_char(hiredate,'YYYY')||'년'||to_char(hiredate,'mm')||'월 입니다.' 자기소개 from emp;

