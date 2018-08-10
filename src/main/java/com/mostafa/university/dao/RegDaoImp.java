package com.mostafa.university.dao;

import com.mostafa.university.domain.Login;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class RegDaoImp implements RegDaoInt{
    
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<Login> getAllObject() {
        String hql="FROM Login l LEFT JOIN FETCH l.accountType LEFT JOIN FETCH l.studentInfo LEFT JOIN FETCH l.teachers LEFT JOIN FETCH l.teachers.department LEFT JOIN FETCH l.teachers.empInfo LEFT JOIN FETCH l.teachers.empInfo.designation ORDER BY l.loginId";
        return (List<Login>) hibernateTemplate.find(hql);
    }

    @Override
    public Login getObjectById(int loginId) {
        return hibernateTemplate.get(Login.class, loginId);
    }

    @Override
    public void addObject(Login login) {
        hibernateTemplate.save(login);
    }

    @Override
    public void updateObject(Login login) {
        Login l=getObjectById(login.getLoginId());
        l.setAccountType(login.getAccountType());
        l.setTeachers(login.getTeachers());
        l.setStudentInfo(login.getStudentInfo());
        l.setUname(login.getUname());
        l.setPass(login.getPass());
        hibernateTemplate.update(l);
    }

    @Override
    public void deleteObject(int loginId) {
        hibernateTemplate.delete(getObjectById(loginId));
    }

    @Override
    public boolean objectExists(String uname, String pass) {
        String hql="FROM Login as l WHERE l.uname=? and l.pass=?";
        List <Login> userList=(List <Login>) hibernateTemplate.find(hql, uname, pass);
        return userList.size() > 0 ? true:false;
    }
    
}
