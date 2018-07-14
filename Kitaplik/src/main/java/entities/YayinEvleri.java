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
@Table(name = "YayinEvleri")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "YayinEvleri.findAll", query = "SELECT y FROM YayinEvleri y")
    , @NamedQuery(name = "YayinEvleri.findByYayinEviID", query = "SELECT y FROM YayinEvleri y WHERE y.yayinEviID = :yayinEviID")
    , @NamedQuery(name = "YayinEvleri.findByYayinEviAdi", query = "SELECT y FROM YayinEvleri y WHERE y.yayinEviAdi = :yayinEviAdi")
    , @NamedQuery(name = "YayinEvleri.findByAciklama", query = "SELECT y FROM YayinEvleri y WHERE y.aciklama = :aciklama")})
public class YayinEvleri implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "yayinEviAdi")
    private String yayinEviAdi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "aciklama")
    private String aciklama;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "yayinEviID")
    private Integer yayinEviID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "yayinEviID")
    private Collection<Kitaplar> kitaplarCollection;

    public YayinEvleri() {
    }

    public YayinEvleri(Integer yayinEviID) {
        this.yayinEviID = yayinEviID;
    }

    public YayinEvleri(Integer yayinEviID, String yayinEviAdi, String aciklama) {
        this.yayinEviID = yayinEviID;
        this.yayinEviAdi = yayinEviAdi;
        this.aciklama = aciklama;
    }

    public Integer getYayinEviID() {
        return yayinEviID;
    }

    public void setYayinEviID(Integer yayinEviID) {
        this.yayinEviID = yayinEviID;
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
        hash += (yayinEviID != null ? yayinEviID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof YayinEvleri)) {
            return false;
        }
        YayinEvleri other = (YayinEvleri) object;
        if ((this.yayinEviID == null && other.yayinEviID != null) || (this.yayinEviID != null && !this.yayinEviID.equals(other.yayinEviID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.YayinEvleri[ yayinEviID=" + yayinEviID + " ]";
    }

    public String getYayinEviAdi() {
        return yayinEviAdi;
    }

    public void setYayinEviAdi(String yayinEviAdi) {
        this.yayinEviAdi = yayinEviAdi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }
    
}
