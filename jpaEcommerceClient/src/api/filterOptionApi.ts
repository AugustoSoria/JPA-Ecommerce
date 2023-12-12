import { FilterOption } from "../model/FilterOption";

const URL_BASE = "http://localhost:8080/api/filter_value"

export const FilterOptionApi = {
    getValuesByFilterId: (filterId: number): Promise<FilterOption[]> => {
        
        return fetch(URL_BASE + "/values-amount-by-filter-id?filterId="  + filterId)
            .then((res) => res.json())
    },
}