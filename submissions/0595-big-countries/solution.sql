SELECT w.name, w.population, w.area
FROM World AS w
WHERE w.area >= 3000000 OR population >= 25000000
