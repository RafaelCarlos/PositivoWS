package com.rafaelcarlos.repositorios;

import com.rafaelcarlos.positivo.util.JpaUtil;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * @author Rafael Carlos
 * @since 12/12/2015
 */
public class RepositorioGenerico<PK, T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private final EntityManager entityManager;
    private final Class classePersistente;
    private final Logger log;

    public RepositorioGenerico() {
        this.entityManager = JpaUtil.getEntityManager();
        this.classePersistente = getTipoDeClasse();
        this.log = LogManager.getLogger(classePersistente.getName());
    }

    public RepositorioGenerico(EntityManager managerTestes) {
        this.entityManager = managerTestes;
        this.classePersistente = getTipoDeClasse();
        this.log = LogManager.getLogger(classePersistente.getName());
    }

    public RepositorioGenerico(Class classe) {
        this.entityManager = JpaUtil.getEntityManager();
        this.classePersistente = classe;
        this.log = LogManager.getLogger(classePersistente.getName());
    }

    public RepositorioGenerico(Class classe, EntityManager manager) {
        this.entityManager = manager;
        this.classePersistente = classe;
        this.log = LogManager.getLogger(classePersistente.getName());
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public T getPorId(PK pk) {
        return (T) entityManager.find(classePersistente, pk);
    }

    /**
     *
     * @param jpql
     * @param params
     * @return Método responsável por retornar um select com parâmetros. Retorna
     * uma consulta personalizada.
     */
    public List<T> find(String jpql, Object... params) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery(jpql);

        for (int i = 0; i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }

        List<T> entities = query.getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return entities;
    }

    /**
     * Método responsável por retornar todos os registros.
     *
     * @return
     */
    public List<T> findAll() {
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();

        Query query = manager.createQuery("from " + classePersistente.getSimpleName());

        List<T> entities = query.getResultList();

        manager.getTransaction().commit();
        manager.close();

        return entities;
    }

    public T findOne(String jpql, Object... params) {
        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();

        Query query = manager.createQuery(jpql);

        for (int i = 0; i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }

        T entity = (T) query.getSingleResult();

        manager.getTransaction().commit();
        manager.close();

        return entity;
    }

    /**
     * Metodo responsavel por retornar a quantidade de registros de uma tabela.
     *
     * @return
     */
    public Integer count() {
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("select count(c) from " + classePersistente.getSimpleName() + " c");

        Integer count = (Integer) query.getSingleResult();

        entityManager.getTransaction().commit();
        entityManager.close();

        return count;
    }

    public boolean salvar(T entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            if (entityManager.isOpen()) {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
            }
            log.error("Erro ao Salvar objeto: " + entity.toString());
            log.error("Causa do erro: " + ex.getMessage());
            return false;
        }
    }

    public boolean atualizar(T entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            if (entityManager.isOpen()) {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
            }
            log.error("Erro ao Editar Objeto: " + entity.toString());
            log.error("Causa do erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    public boolean excluir(T entity) {
        try {
            entityManager.getTransaction().begin();
            T obj = entityManager.merge(entity);
            entityManager.remove(obj);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            if (entityManager.isOpen()) {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
            }
            log.error("Erro ao Excluir objeto: " + entity.toString());
            log.error("Causa do erro: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    public List<T> getList() {
        return entityManager.createQuery("FROM " + classePersistente.getName() + " ORDER BY id").getResultList();
    }

    public static void closeEntityManagers() {
        EntityManager em = JpaUtil.getThreadEntityManager().get();
        if (em != null) {
            EntityTransaction transaction = em.getTransaction();
            if (transaction.isActive()) {
                transaction.commit();
            }
            em.close();
            JpaUtil.getThreadEntityManager().set(null);
        }
    }

    private Class<?> getTipoDeClasse() {
        return (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
}
