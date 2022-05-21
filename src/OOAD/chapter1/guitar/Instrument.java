package OOAD.chapter1.guitar;

public class Instrument {
    private String serialNumber;
    private Double price;
    private InstrumentSpec spec;

    public Instrument(String serialNumber, double price, InstrumentSpec spec) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.spec = spec;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public Double getPrice() {
        return price;
    }

    public InstrumentSpec getSpec() {
        return spec;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setSpec(InstrumentSpec spec) {
        this.spec = spec;
    }
}
