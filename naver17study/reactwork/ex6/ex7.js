let array=['red','green','blue','pink'];
array.map((num,idx)=>(console.log(idx+":"+num)));
//blue 삭제 후 다시 출력
console.log("\n");
//2번 index만 제외하고 다시 배열에 담디
array=[...array.slice(0,2), /*red,green만 펼침 */
       ...array.slice(3,array.length)]; /*3부터 끝까지 펼침 */
array.map((num,idx)=>(console.log(idx+":"+num)));

let array2=['red','green','blue','pink'];
console.log("\n");
array2.map((num,idx)=>(console.log(idx+":"+num)));
//2번만 제외하고 배열에 담기
console.log("\n");
array2=array2.filter((item,i)=>i!==2);//1가 2가 아닌 것만 필터링(반환) ==은 dataType까지 비교
array2.map((num,idx)=>(console.log(idx+":"+num)));

console.log(Number('01'));//숫자로 변환