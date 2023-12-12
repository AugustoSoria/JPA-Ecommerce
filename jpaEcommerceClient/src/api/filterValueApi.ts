import { FilterOption } from "../model/FilterOption";

const URL_BASE = "http://localhost:8080/api/filter_value"

export const FilterValueApi = {
    getValuesByFilterIdAndProductCriteria: (filterId: number, productCriteria?: URLSearchParams): Promise<FilterOption[]> => {
        let urlBaseWithParams = URL_BASE + "/values-amount-by-filter-id?filterId="  + filterId
        if(productCriteria?.size) urlBaseWithParams += "&" + productCriteria.toString()
        
        return fetch(urlBaseWithParams)
            .then((res) => res.json())
    },
}