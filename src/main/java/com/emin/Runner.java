package com.emin;

import com.emin.repository.entity.Musteri;
import com.emin.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Runner {
    public static void main(String[] args) {
        /**
         * Hibernate ile Veri Eklemek
         * 1- Bağlantıyı Aç (oturum oluşturmak ,başlatmak)
         * hibernate yönetici dosyası olan utility , bağlantıyı açar ve yeni bir oturum oluşturur.
         */

        Session session = HibernateUtility.getSessionFactory().openSession();
        /**
         *  2- Transaction oluşturma ve sistemi izleme başladı
         *
         */
        Transaction transaction= session.beginTransaction();
        Musteri mst =new Musteri("emin","bay","Ankara");
        session.save(mst);
        transaction.commit();
        session.close();


    }
}
