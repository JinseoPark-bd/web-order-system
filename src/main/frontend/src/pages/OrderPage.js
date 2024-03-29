import { Button } from "@material-tailwind/react";
import BasicLayout from "../layouts/BasicLayout";

const OrderPage = () => {
  return (
    <BasicLayout>
        <div className="mx-96 my-20" >
          <h1 className="text-2xl font-extrabold flex justify-between">
            <div>제품 주문</div>
            <div className="">
              <Button className="w-20 h-10 text-sm font-medium p-1 rounded mr-3 bg-slate-500">RESET</Button>
              <Button className="w-20 h-10 text-sm font-medium p-1 rounded mr-3 bg-[#4754C9]">삭제하기</Button>
              <Button className="w-20 h-10 text-sm font-medium p-1 rounded bg-[#4754C9]">등록하기</Button>
            </div>
          </h1>
          <hr className="width-300px my-3"></hr>
          <div className="item grid gap-5 grid-cols-2">
            <div className="">
              <div className="flex flex-col space-y-1.5 m-3">
                <label htmlFor="name">Name</label>
                <input id="name" placeholder="Name" required />
              </div>
              <div className="flex flex-col space-y-1.5 m-3">
                <label htmlFor="description">Description</label>
                <textarea id="description" placeholder="Description" required />
              </div>
            </div>
            <div className="flex flex-col space-y-1.5 m-3">
              <label htmlFor="price">Price</label>
              <input id="price" placeholder="Price" required type="number" />
            </div>
            <div className="flex flex-col space-y-1.5 m-3">
              <label htmlFor="quantity">Quantity</label>
              <input id="quantity" placeholder="Quantity" required type="number" />
            </div>
          </div>
          <Button className="w-20 h-10 text-sm font-medium p-1 rounded bg-[#4754C9] my-10">Register</Button>
          <hr className="width-300px my-3"></hr>
          <div className="item_list">
            <div className= "bg-sky-800 w-full h-80"></div>
          </div>
          <div className="Page">
            <div className="title">
              이메일과 비밀번호를<br/> 입력하세요
            </div>
          </div>
        </div>
    </BasicLayout>
  );
}

export default OrderPage;

