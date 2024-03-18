import React from 'react'

export default function Longin() {
    return (
    <div className="page">
        {/* Title */}
        <div className="titleWrap">
            아이디와 비밀번호를<br/> 입력하세요
        </div>

        {/* 이메일 입력 */}
        <div className="contentWrap">
            <div className="inputTitle">
                아이디
            </div>
            <div className="inputWrap">
                <input></input>
            </div>
        </div>

        {/* error 메세지 */}
        <div className="errorMessageWrap">
            <div>올바른 이메일 주소를 입력해주세요</div>
        </div>

        <div className="contentWrap">
            <div className="inputTitle">
                비밀번호
            </div>
            <div className="inputWrap">
                <input></input>
            </div>
        </div>

        <div className="errorMessageWrap">
            <div> 영문, 숫자, 특수문자 포함 8자 이상 입력해주세요</div>
        </div>

        <div>
            <button>
                확인</button>
        </div>

    </div>
    )
}