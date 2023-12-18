import { Filter } from "../model/Filter"
import { apiOptions, handleCreateResponse, handleResponse } from "../utils/api"

const URL_BASE = "http://localhost:8080/api/filter"

export const filterApi = {
    getFilters: (): Promise<Filter[]> => {

        return fetch(URL_BASE)
            .then(res => handleResponse(res))

    },
    getByCategoryName: (categoryName: string | undefined): Promise<Filter[]> => {
        if(!categoryName) categoryName = ""

        return fetch(URL_BASE + "/byCriteria?categoryName=" + categoryName)
            .then(res => handleResponse(res))

    },
    create: (filter: Filter): Promise<string> => {

        apiOptions.method = "POST"
        apiOptions.body = JSON.stringify(filter)

        return fetch(URL_BASE + "/create", apiOptions)
            .then(res => handleCreateResponse(res))

    }
}