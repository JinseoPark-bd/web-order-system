import React, {useEffect, useState} from 'react';
import { Button } from "@material-tailwind/react";
import BasicLayout from "../layouts/BasicLayout";
import { TestTable } from "../components/dataTable/TestTable";
import DatePicker from "react-datepicker";


const OrderPage = () => {
  const [ startDate, setStartDate ] = useState(new Date());
  const [ endDate, setEndDate ] = useState(new Date());

  return (
    <BasicLayout>
        <div className="w-full h-80 bg-[#4754C9]">
          <div className="text-4xl text-white py-32 pl-52">제품 주문</div>
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
              <DatePicker selected={startDate} onChange={(date) => setStartDate(date)}/>
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
            <TestTable/>
          </div>
        </div>
    </BasicLayout>
  );
}

export default OrderPage;

