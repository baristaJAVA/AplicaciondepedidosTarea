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
public class UsuariocompradorJpaController implements Serializable {

    public UsuariocompradorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuariocomprador usuariocomprador) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(usuariocomprador);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUsuariocomprador(usuariocomprador.getIDusuarioComprador()) != null) {
                throw new PreexistingEntityException("Usuariocomprador " + usuariocomprador + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuariocomprador usuariocomprador) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            usuariocomprador = em.merge(usuariocomprador);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = usuariocomprador.getIDusuarioComprador();
                if (findUsuariocomprador(id) == null) {
                    throw new NonexistentEntityException("The usuariocomprador with id " + id + " no longer exists.");
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
            Usuariocomprador usuariocomprador;
            try {
                usuariocomprador = em.getReference(Usuariocomprador.class, id);
                usuariocomprador.getIDusuarioComprador();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuariocomprador with id " + id + " no longer exists.", enfe);
            }
            em.remove(usuariocomprador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuariocomprador> findUsuariocompradorEntities() {
        return findUsuariocompradorEntities(true, -1, -1);
    }

    public List<Usuariocomprador> findUsuariocompradorEntities(int maxResults, int firstResult) {
        return findUsuariocompradorEntities(false, maxResults, firstResult);
    }

    private List<Usuariocomprador> findUsuariocompradorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuariocomprador.class));
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

    public Usuariocomprador findUsuariocomprador(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuariocomprador.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuariocompradorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuariocomprador> rt = cq.from(Usuariocomprador.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
