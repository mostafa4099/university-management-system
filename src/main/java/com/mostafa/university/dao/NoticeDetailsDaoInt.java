package com.mostafa.university.dao;

import com.mostafa.university.domain.NoticeDetails;
import java.util.Date;
import java.util.List;

public interface NoticeDetailsDaoInt {
    List<NoticeDetails> getAllObject();
    NoticeDetails getObjectById(int noticeId);
    void addObject(NoticeDetails noticeDetails);
    void updateObject(NoticeDetails noticeDetails);
    void deleteObject(int noticeId);
    boolean objectExists(String heading, Date publishDate);
    List<NoticeDetails> getNoticeByCate(int ncatId);
}
