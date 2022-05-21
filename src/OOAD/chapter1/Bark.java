package OOAD.chapter1;

import java.util.Objects;

public class Bark {
    private String sound;

    Bark(String sound) {
        this.sound = sound;
    }

    public String getSound() {
        return sound;
    }

    @Override
    public boolean equals(Object bark) {
        if (bark instanceof  Bark) {
            Bark otherBark = (Bark) bark;
            if(this.sound.equalsIgnoreCase(otherBark.sound)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sound);
    }
}
