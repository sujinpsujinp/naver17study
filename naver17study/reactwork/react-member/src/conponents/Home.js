import React from 'react';
import homeimg from "../image/18.jpg";
import { Alert } from '@mui/material';
const Home = () => {
    return (
        <div align="center" style={{margin:'15px'}}>
            <Alert severity='success' style={{fontSize:'25px'}}>
            홈페이지 방문을 환영합니다.</Alert>
            <img alt='' src={homeimg} style={{border:'3px solid lightgray',width:'500px',margin:'15px'}}/>
        </div>
    );
};

export default Home;