/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pruebajsp.proyectoroman.persistencia;

import com.pruebajsp.proyectoroman.logica.Gasto;
import com.pruebajsp.proyectoroman.persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Lopez Martin
 */
public class GastoJpaController implements Serializable {

    public GastoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public GastoJpaController() {
        emf = Persistence.createEntityManagerFactory("com.pruebajsp_ProyectoRoman_jar_1.0-SNAPSHOTPU");
    }

    private EntityManagerFactory emf = null;

    public List<Object[]> getSumaDebePorMes() {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery(
                    "SELECT FUNCTION('MONTH', g.fecha), SUM(g.debe) "
                    + "FROM Gasto g GROUP BY FUNCTION('MONTH', g.fecha)"
            );
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Gasto gasto) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(gasto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Gasto gasto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            gasto = em.merge(gasto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = gasto.getIdGasto();
                if (findGasto(id) == null) {
                    throw new NonexistentEntityException("The gasto with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Gasto gasto;
            try {
                gasto = em.getReference(Gasto.class, id);
                gasto.getIdGasto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The gasto with id " + id + " no longer exists.", enfe);
            }
            em.remove(gasto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Gasto> findGastoEntities() {
        return findGastoEntities(true, -1, -1);
    }

    public List<Gasto> findGastoEntities(int maxResults, int firstResult) {
        return findGastoEntities(false, maxResults, firstResult);
    }

    private List<Gasto> findGastoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Gasto.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Gasto findGasto(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Gasto.class, id);
        } finally {
            em.close();
        }
    }

    public int getGastoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Gasto> rt = cq.from(Gasto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
