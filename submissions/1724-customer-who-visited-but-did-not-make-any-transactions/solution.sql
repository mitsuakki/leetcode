SELECT v.customer_id, COUNT(v.visit_id) AS count_no_trans
FROM Visits AS v
LEFT JOIN Transactions AS t ON t.visit_id = v.visit_id
WHERE transaction_id IS NULL
GROUP BY v.customer_id
