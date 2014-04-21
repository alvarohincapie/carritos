package geniar.siscar.taskmanager;

import geniar.siscar.logic.notification.services.impl.NotificationsServiceImpl;
import geniar.siscar.util.ManipulacionFechas;
import geniar.siscar.util.Util;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Clase en donde se programa la tarea automatica para ser ejecutada
 * 
 * @FechaCreacion (dd-mm-aaaa) 11-06-2007
 */
public class NotificationReservVehiclesNotGathered extends TimerTask {
	private Timer timer = null;
	private String repeticionHorasStr;
	private String factorConversionHorasMilisegs;
	private static final Log log = LogFactory.getLog(NotificationReservVehiclesNotGathered.class);

	/**
	 * Constructor de la Tarea
	 * 
	 * @FechaCreacion (dd-mm-aaaa) 11-06-2007
	 * @param time
	 */
	public NotificationReservVehiclesNotGathered(Date time) {
		try {
			repeticionHorasStr = Util.loadParametersValue("REPETICION_TAREA_AUTOMATICA_HORAS");

			factorConversionHorasMilisegs = Util.loadParametersValue("FACTOR_CONVERSION_HORAS_MILISEGS");

			long repeticionHoras = Long.parseLong(repeticionHorasStr);

			long factorConversion = Long.parseLong(factorConversionHorasMilisegs);

			long repeticionMilisegundos = repeticionHoras * factorConversion;

			setTimer(new Timer());

			getTimer().scheduleAtFixedRate(new NotificationReservVehiclesNotGathered(), time, repeticionMilisegundos);
		} catch (NumberFormatException e) {
			log.error(e);
		} catch (Exception e) {
			log.error(e);
		}
	}

	// Constructor sin parametros
	public NotificationReservVehiclesNotGathered() {

	}

	/**
	 * Metodo para terminar el hilo de la tarea
	 * 
	 * @author Geniar S.A
	 * @FechaCreacion (dd-mm-aaaa) 11-06-2007
	 * @return void
	 */
	public void killTarea() {
		super.cancel();
	}

	/**
	 * Metodo abstracto implementado de la super clase TimerTask para la
	 * ejecucion de la Tarea
	 * 
	 * @author Geniar S.A
	 * @FechaCreacion (dd-mm-aaaa) 11-06-2007
	 * @return void
	 */
	public void run() {
		Date fechaActual = new Date();
		try {
			// Actual
			int horaActual = Integer.parseInt(ManipulacionFechas.getHora(fechaActual));
			int minutosActual = Integer.parseInt(ManipulacionFechas.getMinutos(fechaActual));

			int horaInicialRangoEjecucion = Integer.parseInt(Util.loadParametersValue("HORA_INICIAL_RANGO_EJECUCION_III"));
			int minutosInicialRangoEjecucion = Integer.parseInt(Util.loadParametersValue("MINUTOS_INICIAL_RANGO_EJECUCION_III"));

			int horaFinalRangoEjecucion = Integer.parseInt(Util.loadParametersValue("HORA_FINAL_RANGO_EJECUCION_III"));
			int minutosFinalRangoEjecucion = Integer.parseInt(Util.loadParametersValue("MINUTOS_FINAL_RANGO_EJECUCION_III"));

			// Tiempo Actual en Minutos
			int tiempoActual = (horaActual * 60) + minutosActual;

			// Tiempos de Rango de Ejecucion en Minutos
			int rangoInicial = (horaInicialRangoEjecucion * 60) + minutosInicialRangoEjecucion;
			int rangoFinal = (horaFinalRangoEjecucion * 60) + minutosFinalRangoEjecucion;

			// Pregunta si la hora actual esta dentro del rango de ejecucion de
			// la tarea
			if ((tiempoActual >= rangoInicial) && (tiempoActual <= rangoFinal)) {
				Date start = new Date();
				log.info("--- Corriendo proceso automatico Envio de notificacion veh�culos reservados no recogidos: "+ start + "----");
				new NotificationsServiceImpl().notificacionVehiculosReservadosNoRecogidos();

				Date end = new Date();
				log.info("--- Termina proceso Envio de notificaciones automaticas " + start + "----");
				log.info(end.getTime() - start.getTime() + " total milliseconds en realizar tarea automatica: ");

			}// Fin if
			else {
				log.info("--- Tarea Automatica de notificacion veh�culos reservados no recogidos en espera... "+ new Date() + " ----");
			}
		} catch (Exception e) {
			log.error("Error RUN Tarea Automatica de notificacion fecha de terminacion: " + e.getMessage());
		}

		fechaActual = null;

	}// fin del metodo run()

	// *********************************************** Metodos de Acceso
	// ***********************************************

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public String getRepeticionHorasStr() {
		return repeticionHorasStr;
	}

	public void setRepeticionHorasStr(String repeticionHorasStr) {
		this.repeticionHorasStr = repeticionHorasStr;
	}

	public String getFactorConversionHorasMilisegs() {
		return factorConversionHorasMilisegs;
	}

	public void setFactorConversionHorasMilisegs(String factorConversionHorasMilisegs) {
		this.factorConversionHorasMilisegs = factorConversionHorasMilisegs;
	}

}