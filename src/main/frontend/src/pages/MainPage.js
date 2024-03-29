import { Link } from "react-router-dom"
import BasicLayout from "../layouts/BasicLayout";

const MainPage = () => {
  return (
    <BasicLayout>
        <div className="h-screen w-screen bg-[url('./images/login-bg.jpg')] bg-cover flex justify-center font-style: italic">
          <ul>
            <li className="text-9xl font-sans text-white my-60 mx-auto text-center">WELCOME</li>
            <li className="text-9xl font-sans text-white my-60 mx-auto text-center">TO YONGMA OMS</li>
          </ul>
        
        </div>
    </BasicLayout>
  );
}

export default MainPage;
