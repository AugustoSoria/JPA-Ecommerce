import App from "../../App";
import { createBrowserRouter } from "react-router-dom";
import CreaterProduct from "../creater/CreaterProduct";
import CreaterFilter from "../creater/CreaterFilter";
import CreaterCategory from "../creater/CreaterCategory";

const router = createBrowserRouter([
    {
        path: "/",
        element: <App />,
        children: [
            {
                path: "product/create",
                element: <CreaterProduct />,
            },
            {
                path: "category/create",
                element: <CreaterCategory />,
            },
            {
                path: "filter/create",
                element: <CreaterFilter />,
            }
        ]
    }
]);

export default router