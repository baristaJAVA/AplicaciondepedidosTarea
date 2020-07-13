/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.exceptions.NonexistentEntityException;
import entities.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author nacho
 */
public class CrearuaJpaController implements Serializable {

    public CrearuaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Crearua crearua) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(crearua);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCrearua(crearua.getIDcreacionUA()) != null) {
                throw new PreexistingEntityException("Crearua " + crearua + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Crearua crearua) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            crearua = em.merge(crearua);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = crearua.getIDcreacionUA();
                if (findCrearua(id) == null) {
                    throw new NonexistentEntityException("The crearua with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Crearua crearua;
            try {
                crearua = em.getReference(Crearua.class, id);
                crearua.getIDcreacionUA();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The crearua with id " + id + " no longer exists.", enfe);
            }
            em.remove(crearua);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Crearua> findCrearuaEntities() {
        return findCrearuaEntities(true, -1, -1);
    }

    public List<Crearua> findCrearuaEntities(int maxResults, int firstResult) {
        return findCrearuaEntities(false, maxResults, firstResult);
    }

    private List<Crearua> findCrearuaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Crearua.class));
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

    public Crearua findCrearua(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Crearua.class, id);
        } finally {
            em.close();
        }
    }

    public int getCrearuaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Crearua> rt = cq.from(Crearua.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
