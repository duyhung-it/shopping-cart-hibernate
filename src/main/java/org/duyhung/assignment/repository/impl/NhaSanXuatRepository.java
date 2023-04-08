package org.duyhung.assignment.repository.impl;

import org.duyhung.assignment.entity.NhaSanXuat;
import org.duyhung.assignment.repository.INhaSanXuatRepository;
import org.duyhung.assignment.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class  NhaSanXuatRepository implements INhaSanXuatRepository {
    @Override
    public List<NhaSanXuat> getAll() {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        Transaction transaction = null;
        List<NhaSanXuat> results = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            results = session.createQuery("from NhaSanXuat",NhaSanXuat.class).getResultList();
            transaction.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            if(transaction != null) transaction.rollback();
        }
        return results;
    }

    @Override
    public String insert(NhaSanXuat nhaSanXuat) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        String results = null;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            results = (String) session.save(nhaSanXuat);
            transaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }

    @Override
    public Boolean delete(NhaSanXuat nhaSanXuat) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        Boolean results = false;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.delete("NhaSanXuat", nhaSanXuat);
            transaction.commit();
            results = true;
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }

    @Override
    public Boolean update(NhaSanXuat nhaSanXuat) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        Boolean results = false;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.merge("NhaSanXuat", nhaSanXuat);
            transaction.commit();
            results = true;
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }

    @Override
    public NhaSanXuat getOne(String id) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        NhaSanXuat results = null;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            results = session.get(NhaSanXuat.class,id);
            transaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }
}
