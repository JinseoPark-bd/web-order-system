import { Suspense, lazy } from "react";
import todoRouter from "./todoRouter";

const { createBrowserRouter } = require("react-router-dom")
const Loading = <div>Loading....</div>
const Main = lazy(() => import("../pages/MainPage"))
const Login = lazy(() => import("../pages/LoginPage"))
const Order = lazy(() => import("../pages/OrderPage"))
const OrderList = lazy(() => import("../pages/OrderListPage"))
const TodoIndex = lazy(() => import("../pages/todo/IndexPage"))

const root = createBrowserRouter ([
    {
        path: "",
        element: <Suspense fallback={Loading}><Main/></Suspense>
    },
    {
        path: "login",
        element: <Suspense fallback={Loading}><Login/></Suspense>
    },
    {
        path: "order",
        element: <Suspense fallback={Loading}><Order/></Suspense>
    },
    {
        path: "orderList",
        element: <Suspense fallback={Loading}><OrderList/></Suspense>
    },
    {
        path: "todo",
        element: <Suspense fallback={Loading}><TodoIndex/></Suspense>,
        children: todoRouter()
    },
])

export default root;