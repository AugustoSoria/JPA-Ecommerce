import FiltersList from "../entities/filter/FiltersList";
import ProductsList from "../entities/product/ProductsList";
import './pages.css'

function HomePage() {
    return (
        <section className="HomePage">
            <FiltersList />
            <ProductsList/>
        </section>
    );
}

export default HomePage;