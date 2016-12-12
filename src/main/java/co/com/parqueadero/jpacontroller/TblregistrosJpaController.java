/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.parqueadero.jpacontroller;

import co.com.parqueadero.entities.Tblregistros;
import co.com.parqueadero.jpacontroller.exceptions.NonexistentEntityException;
import co.com.parqueadero.jpacontroller.exceptions.PreexistingEntityException;
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
 * @author sala304
 */
public class TblregistrosJpaController implements Serializable {

    public TblregistrosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tblregistros tblregistros) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tblregistros);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTblregistros(tblregistros.getPlaca()) != null) {
                throw new PreexistingEntityException("Tblregistros " + tblregistros + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tblregistros tblregistros) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tblregistros = em.merge(tblregistros);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tblregistros.getPlaca();
                if (findTblregistros(id) == null) {
                    throw new NonexistentEntityException("The tblregistros with id " + id + " no longer exists.");
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
            Tblregistros tblregistros;
            try {
                tblregistros = em.getReference(Tblregistros.class, id);
                tblregistros.getPlaca();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tblregistros with id " + id + " no longer exists.", enfe);
            }
            em.remove(tblregistros);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tblregistros> findTblregistrosEntities() {
        return findTblregistrosEntities(true, -1, -1);
    }

    public List<Tblregistros> findTblregistrosEntities(int maxResults, int firstResult) {
        return findTblregistrosEntities(false, maxResults, firstResult);
    }

    private List<Tblregistros> findTblregistrosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tblregistros.class));
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

    public Tblregistros findTblregistros(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tblregistros.class, id);
        } finally {
            em.close();
        }
    }

    public int getTblregistrosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tblregistros> rt = cq.from(Tblregistros.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
