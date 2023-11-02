package org.example.planes.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.example.planes.dao.api.IAirportDao;
import org.example.planes.dao.entity.AirportEntity;

import java.util.List;

public class AirportDao implements IAirportDao {

    private final EntityManagerFactory emf;

    public AirportDao(EntityManagerFactory emf) {
        this.emf = emf;
    }
    @Override
    public List<AirportEntity> getAll() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<?> query = cb.createQuery();
        query.from(AirportEntity.class);
        return (List<AirportEntity>) em.createQuery(query).getResultList();
    }
}
