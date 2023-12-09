import { Product } from "../model/Product";

type Props = {product: Product}

function ProductCard({product}: Props) {
    return (
        <div style={{maxWidth: "200px", border: "1px solid #605555", overflow: "hidden"}}>
                <img style={{width: "200px"}} src="https://p.kindpng.com/picc/s/603-6033059_amazon-advertising-icon-png-transparent-png.png"/>
                <h3 style={{textAlign: "start"}}>{product.name}</h3>
                <h3 style={{textAlign: "end"}}>{product.price}</h3>
        </div>);
}

export default ProductCard;