SELECT p.product_id, IFNULL(ROUND(SUM(p.price * u.units) / SUM(u.units), 2), 0) AS average_price
FROM Prices p
LEFT JOIN UnitsSold AS u ON p.product_id = u.product_id 
WHERE (u.purchase_date BETWEEN p.start_date AND p.end_date) OR u.purchase_date IS NULL
GROUP BY p.product_id
