package com.mostafa.university.service;

import com.mostafa.university.dao.NoticeDetailsDaoInt;
import com.mostafa.university.domain.NoticeDetails;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeDetailsServiceImp implements NoticeDetailsServiceInt{
    
    @Autowired
    private NoticeDetailsDaoInt noticeDetailsDaoInt;

    @Override
    public List<NoticeDetails> getAllObject() {
        return noticeDetailsDaoInt.getAllObject();
    }

    @Override
    public NoticeDetails getObjectById(int noticeId) {
        return noticeDetailsDaoInt.getObjectById(noticeId);
    }

    @Override
    public boolean addObject(NoticeDetails noticeDetails) {
        if (noticeDetailsDaoInt.objectExists(noticeDetails.getHeading(), new Date())) {
            return false;
        } else {
            noticeDetailsDaoInt.addObject(noticeDetails);
            return true;
        }
    }

    @Override
    public void updateObject(NoticeDetails noticeDetails) {
        noticeDetailsDaoInt.updateObject(noticeDetails);
    }

    @Override
    public void deleteObject(int noticeId) {
        noticeDetailsDaoInt.deleteObject(noticeId);
    }

    @Override
    public List<NoticeDetails> getNoticeByCate(int ncatId) {
        return noticeDetailsDaoInt.getNoticeByCate(ncatId);
    }
}
