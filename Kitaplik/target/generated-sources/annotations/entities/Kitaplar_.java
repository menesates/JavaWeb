package entities;

import entities.YayinEvleri;
import entities.Yazarlar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-14T20:07:01")
@StaticMetamodel(Kitaplar.class)
public class Kitaplar_ { 

    public static volatile SingularAttribute<Kitaplar, String> aciklama;
    public static volatile SingularAttribute<Kitaplar, Yazarlar> yazarID;
    public static volatile SingularAttribute<Kitaplar, String> kitapAltAdi;
    public static volatile SingularAttribute<Kitaplar, String> kitapSeriAdi;
    public static volatile SingularAttribute<Kitaplar, YayinEvleri> yayinEviID;
    public static volatile SingularAttribute<Kitaplar, Integer> kitapID;
    public static volatile SingularAttribute<Kitaplar, String> kitapAdi;

}