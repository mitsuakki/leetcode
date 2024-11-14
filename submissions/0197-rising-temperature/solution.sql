SELECT w.id AS Id
FROM Weather w, Weather w2 
WHERE DATEDIFF(w.recordDate, w2.recordDate) = 1 AND w.temperature > w2.temperature
