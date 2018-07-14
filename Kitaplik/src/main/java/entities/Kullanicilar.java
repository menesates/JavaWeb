/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author heulahe
 */
@Entity
@Table(name = "Kullanicilar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kullanicilar.findAll", query = "SELECT k FROM Kullanicilar k")
    , @NamedQuery(name = "Kullanicilar.findByKullaniciID", query = "SELECT k FROM Kullanicilar k WHERE k.kullaniciID = :kullaniciID")
    , @NamedQuery(name = "Kullanicilar.findByKullaniciAdi", query = "SELECT k FROM Kullanicilar k WHERE k.kullaniciAdi = :kullaniciAdi")
    , @NamedQuery(name = "Kullanicilar.findBySifre", query = "SELECT k FROM Kullanicilar k WHERE k.sifre = :sifre")})
@ManagedBean(name = "login")
@SessionScoped
public class Kullanicilar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kullaniciID")
    private Integer kullaniciID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "KullaniciAdi")
    protected String kullaniciAdi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Sifre")
    protected String sifre;

    public Kullanicilar() {
    }

    public Kullanicilar(Integer kullaniciID) {
        this.kullaniciID = kullaniciID;
    }

    public Kullanicilar(Integer kullaniciID, String kullaniciAdi, String sifre) {
        this.kullaniciID = kullaniciID;
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
    }

    public Integer getKullaniciID() {
        return kullaniciID;
    }

    public void setKullaniciID(Integer kullaniciID) {
        this.kullaniciID = kullaniciID;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kullaniciID != null ? kullaniciID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kullanicilar)) {
            return false;
        }
        Kullanicilar other = (Kullanicilar) object;
        if ((this.kullaniciID == null && other.kullaniciID != null) || (this.kullaniciID != null && !this.kullaniciID.equals(other.kullaniciID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Kullanicilar[ kullaniciID=" + kullaniciID + " ]";
    }
    
    public boolean checkuser(){
        
        try {
            System.out.println("chechuser fonksiyonu");
            
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            
            String hql = "from Kullanicilar where KullaniciAdi=:userName and Sifre=:password";
            
            Query query = session.createQuery(hql);
            query.setParameter("userName", kullaniciAdi);
            query.setParameter("password", sifre);
            
            List list = query.list();
            System.out.println(list.size());
            
            return list.size() == 1;
            
        } catch (HibernateException e) {
            System.out.println("checkuser error: " + e);
        }
        
        return false;
       
    }
    
    
}
