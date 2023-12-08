import { Category } from "./Category"

export interface Filter {
    id?: number
    name: string
    isRange: boolean
    filterCategory: Category[]
}