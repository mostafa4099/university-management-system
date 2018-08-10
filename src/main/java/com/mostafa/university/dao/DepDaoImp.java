package com.mostafa.university.dao;

import com.mostafa.university.domain.Department;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class DepDaoImp implements DepDaoInt{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Department> getAllObject() {
        String hql="FROM Department d LEFT JOIN FETCH d.faculty ORDER BY d.depId";
        return (List<Department>) hibernateTemplate.find(hql);
    }

    @Override
    public Department getObjectById(int depId) {
        return hibernateTemplate.get(Department.class, depId);
    }

    @Override
    public void addObject(Department department) {
        hibernateTemplate.save(department);
    }

    @Override
    public void updateObject(Department department) {
        Department d=getObjectById(department.getDepId());
        d.setDepName(department.getDepName());
        d.setDepTitle(department.getDepTitle());
        d.setDepSubTitle(department.getDepSubTitle());
        d.setDepDesc(department.getDepDesc());
        hibernateTemplate.update(d);
    }

    @Override
    public void deleteObject(int depId) {
        hibernateTemplate.delete(getObjectById(depId));
    }

    @Override
    public boolean objectExists(String depName) {
        String hql="FROM Department as d WHERE d.depName=?";
        List <Department> depList=(List <Department>) hibernateTemplate.find(hql, depName);
        return depList.size() > 0 ? true:false;
    }
    
}
