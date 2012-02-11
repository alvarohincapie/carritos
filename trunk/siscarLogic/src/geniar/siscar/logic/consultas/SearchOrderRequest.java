package geniar.siscar.logic.consultas;

import geniar.siscar.model.LegateesTypes;
import geniar.siscar.model.RequestsClasses;
import geniar.siscar.model.RequestsStates;
import geniar.siscar.model.RequestsTypes;
import geniar.siscar.persistence.EntityManagerHelper;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.Query;

/**
 * The Class SearchOrderRequest.
 */
public class SearchOrderRequest {

	/**
	 * Request states order.
	 *
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<RequestsStates> requestStatesOrder() {
		EntityManagerHelper.log("finding all RequestsStates instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from RequestsStates model ORDER BY model.rqtNombre ASC";
			Query query = EntityManagerHelper.getEntityManager().createQuery(
					queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Legatees types order.
	 *
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<LegateesTypes> legateesTypesOrder() {
		EntityManagerHelper.log("finding all LegateesTypes instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from LegateesTypes model WHERE model.lgtCodigo in (1,2,3,4,5,6) "
					+ "ORDER BY model.lgtNombre ASC";
			Query query = EntityManagerHelper.getEntityManager().createQuery(
					queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}
	
	/**
	 * Request classes order.
	 *
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<RequestsClasses> requestClassesOrder() {
		EntityManagerHelper.log("finding all RequestsClasses instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from RequestsClasses model ORDER BY model.rqcNombre ASC";
			Query query = EntityManagerHelper.getEntityManager().createQuery(
					queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Request types order.
	 *
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	public List<RequestsTypes> requestTypesOrder() {
		EntityManagerHelper.log("finding all RequestsTypes instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from RequestsTypes model ORDER BY model.rqyNombre ASC";
			Query query = EntityManagerHelper.getEntityManager().createQuery(
					queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}
}
