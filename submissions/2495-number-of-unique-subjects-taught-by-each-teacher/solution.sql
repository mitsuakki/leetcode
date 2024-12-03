SELECT t.teacher_id, COUNT(DISTINCT t.subject_id) AS cnt
FROM Teacher t
GROUP BY t.teacher_id
