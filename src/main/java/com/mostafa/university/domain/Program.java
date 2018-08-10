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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Program generated by hbm2java
 */
@Entity
@Table(name="program"
    ,catalog="university"
)
public class Program  implements java.io.Serializable {


     private Integer proId;
     private String proName;
     private Set<Exam> exams = new HashSet<Exam>(0);
     private Set<Subject> subjects = new HashSet<Subject>(0);
     private Set<FinalResult> finalResults = new HashSet<FinalResult>(0);
     private Set<SemisterResult> semisterResults = new HashSet<SemisterResult>(0);
     private Set<StudentAssigne> studentAssignes = new HashSet<StudentAssigne>(0);

    public Program() {
    }

	
    public Program(String proName) {
        this.proName = proName;
    }
    public Program(String proName, Set<Exam> exams, Set<Subject> subjects, Set<FinalResult> finalResults, Set<SemisterResult> semisterResults, Set<StudentAssigne> studentAssignes) {
       this.proName = proName;
       this.exams = exams;
       this.subjects = subjects;
       this.finalResults = finalResults;
       this.semisterResults = semisterResults;
       this.studentAssignes = studentAssignes;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="pro_id", unique=true, nullable=false)
    public Integer getProId() {
        return this.proId;
    }
    
    public void setProId(Integer proId) {
        this.proId = proId;
    }

    
    @Column(name="pro_name", nullable=false, length=45)
    public String getProName() {
        return this.proName;
    }
    
    public void setProName(String proName) {
        this.proName = proName;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="program")
    public Set<Exam> getExams() {
        return this.exams;
    }
    
    public void setExams(Set<Exam> exams) {
        this.exams = exams;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="program")
    public Set<Subject> getSubjects() {
        return this.subjects;
    }
    
    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="program")
    public Set<FinalResult> getFinalResults() {
        return this.finalResults;
    }
    
    public void setFinalResults(Set<FinalResult> finalResults) {
        this.finalResults = finalResults;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="program")
    public Set<SemisterResult> getSemisterResults() {
        return this.semisterResults;
    }
    
    public void setSemisterResults(Set<SemisterResult> semisterResults) {
        this.semisterResults = semisterResults;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="program")
    public Set<StudentAssigne> getStudentAssignes() {
        return this.studentAssignes;
    }
    
    public void setStudentAssignes(Set<StudentAssigne> studentAssignes) {
        this.studentAssignes = studentAssignes;
    }




}


