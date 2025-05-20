package twp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Map {

    private ArrayList<Room> roomList; // en ring/et lag af rum
    private ArrayList<Room> roomList1;
    private ArrayList<Room> roomList2;
    private ArrayList<Room> roomList3;
    private Room startRoom;
    private ArrayList<Riddle> riddleList;



    public void buildMap(){
        //create roomss
        Room room1 = new Room("Refleksionshallen", "Det spejllignende gulv kaster dit billede tilbage i forvrænget form, og tavse statuer i hættekapper stirrer uden øjne. En stemning af dom og erkendelse hviler i luften.",false);
        room1.addItem("En varm og frodig substans i potion form","potion");
        Room room2 = new Room("Arkivarens Gravkammer", "En marmorfigur hviler med hænderne på et forsejlet skrift. Dens læber er halvt åbne, som om den døde stadig prøver at hviske noget, du burde vide.",false);
        Room room3 = new Room("Offerkammeret", "Midt i rummet står et kar med stivnet blod og stjerner ristet i sten. Noget venter på, at du giver mere end din tilstedeværelse.",false);
        Room room4 = new Room("Det Uskrevne Værelse", "Væggene her er tomme og lyddøde, men du føler, noget blev slettet. Et skrivebord i midten bæver svagt, som om det ikke kan beslutte, hvad det engang bar.",false);
        Room room5 = new Room("Skyggesalen", "Lyset bøjer unaturligt i dette rum, og dine egne skygger bevæger sig, før du gør det. Noget skjult bag søjlerne følger dig med stille interesse.",false);
        Room room6 = new Room("Labyrintisk Søjlegård", "Søjlerne her danner mønstre, der skifter, hver gang du vender dig. Bag dem hører du skridt, som du ikke har taget.",false);
        Room room7 = new Room("Skt. Astarys Kuppel", "En duft af gammel røgelse hænger i luften. Midt i rummet knæler en tom rustning foran en glitrende mosaik, som viser en kvinde, der aldrig ældedes.",false);
        Room room8 = new Room("Skriftgalleriet", "Du træder ind mellem buede vægge dækket af flydende tekst. Skriften ændrer sig i takt med dine skridt – som om den skriver om dig.",false);
        Room room9 = new Room("Tågespiralen", "En kold, sølvgrå tåge snoer sig op ad en spiraltrappe uden gelænder. Hver omgang får lydene til at ændre sig, som om tiden selv bøjer sig.",false);
        Room room10 = new Room("Søvndyssende Sal", "Lyset flimrer som under lukkede øjenlåg. Du kæmper for at holde dig vågen, mens væggene ånder langsomt, som et sovende væsen.",false);
        Room room11 = new Room("Den Forsvundne Skakt", "Gulvet er dækket af flager af nedfaldent loft. En åbning i midten fører dybt ned i mørke – men kulden, der stiger op, føles som en hvisken fra noget glemt.",false);
        Room room12 =  new Room("Rummet med Vævet Lys", "Lysstråler hænger i luften som tråde. Du må bevæge dig langsomt, ellers risikerer du at flænse vævet – og med det, måske også noget i dig selv.",false);
        Room room13 = new Room("Stenbønnernes Hvælv", "Du træder ind i et rundt rum, hvor stenfigurer sidder i bøn. Deres munde er åbne, men tavse – og rummet genlyder af dine egne tanker i forvrænget ekko.",false);
        Room room14 = new Room("Tidens Kammer", "Ure i alle former og aldre dækker væggene, men ingen går rigtigt. Hver gang du blinker, har ét flyttet sig – og du fornemmer, tiden gør det samme.",false);
        Room room15 = new Room("De Blinde Mosaikkers Rum", "Gulvet og væggene er dækket af mosaikker, men de forestiller intet genkendeligt. Når du bevæger dig, synes motiverne at ændre sig, som om rummet forsøger at aflæse dig.",true);

        room2.addItem("En større og glødende rød potion", "potion");
        room4.addItem("En lille men gylden potion", "potion");
        room6.addItem("En lille flaske med en gylden te på potion form", "potion");
        room3.addItem("A potion made from deep-sea seaweed. Salty but invigorating.", "potion");


        Hostile creature1 = new Hostile(
                "Astralfødte",
                "Rummet er fyldt med et blødt lys, og i dens midte bevæger sig et væsen lavet af stjerneskær...",
                new ArrayList<>(List.of("Hold afstand", "Henvend dig venligt")),
                1
        );

        Hostile creature2 = new Hostile(
                "Den Tunge Pust",
                "Rummet føles tungt og stillestående, som om du står i et rum, hvor al tid er blevet stanset...",
                new ArrayList<>(List.of("Træk dig tilbage", "Lyt respektfuldt")),
                1
        );

        Hostile creature3 = new Hostile(
                "Stjernevogteren",
                "Rummet er fyldt med et blinkende lys, og du ser et væsen, der er lavet af krystal og knogler...",
                new ArrayList<>(List.of("Sluk flammerne først", "Vis fredelig hensigt")),
                1
        );

        Hostile creature4 = new Hostile(
                "Skindsløreren",
                "Rummet er fyldt med et blinkende lys, og du ser et væsen, der er lavet af krystal og knogler...",
                new ArrayList<>(List.of("Træk våben", "Tal roligt")),
                1
        );

        Hostile creature5 = new Hostile(
                "Stenskrigeren",
                "Rummet er mørkt og fyldt med støv... Dens krop er forstenet af tidens gang.",
                new ArrayList<>(List.of("Ryst væggen", "Vis noget fra fortiden")),
                1
        );

        Hostile creature6 = new Hostile(
                "Nedskriveren",
                "I dette rum står en væsen med ryggen til, kradsende med en sølvpen på væggen...",
                new ArrayList<>(List.of("Riv teksten ned", "Spørg hvad den skriver")),
                1
        );

        Hostile creature7 = new Hostile(
                "De Tavse Syngere",
                "Rummet er præget af et ekko... deres tilstedeværelse virker både hypnotisk og skræmmende.",
                new ArrayList<>(List.of("Dæk dine ører", "Syng med i roligt tempo")),
                1
        );

        Friendly creature8 = new Friendly(
                "Vogteren af 7. Flamme",
                "Rummet er fyldt med flammer... Denne væsen er en manifestation af dig selv.",
                new ArrayList<>(List.of("Test din styrke", "Del dine valg")),
                1
        );

        Hostile creature9 = new Hostile(
                "Lysbæreren",
                "I dette rum ser du en skikkelse, der holder en lanterne... du er usikker på, hvad du vil miste.",
                new ArrayList<>(List.of("Nægt dens tilbud", "Spørg om lanternens kraft")),
                1
        );

        Hostile creature10 = new Hostile(
                "Ekkoet",
                "Rummet virker tomt, men du hører dine egne ord, gentaget tilbage til dig...",
                new ArrayList<>(List.of("Tie stille", "Spørg hvem den er")),
                1
        );

        Hostile creature11 = new Hostile(
                "Kugleøjet",
                "Rummet er fyldt med et uendeligt mørke... og noget ændrer sig...",
                new ArrayList<>(List.of("Skjul dig", "Buk dig og nik")),
                1
        );

        Friendly creature12 = new Friendly(
                "De Glemsomme",
                "I dette rum går en gruppe hætteklædte figurer i ring... Deres hukommelse er sløret.",
                new ArrayList<>(List.of("Besvar deres spørgsmål", "Spørg til deres fortid")),
                1
        );

        Hostile creature13 = new Hostile(
                "Stjerneslyngen",
                "Rummet er fyldt med et kosmisk væsen... men du føler dig langsomt fanget.",
                new ArrayList<>(List.of("Modstå kraften", "Tal blidt til det")),
                1
        );

        Hostile creature14 = new Hostile(
                "Den Tavse Arkivar",
                "I dette mørke rum sidder en skikkelse og skriver i et evigt voksende bibliotek...",
                new ArrayList<>(List.of("Luk bogen", "Spørg om dine fejl")),
                1
        );

        Friendly creature15 = new Friendly(
                "Zodiakens Klædte",
                "Rummet er fyldt med tolv skikkelser, der bærer stjernetegnens rustninger...",
                new ArrayList<>(List.of("Tag imod deres prøve", "Del din livsrejse")),
                1
        );

        riddleList = new ArrayList<>();

        riddleList.add(new Riddle("The more you take away from me, the bigger I get. What am I?", "a hole", "_ H__E", "Digging this one might help."));
        riddleList.add(new Riddle("I speak without a mouth and hear without ears. I have no body, but I come alive with the wind. What am I?", "an echo", "A _  E _ _ O", "Sound bouncing off the walls!"));
        riddleList.add(new Riddle("What has to be broken before you can use it?", "an egg", "N _G", "Crack one for breakfast."));
        riddleList.add(new Riddle("I’m tall when I’m young and short when I’m old. What am I?", "a candle", "_ _A___E", "It melts but gives light."));
        riddleList.add(new Riddle("What can run but never walks, has a bed but never sleeps, has a mouth but never talks?", "a river", "A  R _ _ _ _", "It flows endlessly."));
        riddleList.add(new Riddle("What has hands but can’t clap?", "a clock", "A  C _ _ _ K", "It tells time."));
        riddleList.add(new Riddle("What has many keys but can’t open a single lock?", "a piano", "A  P _ _ _ O", "It makes music."));



        /*riddleList.add(new Riddle("The more you take away from me, the bigger I get. What am I?", "a hole", "_ H__E", "Digging this one might help."));
        riddleList.add(new Riddle("The more you take away from me, the bigger I get. What am I?", "a hole", "_ H__E", "Digging this one might help."));
        riddleList.add(new Riddle("The more you take away from me, the bigger I get. What am I?", "a hole", "_ H__E", "Digging this one might help."));
        riddleList.add(new Riddle("The more you take away from me, the bigger I get. What am I?", "a hole", "_ H__E", "Digging this one might help."));
        riddleList.add(new Riddle("The more you take away from me, the bigger I get. What am I?", "a hole", "_ H__E", "Digging this one might help."));
        riddleList.add(new Riddle("The more you take away from me, the bigger I get. What am I?", "a hole", "_ H__E", "Digging this one might help."));
        riddleList.add(new Riddle("The more you take away from me, the bigger I get. What am I?", "a hole", "_ H__E", "Digging this one might help."));
        riddleList.add(new Riddle("The more you take away from me, the bigger I get. What am I?", "a hole", "_ H__E", "Digging this one might help."));
*/
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

        List<Room> allRooms = new ArrayList<>();
        allRooms.addAll(roomList1);
        allRooms.addAll(roomList2);
        allRooms.addAll(roomList3);

        Collections.shuffle(allRooms); // Gør rækkefølgen tilfældig

        for (int i = 0; i < 7; i++) { // Vælg fx 7 rum
            allRooms.get(i).setRiddle(riddleList.get(i));
        }

        roomList3.get(4).setIsLockedFalse();

        startRoom = room1;

        //add creatures to rooms
        room1.addCreature(creature1);
        room2.addCreature(creature2);
        room3.addCreature(creature3);
        room4.addCreature(creature4);
        room5.addCreature(creature5);
        room6.addCreature(creature6);
        room7.addCreature(creature7);
        room8.addCreature(creature8);
        room9.addCreature(creature9);
        room10.addCreature(creature10);
        room11.addCreature(creature11);
        room12.addCreature(creature12);
        room13.addCreature(creature13);
        room14.addCreature(creature14);
        room15.addCreature(creature15);


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
    public Room getFinalLockedRoom(){
        return roomList3.get(4);
    }

}
