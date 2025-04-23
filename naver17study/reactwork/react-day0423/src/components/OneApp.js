import { Alert } from '@mui/material';
import React from 'react';
import "./mystyle.css";

const OneApp = () => {
    let colors=["red","white","pink","orange","yellow",
        "tomato","gold","green"];

    let snoopydata=[
        {"photo":"s1.JPG","title":"영식이","addr":"강남구"},
        {"photo":"s3.JPG","title":"순자","addr":"제주도 서귀포시"},
        {"photo":"s4.JPG","title":"둥둥","addr":"경기 안양시"},
        {"photo":"s6.JPG","title":"뽀짝","addr":"부산 해운대구"}
    ]

    return (
        <div style={{margin:'20px'}}>
            <Alert severity='success'>OneApp-map 연습</Alert>
            {
                colors.map((color,idx)=>
                <div key={idx} style={{backgroundColor:color}}
                className='box'></div>)
            }
            <br style={{clear:'both'}}/><br/>
            <table className='table table-bordered' style={{width:'400px'}}>
                <thead>
                    <tr className='table-danger'>
                        <th>이름</th><th>사진</th><th>주소</th>
                    </tr>
                </thead>
                <tbody>
                    {
                     snoopydata.map((data,idx)=>
                    <tr key={idx}>
                        <td>{data.title}</td>
                        <td>
                            <img alt='' src={require(`../snoopy/${data.photo}`)}
                            style={{width:'50px'}}/>
                        </td>
                        <td>{data.addr}</td>
                    </tr>)
                    }
                </tbody>
            </table>

        </div>
    );
};

export default OneApp;