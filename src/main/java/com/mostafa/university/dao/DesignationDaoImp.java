package com.mostafa.university.dao;

import com.mostafa.university.domain.Designation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class DesignationDaoImp implements DesignationDaoInt{

    @Autowired
    private HibernateTemplate hibernateTemplate;
    
    @Override
    public List<Designation> getAllObject() {
        String hql="FROM Designation as des ORDER BY des.desigId";
        return (List<Designation>) hibernateTemplate.find(hql);
    }

    @Override
    public Designation getObjectById(int desigId) {
        return hibernateTemplate.get(Designation.class, desigId);
    }

    @Override
    public void addObject(Designation designation) {
        hibernateTemplate.save(designation);
    }

    @Override
    public void updateObject(Designation designation) {
        Designation d=getObjectById(designation.getDesigId());
        d.setDesigName(designation.getDesigName());
        hibernateTemplate.update(d);
    }

    @Override
    public void deleteObject(int desigId) {
        hibernateTemplate.delete(getObjectById(desigId));
    }

    @Override
    public boolean objectExists(String desigName) {
        String hql="FROM Designation as d WHERE d.desigName=?";
        List <Designation> desList=(List <Designation>) hibernateTemplate.find(hql, desigName);
        return desList.size() > 0 ? true:false;
    }
    
}
