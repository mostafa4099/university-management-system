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
 * SalaryInfo generated by hbm2java
 */
@Entity
@Table(name="salary_info"
    ,catalog="university"
)
public class SalaryInfo  implements java.io.Serializable {


     private Integer salaryId;
     private EmpInfo empInfo;
     private double basic;
     private double house;
     private double helth;
     private double transport;
     private Double festival;
     private Double others;
     private double total;
     private Date paymentMonth;
     private Date payDate;

    public SalaryInfo() {
    }

	
    public SalaryInfo(EmpInfo empInfo, double basic, double house, double helth, double transport, double total, Date paymentMonth, Date payDate) {
        this.empInfo = empInfo;
        this.basic = basic;
        this.house = house;
        this.helth = helth;
        this.transport = transport;
        this.total = total;
        this.paymentMonth = paymentMonth;
        this.payDate = payDate;
    }
    public SalaryInfo(EmpInfo empInfo, double basic, double house, double helth, double transport, Double festival, Double others, double total, Date paymentMonth, Date payDate) {
       this.empInfo = empInfo;
       this.basic = basic;
       this.house = house;
       this.helth = helth;
       this.transport = transport;
       this.festival = festival;
       this.others = others;
       this.total = total;
       this.paymentMonth = paymentMonth;
       this.payDate = payDate;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="salary_id", unique=true, nullable=false)
    public Integer getSalaryId() {
        return this.salaryId;
    }
    
    public void setSalaryId(Integer salaryId) {
        this.salaryId = salaryId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="emp_id", nullable=false)
    public EmpInfo getEmpInfo() {
        return this.empInfo;
    }
    
    public void setEmpInfo(EmpInfo empInfo) {
        this.empInfo = empInfo;
    }

    
    @Column(name="basic", nullable=false, precision=22, scale=0)
    public double getBasic() {
        return this.basic;
    }
    
    public void setBasic(double basic) {
        this.basic = basic;
    }

    
    @Column(name="house", nullable=false, precision=22, scale=0)
    public double getHouse() {
        return this.house;
    }
    
    public void setHouse(double house) {
        this.house = house;
    }

    
    @Column(name="helth", nullable=false, precision=22, scale=0)
    public double getHelth() {
        return this.helth;
    }
    
    public void setHelth(double helth) {
        this.helth = helth;
    }

    
    @Column(name="transport", nullable=false, precision=22, scale=0)
    public double getTransport() {
        return this.transport;
    }
    
    public void setTransport(double transport) {
        this.transport = transport;
    }

    
    @Column(name="festival", precision=22, scale=0)
    public Double getFestival() {
        return this.festival;
    }
    
    public void setFestival(Double festival) {
        this.festival = festival;
    }

    
    @Column(name="others", precision=22, scale=0)
    public Double getOthers() {
        return this.others;
    }
    
    public void setOthers(Double others) {
        this.others = others;
    }

    
    @Column(name="total", nullable=false, precision=22, scale=0)
    public double getTotal() {
        return this.total;
    }
    
    public void setTotal(double total) {
        this.total = total;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="payment_month", nullable=false, length=10)
    public Date getPaymentMonth() {
        return this.paymentMonth;
    }
    
    public void setPaymentMonth(Date paymentMonth) {
        this.paymentMonth = paymentMonth;
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


