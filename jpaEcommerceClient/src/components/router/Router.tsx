import App from "../../App";
import { createBrowserRouter } from "react-router-dom";
import CreaterProduct from "../entities/product/CreaterProduct";
import CreaterFilter from "../entities/filter/CreaterFilter";
import CreaterCategory from "../entities/category/CreaterCategory";
import HomePage from "../pages/HomePage";

const router = createBrowserRouter([
    {
        path: "/",
        element: <App />,
        children: [
            {
              path: '/:categoryName?',
              element: <HomePage/>
            },
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