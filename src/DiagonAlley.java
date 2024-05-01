import java.util.Scanner;

public class DiagonAlley extends SafePlace {
    //marketplace
    Scanner scanner = new Scanner(System.in);
    WandShop wandShop = new WandShop();
    SpellShop spellShop = new SpellShop();
    int damage = 0, price = 0;

    DiagonAlley(Wizard wizard) {
        super(wizard, "diagon alley");
    }

    public boolean getPlace() {
        System.out.println("Galleon : " + wizard.getGalleon());
        System.out.println("1- Wands");
        System.out.println("2- Spells");
        System.out.println("3 - Exit.");

        System.out.print("What do you wanna buy : ");
        int selectTool = scanner.nextInt();

        switch (selectTool) {
            case 1:
                wandShop.wandMenu();
                wandShop.buyWand();
                break;
            case 2:
                spellShop.spellMenu();
                spellShop.buySpell();
                break;
        }
        System.out.println("You have "+wizard.getBag().getSpellName()+" and "+wizard.getBag().getWandName()+".");
        return true;
    }

    private class WandShop {
        public void wandMenu() {
            System.out.println("----------------------WANDS------------------------");
            System.out.println("1- Blackthorne Wand     Galleon : 12    Damage : 4");   //angel's trumpet draught almost a posion
            System.out.println("2- Ebont Wand           Galleon : 10    Damage : 3"); //pertificus totalus body bind curse
            System.out.println("3- Elm Wand             Galleon : 15    Damage : 6");
            System.out.println("4- Exit");
        }

        public void buyWand() {
            System.out.print("What do you wanna buy : ");
            int wandID = scanner.nextInt();
            String wandName = null;

            if (wandID > 0 && wandID < 5) {
                switch (wandID) {
                    case 1:
                        wandName = "Blackthorn Wand";
                        price = 12;
                        damage = 4;
                        break;
                    case 2:
                        wandName = "Ebont Wand";
                        price = 10;
                        damage = 3;
                        break;
                    case 3:
                        wandName = "Elm Wand";
                        price = 15;
                        damage = 6;
                        break;
                }
                System.out.println(price);
                if (wizard.getGalleon() >= price) {
                    wizard.getBag().setDamage(damage);
                    int totalDamage = wizard.getBag().getDamage() + wizard.getDamage();
                    wizard.setDamage(totalDamage);
                    wizard.getBag().setWandName(wandName);
                    wizard.setGalleon(wizard.getGalleon() - price);

                    System.out.println("You bought " + wandName + ". Your new damage is " + totalDamage);
                    System.out.println("Remain galleon :  " + wizard.getGalleon());
                } else
                    System.out.println("You don't have enough galleon");
            } else
                System.out.println("Invalid ID !");

        }
    }

    public class SpellShop {
        public void spellMenu() {
            System.out.println("----------------------POİTİONS--------------------------");
            System.out.println("1- Angel's trumpet draught    Galleon : 11   Damage : 3");
            System.out.println("2- Pertificus totalus         Galleon : 14   Damage : 5");
            System.out.println("3- Body bind curse            Galleon : 12   Damage : 6");
            System.out.println("4- Exit");
            System.out.print("Your choice : ");
        }

        public void buySpell() {

            System.out.print("What do you wanna buy : ");
            int spellID = scanner.nextInt();

            String spellName = null;
            if (spellID > 0 && spellID < 5) {
                switch (spellID) {
                    case 1:
                        spellName = "Angel's trumpet draught";
                        price = 11;
                        damage = 3;
                        break;
                    case 2:
                        spellName = "Pertificus totalus";
                        price = 14;
                        damage = 5;
                        break;
                    case 3:
                        spellName = "Body bind curse";
                        price = 12;
                        damage = 6;
                        break;
                    default:
                        System.out.println("Invalid ID !");
                        break;
                }
                if (wizard.getGalleon() >= price) {
                    wizard.getBag().setDamage(damage);
                    int totalDamage = wizard.getBag().getDamage() + wizard.getDamage();
                    wizard.setDamage(totalDamage);
                    wizard.getBag().setSpellName(spellName);
                    wizard.setGalleon(wizard.getGalleon() - price);
                    System.out.println("You bought a spell. your new damage is " + totalDamage);
                    wizard.showCharacterValues(wizard.getCharacterId());
                    System.out.println("Remain galleon :  " + wizard.getGalleon());
                } else
                    System.out.println("You don't have enough galleon");
            } else
                System.out.println("Invalid ID !");

        }

    }

}