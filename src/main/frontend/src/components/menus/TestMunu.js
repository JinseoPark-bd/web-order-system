import { Link } from "react-router-dom";

const TestMenu = () => {
  return (
    <nav id='navbar' className="flex bg-[#4754C9]">
        <div></div>
        <div className="w-4/5">
            <h1 className="logo_home"></h1>
            <ul className=" flex p-4 text-white font-bold">
                <li className="pr-6 text-xl"><Link to={'/'}>홈</Link></li>
                <li className="pr-6 text-sm"><Link to={'/order'}>주문등록</Link></li>
                <li className="pr-6 text-sm"><Link to={'/orderList'}>주문조회</Link></li>
                <li className="pr-6 text-sm"><Link to={'/todo'}>Todo</Link></li>
            </ul>
        </div>
        <div className="w-1/5 flex justify-end bg-orange-300 p-4 font-medium">
          <li className="text-white pr-6 text-xs"><Link to={'/login'}>로그아웃</Link></li>
        </div>
    </nav>
  );
}

export default TestMenu;
