package OOAD.chapter1.guitar;

import javafx.beans.binding.ObjectExpression;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class InstrumentSpec {
    private Map properties;

    public InstrumentSpec(Map properties) {
        if(properties == null)
            this.properties = new HashMap<>();
        else
            this.properties = new HashMap<>(properties);
    }
    public Object getProperty(String propertyName) {
        return properties.get(propertyName);
    }
    public  Map getProperties() {
        return properties;
    }

    public boolean matches(InstrumentSpec otherSpec) {
        for(Iterator<String> i = otherSpec.getProperties().keySet().iterator();
            i.hasNext();) {
            String propertyName = (String)i.next();
            //  Object obj  = otherSpec.getProperty(propertyName);
            if(!properties.get(propertyName).equals(otherSpec.getProperty(propertyName))) {
                return false;
            }
        }
        return true;
    }
}
