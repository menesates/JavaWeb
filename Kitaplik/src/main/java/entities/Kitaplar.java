/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author heulahe
 */
@Entity
@Table(name = "Kitaplar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kitaplar.findAll", query = "SELECT k FROM Kitaplar k")
    , @NamedQuery(name = "Kitaplar.findByKitapID", query = "SELECT k FROM Kitaplar k WHERE k.kitapID = :kitapID")
    , @NamedQuery(name = "Kitaplar.findByKitapAdi", query = "SELECT k FROM Kitaplar k WHERE k.kitapAdi = :kitapAdi")
    , @NamedQuery(name = "Kitaplar.findByKitapAltAdi", query = "SELECT k FROM Kitaplar k WHERE k.kitapAltAdi = :kitapAltAdi")
    , @NamedQuery(name = "Kitaplar.findByKitapSeriAdi", query = "SELECT k FROM Kitaplar k WHERE k.kitapSeriAdi = :kitapSeriAdi")
    , @NamedQuery(name = "Kitaplar.findByAciklama", query = "SELECT k FROM Kitaplar k WHERE k.aciklama = :aciklama")})
public class Kitaplar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kitapID")
    private Integer kitapID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "kitapAdi")
    private String kitapAdi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "kitapAltAdi")
    private String kitapAltAdi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "kitapSeriAdi")
    private String kitapSeriAdi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "aciklama")
    private String aciklama;
    @JoinColumn(name = "yazarID", referencedColumnName = "yazarID")
    @ManyToOne(optional = false)
    private Yazarlar yazarID;
    @JoinColumn(name = "yayinEviID", referencedColumnName = "yayinEviID")
    @ManyToOne(optional = false)
    private YayinEvleri yayinEviID;

    public Kitaplar() {
    }

    public Kitaplar(Integer kitapID) {
        this.kitapID = kitapID;
    }

    public Kitaplar(Integer kitapID, String kitapAdi, String kitapAltAdi, String kitapSeriAdi, String aciklama) {
        this.kitapID = kitapID;
        this.kitapAdi = kitapAdi;
        this.kitapAltAdi = kitapAltAdi;
        this.kitapSeriAdi = kitapSeriAdi;
        this.aciklama = aciklama;
    }

    public Integer getKitapID() {
        return kitapID;
    }

    public void setKitapID(Integer kitapID) {
        this.kitapID = kitapID;
    }

    public String getKitapAdi() {
        return kitapAdi;
    }

    public void setKitapAdi(String kitapAdi) {
        this.kitapAdi = kitapAdi;
    }

    public String getKitapAltAdi() {
        return kitapAltAdi;
    }

    public void setKitapAltAdi(String kitapAltAdi) {
        this.kitapAltAdi = kitapAltAdi;
    }

    public String getKitapSeriAdi() {
        return kitapSeriAdi;
    }

    public void setKitapSeriAdi(String kitapSeriAdi) {
        this.kitapSeriAdi = kitapSeriAdi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public Yazarlar getYazarID() {
        return yazarID;
    }

    public void setYazarID(Yazarlar yazarID) {
        this.yazarID = yazarID;
    }

    public YayinEvleri getYayinEviID() {
        return yayinEviID;
    }

    public void setYayinEviID(YayinEvleri yayinEviID) {
        this.yayinEviID = yayinEviID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kitapID != null ? kitapID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kitaplar)) {
            return false;
        }
        Kitaplar other = (Kitaplar) object;
        if ((this.kitapID == null && other.kitapID != null) || (this.kitapID != null && !this.kitapID.equals(other.kitapID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Kitaplar[ kitapID=" + kitapID + " ]";
    }
    
}
