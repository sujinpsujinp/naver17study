import React from 'react';
import { Route, Routes } from 'react-router-dom';
import Menu from '../conponents/Menu';
import Home from '../conponents/Home';
import { JoinForm, LoginForm, MemberList } from '../member';
import { BoardDetail, BoardForm, BoardList, UpdateForm } from '../board';


const RouterMain = () => {
    return (
        <div>
            <Menu/>
            <br style={{clear:'both'}}/>
            <div style={{margin:'15px',width:'500px'}}>
            <Routes>
                <Route path="/" element={<Home/>}/>
                
                <Route path="/member" >
                    <Route path='list' element={<MemberList/>}/>
                    <Route path='join' element={<JoinForm/>}/>
                    <Route path='login' element={<LoginForm/>}/>
                </Route>

                <Route path="/board" >
                    <Route path='list' element={<BoardList/>}/>
                    <Route path='form' element={<BoardForm/>}/>
                    <Route path='detail' element={<BoardDetail/>}/>
                    <Route path='updateform' element={<UpdateForm/>}/>
                </Route>
            </Routes>
            </div>
        </div>
    );
};

export default RouterMain;