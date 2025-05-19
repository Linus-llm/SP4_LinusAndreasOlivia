package org.oliviasFX;

import java.util.ArrayList;

public class Room {

    private Room upstairsRoom;
    private Room downstairsRoom;
    private Room forwardRoom;
    private Room backwardRoom;

    private String name;
    private String description;

    private ArrayList<Item> items;

    public Room(String name, String description){
        this.name = name;
        this.description = description;
        items = new ArrayList<>();
    }

    public Room getUpstairsRoom() { return upstairsRoom; }
    public void setUpstairsRoom(Room upstairsRoom) { this.upstairsRoom = upstairsRoom; }

    public Room getDownstairsRoom() { return downstairsRoom; }
    public void setDownstairsRoom(Room downstairsRoom) { this.downstairsRoom = downstairsRoom; }

    public Room getForwardRoom() { return forwardRoom; }
    public void setForwardRoom(Room forwardRoom) { this.forwardRoom = forwardRoom; }

    public Room getBackwardRoom() { return backwardRoom; }
    public void setBackwardRoom(Room backwardRoom) { this.backwardRoom = backwardRoom; }

    public String getName() { return name; }

    public String getDescription() { return description; }

    public ArrayList<Item> getItem() { return items; }

    public Item removeItem(String itemName) {
        Item itemToBeRemoved = findItem(itemName);
        if (itemToBeRemoved != null) {
            items.remove(itemToBeRemoved);
            return itemToBeRemoved;
        }
        return null;
    }

    public Item findItem(String itemName) {
        for (Item item : items) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    // Tilføj eksisterende item
    public void addItem(Item item) {
        items.add(item);
    }

    // Convenience-metode med beskrivelse (bruger Consumables som standardtype)
    public void addItem(String description) {
        this.addItem(new Consumables(description, description, 10));
    }

    // Convenience-metode med beskrivelse og navn
    public void addItem(String description, String name) {
        this.addItem(new Consumables(description, name, 10));
    }
}
