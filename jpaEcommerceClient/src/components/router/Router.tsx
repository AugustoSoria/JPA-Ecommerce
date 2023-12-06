import App from "../../App";
import { createBrowserRouter } from "react-router-dom";
import CreateProduct from "../CreateProduct";

const router = createBrowserRouter([
    {
        path: "/",
        element: <App />,
        children: [
            {
                path: "product/create",
                element: <CreateProduct />,
            }
        ]
    }
]);

export default router