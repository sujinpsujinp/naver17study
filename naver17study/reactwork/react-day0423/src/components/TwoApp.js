import { DeleteForeverOutlined } from '@mui/icons-material';
import { Alert } from '@mui/material';
import React, { useState } from 'react';

const TwoApp = () => {
    const [msg,setMsg]=useState(["안녕하세요","배트캠프","Happy Day!"]);
    
    //메세지 입력 후 엔터 누르면 배열에 추가 concat (원래 배열 추가는 push)
    const addMessageEvent=(e)=>{
        if(e.key==='Enter'){
            //alert(e.target.value,e.key);
            
            //리액트에서는 배열에 추가 시 push가 아닌 concat으로 추가한다
            setMsg(msg.concat(e.target.value));
            e.target.value="";
        }
    }

    //삭제
    const deleteMessage=(i)=>{
        //배열 데이터를 삭제하는 방법
        //1. slice 를 이용한 방법
        // setMsg(
        //     [...msg.slice(0,i),
        //     ...msg.slice(i+1,msg.length)
        //     ]
        // )

        //2. filter를 이용한 방법 : idx가 i랑 같이 않은 것만 거르겠다
        //i번지만 빼고 배열로 리턴
        setMsg(msg.filter((m,idx)=>idx!==i))
    }
    return (
        <div style={{margin:'20px',width:'600px'}}>
            <Alert severity='success'>TwoApp-배열에 추가, 삭제 연습</Alert>
            <h6>추가할 메세지를 입력해주세요</h6>
            <input type='text' className='form-control'
            placeholder='input message' autoFocus
            onKeyUp={addMessageEvent}/>
            <br/>
            <h6 style={{backgroundColor:'orange'}}>msg 배열 데이터 (총 {msg.length}개)</h6>
            {
                msg.map((m,i)=>
                    <h5 key={i}>
                        {i+1} : {m}
                    
                        <DeleteForeverOutlined style={{float:'right',cursor:'pointer',color:'red'}}
                        onClick={()=>deleteMessage(i)}/>
                    </h5>)
            }
        </div>
    );
};

export default TwoApp;