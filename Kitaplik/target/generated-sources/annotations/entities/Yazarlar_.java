package entities;

import entities.Kitaplar;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-14T20:07:01")
@StaticMetamodel(Yazarlar.class)
public class Yazarlar_ { 

    public static volatile SingularAttribute<Yazarlar, Integer> yazarID;
    public static volatile SingularAttribute<Yazarlar, String> aciklama;
    public static volatile SingularAttribute<Yazarlar, String> yazarAdi;
    public static volatile CollectionAttribute<Yazarlar, Kitaplar> kitaplarCollection;

}