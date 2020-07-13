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
public class UsuarioayudaJpaController implements Serializable {

    public UsuarioayudaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuarioayuda usuarioayuda) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(usuarioayuda);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUsuarioayuda(usuarioayuda.getIDRUTusuarioAyuda()) != null) {
                throw new PreexistingEntityException("Usuarioayuda " + usuarioayuda + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuarioayuda usuarioayuda) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            usuarioayuda = em.merge(usuarioayuda);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = usuarioayuda.getIDRUTusuarioAyuda();
                if (findUsuarioayuda(id) == null) {
                    throw new NonexistentEntityException("The usuarioayuda with id " + id + " no longer exists.");
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
            Usuarioayuda usuarioayuda;
            try {
                usuarioayuda = em.getReference(Usuarioayuda.class, id);
                usuarioayuda.getIDRUTusuarioAyuda();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuarioayuda with id " + id + " no longer exists.", enfe);
            }
            em.remove(usuarioayuda);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuarioayuda> findUsuarioayudaEntities() {
        return findUsuarioayudaEntities(true, -1, -1);
    }

    public List<Usuarioayuda> findUsuarioayudaEntities(int maxResults, int firstResult) {
        return findUsuarioayudaEntities(false, maxResults, firstResult);
    }

    private List<Usuarioayuda> findUsuarioayudaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuarioayuda.class));
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

    public Usuarioayuda findUsuarioayuda(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuarioayuda.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioayudaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuarioayuda> rt = cq.from(Usuarioayuda.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
