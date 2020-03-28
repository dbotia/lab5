package com.udea.lab5.repository;

import javax.persistence.EntityManager;
import javax.inject.Inject;
import com.udea.lab5.com.udea.lab5.modelo.Persona;

public class PersonaRepository extends AbstractRepository<Persona, Long> {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaRepository() {
        super(Persona.class);
    }

}
