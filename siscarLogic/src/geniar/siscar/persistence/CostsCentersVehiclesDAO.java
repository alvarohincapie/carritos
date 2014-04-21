package geniar.siscar.persistence;

import geniar.siscar.model.CostsCentersVehicles;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * CostsCentersVehicles entities. Transaction control of the save(), update()
 * and delete() operations must be handled externally by senders of these
 * methods or must be manually added to each of these methods for data to be
 * persisted to the JPA datastore.
 * 
 * @see geniar.siscar.model.CostsCentersVehicles
 * @author MyEclipse Persistence Tools
 */

public class CostsCentersVehiclesDAO implements ICostsCentersVehiclesDAO {
	// property constants
	public static final String CCR_PORCENTAJE = "ccrPorcentaje";
	public static final String CCR_VALOR = "ccrValor";
	public static final String CCR_LOGIN = "ccrLogin";
	public static final String CCR_ESTADO = "ccrEstado";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved CostsCentersVehicles
	 * entity. All subsequent persist actions of this entity should use the
	 * #update() method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * CostsCentersVehiclesDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            CostsCentersVehicles entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(CostsCentersVehicles entity) {
		EntityManagerHelper.log("saving CostsCentersVehicles instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent CostsCentersVehicles entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * CostsCentersVehiclesDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            CostsCentersVehicles entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(CostsCentersVehicles entity) {
		EntityManagerHelper.log("deleting CostsCentersVehicles instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(CostsCentersVehicles.class, entity.getCcrCodigo());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved CostsCentersVehicles entity and return it or a
	 * copy of it to the sender. A copy of the CostsCentersVehicles entity
	 * parameter is returned when the JPA persistence mechanism has not
	 * previously been tracking the updated entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently saved to the persistence store, i.e., database. This
	 * method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = CostsCentersVehiclesDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            CostsCentersVehicles entity to update
	 * @returns CostsCentersVehicles the persisted CostsCentersVehicles entity
	 *          instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public CostsCentersVehicles update(CostsCentersVehicles entity) {
		EntityManagerHelper.log("updating CostsCentersVehicles instance", Level.INFO, null);
		try {
			CostsCentersVehicles result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public CostsCentersVehicles findById(Long id) {
		EntityManagerHelper.log("finding CostsCentersVehicles instance with id: " + id, Level.INFO, null);
		try {
			CostsCentersVehicles instance = getEntityManager().find(CostsCentersVehicles.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all CostsCentersVehicles entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the CostsCentersVehicles property to query
	 * @param value
	 *            the property value to match
	 * @return List<CostsCentersVehicles> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<CostsCentersVehicles> findByProperty(String propertyName, final Object value) {
		EntityManagerHelper.log("finding CostsCentersVehicles instance with property: " + propertyName + ", value: "
				+ value, Level.INFO, null);
		try {
			final String queryString = "select model from CostsCentersVehicles model where model." + propertyName
					+ "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed", Level.SEVERE, re);
			throw re;
		}
	}

	public List<CostsCentersVehicles> findByCcrPorcentaje(Object ccrPorcentaje) {
		return findByProperty(CCR_PORCENTAJE, ccrPorcentaje);
	}

	public List<CostsCentersVehicles> findByCcrValor(Object ccrValor) {
		return findByProperty(CCR_VALOR, ccrValor);
	}

	public List<CostsCentersVehicles> findByCcrLogin(Object ccrLogin) {
		return findByProperty(CCR_LOGIN, ccrLogin);
	}

	public List<CostsCentersVehicles> findByCcrEstado(Object ccrEstado) {
		return findByProperty(CCR_ESTADO, ccrEstado);
	}

	/**
	 * Find all CostsCentersVehicles entities.
	 * 
	 * @return List<CostsCentersVehicles> all CostsCentersVehicles entities
	 */
	@SuppressWarnings("unchecked")
	public List<CostsCentersVehicles> findAll() {
		EntityManagerHelper.log("finding all CostsCentersVehicles instances", Level.INFO, null);
		try {
			final String queryString = "select model from CostsCentersVehicles model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}