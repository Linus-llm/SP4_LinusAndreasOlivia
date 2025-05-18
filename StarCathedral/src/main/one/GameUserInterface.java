package one;

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
        if (!items.isEmpty()) {
            System.out.print("Items i rummet: ");
            for (Item item: items) {
                System.out.print(item.getItemDescription() + " ");
            }
            System.out.println();
        }
    }

    public void printWelcome() {
        System.out.println("Velkommen til Stjernepræsternes stjernekatedral!");
        System.out.println("Tast HJÆLP eller INFO for instrukser til at bevæge dig");
    }

    public void showHelp() {
        System.out.println("""
                Instruktioner
                ------------
                Skriv kommando'en efterfulgt med enter. Store eller små bogstaver betyder ikke noget
                These are the instructions recognized:
                 Hjælp  eller INFO, viser dette tip
                 Gå     Efterfulgt af hvilken retning du vil gå: Fremad, baglæns, Op, Ned hvis det er muligt
                        Eller du kan bare skrive en retning eller det ene bogstav på retningen du vil gå
                 Kig    Du kigger dig omkring og får beskrevet hvad du kan se
                 Tag    Efterfulgt af navnet på item'et, for at samle det op
                 EXIT   Slutter spillet
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

    public void printMessage(String message) {
        System.out.println(message);
    }

}
