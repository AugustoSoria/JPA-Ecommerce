import { useEffect, useState } from "react";
import { Product } from "../../../model/Product";
import { productApi } from "../../../api/productApi";
import ProductCard from "./ProductCard";
import { useParams, useSearchParams } from "react-router-dom";
import './product.css';

function ProductsList() {
    const [products, setProducts] = useState<Product[]>([])
    const [searchParams] = useSearchParams()

    const { categoryName } = useParams()

    useEffect(() => {
        const paramsCopy = new URLSearchParams(searchParams)
        if(categoryName) paramsCopy.set("category", categoryName)
        
        productApi.getProductsBySearchCriteria(paramsCopy)
            .then(apiProducts => {
                setProducts(apiProducts)
            })

    }, [searchParams, categoryName])

    if(!products.length) return;

    return (
        <div className="ProductsList">
            {products.map(p => <ProductCard key={p.id} product={p}/>)}
        </div>
    );
}

export default ProductsList;