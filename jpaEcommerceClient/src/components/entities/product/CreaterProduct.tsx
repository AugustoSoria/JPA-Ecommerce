import { useState, useEffect } from "react";
import { Category } from "../../../model/Category";
import { Filter } from "../../../model/Filter";
import { categoryApi } from "../../../api/categoryApi";
import { filterApi } from "../../../api/filterApi";
import { Product } from "../../../model/Product";
import { productApi } from "../../../api/productApi";
import NotiModal from "../../shared/NotiModal";
import Spinner from "../../shared/Spinner";
import './product.css';

function CreaterProduct() {
    const [categories, setCategories] = useState<Category[]>([])
    const [selectedCategory, setSelectedCategory] = useState<Category>()
    const [filters, setFilters] = useState<Filter[]>([])

    const [successMsg, setSuccessMsg] = useState<string>()
    const [errorMsg, setErrorMsg] = useState<string>()
    const [loading, setLoading] = useState<boolean>(true)

    useEffect(() => {
        Promise.all([categoryApi.getCategories(), filterApi.getFilters()])
            .then(resp => {
                setCategories(resp[0])
                setFilters(resp[1])
            })
            .finally(() => setLoading(false))
    }, [])

    function handleChangeOption(event: React.ChangeEvent<HTMLSelectElement>) {
        const categoryId = event.target.value
        const foundCategory = categories.find(c => c.id?.toString() === categoryId)
        setSelectedCategory(foundCategory)
    }

    function create(event: React.ChangeEvent<HTMLFormElement>) {
        event.preventDefault()
        if(!selectedCategory) return;

        const filterValues: any = []

        filters.forEach(f => {
            filterValues.push({
                value: event.target[f.name].value,
                filter: f
            })
        })

        const newProduct: Product = {
            name: event.target.productName.value,
            price: event.target.price.value.replace(/\./g, ""),
            priceInUsd: event.target.usd.checked,
            category: selectedCategory,
            filterValues
        }

        setLoading(true)
        productApi.create(newProduct)
            .then((res) => setSuccessMsg(res))
            .catch((err: Error) => setErrorMsg(err.message))
            .finally(() => setLoading(false))
    }

    return (
        <section>
            <form className="create-form" onSubmit={create}>
                <label htmlFor="productName">name</label>
                <input type="text" name="productName" id="name" />

                <label htmlFor="price">price</label>
                <input type="number" name="price" id="price" />
                <div style={{display: "flex"}}>
                    <input type="radio" name="priceCurrency" id="arg" value="arg" defaultChecked />
                    <label htmlFor="arg">ARG</label>

                    <input type="radio" name="priceCurrency" id="usd" value="usd" />
                    <label htmlFor="usd">USD</label>
                </div>

                <label htmlFor="category">category</label>
                <select name="category" onChange={(e) => handleChangeOption(e)} defaultValue="">
                    <option value="" disabled>Choose a category</option>
                    {
                        categories.map(c => 
                            <option key={c.id} value={c.id}>{c.name}</option>)
                    }
                </select>

                {   
                    filters.length ?
                    filters.map(f => (
                        <div key={f.id} style={{display: "flex", flexDirection: "column"}}>
                            <label htmlFor={f.name}>{f.name}</label>
                            <input type="text" name={f.name} id={f.name} />
                        </div>
                    )) : <h4>No se encontraron filtros</h4>
                }

                <button type="submit">create</button>
            </form>
            {loading && <Spinner />}
            {successMsg && <NotiModal msg={successMsg} />}
            {errorMsg && <NotiModal msg={errorMsg} errorColor={true} />}
        </section>
    );
}

export default CreaterProduct;