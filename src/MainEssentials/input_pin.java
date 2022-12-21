package MainEssentials;

public class input_pin {

    public boolean isSet = false;

    private int ID = inPinID++;
    public static int inPinID = 0;
    private Node in;
    private String name;

    public input_pin(Node in, String name){
        this.in = in;
        this.name = name;
    }

    public input_pin(Node in){
        this.in = in;
        name = "untitledPin_" + inPinID;

    }

    public void set(boolean setInput){
            in.setVal(setInput);
            isSet = true;

    }

    public boolean getVal(){
        return in.getVal();
    }

    public String toString(){
        return name + " " + in.getVal();
    }




}


//- Stung By a Metabee
//2- Return of the Screws
//3- Running Scared
//4- The Legendary Medafighter
//5- The Old Man and the Sea Monster
//27- Spaceship Superstars
//6- The Gimme Ghost
//28- No Body Home
//7- Cyandog Bites Back
//8- For Better, For Worse (Part 1)
//9- For Better, For Worse (Part 2)
//10- Mystery Medabot
//29- For Love or Robattle
//30- Welcome to Ninja World
//31- Eat, Drink, Man, Medabot
//32- There's Something About Miss Mimosa
//11- Phantom Renegade Unmasked
//12- Ban All Medabots
//33- The Birds and the Metabees
//13- Meet Your Meda-Maker
//14- The Spy Who Robattled Me
//34- Skyward Yo!
//15- I Dream of Hushi
//35- Dance With the Mantis
//16- Metabee vs Rokusho
//17- Use the Medaforce
//18- Fifteen Minutes Of Shame
//36- Love At First Bite
//37- Once Frostbitten, Twice Shy
//38- Heavy Medal
//19- Enter Rintaro
//20- The Ace From Outer Space
//39- Bridge Over Troubled Squidguts
//21 -Me and My Shadow Sword
//22- Dude, Where's My Ma?
//23- X-Treme Measures
//24- The Road To Ruins
//25- Beetle Mania
//26- The Mother Of All Robattles
//40- Let the Meda Games Begin!
//41- Pixies & Pirates
//42- The French Deception
//43- Space Medaballerina X
//44- Swede & Sour
//45- Future's Past
//46- The Medaforce Within
//47- A Date With Destiny
//48- Calm Before The Storm
//49- Taking the Victor Out of Victory
//50- Altered States
//51- Waking To A Dream
//52- Metabee's Last Stand