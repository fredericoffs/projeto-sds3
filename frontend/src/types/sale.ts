import { Seller } from "./seller"

export type Sale = {
    id: number;
    visited: number;
    deals: number;
    amount: number;
    date: string;
    seller: Seller;
}

export type SalePage = {
    content?: Sale[];
    last: boolean,
    totalPages: number;
    totalElements: number;
    numberOfElements?: number;
    size?: number;
    first: boolean,
    number?: number;
    empty?: boolean;
}


export type SaleSum = {
    sellerName: string;
    sum: number;
}

export type SalesSuccess = {
    sellerName: string;
    visited: number;
    deals: number;
}