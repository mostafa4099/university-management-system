package com.mostafa.university.domain;
// Generated Aug 2, 2018 10:23:44 AM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * FinalResult generated by hbm2java
 */
@Entity
@Table(name="final_result"
    ,catalog="university"
)
public class FinalResult  implements java.io.Serializable {


     private Integer cgpaId;
     private Department department;
     private Grade grade;
     private Program program;
     private StudentInfo studentInfo;
     private double cgpa;

    public FinalResult() {
    }

    public FinalResult(Department department, Grade grade, Program program, StudentInfo studentInfo, double cgpa) {
       this.department = department;
       this.grade = grade;
       this.program = program;
       this.studentInfo = studentInfo;
       this.cgpa = cgpa;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="cgpa_id", unique=true, nullable=false)
    public Integer getCgpaId() {
        return this.cgpaId;
    }
    
    public void setCgpaId(Integer cgpaId) {
        this.cgpaId = cgpaId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="dep_id", nullable=false)
    public Department getDepartment() {
        return this.department;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="grade_id", nullable=false)
    public Grade getGrade() {
        return this.grade;
    }
    
    public void setGrade(Grade grade) {
        this.grade = grade;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="pro_id", nullable=false)
    public Program getProgram() {
        return this.program;
    }
    
    public void setProgram(Program program) {
        this.program = program;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="st_id", nullable=false)
    public StudentInfo getStudentInfo() {
        return this.studentInfo;
    }
    
    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    
    @Column(name="cgpa", nullable=false, precision=22, scale=0)
    public double getCgpa() {
        return this.cgpa;
    }
    
    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }




}

