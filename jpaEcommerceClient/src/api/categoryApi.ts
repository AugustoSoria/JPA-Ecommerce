import { Category } from "../model/Category"

const URL_BASE = "http://localhost:8080/api/category"
        
const options: RequestInit = {
    method: "GET",
    headers: {
      'content-type': 'application/json'
    },
    body: null
}

export const categoryApi = {
    getCategories: (): Promise<Category[]> => {

        return fetch(URL_BASE)
            .then((res) => res.json())
    },
    create: (category: Category): Promise<Response> => {

        options.method = "POST"
        options.body = JSON.stringify(category)

        return fetch(URL_BASE + "/create", options)
    }
}