package org.duyhung.assignment.repository.impl;


import org.duyhung.assignment.entity.MauSac;
import org.duyhung.assignment.repository.IMauSacRepository;
import org.duyhung.assignment.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class MauSacRepository implements IMauSacRepository {
    @Override
    public List<MauSac> getAll() {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        Transaction transaction = null;
        List<MauSac> results = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            results = session.createQuery("from MauSac",MauSac.class).getResultList();
            transaction.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            if(transaction != null) transaction.rollback();
        }
        return results;
    }
    @Override
    public String insert(MauSac mauSac) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        String results = null;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            results = (String) session.save(mauSac);
            transaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }

    @Override
    public Boolean delete(MauSac mauSac) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        Boolean results = false;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.delete("MauSac",mauSac);
            transaction.commit();
            results = true;
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }

    @Override
    public Boolean update(MauSac mauSac) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        Boolean results = false;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.merge("MauSac",mauSac);
            transaction.commit();
            results = true;
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }

    @Override
    public MauSac getOne(String id) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        MauSac results = null;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            results = session.get(MauSac.class,id);
            transaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }
}
