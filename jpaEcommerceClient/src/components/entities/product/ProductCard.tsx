import { Product } from "../../../model/Product";
import { PriceFormater } from "../../../utils/formater";
import './product.css';

type Props = {product: Product}

function ProductCard({product}: Props) {
    return (    
        <div className="ProductCard">
            <div className="image-container">
                <img src="https://cdn1.iconfinder.com/data/icons/e-commerce-set-2-1/256/Box-512.png"/>
            </div>
            <h4>{product.name}</h4>
            <h3>{PriceFormater(product.price, product.priceInUsd)}</h3>
        </div>);
}

export default ProductCard;