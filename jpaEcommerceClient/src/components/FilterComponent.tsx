import { ChangeEvent, useEffect, useState } from "react";
import { Filter } from "../model/Filter";
import { FilterOption } from "../model/FilterOption";
import { FilterValueApi } from "../api/filterValueApi";
import { useParams, useSearchParams } from "react-router-dom";

function FilterComponent({filter: {id, name}}: {filter: Filter})  {
    const [values, setValues] = useState<FilterOption[]>([])
    const [searchParams, setSearchParams] = useSearchParams()
    const { categoryName } = useParams()

    useEffect(() => {
        if(categoryName) searchParams.set("category", categoryName)
        getFilterValues()
    }, [searchParams])

    function getFilterValues() {
        if(!id) return;

        FilterValueApi.getValuesByFilterIdAndProductCriteria(id, searchParams)
            .then(values => setValues(values))
    }

    function filterProducts(event: ChangeEvent<HTMLInputElement>): void {
        const inputName = event.target.name
        const inputValue = event.target.value

        setSearchParams(prev => {
            const newParams = new URLSearchParams(prev)
            newParams.set(inputName, inputValue)
            return newParams
        })
        
    }

    if(!values.length) return;
    if(searchParams.get(name)) return;
    
    return (
        <>
            <h3>{name}</h3>
            {
                values.map(({value, amount}, index) => (
                    amount != 0 && <div key={index}>
                        <input 
                            type="radio" 
                            id={value} 
                            name={name} 
                            value={value} 
                            checked={searchParams.get(name) === value}
                            onChange={filterProducts}
                        />
                        <label htmlFor={value}>
                            <span>{value}</span>
                            <span>({amount})</span>
                        </label>
                    </div>
                ))
            }
        </>
    );
}

export default FilterComponent;