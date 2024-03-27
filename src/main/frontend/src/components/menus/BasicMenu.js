import { Link } from "react-router-dom";

const BasicMenu = () => {
  return (
    <nav id='navbar' className="flex bg-blue-300">
        <div className="w-4/5 bg-gray-500">
            <ul className="flex p-4 text-white font-bold">
                <li className="pr-6 text-2xl"><Link to={'/'}>홈</Link></li>
                <li className="pr-6 text-2xl"><Link to={'/order'}>주문등록</Link></li>
                <li className="pr-6 text-2xl"><Link to={'/orderList'}>주문조회</Link></li>
                <li className="pr-6 text-2xl"><Link to={'/todo'}>Todo</Link></li>
            </ul>
        </div>
        <div className="w-1/5 flex justify-end bg-orange-300 p-4 font-medium">
          <li className="text-white pr-6 text-xl"><Link to={'/login'}>로그아웃</Link></li>
        </div>
    </nav>
  );
}

export default BasicMenu;
