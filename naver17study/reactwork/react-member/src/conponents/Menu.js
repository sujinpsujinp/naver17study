import React from 'react';
import { NavLink, useNavigate } from 'react-router-dom';
import "./mystyle.css";

const Menu = () => {
    const navi=useNavigate();
    return (
        <div>
            <ul className='menu'>
                <li>
                    <NavLink to={"/"}>Home</NavLink>
                </li>
                <li>
                    <NavLink to={"/member/join"}>회원가입</NavLink>
                </li>
                <li>
                    <NavLink to={"/board/list"}>회원게시판</NavLink>
                </li>
                <li>
                    <NavLink to={"/member/list"}>회원목록</NavLink>
                </li>
            </ul>
            {
                sessionStorage.token==null?
                <button type='button' className='btn btn-sm btn-success'
                onClick={()=>{navi("/member/login")}}>로그인</button>
                : 
                <button type='button' className='btn btn-sm btn-success'
                onClick={()=>{
                    sessionStorage.removeItem("token");
                    window.location.reload();//강제 새로고침
                }}>로그아웃</button>
             }
        </div>
    );
};

export default Menu;