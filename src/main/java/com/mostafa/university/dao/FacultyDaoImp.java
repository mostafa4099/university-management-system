package com.mostafa.university.dao;

import com.mostafa.university.domain.Faculty;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class FacultyDaoImp implements FacultyDaoInt{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Faculty> getAllObject() {
        String hql="FROM Faculty as fac ORDER BY fac.facId";
        return (List<Faculty>) hibernateTemplate.find(hql);
    }

    @Override
    public Faculty getObjectById(int facId) {
        return hibernateTemplate.get(Faculty.class, facId);
    }

    @Override
    public void addObject(Faculty faculty) {
        hibernateTemplate.save(faculty);
    }

    @Override
    public void updateObject(Faculty faculty) {
        Faculty f=getObjectById(faculty.getFacId());
        f.setFacName(faculty.getFacName());
        f.setFacTitle(faculty.getFacTitle());
        f.setFacSubTitle(faculty.getFacSubTitle());
        f.setFacDesc(faculty.getFacDesc());
        hibernateTemplate.update(f);
    }

    @Override
    public void deleteObject(int facId) {
        hibernateTemplate.delete(getObjectById(facId));
    }

    @Override
    public boolean objectExists(String facName) {
        String hql="FROM Faculty as f WHERE f.facName=?";
        List <Faculty> facList=(List <Faculty>) hibernateTemplate.find(hql, facName);
        return facList.size() > 0 ? true:false;
    }
    
}
