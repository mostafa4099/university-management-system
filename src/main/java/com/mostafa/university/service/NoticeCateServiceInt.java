package com.mostafa.university.service;

import com.mostafa.university.domain.NoticeCategory;
import java.util.List;

public interface NoticeCateServiceInt {
    List<NoticeCategory> getAllObject();
    NoticeCategory getObjectById(int ncatId);
    boolean addObject(NoticeCategory noticeCategory);
    void updateObject(NoticeCategory noticeCategory);
    void deleteObject(int ncatId);
}
