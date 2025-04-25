import React from 'react';
import homeimg from '../image/8.jpg';

const Home = () => {
    return (
        <div align="center">
            <h3>Home 입니다.</h3>
            <img alt='' src={homeimg} style={{border:'3px dotted lightgray'}}/>
        </div>
    );
};

export default Home;