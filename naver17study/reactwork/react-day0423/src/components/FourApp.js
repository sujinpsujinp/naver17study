import { Alert, Button } from '@mui/material';
import React, { useRef, useState } from 'react';
/*
리액트(React)에서 **랜더링(Rendering)**이란,
컴포넌트가 **화면(UI)**에 표시되도록 React가
컴포넌트의 내용을 계산해서 실제 DOM또는 가상 DOM에 반영하는 과정
*/
const FourApp = () => {
    const [count,setCount]=useState(1);//변경될때마다 랜더링 됨
    const numberRef=useRef(1);//변경이 되어도 랜더링 발생하지 않음

    /*
    textarea처럼 한번에 많은 글자를 입력해야하는 경우
    한글자 입력시마다 랜더링될 경우 문제가 발생하기도 한다
    그럴 경우에는 ref 변수에 저장 후 나중에 한번에 출력하면 된다
    */

    const countIncreEvent=()=>{
        setCount(count+1);
        console.log("count 변수값 증가: "+count);
    }

    const numberIncreEvent=()=>{
        numberRef.current=numberRef.current+1;
        console.log("numberRef 증가: "+numberRef.current);
    }
    return (
        <div style={{margin:'20px'}}>
            <Alert severity='success'>FourApp-state변수와 ref 변수의 차이점</Alert>

            <Button variant='contained' color='secondary'
            onClick={countIncreEvent}>count변수 증가</Button>
            <b style={{fontSize:'3em',marginLeft:'20px'}}>{count}</b>
            <br/><br/>
            <Button variant='contained' color='info'
            onClick={numberIncreEvent}>numberRef변수 증가</Button>
            <b style={{fontSize:'3em',marginLeft:'20px'}}>{numberRef.current}</b>
        </div>
    );
};

export default FourApp;