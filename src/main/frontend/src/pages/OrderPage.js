import { Button } from "@material-tailwind/react";
import BasicLayout from "../layouts/BasicLayout";
import { useState, useEffect } from "react";
import DataTable from "../components/dataTable/DataTable";


const OrderPage = () => {
  const headers = [
    {
      text: 'Name',
      value: 'name'
    },
    {
      text: 'Version',
      value: 'version'
    },
    {
      text: 'Launch Date',
      value: 'launch'
    }
  ];
  const items = [
    {
      name: 'React',
      version: '18.2.0',
      launch: '2013-05-29'
    },
    {
      name: 'Vue',
      version: '3.2.45',
      launch: '2014-02'
    },
    {
      name: 'jQuery',
      version: '3.3',
      disabled: true,
      launch: '2006-08-26'
    },
    {
      name: 'Svelte',
      version: '3.53.1',
      launch: '2016-11-26'
    },
  ];

  const [selection, setSelection] = useState([]);
  useEffect(() => {
    console.log(selection);
  }, [selection]);


  return (
    <BasicLayout>
        <div className="w-full h-80 bg-[#4754C9]">
          <div className="text-4xl text-white left-1/3 top-1/2">제품 주문</div>
        </div>
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
            <div className="flex flex-col space-y-1.5 m-3">
              <label htmlFor="order_date">주문 일자</label>
              <input id="order_date" placeholder="Order_date" required />
            </div>
            <div className="flex flex-col space-y-1.5 m-3">
              <label htmlFor="account">거래처</label>
              <textarea id="account" placeholder="Account" required />
            </div>
            <div className="flex flex-col space-y-1.5 m-3">
              <label htmlFor="item">상품선택</label>
              <input id="item" placeholder="Item" required type="number" />
            </div>
            <div className="flex flex-col space-y-1.5 m-3">
              <label htmlFor="quantity">수량</label>
              <input id="quantity" placeholder="Quantity" required type="number" />
            </div>
          </div>
          <Button className="w-20 h-10 text-sm font-medium p-1 rounded bg-[#4754C9] mt-10">상품추가</Button>
          <hr className="width-300px my-3"></hr>
          <div className="item_list">
          <DataTable 
            headers={headers} 
            items={items} 
            selectable={true} 
            updateSelection={setSelection}
          />
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

