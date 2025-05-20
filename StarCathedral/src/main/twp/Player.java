package twp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private int health = 3;
    private ArrayList<Item> inventory;
    private Room currentRoom;

    public Player() {
        inventory = new ArrayList<Item>();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room startRoom) {
        currentRoom = startRoom;
    }

    public boolean move(Direction direction) {
        Room requestedRoom = null;

        switch (direction) {
            case Forward:
                requestedRoom = currentRoom.getForwardRoom();

                break;
            case Backwards:
                requestedRoom = currentRoom.getBackwardRoom();

                break;
            case UP:
                requestedRoom = currentRoom.getUpstairsRoom();

                break;
            case DOWN:
                requestedRoom = currentRoom.getDownstairsRoom();

                break;
        }


        if (requestedRoom != null) {
            setCurrentRoom(requestedRoom);
            return true;
        } else {
            return false;
        }
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void decreaseHealth(int amount) {
        health -= amount;
    }

    protected boolean getItem(String itemName) {
        //should take item from the room the player is standing in and put it into inventory arraylist
        Item pickupFromRoom = currentRoom.removeItem(itemName);
        if (pickupFromRoom != null) {

            inventory.add(pickupFromRoom);
            return true;
        }
        return false;
    }

    public int getHealth() {
        return health;
    }

    public void useItem() {
        if (inventory.isEmpty()) {
            System.out.println("Du har ikke nogen items, der kan bruges");
            return;
        }
        System.out.println("Dine items:");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println((i + 1) + ". " + inventory.get(i).getItemName());
        }
        Scanner scan = new Scanner(System.in);
        System.out.print("Vælg tallet på det item du vil benytte: \n");

        int choice = scan.nextInt() - 1;
        scan.nextLine();
        if (choice >= 0 && choice < inventory.size()) {
            Item selectedItem = inventory.get(choice);

            if (selectedItem.getItemName().toLowerCase().contains("potion")) {
                health += 1;
                System.out.println("Du brugte " + selectedItem.getItemName() + " og blev healet, du har nu: " + health+" liv");
            } else {
                System.out.println("Du brugte " + selectedItem.getItemName() + ". Det havde ingen effekt");
            }

            inventory.remove(choice);
        } else {
            System.out.println("Ugyldigt valg");
        }
    }
}



