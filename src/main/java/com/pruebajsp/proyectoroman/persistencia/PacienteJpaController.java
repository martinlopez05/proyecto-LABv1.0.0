/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pruebajsp.proyectoroman.persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.pruebajsp.proyectoroman.logica.Odontologo;
import com.pruebajsp.proyectoroman.logica.Paciente;
import com.pruebajsp.proyectoroman.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lopez Martin
 */
public class PacienteJpaController implements Serializable {

    public PacienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public PacienteJpaController(){
        emf = Persistence.createEntityManagerFactory("com.pruebajsp_ProyectoRoman_jar_1.0-SNAPSHOTPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public List<Object[]> obtenerTotalFacturadoPorMes() {
    EntityManager em = getEntityManager();
    try {
        Query query = em.createQuery("SELECT FUNCTION('MONTH', p.fecha), SUM(p.debe) " +
                                     "FROM Paciente p " +
                                     "GROUP BY FUNCTION('MONTH', p.fecha) " +
                                     "ORDER BY FUNCTION('MONTH', p.fecha)");
        return query.getResultList();
    } finally {
        em.close();
    }

}


    public void create(Paciente paciente) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Odontologo odontologo = paciente.getOdontologo();
            if (odontologo != null) {
                odontologo = em.getReference(odontologo.getClass(), odontologo.getIdOdontologo());
                paciente.setOdontologo(odontologo);
            }
            em.persist(paciente);
            if (odontologo != null) {
                odontologo.getPacientes().add(paciente);
                odontologo = em.merge(odontologo);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Paciente paciente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente persistentPaciente = em.find(Paciente.class, paciente.getIdPaciente());
            Odontologo odontologoOld = persistentPaciente.getOdontologo();
            Odontologo odontologoNew = paciente.getOdontologo();
            if (odontologoNew != null) {
                odontologoNew = em.getReference(odontologoNew.getClass(), odontologoNew.getIdOdontologo());
                paciente.setOdontologo(odontologoNew);
            }
            paciente = em.merge(paciente);
            if (odontologoOld != null && !odontologoOld.equals(odontologoNew)) {
                odontologoOld.getPacientes().remove(paciente);
                odontologoOld = em.merge(odontologoOld);
            }
            if (odontologoNew != null && !odontologoNew.equals(odontologoOld)) {
                odontologoNew.getPacientes().add(paciente);
                odontologoNew = em.merge(odontologoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = paciente.getIdPaciente();
                if (findPaciente(id) == null) {
                    throw new NonexistentEntityException("The paciente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente paciente;
            try {
                paciente = em.getReference(Paciente.class, id);
                paciente.getIdPaciente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paciente with id " + id + " no longer exists.", enfe);
            }
            Odontologo odontologo = paciente.getOdontologo();
            if (odontologo != null) {
                odontologo.getPacientes().remove(paciente);
                odontologo = em.merge(odontologo);
            }
            em.remove(paciente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Paciente> findPacienteEntities() {
        return findPacienteEntities(true, -1, -1);
    }

    public List<Paciente> findPacienteEntities(int maxResults, int firstResult) {
        return findPacienteEntities(false, maxResults, firstResult);
    }

    private List<Paciente> findPacienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Paciente.class));
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

    public Paciente findPaciente(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paciente.class, id);
        } finally {
            em.close();
        }
    }

    public int getPacienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Paciente> rt = cq.from(Paciente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
