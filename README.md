JSON для добавления поставки:
```
{
    "supplierId": 1,
    "deliveryDate": "2023-01-15",
    "details": [
        {
            "productId": 1,
            "quantity": 100.00
        },
        {
            "productId": 2,
            "quantity": 50.00
        }
    ]
}
```
Для получения отчёт достаточно отправить GET запрос по следующему endpoint'у
```
/api/deliveries/report?startDate=2023-01-01&endDate=2023-01-31
```
