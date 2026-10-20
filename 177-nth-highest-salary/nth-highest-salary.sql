CREATE OR REPLACE FUNCTION NthHighestSalary(N INT) RETURNS TABLE (Salary INT) AS $$
BEGIN
if N<1 then return QUERY(select null :: INT as salary);
else
  RETURN QUERY (
    -- Write your PostgreSQL query statement below.
    select(select distinct e.Salary  from Employee e order by e.Salary desc limit 1 offset N-1)
      
  );
  end if;
END;
$$ LANGUAGE plpgsql;