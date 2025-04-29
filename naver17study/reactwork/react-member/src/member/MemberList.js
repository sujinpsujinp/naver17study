import { DeleteForeverOutlined } from '@mui/icons-material';
import axios from 'axios';
import React, { useEffect, useState } from 'react';

//아이디 주소 가입일 삭제버튼/ userEntity  년월일 시분 
const MemberList = () => {
    const [MemberList,setMemberList]=useState([]);
    const [errorMsg,setErrorMsg]=useState(null);
    
    //출력
    // const list=()=>{
    //     axios.get("/auth/member/list")
    //     .then(res=>setMemberList(res.data));
    // }

    const getMemberData=()=>{
        axios({
            method:'get',
            url:'/auth/member/list',
            headers:{Authorization:`Bearer ${sessionStorage.token}`}       
        }).then(res=>{
            setMemberList(res.data);
        }).catch(error=>{
            //alert(error);if(error.contains("403"))
            setErrorMsg("403");
        });
    }

    //삭제 이벤트
    const deleteMember=(id)=>{
        let deleteurl="/member/memberDel?id="+id;
        let a=window.confirm("해당 멤버를 삭제할까요?");
        if(!a) return;

        axios.delete(deleteurl)
        .then(res=>getMemberData());//삭제 성공후 목록 다시 출력
    }

    //처음 로딩 시 list 호출
    useEffect(()=>{
        
        getMemberData();
    },[]);
    return (
        <div>
            {
                sessionStorage.token==null?
                <div>
                    <h1>먼저 로그인을 해주세요.</h1>
                </div>
                :
                errorMsg==='403'?
                <div>
                    <h1>관리자만 볼 수 있는 페이지입니다.</h1>
                </div>
                :
                <div >
            <h2 className='alert alert-danger'>전체 회원 명단</h2>
            
            <table className='table table-bordered' style={{width:'500px'}}>
                <thead>
                    <tr>
                        <th width="50">번호</th>
                        <th width="120">아이디</th>
                        <th width="100">권한</th>
                        <th width="150">가입일</th>
                        <th>삭제</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        MemberList &&
                        MemberList.map((row,idx)=>
                        <>
                        <tr key={idx}>
                            <td rowSpan={2}>{idx+1}</td>
                            <td>{row.username}</td>
                            <td>{row.role==="ROLE_MEMBER"?"일반사용자":"관리자"}</td>
                            <td>{row.gaipday}</td>
                            <td>
                                <DeleteForeverOutlined style={{color:'red',fontSize:'30px'}} 
                                onClick={()=>deleteMember(row.id)}/>
                            </td>
                        </tr>
                        <tr>
                            <td colSpan={5}>{row.address}</td>
                        </tr>
                        </>)
                    }
                </tbody>
            </table>
        </div>
            }
        </div>
    );
};

export default MemberList;