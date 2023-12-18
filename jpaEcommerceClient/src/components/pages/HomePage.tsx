import FiltersList from "../entities/filter/FiltersList";
import ProductsList from "../entities/product/ProductsList";

function HomePage() {
    return (
        <section style={{display: "grid", gridTemplateColumns: "repeat(2, auto)", gap: "20px"}}>
            <FiltersList />
            <ProductsList/>
        </section>
    );
}

export default HomePage;