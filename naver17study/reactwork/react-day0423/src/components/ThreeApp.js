import { Alert } from '@mui/material';
import React, { useState } from 'react';
import "./mystyle.css";

/*
문제
1. mycarArray를 해당 자동차 이미자가 나오도록 출력 (class는 mycar 적용)
2. input 에 1~15를 입력 후 엔터를 누르면 해당 자동차 번호가 배열에 추가되록
   이미지 형태로 출력되도록 하기
   (단 1~15가 아닐 경우 "해당 자동차는 존재하지 않아요!" 출력)
3. 해당 자동차를 더블클릭하면 "해당 자동차를 삭제할까요?" 물어본 후 확인을 클릭하면 
   배열에서 삭제하기(filter 이용)
*/

const ThreeApp = () => {
    const [mycarArray,setMycarArray]=useState([1,5,10]);
    
    //엔터 누르면 배열에 추가
    const addNumber=(e)=>{
        const num=Number(e.target.value);
        if(e.key==='Enter'){
            if(num>=1 && num<=15){
            setMycarArray(mycarArray.concat(e.target.value));
            e.target.value="";
            }else alert("해당 자동차는 존재하지 않아요!");
        }
    }

    //더블 클릭 후 컨펌창 노출 후 삭제
    const deleteCar=(i)=>{
        if(window.confirm("해당 자동차를 삭제할까요?")){
            setMycarArray(mycarArray.filter((c,idx)=>idx!==i))
        }
    }
    return (
        <div style={{margin:'20px'}}>
            <Alert severity='success'>ThreeApp-배열 문제</Alert>
            <hr/>
            <h6>추가할 숫자를 입력하세요(1~15)</h6>
            <input type='text' className='form-control' placeholder='숫자를 입력하세요'
            autoFocus onKeyUp={addNumber}/>
            <hr/>
            <br/>
            <h6 >등록된 차량 수는 총 {mycarArray.length}대 </h6>
            {
                mycarArray.map((c,i)=>
                <>
                <img className='mycar' alt='' src={require(`../mycar/mycar${c}.png`)}
                    onDoubleClick={()=>deleteCar(i)}/>
                </>)
            }
        </div>
    );
};

export default ThreeApp;