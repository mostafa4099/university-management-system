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
 * NoticeDetails generated by hbm2java
 */
@Entity
@Table(name="notice_details"
    ,catalog="university"
)
public class NoticeDetails  implements java.io.Serializable {


     private Integer noticeId;
     private NoticeCategory noticeCategory;
     private String heading;
     private String mainContent;
     private Date publishDate;
     private Date endDate;

    public NoticeDetails() {
    }

    public NoticeDetails(NoticeCategory noticeCategory, String heading, String mainContent, Date publishDate, Date endDate) {
       this.noticeCategory = noticeCategory;
       this.heading = heading;
       this.mainContent = mainContent;
       this.publishDate = publishDate;
       this.endDate = endDate;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="notice_id", unique=true, nullable=false)
    public Integer getNoticeId() {
        return this.noticeId;
    }
    
    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ncat_id", nullable=false)
    public NoticeCategory getNoticeCategory() {
        return this.noticeCategory;
    }
    
    public void setNoticeCategory(NoticeCategory noticeCategory) {
        this.noticeCategory = noticeCategory;
    }

    
    @Column(name="heading", nullable=false, length=300)
    public String getHeading() {
        return this.heading;
    }
    
    public void setHeading(String heading) {
        this.heading = heading;
    }

    
    @Column(name="main_content", nullable=false, length=5000)
    public String getMainContent() {
        return this.mainContent;
    }
    
    public void setMainContent(String mainContent) {
        this.mainContent = mainContent;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="publish_date", nullable=false, length=10)
    public Date getPublishDate() {
        return this.publishDate;
    }
    
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="end_date", nullable=false, length=10)
    public Date getEndDate() {
        return this.endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }




}


