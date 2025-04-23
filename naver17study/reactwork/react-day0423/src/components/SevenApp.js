import { Alert } from '@mui/material';
import React, { useState } from 'react';

const SevenApp = () => {
    const [starArray,setStarArray]=useState([
        {
            starName:'김우빈',
            starAge:'34세',
            starPhoto:'2.jpg',
            starAddr:'서울시 강남구',
            starPhone:'010-2222-3333'
        },
        {
            starName:'김영광',
            starAge:'37세',
            starPhoto:'3.jpg',
            starAddr:'서울시 금천구',
            starPhone:'010-7777-8888'
        },
        {
            starName:'박보영',
            starAge:'33세',
            starPhoto:'12.jpg',
            starAddr:'서울시 용산구',
            starPhone:'010-4534-4856'
        },
        {
            starName:'신민아',
            starAge:'40세',
            starPhoto:'17.jpg',
            starAddr:'서울시 강남구',
            starPhone:'010-4856-8795'
        },
        {
            starName:'수지',
            starAge:'36세',
            starPhoto:'19.jpg',
            starAddr:'경기도 수원시',
            starPhone:'010-7954-4896'
        },
    ]);
    return (
        <div style={{margin:'20px'}}>
            <Alert severity='success'>SevenApp-배열 데이터 출력</Alert>
            <table className='table table-bordered' style={{width:'400px'}}>
                <tbody>
                    {   
                        starArray.map((row,idx)=>
                        <>
                            <tr>
                                <td rowSpan={4}>
                                    <img alt='' src={require(`../star/${row.starPhoto}`)} style={{width:'150px'}}/>
                                </td>
                                <td>이름 : {row.starName}</td>
                            </tr>
                            <tr>
                                <td>나이 : {row.starAge}</td>
                            </tr>
                            <tr>
                                <td>주소 : {row.starAddr}</td>
                            </tr>
                            <tr>
                                <td>핸드폰 : {row.starPhone}</td>            
                            </tr>
                        </>
                        )
                    }
                </tbody>
            </table>
        </div>
    );
};

export default SevenApp;