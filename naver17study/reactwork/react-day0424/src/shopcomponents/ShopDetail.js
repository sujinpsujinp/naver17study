import { Alert } from '@mui/material';
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

const ShopDetail = () => {
    const [selectData,setSelectData]=useState("");
    const photourl=process.env.REACT_APP_PHOTO_URL;
    const {num}=useParams();
    const navi=useNavigate();

    //num에 해당하는 데이터 가져오기
    const getSelectData=()=>{
      let geturl="/react/detail?num="+num;
      axios.get(geturl)
      .then(res=>setSelectData(res.data));
   }

   //상품삭제 함수
   const onDeleteEvent=(num)=>{
    let delurl="/react/shopdelete?num="+num;
    let a=window.confirm("보고계신 상품을 삭제할까요?");
    if(!a) return;

    axios.delete(delurl)
    .then(res=>navi("/fiveapp/list"));//목록으로 이동
}

    //처음 로딩 시 함수 호출
    useEffect(()=>getSelectData(),[]);

    return (
        <div>
            <Alert severity='info' style={{margin:'15px',fontSize:'20px'}}>상품상세</Alert>
            {
            selectData &&
               <table className='table table-bordered' style={{width:'400px'}}>
                    <tbody>
                        <tr>
                            <td align='center' colSpan={2}>
                            <img alt='' src={photourl+selectData.photo}/>
                            </td>
                        </tr>
                        <tr>
                            <th width="100">상품명 </th>
                            <td> {selectData.sangpum}</td>
                        </tr>
                        <tr>
                            <th width="100">색상 </th>
                            <td style={{backgroundColor:`${selectData.color}`}}> {selectData.color}</td>
                        </tr>
                        <tr>
                            <th width="100">가격 </th>
                            <td> {selectData.price}원</td>
                        </tr>
                        <tr>
                            <th width="100">구입일 </th>
                            <td> {selectData.sangguip}</td>
                        </tr>
                        <tr>
                            <th width="100">등록일 </th>
                            <td> {selectData.writeday}</td>
                        </tr>
                        <tr>
                            <td colSpan={2} align='center'>
                                <button type='button' className='btn btn-sm btn-outline-success'
                                onClick={()=>navi("/fiveapp/form")}>상품추가</button>
                                &nbsp;
                                <button type='button' className='btn btn-sm btn-outline-success' 
                                onClick={()=>navi("/fiveapp/list")}>상품목록</button>
                                &nbsp;
                                <button type='button' className='btn btn-sm btn-outline-success'>상품수정</button>
                                &nbsp;
                                <button type='button' className='btn btn-sm btn-danger'
                                onClick={()=>{onDeleteEvent(selectData.num)}}>상품삭제</button>
                            </td>
                        </tr>
                    </tbody>
               </table>
            }
        </div>
    );
};

export default ShopDetail;