SELECT a.machine_id, ROUND(AVG(a2.timestamp - a.timestamp), 3) AS processing_time
FROM Activity AS a
JOIN ACtivity AS a2 ON a.machine_id = a2.machine_id AND a.process_id = a2.process_id
WHERE a.activity_type = 'start' and a2.activity_type = 'end'
GROUP BY a.machine_id
