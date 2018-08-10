package com.mostafa.university.service;

import com.mostafa.university.dao.NoticeCateDaoInt;
import com.mostafa.university.domain.NoticeCategory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeCateServiceImp implements NoticeCateServiceInt{
    
    @Autowired
    private NoticeCateDaoInt noticeCateDaoInt;

    @Override
    public List<NoticeCategory> getAllObject() {
        return noticeCateDaoInt.getAllObject();
    }

    @Override
    public NoticeCategory getObjectById(int ncatId) {
        return noticeCateDaoInt.getObjectById(ncatId);
    }

    @Override
    public boolean addObject(NoticeCategory noticeCategory) {
        if (noticeCateDaoInt.objectExists(noticeCategory.getNcatName())) {
            return false;
        } else {
            noticeCateDaoInt.addObject(noticeCategory);
            return true;
        }
    }

    @Override
    public void updateObject(NoticeCategory noticeCategory) {
        noticeCateDaoInt.updateObject(noticeCategory);
    }

    @Override
    public void deleteObject(int ncatId) {
        noticeCateDaoInt.deleteObject(ncatId);
    }
    
}
