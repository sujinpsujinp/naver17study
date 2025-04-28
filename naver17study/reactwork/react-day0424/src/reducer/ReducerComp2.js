import React, { useReducer, useState } from 'react';
import Student from './Student';

//reducer 설정 시 초기값으로 미리 지정
const initialState={
    count:1,
    student:[
        {
            id:new Date(),
            name:'이영자',
            isHere:false
        }
    ]
}

const reducer=(state,action)=>{
    console.log(state,action);

    switch(action.type){
        case 'add-student':
            const name=action.payload.name;
            //추가할 학생정보
            const addStudent={
                id:new Date(),
                //name:name 같을 경우에는 한번만 써도 돼
                name,
                isHere:false
            }
            const data={
                count:state.count+1,
                student:[
                    ...state.student,
                    addStudent
                ]
            }
            return data;
        case 'delete-student':
            return{
                count:state.count-1,//인원수 1 줄이기
                //payload를 통해서 전달된 id를 찾아서 filter로 제거
                student :state.student.filter(s=>s.id!==action.payload.id)
            };
        case 'mark-student':
            //mark-student 액션이 발생하면 해당 id와 같은 학생을 찾아서
            //idHere 만 반대로 값을 수정해준다
            return{
                count:state.count,
                student:state.student.map(s=>{
                    if(s.id===action.payload.id){
                        return{...s,isHere:!s.isHere}//isHere를 반대로 (true는 false로 false는 true로)
                    }
                    return s;
                })
            }
        default:
            return state;
    }
}

const ReducerComp2 = () => {
    const [name,setName]=useState('');
    const [studentInfo,dispatch]=useReducer(reducer,initialState);

    return (
        <div>
            <h5>useReducer 예제 #2</h5>
            <h2 className='alert alert-success'>학생관리 Reducer</h2>
            <div className='input-group' style={{width:'200px',marginLeft:'15px'}}>
                <input type='text' className='form-control'
                value={name} onChange={(e)=>setName(e.target.value)}/>

                &nbsp;&nbsp;
                <button type='button' className='btn btn-sm btn-info'
                onClick={()=>{
                    dispatch({'type':'add-student',payload:{name}});
                }}>추가</button>
                <br/><br/>
                {
                    studentInfo.student.map((stu,idx)=>(
                    <Student key={idx} stu={stu}
                    dispatch={dispatch}/>))
                }
            </div>
        </div>
    );
};

export default ReducerComp2;