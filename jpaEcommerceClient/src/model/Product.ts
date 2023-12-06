import { Category } from "./Category"
import { FilterValue } from "./FilterValue"

export interface Product {
    id?: number
    name: string
    price: number
    category: Category
    priceInUsd: Boolean
    filterValues: FilterValue[]
}