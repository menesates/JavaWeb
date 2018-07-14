/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author heulahe
 */
@Entity
@Table(name = "Yazarlar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Yazarlar.findAll", query = "SELECT y FROM Yazarlar y")
    , @NamedQuery(name = "Yazarlar.findByYazarID", query = "SELECT y FROM Yazarlar y WHERE y.yazarID = :yazarID")
    , @NamedQuery(name = "Yazarlar.findByYazarAdi", query = "SELECT y FROM Yazarlar y WHERE y.yazarAdi = :yazarAdi")
    , @NamedQuery(name = "Yazarlar.findByAciklama", query = "SELECT y FROM Yazarlar y WHERE y.aciklama = :aciklama")})
public class Yazarlar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "yazarID")
    private Integer yazarID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "yazarAdi")
    private String yazarAdi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "aciklama")
    private String aciklama;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "yazarID")
    private Collection<Kitaplar> kitaplarCollection;

    public Yazarlar() {
    }

    public Yazarlar(Integer yazarID) {
        this.yazarID = yazarID;
    }

    public Yazarlar(Integer yazarID, String yazarAdi, String aciklama) {
        this.yazarID = yazarID;
        this.yazarAdi = yazarAdi;
        this.aciklama = aciklama;
    }

    public Integer getYazarID() {
        return yazarID;
    }

    public void setYazarID(Integer yazarID) {
        this.yazarID = yazarID;
    }

    public String getYazarAdi() {
        return yazarAdi;
    }

    public void setYazarAdi(String yazarAdi) {
        this.yazarAdi = yazarAdi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    @XmlTransient
    public Collection<Kitaplar> getKitaplarCollection() {
        return kitaplarCollection;
    }

    public void setKitaplarCollection(Collection<Kitaplar> kitaplarCollection) {
        this.kitaplarCollection = kitaplarCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (yazarID != null ? yazarID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Yazarlar)) {
            return false;
        }
        Yazarlar other = (Yazarlar) object;
        if ((this.yazarID == null && other.yazarID != null) || (this.yazarID != null && !this.yazarID.equals(other.yazarID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Yazarlar[ yazarID=" + yazarID + " ]";
    }
    
}
