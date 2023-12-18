import { Product } from "../model/Product"
import { apiOptions, handleCreateResponse, handleResponse } from "../utils/api"

const URL_BASE = "http://localhost:8080/api/product"

export const productApi = {
    create: (product: Product): Promise<string> => {

        apiOptions.method = "POST" 
        apiOptions.body = JSON.stringify(product)

        return fetch(URL_BASE + "/create", apiOptions)
            .then(res => handleCreateResponse(res))
    },
    getProductsBySearchCriteria: (criteria: URLSearchParams): Promise<Product[]> => {

        return fetch(URL_BASE + "/byCriteria?" + criteria.toString())
            .then(res => handleResponse(res))
    },
}