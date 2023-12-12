import { useEffect, useState } from "react";
import { Filter } from "../model/Filter";
import { useParams } from "react-router-dom";
import FilterComponent from "./FilterComponent";
import { filterApi } from "../api/filterApi";

function FiltersList()  {
    const [filters, setFilters] = useState<Filter[]>([])
    const { categoryName } = useParams()

    useEffect(() => {
        filterApi.getByCategoryName(categoryName)
            .then(filters => setFilters(filters))
    }, [])

    if(!filters.length) return;

    return (
        <div>
            {filters.map(f =>  (
                <div key={f.id} style={{display: "flex", flexDirection: "column"}}>
                    <FilterComponent filter={f}/>
                </div>
            ))}
        </div>
    );
}

export default FiltersList;