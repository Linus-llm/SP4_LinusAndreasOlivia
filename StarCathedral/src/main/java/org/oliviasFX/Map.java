package org.oliviasFX;

import java.util.ArrayList;

public class Map {

    private ArrayList<Room> roomList; // en ring/et lag af rum
    private ArrayList<Room> roomList1;
    private ArrayList<Room> roomList2;
    private ArrayList<Room> roomList3;
    private Room startRoom;



    public void buildMap(){
        //create rooms
        Room room1 = new Room("Refleksionshallen", "Det spejllignende gulv kaster dit billede tilbage i forvrænget form, og tavse statuer i hættekapper stirrer uden øjne. En stemning af dom og erkendelse hviler i luften.");
        Room room2 = new Room("Arkivarens Gravkammer", "En marmorfigur hviler med hænderne på et forsejlet skrift. Dens læber er halvt åbne, som om den døde stadig prøver at hviske noget, du burde vide.");
        Room room3 = new Room("Offerkammeret", "Midt i rummet står et kar med stivnet blod og stjerner ristet i sten. Noget venter på, at du giver mere end din tilstedeværelse.");
        Room room4 = new Room("Det Uskrevne Værelse", "Væggene her er tomme og lyddøde, men du føler, noget blev slettet. Et skrivebord i midten bæver svagt, som om det ikke kan beslutte, hvad det engang bar.");
        Room room5 = new Room("Skyggesalen", "Lyset bøjer unaturligt i dette rum, og dine egne skygger bevæger sig, før du gør det. Noget skjult bag søjlerne følger dig med stille interesse.");
        Room room6 = new Room("Labyrintisk Søjlegård", "Søjlerne her danner mønstre, der skifter, hver gang du vender dig. Bag dem hører du skridt, som du ikke har taget.");
        Room room7 = new Room("Skt. Astarys Kuppel", "En duft af gammel røgelse hænger i luften. Midt i rummet knæler en tom rustning foran en glitrende mosaik, som viser en kvinde, der aldrig ældedes.");
        Room room8 = new Room("Skriftgalleriet", "Du træder ind mellem buede vægge dækket af flydende tekst. Skriften ændrer sig i takt med dine skridt – som om den skriver om dig.");
        Room room9 = new Room("Tågespiralen", "En kold, sølvgrå tåge snoer sig op ad en spiraltrappe uden gelænder. Hver omgang får lydene til at ændre sig, som om tiden selv bøjer sig.");
        Room room10 = new Room("Søvndyssende Sal", "Lyset flimrer som under lukkede øjenlåg. Du kæmper for at holde dig vågen, mens væggene ånder langsomt, som et sovende væsen.")

        //create roomLists
        roomList1 = new ArrayList<>;// en ring/et lag af rum
        roomList1.add(room1);
        roomList1.add(room2);
        roomList1.add(room3);
        roomList1.add(room4);
        roomList1.add(room5);

        roomList2 = new ArrayList<>;
        roomList2.add(room6);
        roomList2.add(room7);
        roomList2.add(room8);
        roomList2.add(room9);
        roomList2.add(room10);

        roomList3 = new ArrayList<>;
        //TODO: opret og tilfoej rum

        //connect rooms

        //etage
        room1.setBackwardRoom(room5);
        room1.setForwardRoom(room2);
        //TODO: saet upRoom og downRoom
        room2.setBackwardRoom(room1);
        room2.setForwardRoom(room3);
        //TODO: saet upRoom og downRoom
        room3.setBackwardRoom(room2);
        room3.setForwardRoom(room4);
        //TODO: saet upRoom og downRoom
        room4.setBackwardRoom(room3);
        room4.setForwardRoom(room5);
        //TODO: saet upRoom og downRoom
        room5.setBackwardRoom(room4);
        room5.setForwardRoom(room1);
        //TODO: saet upRoom og downRoom

        //etage
        room6.setBackwardRoom(room10);
        room6.setForwardRoom(room7);
        //TODO: saet upRoom og downRoom
        room7.setBackwardRoom(room6);
        room7.setForwardRoom(room8);
        //TODO: saet upRoom og downRoom
        room8.setBackwardRoom(room7);
        room8.setForwardRoom(room9);
        //TODO: saet upRoom og downRoom
        room9.setBackwardRoom(room8);
        room9.setForwardRoom(room10);
        //TODO: saet upRoom og downRoom
        room10.setBackwardRoom(room9);
        room10.setForwardRoom(room6);
        //TODO: saet upRoom og downRoom

        //TODO: naeste etage med setters


    }

    public void moveRooms(){
        //ide:

        //foer moveRooms
        //roomList1 = {room0, room1, room2, room3, room4, room5, room6};
        //roomList2 = {room0, room1, room2, room3, room4, room5, room6};
        //roomList3 = {room0, room1, room2, room3, room4, room5, room6};

        //efter moveRooms
        //roomList1 = {room0, room1, room2, room3, room4, room5, room6};
        //roomList2 = {room6, room1, room2, room3, room4, room5, room0};
        //roomList3 = {room0, room1, room2, room3, room4, room5, room6};
        //efter roomList2 har rokeret, har alle rum nu et nyt upstairs- og downstairsRoom, men samme forward og backward.

    }

}
