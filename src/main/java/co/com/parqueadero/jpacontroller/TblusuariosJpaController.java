/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.parqueadero.jpacontroller;

import co.com.parqueadero.entities.Tblusuarios;
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
public class TblusuariosJpaController implements Serializable {

    public TblusuariosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tblusuarios tblusuarios) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tblusuarios);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTblusuarios(tblusuarios.getUsuario()) != null) {
                throw new PreexistingEntityException("Tblusuarios " + tblusuarios + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tblusuarios tblusuarios) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tblusuarios = em.merge(tblusuarios);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tblusuarios.getUsuario();
                if (findTblusuarios(id) == null) {
                    throw new NonexistentEntityException("The tblusuarios with id " + id + " no longer exists.");
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
            Tblusuarios tblusuarios;
            try {
                tblusuarios = em.getReference(Tblusuarios.class, id);
                tblusuarios.getUsuario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tblusuarios with id " + id + " no longer exists.", enfe);
            }
            em.remove(tblusuarios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tblusuarios> findTblusuariosEntities() {
        return findTblusuariosEntities(true, -1, -1);
    }

    public List<Tblusuarios> findTblusuariosEntities(int maxResults, int firstResult) {
        return findTblusuariosEntities(false, maxResults, firstResult);
    }

    private List<Tblusuarios> findTblusuariosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tblusuarios.class));
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

    public Tblusuarios findTblusuarios(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tblusuarios.class, id);
        } finally {
            em.close();
        }
    }

    public Tblusuarios findTblusuarios(String usuario, String clave) {
        EntityManager em = getEntityManager();
        Tblusuarios tblusuarios = null;
        tblusuarios = (Tblusuarios) em.createNativeQuery("Tblusuarios.findByUsuarioClave").setParameter("usuario", usuario).setParameter("clave", clave).getSingleResult();

        return tblusuarios;
    }

    public int getTblusuariosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tblusuarios> rt = cq.from(Tblusuarios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
