import React from 'react';
import { NavLink } from 'react-router-dom';
import "../components/mystyle.css";
const Menu = () => {
    return (
        <div>
            <ul className='menu'>
                <li>
                    <NavLink to={"/"}>Home</NavLink>
                </li>
                <li>
                    <NavLink to={"/oneapp"}>OneApp</NavLink>
                </li>
                <li>
                    <NavLink to={"/twoapp"}>TwoApp</NavLink>
                </li>
                <li>
                    <NavLink to={"/threeapp"}>ThreeApp</NavLink>
                </li>
                <li>
                    <NavLink to={"/fourapp"}>FourApp</NavLink>
                </li>
                <li>
                    <NavLink to={"/fiveapp"}>FiveApp</NavLink>
                </li>
                <li>
                    <NavLink to={"/sixapp"}>SixApp</NavLink>
                </li>
                <li>
                    <NavLink to={"/sevenapp"}>SevenApp</NavLink>
                </li>
                <li>
                    <NavLink to={"/eightapp"}>EightApp</NavLink>
                </li>
            </ul>
        </div>
    );
};

export default Menu;