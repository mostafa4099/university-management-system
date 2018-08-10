package com.mostafa.university.dao;

import com.mostafa.university.domain.NoticeDetails;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class NoticeDetailsDaoImp implements NoticeDetailsDaoInt{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<NoticeDetails> getAllObject() {
        String hql="FROM NoticeDetails n LEFT JOIN FETCH n.noticeCategory ORDER BY n.noticeId";
        return (List<NoticeDetails>) hibernateTemplate.find(hql);
    }

    @Override
    public NoticeDetails getObjectById(int noticeId) {
        return hibernateTemplate.get(NoticeDetails.class, noticeId);
    }

    @Override
    public void addObject(NoticeDetails noticeDetails) {
        NoticeDetails n =new NoticeDetails();
        n.setNoticeCategory(noticeDetails.getNoticeCategory());
        n.setHeading(noticeDetails.getHeading());
        n.setMainContent(noticeDetails.getMainContent());
        n.setEndDate(noticeDetails.getEndDate());
        n.setPublishDate(new Date());
        hibernateTemplate.save(n);
    }

    @Override
    public void updateObject(NoticeDetails noticeDetails) {
        NoticeDetails notice=getObjectById(noticeDetails.getNoticeId());
        notice.setNoticeCategory(noticeDetails.getNoticeCategory());
        notice.setHeading(noticeDetails.getHeading());
        notice.setMainContent(noticeDetails.getMainContent());
        notice.setEndDate(noticeDetails.getEndDate());
        hibernateTemplate.update(notice);
    }

    @Override
    public void deleteObject(int noticeId) {
        hibernateTemplate.delete(getObjectById(noticeId));
    }

    @Override
    public boolean objectExists(String heading, Date publishDate) {
        String hql="FROM NoticeDetails as n WHERE n.heading=? and n.publishDate=?";
        List <NoticeDetails> noticeList=(List <NoticeDetails>) hibernateTemplate.find(hql, heading, publishDate);
        return noticeList.size() > 0 ? true:false;
    }
    
    @Override
    public List<NoticeDetails> getNoticeByCate(int ncatId) {
        String hql="FROM NoticeDetails n LEFT JOIN FETCH n.noticeCategory WHERE n.noticeCategory.ncatId=?";
        List <NoticeDetails> noticeList=(List <NoticeDetails>) hibernateTemplate.find(hql, ncatId);
        return noticeList;
    }
    
}
