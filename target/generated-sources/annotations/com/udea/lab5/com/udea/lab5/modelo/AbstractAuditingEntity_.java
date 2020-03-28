package com.udea.lab5.com.udea.lab5.modelo;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-27T13:40:19")
@StaticMetamodel(AbstractAuditingEntity.class)
public abstract class AbstractAuditingEntity_ { 

    public static volatile SingularAttribute<AbstractAuditingEntity, Instant> createdDate;
    public static volatile SingularAttribute<AbstractAuditingEntity, String> createdBy;
    public static volatile SingularAttribute<AbstractAuditingEntity, Instant> lastModifiedDate;
    public static volatile SingularAttribute<AbstractAuditingEntity, String> lastModifiedBy;

}