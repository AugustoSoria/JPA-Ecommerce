import { ChangeEvent, useEffect, useState } from "react";
import { Filter } from "../model/Filter";
import { FilterOption } from "../model/FilterOption";
import { FilterOptionApi } from "../api/filterOptionApi";
import { useSearchParams } from "react-router-dom";

function FilterComponent({filter: {id, name}}: {filter: Filter})  {
    const [values, setValues] = useState<FilterOption[]>([])
    const [searchParams, setSearchParams] = useSearchParams()

    useEffect(() => {
        getFilterValues()
    }, [])

    function getFilterValues() {
        if(!id) return;

        FilterOptionApi.getValuesByFilterId(id)
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
    
    return (
        <>
            <h3>{name}</h3>
            {
                values.map(({value, amount}, index) => (
                    <div key={index}>
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