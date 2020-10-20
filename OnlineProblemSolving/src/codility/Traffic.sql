WITH traffic_cte (user_type, visited_on, time_spent, rn) 
AS 
(
    SELECT 
        x.user_type, x.visited_on, x.time_spent, ROW_NUMBER() OVER(PARTITION BY x.user_type ORDER BY x.visited_on) AS rn
    FROM (
        SELECT 
            a.user_type, b.visited_on, b.time_spent
        FROM 
            traffic b 
        LEFT OUTER JOIN 
            users a 
        ON (a.id = b.user_id)
        WHERE 
            a.user_type = 'user'
    ) x
)
SELECT 
    z.visited_on, CAST( (c1/avg_time_spent)  AS DECIMAL)
FROM (
    SELECT 
        x.visited_on, COUNT(x.time_spent) as c1, SUM(x.time_spent1) AS avg_time_spent
    FROM (
        SELECT 
            a.*,
            CASE WHEN b.time_spent IS NULL THEN 0 ELSE b.time_spent END AS time_spent1
        FROM 
            traffic_cte a 
        LEFT OUTER JOIN
            traffic_cte b
        ON
            b.rn BETWEEN a.rn-2 AND a.rn
    ) x
    GROUP BY 
        x.visited_on
) z;