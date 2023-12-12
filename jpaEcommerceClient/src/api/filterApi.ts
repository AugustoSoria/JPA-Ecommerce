import { Filter } from "../model/Filter"

const URL_BASE = "http://localhost:8080/api/filter"
        
const options: RequestInit = {
    method: "GET",
    headers: {
      'content-type': 'application/json',
    },
    body: null
}

export const filterApi = {
    getFilters: (): Promise<Filter[]> => {

        return fetch(URL_BASE)
            .then((res) => res.json())

    },
    getByCategoryName: (categoryName: string | undefined): Promise<Filter[]> => {
        if(!categoryName) categoryName = ""

        return fetch(URL_BASE + "/byCriteria?categoryName=" + categoryName)
            .then((res) => res.json())

    },
    create: (filter: Filter): Promise<Response> => {

        options.method = "POST"
        options.body = JSON.stringify(filter)

        return fetch(URL_BASE + "/create", options)

    }
}