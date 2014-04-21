package geniar.siscar.logic.billing.services;

import java.util.List;

import geniar.siscar.model.AccountingParameters;
import gwork.exception.GWorkException;

/**
 * The Interface AccountingParametersService.
 */
public interface AccountingParametersService {

	/**
	 * Crear un nuevo parametro contable con los valores especificados.
	 *
	 * @param idTipoAsignacion Identificador del tipo de Asignaci�n.
	 * @param idTipoTransaccion Identificador del tipo de transacci�n.
	 * @param idTipoMovimiento Identificador del tipo de movimiento.
	 * @param idTipoCargo Identificador del tipo de cargo.
	 * @param idCompany Identificador de la compa�ia.
	 * @param idNumeroCuenta Identificador del n�mero de cuenta.
	 * @param idCentroCosto Identificador del centro de costo.
	 * @param idNumeroLinea Identificador del n�mero de l�nea.
	 * @param idAuxiliar Identificador del auxiliar.
	 * @param idTipoControl Identificador del tipo de control.
	 * @param idFuturo Identificador de futuro.
	 * @param idDescripcion Identificador del tipo de descripci�n.
	 * @param idTipoDocUno Identificador del tipo de documento 1.
	 * @param idNumDocUno Identificador del n�mero de documento 1.
	 * @param idTipoDocDos Identificador del tipo de documento 2
	 * @param idNumDocDos Identificador del n�mero de documento 2.
	 * @param idAtributo Identificador del atributo.
	 * @param descripcion Descripci�n del par�metro contable
	 * @param idTipoLocalizacion the id tipo localizacion
	 * @throws GWorkException Manejador de Excepciones.
	 */
	public void crearParametroContable(Long idTipoAsignacion,
			Long idTipoTransaccion, Long idTipoMovimiento, Long idTipoCargo,
			Long idCompany, Long idNumeroCuenta, Long idCentroCosto,
			Long idNumeroLinea, Long idAuxiliar, Long idTipoControl,
			Long idFuturo, Long idDescripcion, Long idTipoDocUno,
			Long idNumDocUno, Long idTipoDocDos, Long idNumDocDos,
			Long idAtributo, String descripcion, Long idTipoLocalizacion,
			Boolean acpState) throws GWorkException;

	/**
	 * Modifica un parametro contable con los valores especificados.
	 *
	 * @param idParametroContable the id parametro contable
	 * @param idTipoAsignacion Identificador del tipo de Asignaci�n.
	 * @param idTipoTransaccion Identificador del tipo de transacci�n.
	 * @param idTipoMovimiento Identificador del tipo de movimiento.
	 * @param idTipoCargo Identificador del tipo de cargo.
	 * @param idCompany Identificador de la compa�ia.
	 * @param idNumeroCuenta Identificador del n�mero de cuenta.
	 * @param idCentroCosto Identificador del centro de costo.
	 * @param idNumeroLinea Identificador del n�mero de l�nea.
	 * @param idAuxiliar Identificador del auxiliar.
	 * @param idTipoControl Identificador del tipo de control.
	 * @param idFuturo Identificador de futuro.
	 * @param idDescripcion Identificador del tipo de descripci�n.
	 * @param idTipoDocUno Identificador del tipo de documento 1.
	 * @param idNumDocUno Identificador del n�mero de documento 1.
	 * @param idTipoDocDos Identificador del tipo de documento 2
	 * @param idNumDocDos Identificador del n�mero de documento 2.
	 * @param idAtributo Identificador del atributo.
	 * @param descripcion Descripci�n del par�metro contable
	 * @throws GWorkException Manejador de Excepciones.
	 */
	public void modificarParametroContable(Long idParametroContable,
			Long idTipoAsignacion, Long idTipoTransaccion,
			Long idTipoMovimiento, Long idTipoCargo, Long idCompany,
			Long idNumeroCuenta, Long idCentroCosto, Long idNumeroLinea,
			Long idAuxiliar, Long idTipoControl, Long idFuturo,
			Long idDescripcion, Long idTipoDocUno, Long idNumDocUno,
			Long idTipoDocDos, Long idNumDocDos, Long idAtributo,
			String descripcion, Long idTipoLocalizacion,
			Boolean acpState) throws GWorkException;

	/**
	 * Consulta un parametro contable por los parametros especificados.
	 *
	 * @param idTipoAsignacion Identificador del tipo de Asignaci�n.
	 * @param idTipoTransaccion Identificador del tipo de transacci�n.
	 * @param idTipoMovimiento Identificador del tipo de Movimiento;
	 * @param idCuentaContable the id cuenta contable
	 * @param idTipoLocalizacion the id tipo localizacion
	 * @return Listado de objetos {@link AccountingParameters}.
	 * @throws GWorkException the g work exception
	 */
	public List<AccountingParameters> consultarParametroContable(
			Long idTipoAsignacion, Long idTipoTransaccion,
			Long idTipoMovimiento, Long idCuentaContable, Long idTipoLocalizacion) throws GWorkException;

	/**
	 * Elimina un parametro contable.
	 * 
	 * @param idParametroContable
	 *            Identificador del parametro contable.
	 * @throws GWorkException
	 *             Manejador de Excepciones.
	 */
	public void eliminarParametroContable(Long idParametroContable)
			throws GWorkException;;
}