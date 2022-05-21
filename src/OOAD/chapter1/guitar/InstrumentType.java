package OOAD.chapter1.guitar;

public enum  InstrumentType {
    GUITAR, BANJO, DOBRO, FIDDLE, BASS, MANDOLIN; // so far these are the types of instrument
    // that Rick sells
    // toString() just makes it easier to print things out
    public  String toString() {
        switch (this) {
            case GUITAR: return "Guitar";
            case BANJO: return "Banjo";
            case DOBRO: return "Dobro";
            case FIDDLE: return "Fiddle";
            case BASS: return  "Bass";
            case MANDOLIN: return "Mandolin";
            default: return  "Unspecified";
        }
    }

}
