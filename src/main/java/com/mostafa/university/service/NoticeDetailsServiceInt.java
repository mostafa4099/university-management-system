package com.mostafa.university.service;

import com.mostafa.university.domain.NoticeDetails;
import java.util.List;

public interface NoticeDetailsServiceInt {
    List<NoticeDetails> getAllObject();
    NoticeDetails getObjectById(int noticeId);
    boolean addObject(NoticeDetails noticeDetails);
    void updateObject(NoticeDetails noticeDetails);
    void deleteObject(int noticeId);
    List<NoticeDetails> getNoticeByCate(int ncatId);
}
