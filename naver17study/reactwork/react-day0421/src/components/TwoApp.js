//단축기 rsf
// import React from 'react';

// function TwoApp(props) {
//     return (
//         <div>
            
//         </div>
//     );
// }

// export default TwoApp;

//단축기 rsc
import React from 'react';
import "./mystyle.css";
import food1 from "../food/11.jpg";
import food2 from "../food/8.jpg";

const TwoApp = () => {
    let msg="Have a Nice Day!"; //출력은 가능하지만 태그내에서 수정은 불가능
    return (
        <div>
            <h2>TwoApp 컴포넌트</h2>
            <img alt="" src={food1} className='photo1'/>
            <img alt="" src={food2} className='photo2'/>
            <br/>
            <br/>
            {/*h5의 배경색, 글자색, 너비, 글꼴 모두 변경해보세요(style로) */}
            <h5 style={{fontFamily:'Playwrite AU SA',color:'olive',backgroundColor:'burlywood',width:'300px'}}>{msg}</h5>
        </div>
    );
};

export default TwoApp;