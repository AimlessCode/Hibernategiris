package com.emin.utility;

import com.emin.repository.entity.Satis;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Java Generic types
 */
public class VTIsletimcisi<T> {
    private Session session;
    private Transaction transaction;

    private void open() {
        session = HibernateUtility.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    private void CloseCommit() {
        transaction.commit();
        ;
        session.close();
    }

    private void CloseRollBack() {
        transaction.commit();
        session.close();

    }

    public void save(T t) {
        try {
            open();
            session.save(t);
            CloseCommit();
        } catch (Exception exception) {
            CloseRollBack();
        }
    }

    public void update(T t) {
        try {
            open();
            session.update(t);
            CloseCommit();
        } catch (Exception exception) {
            CloseRollBack();
        }
    }

    public void delete(T t) {
        try {
            open();
            session.delete(t);
            CloseCommit();
        } catch (Exception exception) {
            CloseRollBack();
        }
    }

    public List<T> findAll() {
        List<T> result = null;
        open();
        /**
         * Veri tabanı sorgusu çalıştır
         */

        Query query = session.createQuery("FROM satis");

        result = query.getResultList();
        return result;

    }

}
