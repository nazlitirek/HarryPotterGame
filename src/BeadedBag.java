public class BeadedBag{
    //inventory
    private boolean maraudersMap, goldenSnitch, sortingHat;
    private String wandName, spellName;
    private int damage;

    public BeadedBag() {
        this.maraudersMap = false;
        this.goldenSnitch = false;
        this.sortingHat = false;
        this.damage = 0;
        this.wandName = null;
        this.spellName = null;
    }
    public void setMaraudersMap(boolean maraudersMap) {
        this.maraudersMap = maraudersMap;
    }
    public void setGoldenSnitch(boolean goldenSnitch) {
        this.goldenSnitch = goldenSnitch;
    }
    public void setSortingHat(boolean sortingHat) {
        this.sortingHat = sortingHat;
    }
    public void setWandName(String wandName) {
        this.wandName = wandName;
    }
    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }
    public void setDamage(int damage) { this.damage = damage;}

    public boolean isMaraudersMap() { return maraudersMap;}
    public boolean isGoldenSnitch() {return goldenSnitch; }
    public boolean isSortingHat() { return sortingHat; }
    public String getWandName() { return wandName; }
    public String getSpellName() { return spellName;}
    public int getDamage() { return damage; }

}
