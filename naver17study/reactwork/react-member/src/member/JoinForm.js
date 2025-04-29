import axios from 'axios';
import React, { useState } from 'react';
import DaumPostcodeEmbed from 'react-daum-postcode';

const JoinForm = () => {
    const [username,setUsername]=useState('');
    const [password,setPassword]=useState('');
    const [address,setAddress]=useState('');
    const [openPostCode,setOpenPostcode]=useState(false);   
    const [role,setRole]=useState('ROLE_MEMBER');
    const [idcheck,setIdCheck]=useState(false);//true 일때만 가입가능

    //회원가입 이벤트
    const onSubmit=(e)=>{
      e.preventDefault();//초기화
      if(!idcheck){
        alert("아이디 중복체크를 해주세요.");
        return;
      }
    }
    //중복 체크 버튼 이벤트
    const btnIdCheck=()=>{
      let url="/member/idcheck?username="+username;
      axios.get(url)
      .then(res=>{
        if(res.data==='fail'){
          setUsername('');
          setIdCheck(false);
          alert("이미 존재하는 아이디입니다.");
        }else{
          setIdCheck(true);
          alert("가입 가능한 아이디입니다.");
        }
      })
    }

    //카카오 주소에 대한 이벤트 들
    const handle={
      clickButton:()=>{
        setOpenPostcode(current=>!current);
      },
      //주소 선택 시 
      selectAddress: (data)=>{
        console.log(data);//나오는 정보로 사용하면 됨

        setAddress(`(${data.zonecode})${data.address}`);
        
        setOpenPostcode(false);
      }
    }

    return (
        <div>
          <h2 className='alert alert-danger'>회원 가입</h2>
          <form onSubmit={onSubmit}>
            <table className='table table-bordered'>
              <tbody>
                <tr>
                  <th className='table-info'>아이디</th>
                  <td className='input-group'>
                    <input type='text' value={username}
                    onChange={(e)=>{
                      setIdCheck(false);
                      setUsername(e.target.value);
                    }}
                    required className='form-control'/>

                    &nbsp;
                    <button type='button' className='btn btn-sm btn-danger'
                    onClick={btnIdCheck}>중복체크</button>
                  </td>
                </tr>
                <tr>
                  <th className='table-info'>비밀번호</th>
                  <td>
                    <input type='text' value={password}
                    onChange={(e)=>setPassword(e.target.value)}
                    required className='form-control'/>
                  </td>
                </tr>
                <tr>
                  <th className='table-info'>주소</th>
                  <td className='input-group'>
                    <input type='text' value={address}
                    onChange={(e)=>setAddress(e.target.value)}
                    required className='form-control'/>
                    &nbsp;
                    <button type='button' className='btn btn-sm btn-danger'
                    onClick={handle.clickButton}>주소검색</button>
                    <br/>
                    {
                      openPostCode &&
                      <DaumPostcodeEmbed
                        onComplete={handle.selectAddress}
                        autoClose={false}
                        defaultQuery='강남대로 94길 20'/>
                    }
                  </td>
                </tr>
                <tr>
                  <th className='table-info'>가입권한</th>
                  <td>
                    <select className='form-select'>
                      <option value={'ROLE_MEMBER'}>일반멤버</option>
                      <option value={'ROLE_ADMIN'}>관리자</option>
                    </select>
                  </td>
                </tr>
                <tr>
                  <td colSpan={2} align='center'>
                    <button type='submit' className='btn btn-success'>회원가입</button>
                  </td>
                </tr>
              </tbody>
            </table>
          </form>
        </div>
    );
};

export default JoinForm;