package com.emin.repository.entity;

import javax.persistence.*;

/**
 * entity, sınıfı bir veritabanı varlığı oldugunu niteliyoruz
 */
@Entity
/**
 * bu sınıfın bir tablo oldugunu ve özeliiklerinin neler
 * oldugunu belirtmek için kullanıyoruz
 * eger name property kullanılmaz ise sınıf adı tablo adı olarak kullanılır
 *
 *  name -> sınıfın veritbanınıdaki adını ne olacapını bildir
 *
 */
@Table(name = "tblmusteri")

public class Musteri {

    /**
     * @Id bir değişkenin primary key olduğunu işaretlemek için kullanılır
     */
    @Id
    /**
     *ID'nin otomatik sayı olarak kullanılabilmesi için
     * 2 farklı yöntem vardır.
     * 1 - bize sunulan otomatik sayıüreten Strategy type
     * @GeneratedValue(strategy= GenerationType.AUTO)
     * 2 - elle Squenece oluşturabilir ve bunu generete edebiliriz
     *   @SequenceGenerator(name = "sq_tblmusteri_id",
     *             sequenceName ="sq_tblmusteri_id",
     *             initialValue = 1,
     *             allocationSize = 2)
     */
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    /**
     * Eğer alanlarınıza hiçbir annotation eklemeden
     * bırakırsanız default degerler ile devameder.
     * String bir alan -> varchar olur ve maz uzunluk 255 karakter olarak atanır .
     */
    @Column(name = "MusteriAdi",length =100, nullable = false)
    String ad;
    String soyad;
    @Column(length = 500)
    String adres;


    public Musteri(long id) {
        this.id = id;
    }

    public Musteri() {
    }

    public Musteri(long id, String ad, String soyad, String adres) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.adres = adres;
    }

    @Override
    public String toString() {
        return "Musteri{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", adres='" + adres + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}
