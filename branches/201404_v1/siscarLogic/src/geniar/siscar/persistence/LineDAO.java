package geniar.siscar.persistence;

import geniar.siscar.model.Line;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for Line
 * entities. Transaction control of the save(), update() and delete() operations
 * must be handled externally by senders of these methods or must be manually
 * added to each of these methods for data to be persisted to the JPA datastore.
 * 
 * @see geniar.siscar.model.Line
 * @author MyEclipse Persistence Tools
 */

public class LineDAO implements ILineDAO {
	// property constants
	public static final String LIN_VALOR = "linValor";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved Line entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * LineDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Line entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Line entity) {
		EntityManagerHelper.log("saving Line instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Line entity. This operation must be performed within
	 * the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * LineDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Line entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Line entity) {
		EntityManagerHelper.log("deleting Line instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(Line.class,
					entity.getLinId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved Line entity and return it or a copy of it to
	 * the sender. A copy of the Line entity parameter is returned when the JPA
	 * persistence mechanism has not previously been tracking the updated
	 * entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = LineDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Line entity to update
	 * @return Line the persisted Line entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Line update(Line entity) {
		EntityManagerHelper.log("updating Line instance", Level.INFO, null);
		try {
			Line result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public Line findById(Long id) {
		EntityManagerHelper.log("finding Line instance with id: " + id,
				Level.INFO, null);
		try {
			Line instance = getEntityManager().find(Line.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all Line entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Line property to query
	 * @param value
	 *            the property value to match
	 * @return List<Line> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Line> findByProperty(String propertyName, final Object value) {
		EntityManagerHelper.log("finding Line instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Line model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	public List<Line> findByLinValor(Object linValor) {
		return findByProperty(LIN_VALOR, linValor);
	}

	/**
	 * Find all Line entities.
	 * 
	 * @return List<Line> all Line entities
	 */
	@SuppressWarnings("unchecked")
	public List<Line> findAll() {
		EntityManagerHelper.log("finding all Line instances", Level.INFO, null);
		try {
			final String queryString = "select model from Line model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}