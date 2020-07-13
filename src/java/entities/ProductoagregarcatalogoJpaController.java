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
public class ProductoagregarcatalogoJpaController implements Serializable {

    public ProductoagregarcatalogoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Productoagregarcatalogo productoagregarcatalogo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(productoagregarcatalogo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProductoagregarcatalogo(productoagregarcatalogo.getIDagregarPC()) != null) {
                throw new PreexistingEntityException("Productoagregarcatalogo " + productoagregarcatalogo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Productoagregarcatalogo productoagregarcatalogo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            productoagregarcatalogo = em.merge(productoagregarcatalogo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = productoagregarcatalogo.getIDagregarPC();
                if (findProductoagregarcatalogo(id) == null) {
                    throw new NonexistentEntityException("The productoagregarcatalogo with id " + id + " no longer exists.");
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
            Productoagregarcatalogo productoagregarcatalogo;
            try {
                productoagregarcatalogo = em.getReference(Productoagregarcatalogo.class, id);
                productoagregarcatalogo.getIDagregarPC();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The productoagregarcatalogo with id " + id + " no longer exists.", enfe);
            }
            em.remove(productoagregarcatalogo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Productoagregarcatalogo> findProductoagregarcatalogoEntities() {
        return findProductoagregarcatalogoEntities(true, -1, -1);
    }

    public List<Productoagregarcatalogo> findProductoagregarcatalogoEntities(int maxResults, int firstResult) {
        return findProductoagregarcatalogoEntities(false, maxResults, firstResult);
    }

    private List<Productoagregarcatalogo> findProductoagregarcatalogoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Productoagregarcatalogo.class));
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

    public Productoagregarcatalogo findProductoagregarcatalogo(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Productoagregarcatalogo.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductoagregarcatalogoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Productoagregarcatalogo> rt = cq.from(Productoagregarcatalogo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
