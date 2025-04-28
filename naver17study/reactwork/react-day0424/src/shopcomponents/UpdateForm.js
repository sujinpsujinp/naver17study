import { NumbersOutlined } from '@mui/icons-material';
import { Alert, Button } from '@mui/material';
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

const UpdateForm = () => {
    const [shopdata,setShopData]=useState('');
    const {num}=useParams();
    
    const shoppath=process.env.REACT_APP_PHOTO_URL;
    const navi=useNavigate();
    //업로드한 사진을 저장하기위한 변수
    const [photo,setPhoto]=useState('');

    //사진업로드 이벤트
    const photoUploadEvent=(e)=>{
        const imgFile=new FormData();
        const uploadFile=e.target.files[0];
        imgFile.append("upload",uploadFile);

        axios({
            method:'post',
            url:'/react/upload',
            data:imgFile
        }).then(res=>setPhoto(res.data));
    }

    //처음 시작 시 스프링으로부터 데이터 가져오기
    const getSelectData=()=>{
        let url="/react/detail?num="+num;
        axios.get(url)
        .then(res=>{
            setShopData(res.data);
            setPhoto(res.data.photo);
        })
    }

    useEffect(()=>{
        getSelectData();
    },[]);//처음 시작 시 한번만 호출

    //입력 시 호출
    const shopDataChange=(e)=>{
        const {name,value}=e.target;
        setShopData({
            ...shopdata,
            [name]:value
        })
    }

    //submit 발생 시 호출
    const onSubmit=(e)=>{
        e.preventDefault();//기본 이벤트 무효화(action 호출)

        //수정
        axios.post("/react/shopupdate",shopdata)
        .then(res=>{
            //성공 후 상세보기 페이지로 이동
            navi(`/fiveapp/detail/${num}`);
        }); 
    }
    return (
        <div>
            <Alert severity='info' style={{margin:'15px',fontSize:'20px'}}>상품수정</Alert>
            <form onSubmit={onSubmit}>
            <table className='table table-bordered' style={{width:'400px'}}>
                    <tbody>
                        <tr>
                            <td align='center' colSpan={2}>
                            <img alt=''  src={shoppath+photo} style={{width:'120px'}}/>
                            </td>
                        </tr>
                        <tr>
                            <th width="100">사진 </th>
                            <td> 
                            <input type='file' onChange={photoUploadEvent}/>
                            </td>
                        </tr>
                        <tr>
                            <th width="100">상품명 </th>
                            <td> 
                                <input type='text' value={shopdata.sangpum} className='form-control' name='sangpum' onChange={shopDataChange}/>
                            </td>
                        </tr>
                        <tr>
                            <th width="100">색상 </th>
                            <td> 
                                <input type='color' value={shopdata.color} className='form-control' name='color' onChange={shopDataChange}/>
                            </td>
                        </tr>
                        <tr>
                            <th width="100">가격 </th>
                            <td>
                                <input type='text' value={shopdata.price} className='form-control' name='price'
                                onChange={shopDataChange}/>
                            </td>
                        </tr>
                        <tr>
                            <th width="100">구입일 </th>
                            <td> 
                                <input type='date' value={shopdata.sangguip} className='form-control' name='sangguip'
                                onChange={shopDataChange}/>
                            </td>
                        </tr>
                        <tr>
                            <td colSpan={2} align='center'>
                                <Button type='submit' color='success' variant='contained'
                                style={{margin:'10px 160px', width:'100px'}}>상품수정</Button>
                            </td>
                        </tr>
                    </tbody>
               </table>
               </form>
        </div>
    );
};

export default UpdateForm;