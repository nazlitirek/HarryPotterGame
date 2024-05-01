import java.util.InputMismatchException;


public  abstract class BattlePlace extends Place {
    protected Creatures creature;
    protected String award;
    int selectCaseNum=0;

    BattlePlace(Wizard wizard, String name, Creatures creature, String award) {
        super(wizard);
        this.name = name;
        this.creature = creature;
        this.award = award;
    }


    public boolean getPlace(){
        int creatureNumber = creature.creatureCount();
        System.out.println("you are at "+this.getName());
        System.out.println("be careful. there are "+creatureNumber+" "+ creature.getName()+"s here.");
        System.out.println("1- Escape    2-Fight");
        selectCase();


        switch(selectCaseNum) {
            case 1:
                System.out.println("you escaped.");
                return true;
            case 2:
                if(fight(creatureNumber)) {
                    System.out.println("you saved the territory...");
                    if(this.award.equals("Golden Snitch") && !wizard.getBag().isGoldenSnitch()) {
                        System.out.println("you won "+this.award+"...");
                        wizard.getBag().setGoldenSnitch(true);
                    }
                    else if(this.award.equals("Marauder's Map") && !wizard.getBag().isMaraudersMap()) {
                        System.out.println("you won "+this.award+"...");
                        wizard.getBag().setMaraudersMap(true);
                    }
                    else if(this.award.equals("Sorting Hat") && !wizard.getBag().isSortingHat()) {
                        System.out.println("you won "+this.award+"...");
                        wizard.getBag().setSortingHat(true);
                    }

                    return true;
                }
                if(wizard.getHealth() <= 0) {
                    System.out.println("you are dead...");
                    return false;
                }
                return true;
        }

        return true;
    }
    private boolean fight(int creatureNumber) {

        for (int i = 0; i < creatureNumber; i++) {
            int defaultCreatureHealth = creature.getHealth();
            showStatus(this.wizard);
            showStatus(this.creature);

            while (wizard.getHealth() > 0 && creature.getHealth() > 0){
                try {
                    System.out.print("press h for hit, press e for escape : ");
                    String selectCase;
                    selectCase = scanner.next().toUpperCase();
                    if (selectCase.equals("H")) {
                        System.out.println("you hit the enemies...");
                        creature.setHealth(creature.getHealth() - wizard.getDamage());
                        afterHitStatus(this.wizard);
                        afterHitStatus(this.creature);
                        System.out.println("--------------------------------");
                        if (creature.getHealth() > 0) {
                            System.out.println(creature.getName() + " hits you...");
                            wizard.setHealth(wizard.getHealth() - creature.getDamage());
                            afterHitStatus(this.wizard);
                            afterHitStatus(this.creature);
                        }
                    }
                    else if(selectCase.equals("E")) {
                        return false;
                    }else {
                        throw new InputMismatchException("Invalid input. Please enter 'H' or 'E'.");
                        //return  false;
                    }
                } catch (Exception e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }
            }
            if (creature.getHealth() <= 0 && wizard.getHealth() > 0) {
                System.out.println("you killed the enemie !");
                wizard.setGalleon(wizard.getGalleon() + creature.getAward());
                System.out.println("new balance : " + wizard.getGalleon());
                creature.setHealth(defaultCreatureHealth);
            } else {
                return false;
            }
        }
        return true;
    }
    private void showStatus(Wizard wizard) {
        System.out.println(wizard.getCharacterName()+"'s Values");
        System.out.println("Health : "+wizard.getHealth());
        System.out.println("Damage : "+wizard.getDamage());
        System.out.println("Galleon : "+wizard.getGalleon());
        if(wizard.getDamage() > 0) {
            System.out.println("Wand : "+wizard.getBag().getWandName());
        }
        if(wizard.getDamage() > 0) {
            System.out.println("Spell : "+wizard.getBag().getSpellName());
        }
    }
    private void showStatus(Creatures creature) {
        System.out.println(creature.getName()+"'s Values");
        System.out.println("Health : "+creature.getHealth());
        System.out.println("Damage : "+creature.getDamage());
        System.out.println("Award :"+creature.getAward());
    }
    private void afterHitStatus(Wizard wizard) {
        System.out.println(wizard.getCharacterName()+"'s health : "+wizard.getHealth());
    }
    private void afterHitStatus(Creatures creature) {
        System.out.println(creature.getName()+"'s health : "+creature.getHealth());
    }
    private void selectCase() {
        while(true) {
            try {
                selectCaseNum = scanner.nextInt();
                if (selectCaseNum == 1 || selectCaseNum == 2)
                    break;
                else if(selectCaseNum != 1 || selectCaseNum != 2) {
                    System.out.print("enter 1 for escape, 2 for fight : ");
                    selectCaseNum = scanner.nextInt();
                }else
                    throw new InputMismatchException();
            } catch (InputMismatchException e) {
                System.out.println("An error occured : please enter 1 or 2");
                //scanner.next();
            }
        }
    }
}
