--1. �� ������б��� �а� �̸��� �迭�� ǥ���Ͻÿ�. ��, ��� ����� "�а� ��", "�迭" ���� ǥ���ϵ��� ����.
select department_name as "�а� ��", category as "�迭" from tb_department;
--2. �а��� �а� ������ ������ ���� ���·� ȭ�鿡 �������.
select department_name, capacity from tb_department;
--3. "������а�" �� �ٴϴ� ���л� �� ���� �������� ���л��� ã�ƴ޶�� ��û�� ���Դ�. �����ΰ�? (�����а��� '�а��ڵ�'�� �а� ���̺�(TB_DEPARTMENT)�� ��ȸ�ؼ� ã�� ������ ����)
select * from TB_STUDENT student
    join TB_DEPARTMENT depart on depart.DEPARTMENT_NO = student.DEPARTMENT_NO 
    where student.STUDENT_NAME = '�Ѽ���';
--4. ���������� ���� ���� ��� ��ü�� ���� ã�� �̸��� �Խ��ϰ��� ����. �� ����ڵ��� �й��� ������ ���� �� ����ڵ��� ã�� ������ SQL ������ �ۼ��Ͻÿ�.
select student_name from TB_STUDENT 
    where student_no = 'A513079' or student_no = 'A513090' or student_no = 'A513091' or student_no = 'A513110'or student_no = 'A513119';
--A513079, A513090, A513091, A513110, A513119
--5. ���������� 20�� �̻� 30�� ������ �а����� �а� �̸��� �迭�� ����Ͻÿ�.
select department_name as "�а� �̸�", category as "�迭"
    from TB_DEPARTMENT where capacity between 20 and 30;
--6. �� ������б��� ������ �����ϰ� ��� �������� �Ҽ� �а��� ������ �ִ�. �׷� �� ������б� ������ �̸��� �˾Ƴ� �� �ִ� SQL ������ �ۼ��Ͻÿ�.
select professor_name from TB_PROFESSOR where DEPARTMENT_NO is null;
--7. Ȥ�� ������� ������ �а��� �����Ǿ� ���� ���� �л��� �ִ��� Ȯ���ϰ��� ����. ��� SQL ������ ����ϸ� �� ������ �ۼ��Ͻÿ�.
select * from TB_STUDENT where DEPARTMENT_NO is null;
--8. ������û�� �Ϸ��� ����. �������� ���θ� Ȯ���ؾ� �ϴµ�, ���������� �����ϴ� ������� � �������� �����ȣ�� ��ȸ�غ��ÿ�.
select * from TB_CLASS class1
    join TB_CLASS class2 on class1.PREATTENDING_CLASS_NO = class2.CLASS_NO;
--9. �� ���п��� � �迭(CATEGORY)���� �ִ��� ��ȸ�غ��ÿ�.
select distinct category from TB_DEPARTMENT;
--10. 02�й� ���� �����ڵ��� ������ ������� ����. ������ ������� �����ϰ� �������� �л����� �й�, �̸�, �ֹι�ȣ�� ����ϴ� ������ �ۼ��Ͻÿ�.
select STUDENT_NO as "�й�", TB_STUDENT.STUDENT_NAME as "�̸�", TB_STUDENT.STUDENT_SSN as "�ֹι�ȣ"
    from TB_STUDENT where student_address like '%����%' and absence_yn ='N';
--11. ������а�(�а��ڵ� 002) �л����� �й��� �̸�, ���� �⵵�� ���� �⵵�� ���� ������ ǥ���ϴ� SQL ������ �ۼ��Ͻÿ�.( ��, ����� "�й�", "�̸�", "���г⵵" �� ǥ�õǵ��� ����.)
select * from TB_STUDENT 
    where DEPARTMENT_NO = '002'
    order by ENTRANCE_DATE;
--2. �� ������б��� ���� �� �̸��� �� ���ڰ� �ƴ� ������ �� �� �ִٰ� ����. �� ������ �̸��� �ֹι�ȣ�� ȭ�鿡 ����ϴ� SQL ������ �ۼ��� ����. (* �̶� �ùٸ��� �ۼ��� SQL ������ ��� ���� ����� �ٸ��� ���� �� �ִ�. ������ �������� �����غ� ��)
select professor_name, PROFESSOR_SSN from TB_PROFESSOR where length(professor_name)!=3; 
--3. �� ������б��� ���� �������� �̸��� ���̸� ����ϴ� SQL ������ �ۼ��Ͻÿ�. �� �̶� ���̰� ���� ������� ���� ��� ������ ȭ�鿡 ��µǵ��� ����ÿ�. (��, ���� �� 2000�� ���� ����ڴ� ������ ��� ����� "�����̸�", "����"�� ����. ���̴� ���������� �������.)
select professor_name, tb_professor.PROFESSOR_NAME, to_number(sysdate-to_number('19' || substr(professor_ssn,1,2))) from tb_professor
    where PROFESSOR_SSN like '%-1%'
    order by professor_ssn;

select to_number('19' || substr(professor_ssn,1,2)) from TB_PROFESSOR;
--4. �������� �̸� �� ���� ������ �̸��� ����ϴ� SQL ������ �ۼ��Ͻÿ�. ��� ����� ?�̸�? �� �������� ����. (���� 2���� ���� ������ ���ٰ� �����Ͻÿ�)
select substr(PROFESSOR_NAME, 2)from tb_professor;
--5. �� ������б��� ����� �����ڸ� ���Ϸ��� ����. ��� ã�Ƴ� ���ΰ�? �̶�, 19�쿡 �����ϸ� ����� ���� ���� ������ �A������.
select to_char(substr(ENTRANCE_DATE,1,2))-to_char(substr(student_ssn,1,2)) from tb_student;
select substr(ENTRANCE_DATE,1,2)-substr(student_ssn,1,2) from tb_student;
SELECT
    to_number(SUBSTR(ENTRANCE_DATE, 1, 2))- to_number(to_char(19||substr(student_ssn,1,2))) AS ssn_prefix
FROM
    tb_student;


--6. 2020�� ũ���������� ���� �����ΰ�?
select to_char(to_date('20201225'), 'dy') from dual;
--7. TO_DATE('99/10/11','YY/MM/DD'), TO_DATE('49/10/11','YY/MM/DD') �� ���� �� �� �� �� �� ���� �ǹ�����? �� TO_DATE('99/10/11','RR/MM/DD'), TO_DATE('49/10/11','RR/MM/DD') �� ���� �� �� �� �� �� ���� �ǹ�����?

--8. �� ������б��� 2000�⵵ ���� �����ڵ��� �й��� A�� �����ϰ� �Ǿ��ִ�. 2000�⵵ �̠� �й��� ���� �л����� �й��� �̸��� �����ִ� SQL ������ �ۼ��Ͻÿ�.
select student_no, student_name from tb_student where student_no not like 'A%';
--9. �й��� A517178 �� ���Ƹ� �л��� ���� �� ������ ���ϴ� SQL ���� �ۼ��Ͻÿ�. ��, �̶� ��� ȭ���� ����� "����" �̶�� ������ �ϰ�, ������ �ݿø��Ͽ� �Ҽ��� ���� �� �ڸ������� ǥ������.
select to_char(avg(point), 'fm999.9') from tb_student student
    join tb_grade grade on student.STUDENT_NO = grade.STUDENT_NO
    where student.student_no = 'A517178';
--10. �а��� �л����� ���Ͽ� "�а���ȣ", "�л���(��)" �� ���·� ����� ����� ������� ��µǵ��� �Ͻÿ�.
select dept.DEPARTMENT_NO as "�а���ȣ", count(student.STUDENT_NO) as "�л���" from tb_student student 
    join TB_DEPARTMENT dept
        on student.DEPARTMENT_NO = dept.DEPARTMENT_NO
    group by dept.DEPARTMENT_NO
    order by dept.DEPARTMENT_NO;
--11. ���� ������ �������� ���� �л��� ���� �� �� ���� �Ǵ� �˾Ƴ��� SQL ���� �ۼ��Ͻÿ�.
select count(*) from TB_STUDENT where COACH_PROFESSOR_NO is null;
--12. �й��� A112113�� ���� �л��� �⵵ �� ������ ���ϴ� SQL ���� �ۼ��Ͻÿ�. ��, �̶� ��� ȭ���� ����� "�⵵", "�⵵ �� ����" �̶�� ������ �ϰ�, ������ �ݿø��Ͽ� �Ҽ��� ���� �� �ڸ������� ǥ������.
select substr(term_no,1,4) as "�⵵", to_char(avg(grade.point), 'fm999.9') as "�⵵�� ����" from TB_STUDENT student
    join tb_grade grade 
        on student.STUDENT_NO = grade.STUDENT_NO
    where student.STUDENT_NO = 'A112113'
    group by substr(term_no, 1,4);
select substr(term_no, 1, 4)from tb_grade;
--13. �а� �� ���л� ���� �ľ��ϰ��� ����. �а� ��ȣ�� ���л� ���� ǥ���ϴ� SQL ������ �ۼ��Ͻÿ�.
select dept.DEPARTMENT_NAME, count(*) as "���л� ��" from TB_STUDENT student
    join TB_DEPARTMENT dept
        on student.DEPARTMENT_NO = dept.DEPARTMENT_NO
    where student.ABSENCE_YN = 'Y'
    group by dept.DEPARTMENT_NAME;
--14. �� ���б��� �ٴϴ� ��������(��٣���) �л����� �̸��� ã���� ����. � SQL ������ ����ϸ� �����ϰڴ°�?
SELECT student_name, COUNT(*) OVER(PARTITION BY student_name) AS sname_cnt
  FROM tb_student;

--15. �й��� A112113 �� ���� �л��� �⵵, �б� �� ������ �⵵ �� ���� ���� , �� ������ ���ϴ� SQL ���� �ۼ��Ͻÿ�. (��, ������ �Ҽ��� 1�ڸ������� �ݿø��Ͽ� ǥ������.)
select substr(term_no,1,4) as "�⵵", to_char(avg(grade.point), 'fm999.9') as "�⵵�� ����"
    from TB_STUDENT student
    join tb_grade grade 
        on student.STUDENT_NO = grade.STUDENT_NO
    where student.STUDENT_NO = 'A112113'
    group by substr(term_no, 1,4) 
    
    union 
    
select term_no as "�⵵", to_char(avg(grade.point), 'fm999.9') as "�⵵�� ����"
    from TB_STUDENT student
    join tb_grade grade 
        on student.STUDENT_NO = grade.STUDENT_NO
    where student.STUDENT_NO = 'A112113'
    group by term_no
    
    union

select '������', to_char(avg(grade.point),'fm999.9')
    from TB_STUDENT student
    join tb_grade grade 
        on student.STUDENT_NO = grade.STUDENT_NO
    where student.STUDENT_NO = 'A112113';
    
--1. �л��̸��� �ּ����� ǥ���Ͻÿ�. ��, ��� ����� "�л� �̸�", "�ּ���"�� �ϰ�, ������ �̸����� �������� ǥ���ϵ��� ����.
select STUDENT_NAME, student_address 
    from tb_student
    order by student_name ASC;
--2. �������� �л����� �̸��� �ֹι�ȣ�� ���̰� ���� ������ ȭ�鿡 ����Ͻÿ�.
SELECT STUDENT_NAME, STUDENT_SSN FROM TB_STUDENT
    WHERE ABSENCE_YN ='Y'
    order by to_char(sysdate-'19'||substr(STUDENT_SSN,1,2)) desc; 
--3. �ּ����� �������� ��⵵�� �л��� �� 1900��� �й��� ���� �л����� �̸��� �й�, �ּҸ� �̸��� ������������ ȭ�鿡 ����Ͻÿ�. 
--��, ���������� "�л��̸�","�й�", "������ �ּ�" �� ��µǵ��� ����.
select STUDENT_NAME, tb_student.STUDENT_NO,tb_student.STUDENT_ADDRESS from tb_student 
    where student_address like '%������%' 
    or student_address like '%��⵵%'
    and student_no like '9%';
--4. ���� ���а� ���� �� ���� ���̰� ���� ������� �̸��� Ȯ���� �� �ִ� SQL ������ �ۼ��Ͻÿ�. (���а��� '�а��ڵ�'�� �а� ���̺�(TB_DEPARTMENT)�� ��ȸ�ؼ� ã�� ������ ����)
select prof.PROFESSOR_NAME, prof.PROFESSOR_SSN from tb_professor prof 
    join tb_department dept 
        on prof.DEPARTMENT_NO = dept.DEPARTMENT_NO
    where dept.DEPARTMENT_NAME like '%���а�%'
    order by substr(professor_ssn, 1, 4);
--5. 2004��2�б⿡ 'C3118100' ������ ������ �л����� ������ ��ȸ�Ϸ��� ����. ������ ���� �л����� ǥ���ϰ�, ������ ������ �й��� ���� �л����� ǥ���ϴ� ������ �ۼ��غ��ÿ�.
select * from TB_STUDENT student
    join TB_CLASS class 
        on student.STUDENT_NO = class.CLASS_NO
    join TB_GRADE grade
        on grade.class_no = class.CLASS_NO
    where class.CLASS_NO = 'C3118100'
    order by grade.POINT desc;
--6. �л� ��ȣ, �л� �̸�,  �а� �̸��� �л� �̸����� �������� �����Ͽ� ����ϴ� SQL ���� �ۼ��Ͻÿ�.
select student.STUDENT_no, student.STUDENT_NAME, dept.DEPARTMENT_NAME from TB_STUDENT student
    join TB_DEPARTMENT dept
    on student.DEPARTMENT_NO = dept.DEPARTMENT_NO
    order by student.STUDENT_NAME;
--7. �� ������б��� ���� �̸��� ������ �а� �̸��� ����ϴ� SQL ������ �ۼ��Ͻÿ�.
select info.CLASS_NAME as "�����̸�", dept.DEPARTMENT_NAME as "�а��̸�" from tb_class info
    join TB_DEPARTMENT dept
        on info.DEPARTMENT_NO = dept.DEPARTMENT_NO;
--8. ���� ���� �̸��� ã������ ����. ���� �̸��� ���� �̸��� ����ϴ� SQL ���� �ۼ��Ͻÿ�.
select class.CLASS_NAME, prof.PROFESSOR_NAME from TB_CLASS class
    join TB_CLASS_PROFESSOR class_Prof
        on class.CLASS_NO = class_Prof.CLASS_NO
    join TB_PROFESSOR prof
        on class_Prof.professor_no = prof.PROFESSOR_NO;
--8���� ��� �� ���ι���ȸ�� �迭�� ���� ������ ���� �̸��� ã������ ����. �̿� �ش��ϴ� ���� �̸��� ���� �̸��� ����ϴ� SQL ���� �ۼ��Ͻÿ�.
select class.CLASS_NAME, prof.PROFESSOR_NAME from TB_CLASS class
    join TB_CLASS_PROFESSOR class_Prof
        on class.CLASS_NO = class_Prof.CLASS_NO
    join TB_PROFESSOR prof
        on class_Prof.professor_no = prof.PROFESSOR_NO
    join TB_DEPARTMENT dept
        on prof.DEPARTMENT_NO = dept.DEPARTMENT_NO
    where dept.CATEGORY = '�ι���ȸ';
--10. �������а��� �л����� ������ ���Ϸ��� ����. �����а� �л����� "�й�", "�л� �̸�", "��ü ����"�� ����ϴ� SQL ������ �ۼ��Ͻÿ�. (��, ������ �Ҽ��� 1�ڸ������� �ݿø��Ͽ� ǥ������.)
select student.student_no, student.student_name, to_char(avg(point), 'fm999.9') from TB_STUDENT student
    left join TB_DEPARTMENT dept
        on student.DEPARTMENT_NO = dept.DEPARTMENT_NO
    join TB_GRADE grade
        on student.student_no = grade.STUDENT_NO
    where dept.department_name = '�����а�'
    group by student.STUDENT_NAME, student.student_no;
--11. �й��� A313047�� �л��� �б��� ������ ���� �ʴ�. ���� �������� ������ �����ϱ� ���� �а� �̸�, �л� �̸��� ���� ���� �̸��� �ʿ��ϴ�
--�̶� ����� SQL ���� �ۼ��Ͻÿ�. ��, �������� ?�а��̸�?, ?�л��̸�?, ?���������̸�?���� ��µǵ��� ����.
select dept.DEPARTMENT_NAME, student.STUDENT_NAME, prof.PROFESSOR_NAME from tb_student student
    join TB_PROFESSOR prof
        on student.COACH_PROFESSOR_NO = prof.PROFESSOR_NO
    join TB_DEPARTMENT dept
        on student.DEPARTMENT_NO = dept.DEPARTMENT_NO
    where student.STUDENT_NO = 'A313047';
--12. 2007�⵵�� '�΁A�����' ������ ������ �л��� ã�� �л��̸��� �����б⸧ ǥ���ϴ� SQL ������ �ۼ��Ͻÿ�.
select student.STUDENT_NAME, grade.TERM_NO from TB_STUDENT student
    join TB_GRADE grade
        on student.STUDENT_NO = grade.STUDENT_NO
    join tb_class class
        on class.class_no = grade.CLASS_NO
    where class.CLASS_NAME = '�ΰ������' and grade.term_no like '2007%';
--13. ��ü�� �迭 ���� �� ���� ��米���� �� �� �������� ���� ������ ã�� �� ���� �̸��� �а� �̸��� ����ϴ� SQL ������ �ۼ��Ͻÿ�.
select class.CLASS_NAME, dept.DEPARTMENT_NAME from tb_class class
    join tb_department dept
        on class.DEPARTMENT_NO = dept.DEPARTMENT_NO
    full outer join TB_CLASS_PROFESSOR class_prof
        on class_prof.CLASS_NO = class.CLASS_NO
    full outer join TB_PROFESSOR prof
        on class_prof.PROFESSOR_NO = prof.PROFESSOR_NO
    where dept.CATEGORY = '��ü��' and class_prof.professor_no is null;
--14. �� ������б� ���ݾƾ��а� �л����� ���������� �Խ��ϰ��� ����. 
--�л��̸��� �������� �̸��� ã�� ���� ���� ������ ���� �л��� ��� "�������� ������?���� ǥ���ϵ��� �ϴ� SQL ���� �ۼ��Ͻÿ�. 
--��, �������� ?�л��̸�?, ?��������?�� ǥ���ϸ� ���й� �л��� ���� ǥ�õǵ��� ����.
select stud.student_name, nvl(professor_name, '�������� ������') from TB_STUDENT stud
    left join TB_PROFESSOR prof
        on stud.COACH_PROFESSOR_NO = prof.PROFESSOR_NO
    join TB_DEPARTMENT dept
        on stud.DEPARTMENT_NO = dept.DEPARTMENT_NO
    where department_name = '���ݾƾ��а�';
--15. ���л��� �ƴ� �л� �� ������ 4.0 �̻��� �л��� ã�� �� �л��� �й�, �̸�, �а� �̸�, ������ ����ϴ� SQL ���� �ۼ��Ͻÿ�.
select stud.student_no, stud.student_name, dept.department_name, to_char(avg(point),'fm999.9') from TB_STUDENT stud
    join TB_GRADE grade 
        on stud.student_no = grade.STUDENT_NO
    join TB_DEPARTMENT dept
        on stud.DEPARTMENT_NO = dept.DEPARTMENT_NO
    where stud.ABSENCE_YN = 'N'
    group by stud.STUDENT_NO, stud.student_name, dept.department_name
    having avg(point)>4.0;
--16. �Q�������а� ����������� ���� �� ������ �ľ��� �� �ִ� SQL ���� �ۼ��Ͻÿ�.
select to_char(avg(point),'fm999.99') from TB_CLASS class
    join tb_grade grade 
        on class.CLASS_NO = grade.CLASS_NO
    join TB_DEPARTMENT dept
        on class.DEPARTMENT_NO = dept.DEPARTMENT_NO
    where dept.department_NAME = 'ȯ�������а�'
    group by class.CLASS_NO;
--17. �� ������б��� �ٴϰ� �ִ� �ְ��� �л��� ���� �� �л����� �̸��� �ּҸ� ����ϴ� SQL ���� �ۼ��Ͻÿ�.
select student_name as "name", student_address as "address" from tb_student stud
    join TB_DEPARTMENT dept
       on stud.department_no = dept.department_no
    where dept.department_no = 
        (select dept.department_no from tb_department dept 
            join TB_STUDENT stud
                on dept.DEPARTMENT_NO = stud.DEPARTMENT_NO
            where stud.STUDENT_NAME ='�ְ���');
    --18. ������а����� �� ������ ���� ���� �л��� �̸��� �й��� ǥ���ϴ� SQL���� �ۼ��Ͻÿ�. !!
SELECT
    stud.STUDENT_NAME,
    stud.STUDENT_NO
FROM
    tb_student stud
    JOIN TB_DEPARTMENT dept ON stud.DEPARTMENT_NO = dept.DEPARTMENT_NO
    JOIN TB_GRADE grade ON stud.STUDENT_NO = grade.STUDENT_NO
WHERE
    dept.DEPARTMENT_NAME = '������а�'
GROUP BY
    stud.STUDENT_NAME,
    stud.STUDENT_NO
HAVING
    SUM(grade.POINT) = (
        SELECT
            MAX(total_points)
        FROM
            (
                SELECT
                    SUM(g.POINT) AS total_points
                FROM
                    TB_GRADE g
                    JOIN tb_student s ON g.STUDENT_NO = s.STUDENT_NO
                    JOIN TB_DEPARTMENT d ON s.DEPARTMENT_NO = d.DEPARTMENT_NO
                WHERE
                    d.DEPARTMENT_NAME = '������а�'
                GROUP BY
                    g.STUDENT_NO
            )
    );

--19. �� ������б��� "�Q�������а�"�� ���� ���� �迭 �а����� �а� �� �������� ������ �ľ��ϱ� ���� ������ SQL ���� ã�Ƴ��ÿ�.
--��, �������� "�迭 �а���", "��������"���� ǥ�õǵ��� �ϰ�, ������ �Ҽ��� �� �ڸ������� �ݿø��Ͽ� ǥ�õǵ��� ����.
select dept.CATEGORY, to_char(avg(point),'fm999.9') from tb_grade grade
    join tb_class class
        on grade.CLASS_NO = class.CLASS_NO
    join TB_DEPARTMENT dept
        on class.department_no = dept.department_no
    where dept.category = (select CATEGORY from TB_DEPARTMENT where department_name = 'ȯ�������а�')
    group by dept.CATEGORY;
    
    select CATEGORY from TB_DEPARTMENT where department_name = 'ȯ�������а�'
----1. �迭 ������ ������ ī�װ� ���̺��� ������� ����. ������ ���� ���̺��� �ۼ��Ͻÿ�.
--2. ���� ������ ������ ���̺��� ������� ����. ������ ���� ���̺��� �ۼ��Ͻÿ�.
--3. TB_CATAGORY ���̺��� NAME �÷��� PRIMARY KEY�� �����Ͻÿ�. (KEY �̸��� �������� �ʾƵ� ������. ���� KEY �̸� �����ϰ��� ���ٸ� �̸��� ������ �˾Ƽ� ������ �̸��� �������.)
--4. TB_CLASS_TYPE ���̺��� NAME �÷��� NULL ���� ���� �ʵ��� �Ӽ��� �����Ͻÿ�.
--5. �� ���̺��� �÷� ���� NO�� ���� ���� Ÿ���� �����ϸ鼭 ũ��� 10 ����, �÷����� NAME �� ���� ���C������ ���� Ÿ���� �����ϸ鼭 ũ�� 20 ���� �����Ͻÿ�.
--6. �� ���̺��� NO �÷��� NAME �÷��� �̸��� �� �� TB_ �� ������ ���̺� �̸��� �տ� ���� ���·� ��������.
--7. TB_CATAGORY ���̺�� TB_CLASS_TYPE ���̺��� PRIMARY KEY �̸��� ������ ���� �����Ͻÿ�. Primary Key�� �̸��� ?PK_ + �÷��̸�?���� �����Ͻÿ�. (ex. PK_CATEGORY_NAME )
--8. ������ ����INSERT ���� ��������.
--9.TB_DEPARTMENT�� CATEGORY �÷��� TB_CATEGORY ���̺��� CATEGORY_NAME �÷��� �θ� ������ �����ϵ��� FOREIGN KEY�� �����Ͻÿ�. �� �� KEY �̸��� FK_���̺��̸�_�÷��̸����� ��������. (ex. FK_DEPARTMENT_CATEGORY )
--10. �� ������б� �л����� �������� ���ԵǾ� �ִ� �л��Ϲ����� VIEW�� ������� ����. �Ʒ� ������ �����Ͽ� ������ SQL ���� �ۼ��Ͻÿ�.
--11. �� ������б��� 1�⿡ �� ���� �а����� �л��� ���������� ���� ����� ��������. �̸� ���� ����� �л��̸�, �а��̸�, ��米���̸� ���� �����Ǿ� �ִ� VIEW �� ����ÿ�. �̶� ���� ������ ���� �л��� ���� �� ������ ����Ͻÿ� (��, �� VIEW �� �ܼ� SELECT ���� �� ��� �а����� ���ĵǾ� ȭ�鿡 �������� ����ÿ�.)
--12. ��� �а��� �а��� �л� ���� Ȯ���� �� �ֵ��� ������ VIEW �� �ۼ��� ����.
--13. ������ ������ �л��Ϲ����� View�� ���ؼ� �й��� A213046�� �л��� �̸��� ���� �̸����� �����ϴ� SQL ���� �ۼ��Ͻÿ�.
--14. 13�������� ���� VIEW�� ���ؼ� �����Ͱ� ����� �� �ִ� ��Ȳ�� �������� VIEW�� ��� �����ؾ� �ϴ��� �ۼ��Ͻÿ�.
--15. �� ������б��� �ų� ������û ��A�� �Ǹ� Ư�� �α� ����鿡 ���� ��û�� ���� ������ �ǰ� �ִ�. �ֱ� 3���� �������� �����ο��� ���� ���Ҵ� 3 ������ ã�� ������ �ۼ��غ��ÿ�.
--1. �������� ���̺�(TB_CLASS_TYPE)�� �Ʒ��� ���� �����͸� �Է��Ͻÿ�.
--2. �� ������б� �л����� ������ ���ԵǾ� �ִ� �л��Ϲ����� ���̺��� ������� ����. �Ʒ� ������ �����Ͽ� ������ SQL ���� �ۼ��Ͻÿ�. (���������� �̿��Ͻÿ�)
--3. ������а� �л����� �������� ���ԵǾ� �ִ� �а����� ���̺��� ������� ����. �Ʒ� ������ �����Ͽ� ������ SQL ���� �ۼ��Ͻÿ�. (��Ʈ : ����� �پ���, �ҽŲ� �ۼ��Ͻÿ�)
--4. �� �а����� ������ 10% ������Ű�� �Ǿ���. �̿� ����� SQL ���� �ۼ��Ͻÿ�. (��, �ݿø��� ����Ͽ� �Ҽ��� �ڸ����� ������ �ʵ��� ����)
--5. �й� A413042�� �ڰǿ� �л��� �ּҰ� "����� ���α� ���ε� 181-21 "�� ����Ǿ��ٰ� ����. �ּ����� �����ϱ� ���� ����� SQL ���� �ۼ��Ͻÿ�.
--6. �ֹε�Ϲ�ȣ ��ȣ���� ���� �л����� ���̺��� �ֹι�ȣ ���ڸ��� �������� �ʱ�� �����Ͽ���. �� ������ �ݿ��� ������ SQL ������ �ۼ��Ͻÿ�.
--7. ���а� ����� �л��� 2005�� 1�б⿡ �ڽ��� ������ '�Ǻλ�����' ������ �߸��Ǿ��ٴ� ���� �߰��ϰ�� ������ ��û�Ͽ���. ��� ������ Ȯ�� ���� ��� �ش� ������ ������ 3.5�� ����Ű�� �����Ǿ���. ������ SQL ���� �ۼ��Ͻÿ�.
--8. ���� ���̺�(TB_GRADE) ���� ���л����� �����׸��� �����Ͻÿ�.
