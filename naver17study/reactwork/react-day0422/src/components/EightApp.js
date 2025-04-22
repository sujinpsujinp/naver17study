import { Alert } from '@mui/material';
import React from 'react';

const EightApp = () => {
    const names=['이효리','강호동','이영자','손나은','변우석'];
    //방법1
    //중괄호 쓰게되면 return 해줘야함
    const nameList=names.map((irum,idx)=><h5 key={idx}>{idx}:{irum}</h5>);



    return (
        <div>
            <h3 className='alert alert-success'>EightApp-map 반복문</h3>
            
            <h5>배열 변수 없이 1부터 10까지 반복</h5>
            {
                [...new Array(10)].map((a,idx)=><b>{idx+1}&nbsp;</b>)
                // Array(10).fill().map((_, i) => (
                //     <li key={i+1}>{i + 1}</li>
                //   ))
            }
            <hr/>
            <h5>mycar 폴더에 이미지를 넣고 mycar 1부터 15번까지 이미지 출력하기</h5>
            {
                [...new Array(15)].map((c,idx)=>(<img key={idx} alt='' src={require(`../mycar/mycar${idx+1}.png`)}  
                style={{width:'100px',height:'100px',margin:'5px',border:'1px solid black'}}/> )) 
            }
            <hr/>
            {nameList}

            {/*배열 반목문을 직접 넣는 방법 */}
            {
                names.map((irum,idx)=><Alert key={idx}
                    severity='secondary'>{idx}:{irum}
                    <img alt='' src={require(`../image/${idx+1}.jpg`)} style={{width:'100px'}}/>
                </Alert>)
            }

            

        </div>
    );
};

export default EightApp;