package OOAD.chapter1;

public class DogDoorSimulator {
    public static void main(String[] args) {
        DogDoor door = new DogDoor();
        door.addAllowedBarks(new Bark("rowlf"));
        door.addAllowedBarks(new Bark("rooowlf"));
        door.addAllowedBarks(new Bark("rawlf"));
        door.addAllowedBarks(new Bark("rowlf"));
        door.addAllowedBarks(new Bark("woof"));
        BarkRecognizer recognizer = new BarkRecognizer(door);
      //  Remote  remote  = new Remote(door);

        // Simulate the hardware hearing a bark
        System.out.println("Bruce started barking");
        recognizer.recognize(new Bark("rowlf"));
        System.out.println("\n Bruce has gone outside");
       try{
            Thread.sleep(10000);
        }catch (InterruptedException e) {}
        System.out.println("\n Bruce's all done");
        System.out.println("... but he's stuck outside");

        // Simulate the hardware hearing a bark (not Bruce!)
        Bark smallDogBark = new Bark("yip");
        System.out.println("A small dog starts barking");
        recognizer.recognize(smallDogBark);

        try {
            Thread.sleep(5000);
        }catch (InterruptedException e) {}
        // Simulate the hardware hearing a bark again
        recognizer.recognize(new Bark("Rowlf"));
        System.out.println("\n Bruce's back inside..");
    }



}
