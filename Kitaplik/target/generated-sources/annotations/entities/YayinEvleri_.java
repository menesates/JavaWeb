package entities;

import entities.Kitaplar;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-14T20:07:01")
@StaticMetamodel(YayinEvleri.class)
public class YayinEvleri_ { 

    public static volatile SingularAttribute<YayinEvleri, Integer> aciklama;
    public static volatile SingularAttribute<YayinEvleri, Integer> yayinEviID;
    public static volatile CollectionAttribute<YayinEvleri, Kitaplar> kitaplarCollection;
    public static volatile SingularAttribute<YayinEvleri, Integer> yayinEviAdi;

}