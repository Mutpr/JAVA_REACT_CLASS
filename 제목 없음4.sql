-- 1. 2020�� 12�� 25���� ���� �������� ��ȸ�ϼ���.
select to_char(to_date('2020.12.15'), 'dy') from dual;
-- 2. �ֹι�ȣ�� 1970��� ���̸鼭 ������ �����̰�, ���� ������ �������� �����, �ֹι�ȣ, �μ���, ���޸��� ��ȸ�ϼ���.
select e.emp_name, e.emp_no, d.dept_title, j.JOB_NAME from employee e
    join department d on e.dept_code = d.dept_id
    join job j on e.job_code = j.job_code
    where emp_no like '7%' and emp_no like '-2%' and emp_name like '��%';
    
-- 3. �̸��� "��"�ڰ� ���� �������� ���, �����, �μ����� ��ȸ�ϼ���.
select e.emp_id, e.emp_name, d.DEPT_TITLE from employee e
    join DEPARTMENT d  on e.DEPT_CODE = d.DEPT_ID
    where e.EMP_NAME like '%��%';
    
-- 4. �μ��� �޿� ����� 300���� ������ �μ��� �μ���� �޿� ����� ����ϼ���
-- > �޿� ����� 10000�� �ڸ� �Ʒ��� ������ ������ּ���. 
-- > ���� �ѱ� ���� ��ȭ ǥ������� ������ּ���. (��3,520,000)
select d.DEPT_TITLE, to_char(avg(salary), 'L999,999,999') from employee e
    join department d on e.DEPT_CODE=d.DEPT_ID
    where salary<'3000000' group by d.DEPT_TITLE;
-- 5. �ؿܿ����ο� �ٹ��ϴ� �����, ���޸�, �μ��ڵ�, �μ����� ��ȸ�ϼ���.
select * from employee e
    join department d on e.dept_code=d.dept_id    
    where d.dept_title ='�ؿܿ�����';
-- 6. ���ʽ�����Ʈ�� �޴� �������� �����, ���ʽ�����Ʈ, �μ���, �ٹ��������� ��ȸ�ϼ���.
select e.emp_name, e.bonus, d.dept_title, l.LOCAL_NAME from employee e
    join department d on e.DEPT_CODE=d.dept_id
    join location l on d.LOCATION_ID=l.LOCAL_CODE
    where NVL(bonus, 0) != 0;
-- 7. �μ��ڵ尡 D2�� �������� �����, ���޸�, �μ���, �ٹ��������� ��ȸ�ϼ���.
select e.emp_name, j.JOB_NAME, d.DEPT_TITLE, n.NATIONAL_NAME from employee e
    join JOB j on j.JOB_CODE = e.JOB_CODE
    join department d on e.DEPT_CODE=d.dept_id
    join location l on d.LOCATION_ID = l.LOCAL_CODE
    join NATIONAL n on l.NATIONAL_CODE = n.NATIONAL_CODE
    where e.DEPT_CODE = 'D2';
-- 8. �ѱ�(KO)�� �Ϻ�(JP)�� �ٹ��ϴ� �������� �����, �μ���, �ٹ�������, �������� ��ȸ�ϼ���.
select e.emp_name, d.DEPT_TITLE, l.LOCAL_NAME, n.NATIONAL_NAME
    from employee e
    join DEPARTMENT d on e.DEPT_CODE = d.DEPT_ID
    join LOCATION l on d.LOCATION_ID = l.LOCAL_CODE
    join NATIONAL n on l.NATIONAL_CODE = n.NATIONAL_CODE
    where l.national_code = 'KO' or l.national_code = 'JP';
-- 9. ��� ��� �� �������� �Ŵ����� �ΰ� �ִ� ������ �̸�, ������ �μ���, �Ŵ����� �̸��� ����ϼ���.
select e1.emp_name, e1.DEPT_CODE, e1.EMP_NAME
    from employee e1
    join employee e2 on e1.MANAGER_ID = e2.emp_id
    join DEPARTMENT d on e1.DEPT_CODE = d.DEPT_ID
where e2.emp_name = '������';
-- 10. ���ʽ�����Ʈ�� ���� ������ �߿��� ������ ����� ����� �������� �����, ���޸�, �޿��� ��ȸ�ϼ��� (join�� in ���)
select e.emp_name �����, k.JOB_NAME ���޸�, e.salary from employee e
    join department d on e.DEPT_CODE=d.dept_id
    join JOB k on e.JOB_CODE=k.JOB_CODE
    where (NVL(e.bonus,0)) in (0) 
    and k.job_name in '����';
-- 11. �������� ������ ����� ������ ���� ��ȸ�ϼ���.
select 
    count(case when a.ENT_YN='N' then 1 end) as ������, 
    count(case when b.ent_yn = 'Y' then 1 end) as ����� from employee a 
    join employee b on a.emp_id=b.emp_id;