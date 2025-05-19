package twp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameUserInterface {
    private Scanner scanner;

    public GameUserInterface() {
        scanner = new Scanner(System.in);
    }

    public void showInventory(Player player) {
        List<Item> items = player.getInventory();
        if (items.size() == 0) {
            System.out.println("Du har ikke noget i dit inventory");
        } else if (items.size() <= 3) {
            // Show a nice compact list if max. carrying three things
            System.out.println("Du bærer på " + prettyCommaSeparatedList(items));

        } else {
            System.out.println("Du bærer på: ");
            for (Item item : items) {
                System.out.print(" - " + item);
            }
            System.out.println();
        }
    }

    public String[] readInput() {
        System.out.println("Venter på din kommando:");
        String[] commands = scanner.nextLine().trim().toLowerCase().split(" ");
        return commands;
    }

    public void describeRoom(Room room) {
        System.out.println(room.getDescription());
        ArrayList<Item> items = room.getItem();
        ArrayList<Creature> creatures = room.getCreatures();
        if (!items.isEmpty()) {
            System.out.print("Items i rummet: ");
            for (Item item: items) {
                System.out.print(item.getItemDescription() + " ");
            }
            System.out.println();
        }
        System.out.println();


        if (!creatures.isEmpty()){
        System.out.print("Disse kreaturer er i rummet: ");
        for (Creature creature: creatures) {
            System.out.print(creature.displayCreature() + " ");
        }
        System.out.println();}
    }

    public void printWelcome() {
        System.out.println("Velkommen til Stjernepræsternes stjernekatedral!\n");
        System.out.println("Tast HJÆLP eller INFO for instrukser\n");
        System.out.println("I en svunden æra, før landene blev adskilt af kongedømmer og krige, styrede Stjernepræsterne over et folk, der lyttede til himlen.\n" +
                "De byggede en enorm, stenkold katedral dybt under jorden – ikke for at tilbede guder, men for at forstå stjernernes stemmer.\n" +
                "Det siges, at rummet og tidens mønstre blev mejslet i væggene og ændrede sig efter himlens bevægelser.\n" +
                "En dag forsvandt præsterne. Uden varsel. Katedralen blev forseglet, og i århundreder blev den glemt.\n" +
                "Men stjernerne er begyndt at bevæge sig forkert. Kometer kredser mod Jorden i omvendte baner.\nMennesker drømmer om en stemme, der hvisker:\n" +
                "“Tænd lyset. Syv flammer for at vække balancen.”\n" +
                "Du er én af de få, der mærker kaldet. Legender siger, at syv stjerner blev tændt i katedralen for at holde kaos i skak. Nu er de slukket.\n" +
                "Du stiger ned i mørket, alene, kun med din viden og dit mod, for at finde og tænde de syv stjernelys igen\n— og måske forstå, hvad der skete med præsterne… og hvorfor de aldrig vendte tilbage.\n");
        System.out.println("Tænd de syv lys i rummene og få adgang til de sidste rum");
    }

    public void showHelp() {
        System.out.println("""
                Instruktioner
                ------------
                Skriv kommandoen efterfulgt med enter. Store eller små bogstaver betyder ikke noget
                Disse kommandoer virker i spillet:
                 Hjælp  eller INFO, viser dette tip
                 Gå     Efterfulgt af hvilken retning du vil gå: Fremad, baglæns, Op, Ned hvis det er muligt
                        Eller du kan bare skrive en retning eller det ene bogstav på retningen du vil gå
                 Kig    Du kigger dig omkring og får beskrevet hvad du kan se
                 Tag    Efterfulgt af navnet på item'et, for at samle det op
                 Exit   Slutter spillet
                 Use    Bruger det item du har i dit inventory
                """);
    }

    private String prettyCommaSeparatedList(List items) {
        StringBuilder str = new StringBuilder();
        int length = items.size();
        for (int i = 0; i < length; i++) {
            str.append(items.get(i));
            if (i == length - 2) {
                str.append(" og ");
            } else if (i < length - 2) {
                str.append(", ");
            }
        }
        return str.toString();
    }

    public void printMessage(String message)
    {
        System.out.println(message);
    }

}
