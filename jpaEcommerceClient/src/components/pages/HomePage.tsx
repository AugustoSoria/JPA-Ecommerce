import FiltersList from "../FiltersList";
import ProductsList from "../ProductsList";

function HomePage() {
    return (
        <section style={{display: "grid", gridTemplateColumns: "repeat(2, auto)", gap: "20px"}}>
            <FiltersList />
            <ProductsList/>
        </section>
    );
}

export default HomePage;