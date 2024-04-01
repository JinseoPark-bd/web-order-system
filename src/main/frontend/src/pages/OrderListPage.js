import { Button, Input } from "@material-tailwind/react";
import BasicLayout from "../layouts/BasicLayout";
import { TestTable } from "../components/dataTable/TestTable";
import axios from "axios";
import React, {useEffect, useState} from 'react';
import DatePicker from "react-datepicker";

const OrderListPage = () => {
  const [ orderList, setOrderList ] = useState([]);
  const [ startDate, setStartDate ] = useState(new Date());
  const [ endDate, setEndDate ] = useState(new Date());

  const getOrderList = async () => {
    const resp = (await axios.get('http://localhost:8080/api/order/list')).data;
    setOrderList(resp.data);
    
    const pngn = resp.pagination;
    console.log(pngn);
  }

  useEffect(() => {
    getOrderList();
  }, []);

  return (
    <BasicLayout>
        <div className="w-full h-80 bg-[#4754C9]">
        <div className="text-4xl text-white py-32 pl-52">주문 조회</div>
        </div>
        <div className="mx-96 my-20" >
          <h1 className="text-2xl font-extrabold flex justify-between">
            <div>주문 조회</div>
          </h1> 
          <hr className="width-300px my-3"></hr>
          <div className="item grid gap-5 grid-cols-3 ">
            <div className="left-1/4 flex flex-col space-y-1.5 m-3">
              <label htmlFor="order_date">시작 일자</label>
              <DatePicker selected={startDate} onChange={(date) => setStartDate(date)}/>
            </div>
            <div className="left-1/4 flex flex-col space-y-1.5 m-3">
              <label htmlFor="order_date">종료 일자</label>
              
            </div>
            <div className="flex flex-col space-y-1.5 m-3">
              <label htmlFor="account">거래처</label>
              <textarea id="account" placeholder="거래처를 선택해주세요" required className="h-15 border border-gray-200 rounded-md text-lg"/>
            </div>
          </div>
          <Button className="w-20 h-10 text-sm font-medium p-1 rounded bg-[#4754C9] mt-10">검색</Button>
          <hr className="width-300px my-3"></hr>
          <div className="item_list">
            <TestTable/>
          </div>
        </div>
    </BasicLayout>
  );
}

export default OrderListPage;
