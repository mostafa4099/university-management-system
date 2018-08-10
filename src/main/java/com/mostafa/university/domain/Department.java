package com.mostafa.university.domain;
// Generated Aug 2, 2018 10:23:44 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Department generated by hbm2java
 */
@Entity
@Table(name="department"
    ,catalog="university"
    , uniqueConstraints = @UniqueConstraint(columnNames="dep_name") 
)
public class Department  implements java.io.Serializable {


     private Integer depId;
     private Faculty faculty;
     private String depName;
     private String depTitle;
     private String depSubTitle;
     private String depDesc;
     private Set<Exam> exams = new HashSet<Exam>(0);
     private Set<StudentAssigne> studentAssignes = new HashSet<StudentAssigne>(0);
     private Set<FinalResult> finalResults = new HashSet<FinalResult>(0);
     private Set<Subject> subjects = new HashSet<Subject>(0);
     private Set<Teachers> teacherses = new HashSet<Teachers>(0);
     private Set<SemisterResult> semisterResults = new HashSet<SemisterResult>(0);

    public Department() {
    }

	
    public Department(Faculty faculty, String depName) {
        this.faculty = faculty;
        this.depName = depName;
    }
    public Department(Faculty faculty, String depName, String depTitle, String depSubTitle, String depDesc, Set<Exam> exams, Set<StudentAssigne> studentAssignes, Set<FinalResult> finalResults, Set<Subject> subjects, Set<Teachers> teacherses, Set<SemisterResult> semisterResults) {
       this.faculty = faculty;
       this.depName = depName;
       this.depTitle = depTitle;
       this.depSubTitle = depSubTitle;
       this.depDesc = depDesc;
       this.exams = exams;
       this.studentAssignes = studentAssignes;
       this.finalResults = finalResults;
       this.subjects = subjects;
       this.teacherses = teacherses;
       this.semisterResults = semisterResults;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="dep_id", unique=true, nullable=false)
    public Integer getDepId() {
        return this.depId;
    }
    
    public void setDepId(Integer depId) {
        this.depId = depId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fac_id", nullable=false)
    public Faculty getFaculty() {
        return this.faculty;
    }
    
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    
    @Column(name="dep_name", unique=true, nullable=false, length=45)
    public String getDepName() {
        return this.depName;
    }
    
    public void setDepName(String depName) {
        this.depName = depName;
    }

    
    @Column(name="dep_title", length=300)
    public String getDepTitle() {
        return this.depTitle;
    }
    
    public void setDepTitle(String depTitle) {
        this.depTitle = depTitle;
    }

    
    @Column(name="dep_sub_title", length=300)
    public String getDepSubTitle() {
        return this.depSubTitle;
    }
    
    public void setDepSubTitle(String depSubTitle) {
        this.depSubTitle = depSubTitle;
    }

    
    @Column(name="dep_desc", length=5000)
    public String getDepDesc() {
        return this.depDesc;
    }
    
    public void setDepDesc(String depDesc) {
        this.depDesc = depDesc;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="department")
    public Set<Exam> getExams() {
        return this.exams;
    }
    
    public void setExams(Set<Exam> exams) {
        this.exams = exams;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="department")
    public Set<StudentAssigne> getStudentAssignes() {
        return this.studentAssignes;
    }
    
    public void setStudentAssignes(Set<StudentAssigne> studentAssignes) {
        this.studentAssignes = studentAssignes;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="department")
    public Set<FinalResult> getFinalResults() {
        return this.finalResults;
    }
    
    public void setFinalResults(Set<FinalResult> finalResults) {
        this.finalResults = finalResults;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="department")
    public Set<Subject> getSubjects() {
        return this.subjects;
    }
    
    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="department")
    public Set<Teachers> getTeacherses() {
        return this.teacherses;
    }
    
    public void setTeacherses(Set<Teachers> teacherses) {
        this.teacherses = teacherses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="department")
    public Set<SemisterResult> getSemisterResults() {
        return this.semisterResults;
    }
    
    public void setSemisterResults(Set<SemisterResult> semisterResults) {
        this.semisterResults = semisterResults;
    }




}


