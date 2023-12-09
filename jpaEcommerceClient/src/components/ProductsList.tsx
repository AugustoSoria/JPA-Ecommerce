import { useEffect, useState } from "react";
import { Product } from "../model/Product";
import { productApi } from "../api/productApi";
import ProductCard from "./ProductCard";
import { useParams } from "react-router-dom";

function ProductsList() {
    const [products, setProducts] = useState<Product[]>([])

    const { productCategory } = useParams()

    useEffect(() => {
        const paramsCopy = new URLSearchParams()
        if(productCategory) paramsCopy.set("category", productCategory)

        productApi.getProductsBySearchCriteria(paramsCopy)
            .then(ps => setProducts(ps))
    }, [])

    console.log("products")
    console.log(products)
    if(!products.length) return;

    return (
        <div style={{ display: "grid", gridTemplateColumns: "repeat(4, 200px)", gridGap: "10px", gridAutoRows: "minmax(100px, auto)" }}>
            {products.map(p => <ProductCard key={p.id} product={p}/>)}
        </div>
    );
}

export default ProductsList;