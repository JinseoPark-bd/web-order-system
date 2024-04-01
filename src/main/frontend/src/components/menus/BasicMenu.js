import { Link } from "react-router-dom";
import logo from '../../images/oms_logo.png'

const BasicMenu = () => {
  return (
    <nav id='navbar' className="flex bg-[#4754C9] border-b border-white">
        <h1 className="home w-2/3 m-1">
          <Link to={'/'}>
            <img src={logo} alt="title_logo" className=" w-48 h-28"/>
          </Link>
        </h1>
        <div className="w-1/3 font-medium">
            <ul className=" flex py-10 text-white">
                <li className=" pr-24 text-2xl"><Link to={'/order'} className="hover:underline underline-offset-8">제품 주문</Link></li>
                <li className="pr-24 text-2xl"><Link to={'/orderList'} className="hover:border-gray-300 hover:text-gray-700">주문 조회</Link></li>
                <li className="text-2xl"><Link to={'/login'} className="hover:underline underline-offset-8">로그아웃</Link></li>
            </ul>
        </div>

    </nav>
  );
}

export default BasicMenu;
