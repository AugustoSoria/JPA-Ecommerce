import { useEffect, useState } from "react";
import { Filter } from "../../../model/Filter";
import { useParams, useSearchParams } from "react-router-dom";
import FilterComponent from "./FilterComponent";
import { filterApi } from "../../../api/filterApi";
import './filter.css';

function FiltersList()  {
    const [filters, setFilters] = useState<Filter[]>([])
    const { categoryName } = useParams()
    const [searchParams, setSearchParams] = useSearchParams()

    useEffect(() => {
        filterApi.getByCategoryName(categoryName)
            .then(filters => setFilters(filters))
    }, [])

    function deselectValue(k: string) {
        setSearchParams(prev => {
            const newParams = new URLSearchParams(prev)
            newParams.delete(k)
            return newParams
        })
    }

    if(!filters.length) return;

    return (
        <div>
            <div className="select-values">
                {
                    [...searchParams.keys()]
                        .map((k, i) => 
                            <div key={i}>
                                <button className="deselect-value-btn" onClick={() => deselectValue(k)}>
                                    <h5>X</h5>
                                </button>
                                <h4>{searchParams.get(k)}</h4>
                            </div>
                        )
                }
            </div>
            {filters.map(f =>  (
                <div key={f.id} className="FiltersList">
                    <FilterComponent filter={f}/>
                </div>
            ))}
        </div>
    );
}

export default FiltersList;