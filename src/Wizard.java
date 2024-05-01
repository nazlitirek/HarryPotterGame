import java.util.InputMismatchException;
import java.util.Scanner;

public class Wizard{
    Scanner scanner = new Scanner(System.in);
    private int damage=0, health=0, galleon=0, rHealth=0;
    private String characterName;
    private BeadedBag bag;
    public Wizard() {
        this.bag = new BeadedBag();
    }
    private int characterId=0;
    public void selectCharacter() {

        //show the characters
        characterMenu();
        try {
            System.out.print("\nchoose a character : ");
            characterId = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("An error occured : Please enter a valid integer...");
            scanner.nextLine();
        }
        characterControl(characterId);

        switch(characterId) {
            case 1 :
                setCharacterValues("Harry",5,17,12 );
                break;
            case 2 :
                setCharacterValues("Hermonie",3,14,15);
                break;
            case 3 :
                setCharacterValues("Ron",7,23,20 );
                break;
            case 4 :
                setCharacterValues("Lucy",4,12,23 );
                break;
        }

        //get and write the values
        showCharacterValues(characterId);

    }
    public void characterMenu() {
        System.out.println("\n----------------------CHARACTERS----------------------");
        System.out.println("1 - Harry      damage : 5   health : 17   galleon : 12  ");
        System.out.println("2 - Hermonie   damage : 3   health : 14   galleon : 15  ");
        System.out.println("3 - Ron        damage : 7   health : 23   galleon : 20  ");
        System.out.println("4 - Lucy       damage : 4   health : 12   galleon : 23  ");
    }
    public int characterControl(int characterId) {
        while(characterId < 1 || characterId > 4) {
            System.out.print("please enter a valid number : ");
            characterId = scanner.nextInt();
        }
        return characterId;
    }
    public void setCharacterValues(String characterName, int damage, int health, int galleon) {
        setCharacterName(characterName);
        setDamage(damage);
        setHealth(health);
        setGalleon(galleon);
        setRHealth(health);
    }
    public void showCharacterValues(int characterID){
        System.out.println("\nchoosen character : "+getCharacterName() + "\t damage : " + getDamage() + "\t health : " + getHealth() + "\t galleon : " + getGalleon());

    }





    //set methods
    public void setDamage(int damage) {this.damage = damage; }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setGalleon(int galleon) {
        this.galleon = galleon;
    }
    public void setRHealth(int rHealth) {
        this.rHealth = rHealth;
    }
    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }
    public void setBag(BeadedBag bag) {
        this.bag = bag;
    }
    //get methods
    public int getDamage() {return this.damage;}
    public int getHealth() {return this.health;}
    public int getGalleon() {return this.galleon; }
    public int getRHealth() { return this.rHealth; }
    public String getCharacterName() { return this.characterName; }
    public int getCharacterId() {
        return this.characterId;
    }
    public BeadedBag getBag() { return this.bag;}

}



