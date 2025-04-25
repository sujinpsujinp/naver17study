import React from 'react';
import Menu from '../components/Menu';
import { Route, Routes } from 'react-router-dom';
//import Home from '../pages/Home';
//import About from '../pages/About';
//import Food from '../pages/Food';
import { About, Food, Home } from '../pages'; //index.js에서 export해주면 이렇게 from 이 pages로 나옴
import erroimg from '../image/14.jpg';

const RouterMain = () => {
    return (
        <div>
            <Menu/>
            <hr style={{clear:'both'}}/>
            <Routes>
                <Route path='/' element={<Home/>}/>
                <Route path='/home/*' element={<Home/>}/>
                {/* <Route path='/about' element={<About/>}/> */}
                
                <Route path='/about' element={<About/>}>
                    <Route path=':emp' element={<About/>}/>
                </Route>
                
                {/* <Route path='/food' element={<Food/>}/> */}
                <Route path='/food' element={<Food/>}>
                    <Route path=':food1' element={<Food/>}/>
                    <Route path=':food1/:food2' element={<Food/>}/> 
                </Route>
                
                {/**이렇게 여러페이지를 넣어도 됨 - 부모태그만 하나면 문제되지 안흥 */}
                <Route path='/login/*' element={
                    <div>
                        <h2> 로그인 페이지는 작업중입니다.</h2>
                        <About/>
                        <Food/>
                    </div>
                }/>

                {/**그 이외의 모든 매핑주소일 경우 호출 */}
                <Route path='*' element={
                    <div>
                        <h1>잘못된 URL 입니다.</h1>
                        <img alt='' src={erroimg} style={{width:'200px'}}/>
                    </div>
                }/>
            </Routes>
        </div>
    );
};

export default RouterMain;