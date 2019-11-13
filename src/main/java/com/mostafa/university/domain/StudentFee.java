package com.mostafa.university.domain;
// Generated Aug 2, 2018 10:23:44 AM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * StudentFee generated by hbm2java
 */
@Entity
@Table(name="student_fee"
    ,catalog="university"
)
public class StudentFee  implements java.io.Serializable {


     private Integer feeId;
     private StudentInfo studentInfo;
     private double applyFee;
     private double regFee;
     private double tutionFee;
     private double examFee;
     private double othersFee;
     private double totalFee;
     private Date payDate;

    public StudentFee() {
    }

    public StudentFee(StudentInfo studentInfo, double applyFee, double regFee, double tutionFee, double examFee, double othersFee, double totalFee, Date payDate) {
       this.studentInfo = studentInfo;
       this.applyFee = applyFee;
       this.regFee = regFee;
       this.tutionFee = tutionFee;
       this.examFee = examFee;
       this.othersFee = othersFee;
       this.totalFee = totalFee;
       this.payDate = payDate;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="fee_id", unique=true, nullable=false)
    public Integer getFeeId() {
        return this.feeId;
    }
    
    public void setFeeId(Integer feeId) {
        this.feeId = feeId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="st_id", nullable=false)
    public StudentInfo getStudentInfo() {
        return this.studentInfo;
    }
    
    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    
    @Column(name="apply_fee", nullable=false, precision=22, scale=0)
    public double getApplyFee() {
        return this.applyFee;
    }
    
    public void setApplyFee(double applyFee) {
        this.applyFee = applyFee;
    }

    
    @Column(name="reg_fee", nullable=false, precision=22, scale=0)
    public double getRegFee() {
        return this.regFee;
    }
    
    public void setRegFee(double regFee) {
        this.regFee = regFee;
    }

    
    @Column(name="tution_fee", nullable=false, precision=22, scale=0)
    public double getTutionFee() {
        return this.tutionFee;
    }
    
    public void setTutionFee(double tutionFee) {
        this.tutionFee = tutionFee;
    }

    
    @Column(name="exam_fee", nullable=false, precision=22, scale=0)
    public double getExamFee() {
        return this.examFee;
    }
    
    public void setExamFee(double examFee) {
        this.examFee = examFee;
    }

    
    @Column(name="others_fee", nullable=false, precision=22, scale=0)
    public double getOthersFee() {
        return this.othersFee;
    }
    
    public void setOthersFee(double othersFee) {
        this.othersFee = othersFee;
    }

    
    @Column(name="total_fee", nullable=false, precision=22, scale=0)
    public double getTotalFee() {
        return this.totalFee;
    }
    
    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="pay_date", nullable=false, length=10)
    public Date getPayDate() {
        return this.payDate;
    }
    
    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }




}

