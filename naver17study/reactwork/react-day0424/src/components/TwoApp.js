import { Alert } from '@mui/material';
import React, { useRef } from 'react';
import cate from '../data/CateData.json';
import './mystyle.css';
import errimg from '../image/noimage.jpeg';

const TwoApp = () => {
    const navData=cate.navData;
    const cateData=cate.categoryData;
    const mainPhotoRef=useRef(null);

    return (
        <div style={{margin:'15px'}}>
            <Alert severity='success' style={{fontSize:'20px'}}>
                TwoApp-json 데이터 출력</Alert>
            <div className='nav_container'>
              <ul className='nav_category'>
            {
                navData.map((item,i)=>
                <li key={i}>
                    <div>
                        <img alt='' src={item.img} className='imgcategory' 
                        onClick={(e)=>mainPhotoRef.current.src=e.target.src}/>
                    </div>
                    <div>{item.title}</div>
                </li>)
            }
              </ul>
            </div>

            <div className='nav_container'>
              <ul className='nav_category'>
            {
                cateData.map((item,i)=>
                <li key={i}>
                    <div>
                        <img alt='' src={item.img} className='imgcategory' 
                        onClick={(e)=>mainPhotoRef.current.src=e.target.src}/>
                    </div>
                    <div>{item.title}</div>
                </li>)
            }
              </ul>
            </div>

            {/**아이콘 클릭 시 작은 이미지를 가져와서 출력할 이미지 */}
            <div>
                <img alt='' src='' style={{width:'300px',height:'300px',border:'5px inset gray',
                    margin:'10px 300px'}} ref={mainPhotoRef}
                    onError={errimg}/>
            </div>
        </div>
    );
};

export default TwoApp;