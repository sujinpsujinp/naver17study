import React, { useState } from 'react';
import photo1 from '../image2/3.jpg';
import photo2 from '../image2/9.jpg';
import photo3 from '../image2/12.jpg';
import photo4 from '../image2/19.jpg';
import photo5 from '../image2/16.jpg';

const ThreeApp = () => {
    const [show,setShow]=useState(false);
    const [photo, setPhoto]=useState(photo1);
    const [borderStyle,setBorderStyle]=useState('solid');
    const [imgWidth,setImgWidth]=useState(250);
    const [text,setText]=useState('리액트 문제 다 풀면 복습 100% 보장');

    //사진 크기 이벤트
    const decre=()=>{
        if(imgWidth>0)
            setImgWidth(imgWidth-5)
    }
    const incre=()=>{
        if(imgWidth<1000)
            setImgWidth(imgWidth+5)
    }
    return (
        <div>
            <h3 className='alert alert-success'>ThreeApp-이벤트 연습 2</h3>
            <h2 style={{fontFamily:'Nanum Pen Script',fontSize:'50px',color:'#f63030'}}>오늘의 문제</h2>
            <hr/>
            <label>
                <input type={'checkbox'} onClick={(e)=>setShow(e.target.checked)}/>
                &nbsp;&nbsp;<b>사진 숨김</b>
            </label>
            &nbsp;&nbsp;
            <button type='button' style={{color:'red',borderColor:'red'}}
            onClick={decre}>점점 작게</button>
            &nbsp;&nbsp;
            <button type='button' style={{color:'red',borderColor:'red'}}
            onClick={incre}>점점 크게</button>
            <br/><br/>
            <input type='text' placeholder='리액트 문제 다 풀면 복습 100% 보장'
            onChange={(e)=>setText(e.target.value)}/>
            <br/><br/>
           
           <div style={{float:'left'}}>
            <select className='form-select' style={{width:'150px'}}
                onChange={(e)=>setPhoto(e.target.value)}>
                <option value={photo1} selected>김영광</option> 
                <option value={photo2}>강동원</option> 
                <option value={photo3}>박보영</option> 
                <option value={photo4}>수지</option> 
                <option value={photo5}>공유</option>    
            </select> &nbsp;&nbsp;
            <br/> <br/>
            
            <select className='form-select' style={{width:'150px'}}
                onChange={(e)=>setBorderStyle(e.target.value)}>
                <option value='dashed'>dashed</option> 
                <option value='dotted'>dotted</option> 
                <option value='solid' selected>solid</option> 
                <option value='double'>double</option> 
                <option value='groove'>groove</option>    
            </select> &nbsp;&nbsp;
            </div>
            {
            !show &&
            <img alt='' src={photo} style={{width:`${imgWidth}px`,marginLeft:'20px',border:`10px ${borderStyle} blue`}}/>
            }
            <br/><br/>
            <h2 className='alert alert-info'>{text}</h2>
        </div>
    );
};

export default ThreeApp;