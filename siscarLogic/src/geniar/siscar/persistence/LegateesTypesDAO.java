package geniar.siscar.persistence;
// default package

import geniar.siscar.model.LegateesTypes;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * LegateesTypes entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see .LegateesTypes
 * @author MyEclipse Persistence Tools
 */

public class LegateesTypesDAO implements ILegateesTypesDAO {
	// property constants
	public static final String LGT_NOMBRE = "lgtNombre";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved LegateesTypes entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * LegateesTypesDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            LegateesTypes entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(LegateesTypes entity) {
		EntityManagerHelper.log("saving LegateesTypes instance", Level.INFO,
				null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent LegateesTypes entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * LegateesTypesDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            LegateesTypes entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(LegateesTypes entity) {
		EntityManagerHelper.log("deleting LegateesTypes instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(LegateesTypes.class,
					entity.getLgtCodigo());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved LegateesTypes entity and return it or a copy
	 * of it to the sender. A copy of the LegateesTypes entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = LegateesTypesDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            LegateesTypes entity to update
	 * @return LegateesTypes the persisted LegateesTypes entity instance, may
	 *         not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public LegateesTypes update(LegateesTypes entity) {
		EntityManagerHelper.log("updating LegateesTypes instance", Level.INFO,
				null);
		try {
			LegateesTypes result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public LegateesTypes findById(Long id) {
		EntityManagerHelper.log(
				"finding LegateesTypes instance with id: " + id, Level.INFO,
				null);
		try {
			LegateesTypes instance = getEntityManager().find(
					LegateesTypes.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all LegateesTypes entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the LegateesTypes property to query
	 * @param value
	 *            the property value to match
	 * @return List<LegateesTypes> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<LegateesTypes> findByProperty(String propertyName,
			final Object value) {
		EntityManagerHelper.log(
				"finding LegateesTypes instance with property: " + propertyName
						+ ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from LegateesTypes model where model."
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

	public List<LegateesTypes> findByLgtNombre(Object lgtNombre) {
		return findByProperty(LGT_NOMBRE, lgtNombre);
	}

	/**
	 * Find all LegateesTypes entities.
	 * 
	 * @return List<LegateesTypes> all LegateesTypes entities
	 */
	@SuppressWarnings("unchecked")
	public List<LegateesTypes> findAll() {
		EntityManagerHelper.log("finding all LegateesTypes instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from LegateesTypes model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}