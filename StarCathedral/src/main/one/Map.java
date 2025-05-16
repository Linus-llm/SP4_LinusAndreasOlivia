package one;

import java.util.ArrayList;

public class Map {

    private ArrayList<Room> roomList; // en ring/et lag af rum
    private ArrayList<Room> roomList1;
    private ArrayList<Room> roomList2;
    private ArrayList<Room> roomList3;
    private Room startRoom;


    public void buildMap(){
        //create roomss
        Room room1 = new Room("Refleksionshallen", "Det spejllignende gulv kaster dit billede tilbage i forvrænget form, og tavse statuer i hættekapper stirrer uden øjne. En stemning af dom og erkendelse hviler i luften.");
        Room room2 = new Room("Arkivarens Gravkammer", "En marmorfigur hviler med hænderne på et forsejlet skrift. Dens læber er halvt åbne, som om den døde stadig prøver at hviske noget, du burde vide.");
        Room room3 = new Room("Offerkammeret", "Midt i rummet står et kar med stivnet blod og stjerner ristet i sten. Noget venter på, at du giver mere end din tilstedeværelse.");
        Room room4 = new Room("Det Uskrevne Værelse", "Væggene her er tomme og lyddøde, men du føler, noget blev slettet. Et skrivebord i midten bæver svagt, som om det ikke kan beslutte, hvad det engang bar.");
        Room room5 = new Room("Skyggesalen", "Lyset bøjer unaturligt i dette rum, og dine egne skygger bevæger sig, før du gør det. Noget skjult bag søjlerne følger dig med stille interesse.");
        Room room6 = new Room("Labyrintisk Søjlegård", "Søjlerne her danner mønstre, der skifter, hver gang du vender dig. Bag dem hører du skridt, som du ikke har taget.");
        Room room7 = new Room("Skt. Astarys Kuppel", "En duft af gammel røgelse hænger i luften. Midt i rummet knæler en tom rustning foran en glitrende mosaik, som viser en kvinde, der aldrig ældedes.");
        Room room8 = new Room("Skriftgalleriet", "Du træder ind mellem buede vægge dækket af flydende tekst. Skriften ændrer sig i takt med dine skridt – som om den skriver om dig.");
        Room room9 = new Room("Tågespiralen", "En kold, sølvgrå tåge snoer sig op ad en spiraltrappe uden gelænder. Hver omgang får lydene til at ændre sig, som om tiden selv bøjer sig.");
        Room room10 = new Room("Søvndyssende Sal", "Lyset flimrer som under lukkede øjenlåg. Du kæmper for at holde dig vågen, mens væggene ånder langsomt, som et sovende væsen.");
        Room room11 = new Room("Den Forsvundne Skakt", "Gulvet er dækket af flager af nedfaldent loft. En åbning i midten fører dybt ned i mørke – men kulden, der stiger op, føles som en hvisken fra noget glemt.");
        Room room12 =  new Room("Rummet med Vævet Lys", "Lysstråler hænger i luften som tråde. Du må bevæge dig langsomt, ellers risikerer du at flænse vævet – og med det, måske også noget i dig selv.");
        Room room13 = new Room("Stenbønnernes Hvælv", "Du træder ind i et rundt rum, hvor stenfigurer sidder i bøn. Deres munde er åbne, men tavse – og rummet genlyder af dine egne tanker i forvrænget ekko.");
        Room room14 = new Room("Tidens Kammer", "Ure i alle former og aldre dækker væggene, men ingen går rigtigt. Hver gang du blinker, har ét flyttet sig – og du fornemmer, tiden gør det samme.");
        Room room15 = new Room("De Blinde Mosaikkers Rum", "Gulvet og væggene er dækket af mosaikker, men de forestiller intet genkendeligt. Når du bevæger dig, synes motiverne at ændre sig, som om rummet forsøger at aflæse dig.");

        //create roomLists
        roomList1 = new ArrayList<>();// en ring/et lag af rum
        roomList1.add(room1);
        roomList1.add(room2);
        roomList1.add(room3);
        roomList1.add(room4);
        roomList1.add(room5);

        roomList2 = new ArrayList<>();
        roomList2.add(room6);
        roomList2.add(room7);
        roomList2.add(room8);
        roomList2.add(room9);
        roomList2.add(room10);

        roomList3 = new ArrayList<>();
        roomList3.add(room11);
        roomList3.add(room12);
        roomList3.add(room13);
        roomList3.add(room14);
        roomList3.add(room15);


        startRoom = room1;

        //connect rooms

        //etage
        room1.setBackwardRoom(room5);
        room1.setForwardRoom(room2);
        room1.setDownstairsRoom(roomList2.get(0));

        room2.setBackwardRoom(room1);
        room2.setForwardRoom(room3);
        room2.setDownstairsRoom(roomList2.get(1));

        room3.setBackwardRoom(room2);
        room3.setForwardRoom(room4);
        room3.setDownstairsRoom(roomList2.get(2));

        room4.setBackwardRoom(room3);
        room4.setForwardRoom(room5);
        room4.setDownstairsRoom(roomList2.get(3));

        room5.setBackwardRoom(room4);
        room5.setForwardRoom(room1);
        room5.setDownstairsRoom(roomList2.get(4));

        //etage
        room6.setBackwardRoom(room10);
        room6.setForwardRoom(room7);
        room6.setUpstairsRoom(roomList1.get(0));
        room6.setDownstairsRoom(roomList3.get(0));

        room7.setBackwardRoom(room6);
        room7.setForwardRoom(room8);
        room7.setUpstairsRoom(roomList1.get(1));
        room7.setDownstairsRoom(roomList3.get(1));

        room8.setBackwardRoom(room7);
        room8.setForwardRoom(room9);
        room8.setUpstairsRoom(roomList1.get(2));
        room8.setDownstairsRoom(roomList3.get(2));

        room9.setBackwardRoom(room8);
        room9.setForwardRoom(room10);
        room9.setUpstairsRoom(roomList1.get(3));
        room9.setDownstairsRoom(roomList3.get(3));

        room10.setBackwardRoom(room9);
        room10.setForwardRoom(room6);
        room10.setUpstairsRoom(roomList1.get(4));
        room10.setDownstairsRoom(roomList3.get(4));

        //etage
        room11.setBackwardRoom(room15);
        room11.setForwardRoom(room12);
        room11.setUpstairsRoom(roomList2.get(0));

        room12.setBackwardRoom(room11);
        room12.setForwardRoom(room13);
        room12.setUpstairsRoom(roomList2.get(1));

        room13.setBackwardRoom(room12);
        room13.setForwardRoom(room14);
        room13.setUpstairsRoom(roomList2.get(2));

        room14.setBackwardRoom(room13);
        room14.setForwardRoom(room15);
        room14.setUpstairsRoom(roomList2.get(3));

        room15.setBackwardRoom(room14);
        room15.setForwardRoom(room11);
        room15.setUpstairsRoom(roomList2.get(4));

    }

    public void moveRooms(){

        Room last = roomList2.remove(roomList2.size() - 1);
        roomList2.add(0, last);
    }

    public Room getStartRoom(){
        return startRoom;
    }

    public Room fetchMissionRoom(){
        return roomList2.get(2);
    }
}
