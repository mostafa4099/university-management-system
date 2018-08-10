package com.mostafa.university.dao;

import com.mostafa.university.domain.NoticeCategory;
import java.util.List;

public interface NoticeCateDaoInt {
    List<NoticeCategory> getAllObject();
    NoticeCategory getObjectById(int ncatId);
    void addObject(NoticeCategory ncategory);
    void updateObject(NoticeCategory ncategory);
    void deleteObject(int ncatId);
    boolean objectExists(String ncatName);
}
