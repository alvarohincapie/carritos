
package ciat.siscarMobile.services.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "consultarCostCenterFuelPorPlacaResponse", namespace = "http://services.siscarMobile.ciat/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultarCostCenterFuelPorPlacaResponse", namespace = "http://services.siscarMobile.ciat/")
public class ConsultarCostCenterFuelPorPlacaResponse {

    @XmlElement(name = "return", namespace = "")
    private List<geniar.siscar.model.VOCostCentersFuels> _return;

    /**
     * 
     * @return
     *     returns List<VOCostCentersFuels>
     */
    public List<geniar.siscar.model.VOCostCentersFuels> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<geniar.siscar.model.VOCostCentersFuels> _return) {
        this._return = _return;
    }

}
