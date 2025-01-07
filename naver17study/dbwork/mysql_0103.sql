select * from person;
-- 테이블 구조 변경
-- 1. 컬럼 추가 hp
alter table person add hp varchar(20);
-- 2. today 컬럼 제거
alter table person drop column today;
desc person; -- 구조 확인
-- 3. 타입 변경 name을 바이트 20에서 30으로 변경
alter table person modify name varchar(30);
-- 4. writeday를 today로 수정
alter table person rename column writeday to today;

-- 5. hp에 데이터 넣기
update person set hp='010-1354-5461' where num=7;

-- join 연습용 테이블 생성하기
-- 부모테이블 person으로 하고 person num을 외부키로 갖는 stu 생성
create table stu (
	idx tinyint auto_increment primary key,
    num smallint,
    kor smallint default 0,
    eng smallint default 0,
    sum smallint,
    constraint fk_stu_num foreign key (num) references person(num) 
    on delete cascade);
    -- person 데이터 삭제 시 stu에 추가된 데이터는 자동으로 지워짐
    
update person set hp="010-2144-4562" where name='이영자';


    
    
    
    