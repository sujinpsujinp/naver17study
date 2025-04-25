import React from 'react';
import Menu from './Menu';
import { Route, Routes } from 'react-router-dom';
import { EightApp, FiveApp, FourApp, Home, OneApp, SevenApp, SixApp, ThreeApp, TwoApp } from '../components';


const RouterMain = () => {
    return (
        <div>
            <Menu/>
            <hr style={{clear:'both'}}/>
            <Routes>
            <Route path='/' element={<Home/>}/>
            <Route path='/oneapp' element={<OneApp/>}/>
            <Route path='/twoapp' element={<TwoApp/>}/>
            <Route path='/threeapp' element={<ThreeApp/>}/>
            <Route path='/fourapp' element={<FourApp/>}/>
            <Route path='/fiveapp/*' element={<FiveApp/>}/>
            <Route path='/sixapp' element={<SixApp/>}/>
            <Route path='/sevenapp' element={<SevenApp/>}/>
            <Route path='/eightapp' element={<EightApp/>}/>
            </Routes>
        </div>
    );
};

export default RouterMain;