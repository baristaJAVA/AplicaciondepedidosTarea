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
public class ProductoagregarpedidoJpaController implements Serializable {

    public ProductoagregarpedidoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Productoagregarpedido productoagregarpedido) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(productoagregarpedido);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProductoagregarpedido(productoagregarpedido.getIDagregarPP()) != null) {
                throw new PreexistingEntityException("Productoagregarpedido " + productoagregarpedido + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Productoagregarpedido productoagregarpedido) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            productoagregarpedido = em.merge(productoagregarpedido);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = productoagregarpedido.getIDagregarPP();
                if (findProductoagregarpedido(id) == null) {
                    throw new NonexistentEntityException("The productoagregarpedido with id " + id + " no longer exists.");
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
            Productoagregarpedido productoagregarpedido;
            try {
                productoagregarpedido = em.getReference(Productoagregarpedido.class, id);
                productoagregarpedido.getIDagregarPP();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The productoagregarpedido with id " + id + " no longer exists.", enfe);
            }
            em.remove(productoagregarpedido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Productoagregarpedido> findProductoagregarpedidoEntities() {
        return findProductoagregarpedidoEntities(true, -1, -1);
    }

    public List<Productoagregarpedido> findProductoagregarpedidoEntities(int maxResults, int firstResult) {
        return findProductoagregarpedidoEntities(false, maxResults, firstResult);
    }

    private List<Productoagregarpedido> findProductoagregarpedidoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Productoagregarpedido.class));
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

    public Productoagregarpedido findProductoagregarpedido(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Productoagregarpedido.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductoagregarpedidoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Productoagregarpedido> rt = cq.from(Productoagregarpedido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
