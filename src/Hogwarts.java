import java.util.Scanner;
public class Hogwarts extends SafePlace {
    public Hogwarts(Wizard wizard) {
        super(wizard, "hogwarts");
    }
    public boolean getPlace() {
        System.out.println();
        System.out.println("1-Renew your health    2-Show status");
        System.out.print("What do you wanna do : ");
        int selectCase = scanner.nextInt();
        switch(selectCase) {
            case 1:
                System.out.println("Your health : "+wizard.getHealth());
                wizard.setHealth(wizard.getRHealth());
                System.out.println("You renewed your health...");
                System.out.println(wizard.getCharacterName()+"'s health : "+wizard.getHealth());
                break;
            case 2:
                System.out.println();
                System.out.println("1-Show Values       2-Show wand and spell");
                System.out.print("Enter your choice :");
                int showCase = scanner.nextInt();
                try {
                    switch (showCase) {
                        case 1:
                            showStatus();
                            break;
                        case 2:
                            showStatus(wizard.getBag().getWandName(), wizard.getBag().getSpellName());
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + showCase);
                    }
                }catch(IllegalStateException e){
                    System.out.println(e.getMessage());
                }
        }

        return true;
    }
    private void showStatus() {
        System.out.println();
        wizard.showCharacterValues(wizard.getCharacterId());
    }
    private void showStatus(String wandName, String spellName) {

        wandName = wizard.getBag().getWandName();
        spellName = wizard.getBag().getSpellName();

        if(wandName==null) {
            System.out.println("You don't have a wand.");
        }else
            System.out.println("Your wand is "+wandName);
        if(spellName==null) {
            System.out.println("You don't have a spell.");
        }else
            System.out.println("Your spell is "+spellName);
    }
}
