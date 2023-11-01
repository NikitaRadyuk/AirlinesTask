package org.example.planes.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.example.planes.dao.api.IAircraftDao;
import org.example.planes.dao.entity.AircraftEntity;

import java.util.List;

public class AircraftDao implements IAircraftDao {

    private final EntityManagerFactory emf;


    public AircraftDao(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<AircraftEntity> getAll() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<AircraftEntity> query = cb.createQuery(AircraftEntity.class);
        return em.createQuery(query).getResultList();
    }
}
