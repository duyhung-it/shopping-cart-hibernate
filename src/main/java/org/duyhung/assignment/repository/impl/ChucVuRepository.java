package org.duyhung.assignment.repository.impl;


import org.duyhung.assignment.entity.ChucVu;
import org.duyhung.assignment.repository.IChucVuRepository;
import org.duyhung.assignment.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ChucVuRepository implements IChucVuRepository {
    @Override
    public List<ChucVu> getAll() {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        List<ChucVu> results = null;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            results = session.createQuery("from ChucVu",ChucVu.class)
                    .getResultList();
            transaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }

    @Override
    public String insert(ChucVu chucVu) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        String results = null;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            results = (String) session.save(chucVu);
            transaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }

    @Override
    public Boolean delete(ChucVu chucVu) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        Boolean results = false;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.delete("ChucVu",chucVu);
            transaction.commit();
            results = true;
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }

    @Override
    public Boolean update(ChucVu chucVu) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        Boolean results = false;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.merge("ChucVu",chucVu);
            transaction.commit();
            results = true;
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }

    @Override
    public ChucVu getOne(String id) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        ChucVu results = null;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            results = session.get(ChucVu.class,id);
            transaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }
}
