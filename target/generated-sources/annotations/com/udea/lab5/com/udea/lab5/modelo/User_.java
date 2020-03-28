package com.udea.lab5.com.udea.lab5.modelo;

import com.udea.lab5.com.udea.lab5.modelo.Authority;
import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-27T13:40:18")
@StaticMetamodel(User.class)
public class User_ extends AbstractAuditingEntity_ {

    public static volatile SingularAttribute<User, String> lastName;
    public static volatile SingularAttribute<User, String> firstName;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, Instant> resetDate;
    public static volatile SingularAttribute<User, String> langKey;
    public static volatile SingularAttribute<User, Long> id;
    public static volatile SingularAttribute<User, String> login;
    public static volatile SingularAttribute<User, String> activationKey;
    public static volatile SingularAttribute<User, String> resetKey;
    public static volatile SetAttribute<User, Authority> authorities;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, Boolean> activated;

}