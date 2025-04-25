import { Alert } from '@mui/material';
import React, { useEffect, useState } from 'react';
import FourWriteShop from './FourWriteShop';
import axios  from 'axios';
import FourRowItem from './FourRowItem';
/**
axios 는 현재 커뮤니티에서 가장 많이 사용하는 http 통신 라이브러리이다
형식
axios.get('uri주소').then().catch();
axios.post('uri주소').then().catch();
또는
axios({
    method:'get',
    url:'url주소',
    .....
})
 */
const FourApp = () => {
    const [shoplist,setShopList]=useState([]);

    //추가하는 함수
    //const addurl="http://localhost:8090/react/addshop";
    const addurl="/react/addshop";//package.json 에서 proxy 설정을 한 경우

    const addShopEvent=(shopdata)=>{
        console.log(shopdata);
        axios.post(addurl,shopdata)
        .then(res=>{
            //alert(res);
        }).catch(error=>console.log("inser 오류:"+error));
        
    }

    //db에서 데이터를 가져오는 함수
    const list= ()=>{
        axios.get("/react/shoplist")
        .then(res=>setShopList(res.data));
    }

    //삭제 함수
    const onDelete=(num)=>{
        let deleteurl="/react/shopdelete?num="+num;
        axios.delete(deleteurl)
        .then(res=>list());//삭제 성공 후 목록 다시 출력
    }

    //처음 시작 시작 시 딱 한번만 list 호출하기
    useEffect(()=>{
        list();
    },[]);
    
    return (
        <div style={{margin:'15px'}}>
            <Alert severity='success' style={{fontSize:'20px'}}>
                FourApp-axios 통신(jpa shop db)</Alert>
            <FourWriteShop onSave={addShopEvent}/>
            <hr/>
            <h5>총 {shoplist.length} 개의 상품이 있습니다.</h5>
            <table className='table table-bordered' style={{width:'500px'}}> 
                <tbody>
                {
                    //비동기 통신 특성상 약간의 시간을 두고 불러와지는 경우
                    //가끔 오류가 발생하는 현상이 나온다
                    shoplist
                    &&
                    shoplist.map((row,idx)=><FourRowItem key={idx} row={row} onDelete={onDelete}/>)
                }
                </tbody>
            </table>
        </div>
    );
};

export default FourApp;