/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pruebajsp.proyectoroman.persistencia;

import com.pruebajsp.proyectoroman.logica.Odontologo;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.pruebajsp.proyectoroman.logica.Paciente;
import com.pruebajsp.proyectoroman.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lopez Martin
 */
public class OdontologoJpaController implements Serializable {

    public OdontologoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public OdontologoJpaController(){
        emf = Persistence.createEntityManagerFactory("com.pruebajsp_ProyectoRoman_jar_1.0-SNAPSHOTPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Odontologo odontologo) {
        if (odontologo.getPacientes() == null) {
            odontologo.setPacientes(new ArrayList<Paciente>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Paciente> attachedPacientes = new ArrayList<Paciente>();
            for (Paciente pacientesPacienteToAttach : odontologo.getPacientes()) {
                pacientesPacienteToAttach = em.getReference(pacientesPacienteToAttach.getClass(), pacientesPacienteToAttach.getIdPaciente());
                attachedPacientes.add(pacientesPacienteToAttach);
            }
            odontologo.setPacientes(attachedPacientes);
            em.persist(odontologo);
            for (Paciente pacientesPaciente : odontologo.getPacientes()) {
                Odontologo oldOdontologoOfPacientesPaciente = pacientesPaciente.getOdontologo();
                pacientesPaciente.setOdontologo(odontologo);
                pacientesPaciente = em.merge(pacientesPaciente);
                if (oldOdontologoOfPacientesPaciente != null) {
                    oldOdontologoOfPacientesPaciente.getPacientes().remove(pacientesPaciente);
                    oldOdontologoOfPacientesPaciente = em.merge(oldOdontologoOfPacientesPaciente);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Odontologo odontologo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Odontologo persistentOdontologo = em.find(Odontologo.class, odontologo.getIdOdontologo());
            List<Paciente> pacientesOld = persistentOdontologo.getPacientes();
            List<Paciente> pacientesNew = odontologo.getPacientes();
            List<Paciente> attachedPacientesNew = new ArrayList<Paciente>();
            for (Paciente pacientesNewPacienteToAttach : pacientesNew) {
                pacientesNewPacienteToAttach = em.getReference(pacientesNewPacienteToAttach.getClass(), pacientesNewPacienteToAttach.getIdPaciente());
                attachedPacientesNew.add(pacientesNewPacienteToAttach);
            }
            pacientesNew = attachedPacientesNew;
            odontologo.setPacientes(pacientesNew);
            odontologo = em.merge(odontologo);
            for (Paciente pacientesOldPaciente : pacientesOld) {
                if (!pacientesNew.contains(pacientesOldPaciente)) {
                    pacientesOldPaciente.setOdontologo(null);
                    pacientesOldPaciente = em.merge(pacientesOldPaciente);
                }
            }
            for (Paciente pacientesNewPaciente : pacientesNew) {
                if (!pacientesOld.contains(pacientesNewPaciente)) {
                    Odontologo oldOdontologoOfPacientesNewPaciente = pacientesNewPaciente.getOdontologo();
                    pacientesNewPaciente.setOdontologo(odontologo);
                    pacientesNewPaciente = em.merge(pacientesNewPaciente);
                    if (oldOdontologoOfPacientesNewPaciente != null && !oldOdontologoOfPacientesNewPaciente.equals(odontologo)) {
                        oldOdontologoOfPacientesNewPaciente.getPacientes().remove(pacientesNewPaciente);
                        oldOdontologoOfPacientesNewPaciente = em.merge(oldOdontologoOfPacientesNewPaciente);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = odontologo.getIdOdontologo();
                if (findOdontologo(id) == null) {
                    throw new NonexistentEntityException("The odontologo with id " + id + " no longer exists.");
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
            Odontologo odontologo;
            try {
                odontologo = em.getReference(Odontologo.class, id);
                odontologo.getIdOdontologo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The odontologo with id " + id + " no longer exists.", enfe);
            }
            List<Paciente> pacientes = odontologo.getPacientes();
            for (Paciente pacientesPaciente : pacientes) {
                pacientesPaciente.setOdontologo(null);
                pacientesPaciente = em.merge(pacientesPaciente);
            }
            em.remove(odontologo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Odontologo> findOdontologoEntities() {
        return findOdontologoEntities(true, -1, -1);
    }

    public List<Odontologo> findOdontologoEntities(int maxResults, int firstResult) {
        return findOdontologoEntities(false, maxResults, firstResult);
    }

    private List<Odontologo> findOdontologoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Odontologo.class));
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

    public Odontologo findOdontologo(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Odontologo.class, id);
        } finally {
            em.close();
        }
    }

    public int getOdontologoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Odontologo> rt = cq.from(Odontologo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
