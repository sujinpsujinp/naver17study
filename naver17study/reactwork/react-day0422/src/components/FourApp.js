import { Add, AddToPhotos, Delete } from '@mui/icons-material';
import React from 'react';
import styled from 'styled-components';
/*
https://styled-components.com/docs/basics#getting-started

# with npm
npm install styled-components

# with yarn
yarn add styled-components

설명
styled-components태그가 지정된 템플릿 리터럴(백틱)을 활용하여 구성 요소의 스타일을 지정합니다.
*/
const FourApp = () => {
    const Title=styled.h2`
        color:orange;
        font-size:1.5em;
        background-color:yellow;
        width:300px;
        text-align:center;
    `;
    const MyButton=styled.button`
        color:blue;
        background-color:orange;
        border:5px inset green;
        width:130px;
    `;
    const TomatoButton=styled(MyButton)`
        color:tomato;
        border-color:tomato;
    `;
    return (
        <div>
            <h3 className='alert alert-success'>FourApp-styled로 디자인 변경하기</h3>
            <Title>Hello React!</Title>
            <Title>하이하이</Title>

            <button type='button'>기본 버튼 모양</button>
            <br/>
            <MyButton>MyButton 모양</MyButton>
            <br/>
            <TomatoButton>토마토버튼</TomatoButton>
            <h5>Material Icons</h5>
            <AddToPhotos style={{color:'red',fontSize:'20px'}}/>
            <Delete/>
        </div>
        
    );
};

export default FourApp;