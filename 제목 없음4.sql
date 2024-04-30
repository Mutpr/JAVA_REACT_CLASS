-- 1. 2020년 12월 25일이 무슨 요일인지 조회하세요.
select to_char(to_date('2020.12.15'), 'dy') from dual;
-- 2. 주민번호가 1970년대 생이면서 성별이 여자이고, 성이 전씨인 직원들의 사원명, 주민번호, 부서명, 직급명을 조회하세요.
select e.emp_name, e.emp_no, d.dept_title, j.JOB_NAME from employee e
    join department d on e.dept_code = d.dept_id
    join job j on e.job_code = j.job_code
    where emp_no like '7%' and emp_no like '-2%' and emp_name like '전%';
    
-- 3. 이름에 "형"자가 들어가는 직원들의 사번, 사원명, 부서명을 조회하세요.
select e.emp_id, e.emp_name, d.DEPT_TITLE from employee e
    join DEPARTMENT d  on e.DEPT_CODE = d.DEPT_ID
    where e.EMP_NAME like '%형%';
    
-- 4. 부서별 급여 평균이 300만원 이하인 부서의 부서명과 급여 평균을 출력하세요
-- > 급여 평균은 10000의 자리 아래로 버리고 출력해주세요. 
-- > 또한 한국 로컬 통화 표기법으로 출력해주세요. (￦3,520,000)
select d.DEPT_TITLE, to_char(avg(salary), 'L999,999,999') from employee e
    join department d on e.DEPT_CODE=d.DEPT_ID
    where salary<'3000000' group by d.DEPT_TITLE;
-- 5. 해외영업부에 근무하는 사원명, 직급명, 부서코드, 부서명을 조회하세요.
select * from employee e
    join department d on e.dept_code=d.dept_id    
    where d.dept_title ='해외영업부';
-- 6. 보너스포인트를 받는 직원들의 사원명, 보너스포인트, 부서명, 근무지역명을 조회하세요.
select e.emp_name, e.bonus, d.dept_title, l.LOCAL_NAME from employee e
    join department d on e.DEPT_CODE=d.dept_id
    join location l on d.LOCATION_ID=l.LOCAL_CODE
    where NVL(bonus, 0) != 0;
-- 7. 부서코드가 D2인 직원들의 사원명, 직급명, 부서명, 근무지역명을 조회하세요.
select e.emp_name, j.JOB_NAME, d.DEPT_TITLE, n.NATIONAL_NAME from employee e
    join JOB j on j.JOB_CODE = e.JOB_CODE
    join department d on e.DEPT_CODE=d.dept_id
    join location l on d.LOCATION_ID = l.LOCAL_CODE
    join NATIONAL n on l.NATIONAL_CODE = n.NATIONAL_CODE
    where e.DEPT_CODE = 'D2';
-- 8. 한국(KO)과 일본(JP)에 근무하는 직원들의 사원명, 부서명, 근무지역명, 국가명을 조회하세요.
select e.emp_name, d.DEPT_TITLE, l.LOCAL_NAME, n.NATIONAL_NAME
    from employee e
    join DEPARTMENT d on e.DEPT_CODE = d.DEPT_ID
    join LOCATION l on d.LOCATION_ID = l.LOCAL_CODE
    join NATIONAL n on l.NATIONAL_CODE = n.NATIONAL_CODE
    where l.national_code = 'KO' or l.national_code = 'JP';
-- 9. 모든 사원 중 선동일을 매니저로 두고 있는 직원의 이름, 직원의 부서명, 매니저의 이름을 출력하세요.
select e1.emp_name, e1.DEPT_CODE, e1.EMP_NAME
    from employee e1
    join employee e2 on e1.MANAGER_ID = e2.emp_id
    join DEPARTMENT d on e1.DEPT_CODE = d.DEPT_ID
where e2.emp_name = '선동일';
-- 10. 보너스포인트가 없는 직원들 중에서 직급이 차장과 사원인 직원들의 사원명, 직급명, 급여를 조회하세요 (join과 in 사용)
select e.emp_name 사원명, k.JOB_NAME 직급명, e.salary from employee e
    join department d on e.DEPT_CODE=d.dept_id
    join JOB k on e.JOB_CODE=k.JOB_CODE
    where (NVL(e.bonus,0)) in (0) 
    and k.job_name in '차장';
-- 11. 재직중인 직원과 퇴사한 직원의 수를 조회하세요.
select 
    count(case when a.ENT_YN='N' then 1 end) as 재직자, 
    count(case when b.ent_yn = 'Y' then 1 end) as 퇴사자 from employee a 
    join employee b on a.emp_id=b.emp_id;