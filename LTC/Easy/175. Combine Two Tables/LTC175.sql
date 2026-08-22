-- [Target DB] MySQL, PostgreSQL, Oracle

SELECT
    p.firstName,
    p.lastName,
    a.city,
    a.state
FROM
    Person p
-- [Note] USING (personId) is also an option. But it modifies the query.
LEFT JOIN
    Address a ON p.personId = a.personId;