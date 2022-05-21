package OOAD.chapter1.guitar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory {
    private List inventory;
    public  Inventory (){
        inventory = new ArrayList();
    }

    public void addInstrument(String serialNumber, double price, InstrumentSpec spec) {
        Instrument instrument = new Instrument(serialNumber,price,spec);
        inventory.add(instrument);
    }

    public Instrument get(String serialNumber) {
        for (Iterator iterator = inventory.iterator(); iterator.hasNext();){
            Instrument instrument = (Instrument) iterator.next();
            if(instrument.getSerialNumber().equals(serialNumber)) {
                return instrument;
            }
        }
        return null;
    }

    public List<Instrument> search(InstrumentSpec searchSpec) {
        List<Instrument> matchingInstrument = new ArrayList<>();
        for(Iterator iterator = inventory.iterator(); iterator.hasNext();) {
            Instrument instrument = (Instrument) iterator.next();
            if(instrument.getSpec().matches(searchSpec)) {
                matchingInstrument.add(instrument);
            }
        }
        return matchingInstrument;
    }
}
