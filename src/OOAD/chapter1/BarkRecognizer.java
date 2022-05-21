package OOAD.chapter1;

import java.util.List;

public class BarkRecognizer {
    private DogDoor door;
    BarkRecognizer(DogDoor door) {
        this.door = door;
    }
    public void recognize(Bark bark) {
        System.out.println(" BarkRecognizer: Heard  a sound '" + bark.getSound() + "'");
        List<Bark> allowedBarks = door.getAllowedBarks(bark);
        for (int i = 0; i < allowedBarks.size() ; i++) {
            Bark allowedBark = (Bark) allowedBarks.get(i);
            if(allowedBark.equals(bark)) {
                door.open();
                return;
            }
        }
        System.out.println("The dog is not allowed");
    }
}
