export function PriceFormater(price: number, priceInUsd: boolean) {
    let AR$ = new Intl.NumberFormat('es-AR', {
        style: 'currency',
        currency: 'ARS',
        maximumFractionDigits: 0, 
    	currencyDisplay: 'narrowSymbol'
    });
    let parsedPrice = AR$.format(price);
    if(priceInUsd) {
        parsedPrice = parsedPrice.replace("$", "USD");
    }
    return parsedPrice;
}
