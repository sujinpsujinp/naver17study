import { Alert } from '@mui/material';
import axios from 'axios';
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const ShopForm = () => {
    const [sangpum,setSangpum]=useState('');
    const [color,setColor]=useState('#ccffcc');
    const [price,setPrice]=useState(0);
    const [sangguip,setSangguip]=useState('2025-01-01');
    const shoppath=process.env.REACT_APP_PHOTO_URL;
    const navi=useNavigate();
    //업로드한 사진을 저장하기위한 변수
    const [photo,setPhoto]=useState('');

    //등록 버튼 이벤트
    const addShopEvent=()=>{
        const addurl="/react/addshop";
        const shopdata={sangpum,color,price,sangguip,photo};
        axios.post(addurl,shopdata)
        .then(res=>{
            alert("상품 등록 성공!");
            navi("/fiveapp/list");
        }).catch(error=>console.log("insert 오류:"+error));

        
    }
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
    return (
        <div>
            <Alert severity='info' style={{margin:'15px',fontSize:'20px'}}>상품등록</Alert>
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
                                <input type='text' value={sangpum} onChange={(e)=>setSangpum(e.target.value)}/>
                            </td>
                        </tr>
                        <tr>
                            <th width="100">색상 </th>
                            <td> 
                                <input type='color' value={color} onChange={(e)=>setColor(e.target.value)}/>
                            </td>
                        </tr>
                        <tr>
                            <th width="100">가격 </th>
                            <td>
                                <input type='text' placeholder='상품가격' value={price}
                                onChange={(e)=>setPrice(e.target.value)}/>
                            </td>
                        </tr>
                        <tr>
                            <th width="100">구입일 </th>
                            <td> 
                                <input type='date' value={sangguip}
                                onChange={(e)=>setSangguip(e.target.value)}/>
                            </td>
                        </tr>
                        <tr>
                            <td colSpan={2} align='center'>
                                <button type='button' className='btn btn-sm btn-success'
                                onClick={addShopEvent}>등록</button>
                                &nbsp;
                                <button type='button' className='btn btn-sm btn-outline-success' 
                                onClick={()=>navi("/fiveapp/list")}>상품목록</button>
                                
                            </td>
                        </tr>
                    </tbody>
               </table>
        </div>
    );
};

export default ShopForm;