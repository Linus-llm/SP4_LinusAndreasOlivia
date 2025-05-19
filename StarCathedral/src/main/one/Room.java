package one;

import java.util.ArrayList;

public class Room {

    private Room upstairsRoom;
    private Room downstairsRoom;
    private Room forwardRoom;
    private Room backwardRoom;

    private String name;
    private String description;


    private ArrayList<Item> items;
    private ArrayList<Creature> creatures;



    public Room(String name, String description){
        this.name = name;
        this.description = description;
        items = new ArrayList<>();
        creatures = new ArrayList<>();
    }


    public void addCreature(Creature creature) {
        creatures.add(creature);
    }
    public void removeCreature(Creature creature) {
        creatures.remove(creature);
    }

    public ArrayList<Creature> getCreatures() {
        return creatures;
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
