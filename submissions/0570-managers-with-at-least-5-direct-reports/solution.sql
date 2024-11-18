SELECT e.name
FROM Employee e, Employee e2
WHERE e2.managerId = e.id
GROUP BY e2.managerId HAVING COUNT(*) >= 5
