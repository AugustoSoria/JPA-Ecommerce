export function AR$Formater(price: number) {
    let AR$ = new Intl.NumberFormat('es-AR', {
        style: 'currency',
        currency: 'ARS',
        maximumFractionDigits: 0
    });
    return AR$.format(price);
}
