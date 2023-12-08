import { useEffect, useState } from "react";
import { categoryApi } from "../../api/categoryApi";
import { Filter } from "../../model/Filter";
import { Category } from "../../model/Category";
import { filterApi } from "../../api/filterApi";

function CreaterFilter() {
    const [categories, setCategories] = useState<Category[]>([])
    const [selectedCategories, setSelectedCategories] = useState<Category[]>([])

    useEffect(() => {
        categoryApi.getCategories()
            .then(categories => setCategories(categories))
    }, [])

    function create(event: React.ChangeEvent<HTMLFormElement>) {
        event.preventDefault()

        const newFilter: Filter = {
            name: event.target.filterName.value,
            isRange: event.target.yes.checked,
            filterCategory: selectedCategories
        }

        filterApi.create(newFilter)
            .then(resp => resp.ok ? console.log("Filter created") : console.log("Filter not created"))

    }

    function handleCheck(event: React.FormEvent<HTMLDivElement>) {
        const target = event.target as HTMLInputElement;
        const checked = target.checked
        const categoryId = target.value
        const foundCategory = categories.find(c => c.id?.toString() == categoryId)

        if(!foundCategory) return;
        if(checked) setSelectedCategories(prev => [...prev, foundCategory])
        else setSelectedCategories(prev => prev.filter(c => c.id?.toString() !== categoryId))
    }

    return (
        <section>
            <form className="create-form" onSubmit={create}>
                <label htmlFor="filterName">name</label>
                <input type="text" name="filterName" id="name" />

                <div style={{display: "flex", alignItems: "center"}}>
                    <h4 style={{marginRight: "5px"}}>range:</h4>
                    <label htmlFor="yes">yes</label>
                    <input type="radio" name="isRange" id="yes" />

                    <label htmlFor="no">no</label>
                    <input type="radio" name="isRange" id="no" />
                </div>

                <div style={{display: "flex", alignItems: "center"}} onChange={handleCheck}>
                    <h4 style={{marginRight: "5px"}}>categories:</h4>

                    {categories.map(c => 
                    <div key={c.id}>
                        <label htmlFor={c.name}>{c.name}</label>
                        <input type="checkbox" name="categories" id={c.name} value={c.id}/>
                    </div>)}
                </div>

                <button type="submit">create</button>
            </form>
        </section>
    );
}

export default CreaterFilter;