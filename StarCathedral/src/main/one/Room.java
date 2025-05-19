// Tess - prøver lige hurtigt at ændre package one til main.one på flere klasser, skifter tilbage med det samme hvis det ikke virker, men jeg kan ikke compile - package one;
package main.one;

import java.util.ArrayList;
// Tess - importing riddle to connect with rooms
import main.one.Riddle;

public class Room {

    private Room upstairsRoom;
    private Room downstairsRoom;
    private Room forwardRoom;
    private Room backwardRoom;

    private String name;
    private String description;


    private ArrayList<Item> items;

// Tess - Connecting riddle with rooms
    private Riddle riddle;

    public Room(String name, String description){
        this.name = name;
        this.description = description;
        items = new ArrayList<>();
        // Tess - intitialicing riddle to null
        riddle = null;
    }

    // Tess - method for assigning a riddle to this room associating the room and riddle

    public void setRiddle(Riddle riddle){
        this.riddle = riddle;
    }

    // Tess - method for retrieving the riddle from this room, retrieves the ass. riddle to this room or null

    public Riddle getRiddle(){
        return riddle;
    }

    public String presentRiddle(){
        if (riddle != null) {
            return riddle.getCurrentRiddle();
        }
        return null;
    }

    public Room getUpstairsRoom(){

        return upstairsRoom;
    }

    public void setUpstairsRoom(Room upstairsRoom){

        this.upstairsRoom = upstairsRoom;
    }

    public Room getDownstairsRoom(){

        return downstairsRoom;
    }

    public void setDownstairsRoom(Room downstairsRoom){

        this.downstairsRoom = downstairsRoom;
    }

    public Room getForwardRoom(){

        return forwardRoom;
    }

    public void setForwardRoom(Room forwardRoom){
        this.forwardRoom = forwardRoom;
    }

    public Room getBackwardRoom(){

        return backwardRoom;
    }

    public void setBackwardRoom(Room backwardRoom){

        this.backwardRoom = backwardRoom;
    }

    public String getName(){

        return name;
    }

    public String getDescription(){

        return description;
    }

    public ArrayList<Item> getItem(){
        return items;
    }

    public Item removeItem(String itemName) {
        Item itemToBeRemoved = findItem(itemName);
        if (itemToBeRemoved != null) {
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

}
