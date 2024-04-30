select emp_name from employee where emp_id= (select manager_id from employee where emp_name ='������');

select avg(salary) from employee;
select emp_name from employee where salary >=(select avg(salary) from employee);
select emp_id, emp_name, salary from employee where salary =(select salary from employee where emp_name = '������') and emp_name not like '������';
select emp_id, emp_name, salary from employee where salary = (select min(salary) from employee) or salary = (select max(salary) from employee);
select e.emp_name as "�����", e.dept_code as "�μ��ڵ�", d.dept_title as "�μ�", e.salary as "�޿�" from employee e join department d on e.dept_code=d.dept_id where e.dept_code in('D1', 'D2') and salary>(select avg(salary) from employee where dept_code = 'D5');

SELECT
    e.emp_name,
    e.sal_level,
    j.JOB_NAME
FROM
    employee e
    JOIN sal_grade s ON
        e.sal_level = s.sal_level
    JOIN job j on
        e.job_code = j.JOB_CODE
WHERE
    s.sal_level IN (
        (
            SELECT
                sal_level
            FROM
                employee
            WHERE
                emp_name = '���¿�'
        ),(
            SELECT
                sal_level
            FROM
                employee
            WHERE
                emp_name = '������'
        )
    );

SELECT
    e.emp_id ���,  e.emp_name �����, d.DEPT_TITLE �μ���, j.JOB_NAME ���޸�
FROM
    employee e
    JOIN job j ON j.job_code = e.job_code
    left JOIN department d on e.DEPT_CODE = d.DEPT_ID
    --
WHERE
    j.job_code NOT IN (
    (SELECT job_code FROM job WHERE job_name in ('��ǥ', '�λ���', '����'))
    );
    
select e.emp_name, e.job_code, j.job_name, e.hire_date 
    from employee e
    join department d on e.dept_code = d.dept_id 
    join job j on e.JOB_CODE=j.JOB_CODE
    where (e.dept_code , e.job_code) in (select dept_code , job_code from employee where ent_yn = 'Y');

select e.emp_name, e.emp_no, e.dept_code, d.dept_title
    from employee e
    join department d
        on e.dept_code = d.dept_id
    join job j
        on e.job_code=j.JOB_CODE
    where (e.dept_code) in (select dept_code from employee where emp_no like '%0808%');
    select dept_code, job_code from employee where emp_no like '%0808%';
    
select NVL(e.dept_code, 'intern') �μ��ڵ�, e.emp_name �μ���, e.salary �޿� from employee e
    left join department d 
        on e.DEPT_CODE = d.DEPT_ID
    where e.salary in (select max(salary) from employee group by dept_code)
    order by e.DEPT_CODE;

select e.emp_name, e.SAL_LEVEL, e.salary, e.job_code from employee e
    join sal_grade sal on e.SAL_LEVEL = sal.SAL_LEVEL
    where (e.sal_level, e.job_code) in (select min(sal_level), job_code from employee group by job_code)
    order by JOB_CODE;
    
select max(sal_level), job_code from employee group by job_code order by max(sal_level);
    
    -- �ζ��� ��: ���������� ���������� ����Ͽ� ���� ����� ���� ����Ʈ ������ �����ϴ� ����
select d.dept_title, e.EMP_name from (select department.dept_title, department.dept_id from department) d, employee e
where d.dept_id = e.DEPT_CODE;

    select * from (
    (select emp_id, emp_name, rank() over (order by salary DESC) b from employee) b) where b between 5 and 10;


