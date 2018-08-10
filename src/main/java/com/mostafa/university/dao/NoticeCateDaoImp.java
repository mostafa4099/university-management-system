package com.mostafa.university.dao;

import com.mostafa.university.domain.NoticeCategory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class NoticeCateDaoImp implements NoticeCateDaoInt{

    @Autowired
    private HibernateTemplate hibernateTemplate;
    
    @Override
    public List<NoticeCategory> getAllObject() {
        String hql="FROM NoticeCategory as ncat ORDER BY ncat.ncatId";
        return (List<NoticeCategory>) hibernateTemplate.find(hql);
    }

    @Override
    public NoticeCategory getObjectById(int ncatId) {
        return hibernateTemplate.get(NoticeCategory.class, ncatId);
    }

    @Override
    public void addObject(NoticeCategory ncategory) {
        hibernateTemplate.save(ncategory);
    }

    @Override
    public void updateObject(NoticeCategory ncategory) {
        NoticeCategory ncat=getObjectById(ncategory.getNcatId());
        ncat.setNcatName(ncategory.getNcatName());
        hibernateTemplate.update(ncat);
    }

    @Override
    public void deleteObject(int ncatId) {
        hibernateTemplate.delete(getObjectById(ncatId));
    }

    @Override
    public boolean objectExists(String ncatName) {
        String hql="FROM NoticeCategory as ncat WHERE ncat.ncatName=?";
        List <NoticeCategory> ncatList=(List <NoticeCategory>) hibernateTemplate.find(hql, ncatName);
        return ncatList.size() > 0 ? true:false;
    }
    
}
