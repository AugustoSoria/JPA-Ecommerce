import { Product } from "../model/Product"

const URL_BASE = "http://localhost:8080/api/product"

const options: RequestInit = {
    method: "GET",
    headers: {
      'content-type': 'application/json',
    },
    body: null
}

export const productApi = {
    create: (product: Product): Promise<Response> => {

        options.method = "POST" 
        options.body = JSON.stringify(product)

        return fetch(URL_BASE + "/create", options)
    }

}