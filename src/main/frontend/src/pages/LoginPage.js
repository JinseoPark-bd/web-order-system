import React, { useEffect, useState } from "react";
import axios from 'axios';
import logo from '../images/oms_logo.png';
import { useCookies } from "react-cookie";

const LoginPage = () => {
  const [userId, setUserId] = useState("")
  const [userPw, setUserPw] = useState("")
  const [error, setError] = useState(null)
  //const [checked, setChecked] = useState(false)
  const [showPassword, setShowPassword] = useState(false)
  const [isRemember, setIsRemember] = useState(false)
  const [cookies, setCookie,removeCookie] = useCookies(["rememberUserId"])

  const loginSubmit = async (e) => {
    e.preventDefault()
    setError("")
    alert("You are Signed In")
    try {
        await axios.post('http://localhost:8080/api/login', { userId, userPw })
    } catch(e) {
        if(e.res.message) {
            setError(e.res.message)
        }
    }   
  }

  const toggleShowPassword = () => {
    setShowPassword(!showPassword)
  }

  useEffect(() => {
    if(cookies.rememberUserId !== undefined) {
      setUserId(cookies.rememberUserId);
      setIsRemember(true);
    }
  }, [cookies.rememberUserId]);

  const handleRemember = (e) => {
    setIsRemember(e.target.checked);
    if(e.target.checked) {
      //쿠키에 userId값 저장, 유효기간 2000초
      setCookie("rememberUserId", userId, {maxAge: 2000});
    } else {
      //체크 안되어 있으면 쿠키 삭제
      removeCookie("rememberUserId");
    }
  };

  return (
    <div className="h-screen w-screen bg-[url('./images/login-bg.jpg')] bg-cover">
      <div className="login-wrap">
        <div className="login form absolute top-1/3 left-1/2 transform -translate-x-1/2 -translate-y-1/2">
          <div className="mt-20 flex flex-col items-center">
          <img src={logo} alt="title_logo" className="w-80 h-40"/>
          </div>
          {error ?(<div>{error}</div>):('')}
          <form className="max-w-sm mx-auto w-full items-center" onSubmit={loginSubmit}>
            <div className="flex flex-col pt-10">
              <label htmlFor="userId" className="text-white ">ID</label>
              <input type="text"  className="border-none mb-3 rounded-sm h-12 w-100" onChange={e => setUserId(e.target.value)} value={userId}/>
              <label htmlFor="userPw" className="text-white">Password</label>
              <div className="relative">
                <input type={showPassword ? "text" : "password"}  className="border-none pr-48 rounded-sm h-12 w-100" onChange={e => setUserPw(e.target.value)} value={userPw}/>
                <button type="button" className="absolute inset-y-0 right-0 pr-2 flex items-center" onClick={toggleShowPassword}> {showPassword ? <i className="fas fa-eye-slash fa-2x"></i> : <i className="fas fa-eye fa-2x"></i>} </button>
              </div>
              <div className="saveId mt-2">
                <input type="checkbox" className="saveId-cb" id="saveId" onChange={ (e) => {handleRemember(e);}} checked={isRemember}/>{" "}
                <label className="text-white">아이디 저장하기</label>
              </div>
              <button type="submit" className="text-lg leading-4 font-medium bg-blue-500 hover:bg-sky-700 h-12 mt-20 text-white rounded-sm" onClick={loginSubmit}>로그인</button>
            </div>
          </form>
        </div>
        <div className=""></div>
      </div>
    </div>
  );

}

export default LoginPage;
