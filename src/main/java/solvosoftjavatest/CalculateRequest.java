//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.04.16 a las 10:13:23 AM CST 
//


package solvosoftjavatest;

import javax.xml.bind.annotation.*;
import java.util.Collections;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "inputs"
})
@XmlRootElement(name = "calculateRequest")
public class CalculateRequest {

    @XmlElement(name="input")
    protected List<String> inputs;

    public List<String> getInputs() {
        if (inputs == null) {
            inputs = Collections.emptyList();
        }
        return this.inputs;
    }

}
