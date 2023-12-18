import { Category } from "../model/Category"
import { apiOptions, handleCreateResponse, handleResponse } from "../utils/api"

const URL_BASE = "http://localhost:8080/api/category"

export const categoryApi = {
    getCategories: (): Promise<Category[]> => {

        return fetch(URL_BASE)
            .then(res => handleResponse(res))
    },
    create: (category: Category): Promise<string> => {

        apiOptions.method = "POST"
        apiOptions.body = JSON.stringify(category)

        return fetch(URL_BASE + "/create", apiOptions)
            .then(res => handleCreateResponse(res))
    }
}