import { Alert } from '@mui/material';
import React from 'react';
import posting from '../data/PostingData.json';

const ThreeApp = () => {
    const deal=posting.deal;

    return (
        <div style={{margin:'15px'}}>
            <Alert severity='success' style={{fontSize:'20px'}}>
                ThreeApp-json 데이터 출력</Alert>
            <div className='maindiv'>
                <h5><b>오늘의 딜</b></h5>
                {
                    deal.map((item,i)=>
                    <div key={i} className='photodiv'>
                        <img alt='' src={item.img} className='photo'/>
                        <br/>
                        <div style={{color:'gray',fontSize:'14px'}}>{item.company}</div>
                        <div style={{color:'gray',fontSize:'16px'}}>
                            [오늘의 딜]{item.title}</div>
                        <span style={{color:'#00ffff'}}>{item.sale}</span>
                        <span style={{marginLeft:'5px'}}>{item.price}</span>
                    </div>
                    )
                }
            </div>
        </div>
    );
};

export default ThreeApp;