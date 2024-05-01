import java.util.Random;

public class Creatures {
    private String name;
    private int damage, award, health, maxNumber;

    public Creatures(String name, int damage, int award, int health, int maxNumber) {
        this.name = name;
        this.damage = damage;
        this.award = award;
        this.health = health;
        this.maxNumber = maxNumber;
    }
    public int creatureCount() {
        Random r = new Random();
        return r.nextInt(this.maxNumber)+1;
    }



    //setters and getters
    public void setName(String name) {
        this.name = name;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public void setAward(int award) {
        this.award = award;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }
    public String getName() {
        return name;
    }
    public int getDamage() {
        return damage;
    }
    public int getAward() {
        return award;
    }
    public int getHealth() {
        return health;
    }
    public int getMaxNumber() {
        return maxNumber;
    }
}
