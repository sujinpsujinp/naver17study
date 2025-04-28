import { Alert } from '@mui/material';
import React from 'react';
import { NavLink, Route, Routes, useNavigate } from 'react-router-dom';
import { ShopDetail, ShopForm, ShopList } from '../shopcomponents';
import UpdateForm from '../shopcomponents/UpdateForm';

const FiveApp = () => {
    const navi=useNavigate();
    return (
        <div>
            <Alert severity='success' style={{margin:'15px',fontSize:'20px'}}>FiveApp-Shop 라우터 설정</Alert>
            <div style={{margin:'20px'}}>
                {/* <NavLink to={"/fiveapp/list"}>Shop 목록</NavLink>
                &nbsp;&nbsp;
                <NavLink to={"/fiveapp/form"}>Shop 추가</NavLink> */}
                <button type='button' className='btn btn-sm btn-outline-secondary'
                onClick={()=>navi("/fiveapp/list")}>Shop 목록</button>
                &nbsp;&nbsp;
                <button type='button' className='btn btn-sm btn-outline-secondary'
                onClick={()=>navi("/fiveapp/form")}>Shop 추가</button>
                <br/><br/>
                <Routes>
                    <Route path='/' element={<ShopList/>}/>
                    <Route path='list' element={<ShopList/>}/>
                    <Route path='form' element={<ShopForm/>}/>
                    <Route path='detail/:num' element={<ShopDetail/>}/>
                    <Route path='updateform/:num' element={<UpdateForm/>}/>
                </Routes>
            </div>
        </div>
    );
};

export default FiveApp;