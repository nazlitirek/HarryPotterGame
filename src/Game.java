import java.util.Scanner;
import java.util.InputMismatchException;
public class Game {
    Scanner scanner = new Scanner(System.in);
    Place place;
    Wizard wizard = new Wizard();
    public void login() {
        System.out.println("welcome to Hogwarts ");
        System.out.println("here are the characters you can play as...");
        wizard.selectCharacter();
    }
    public void play() {
        while (true) {
            placeMenu();
            int selectPlace;
            while (true) {
                try {
                    System.out.print("Where do you wanna go: ");
                    selectPlace = scanner.nextInt();
                    scanner.nextLine();
                    if (selectPlace >= 0 && selectPlace <= 5)
                        break;
                    else
                        System.out.println("Please enter a number between 0 and 5.");
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter an integer.");
                    scanner.nextLine();
                }
            }

            switch (selectPlace) {
                case 1:
                    place = new Hogwarts(wizard);
                    break;
                case 2:
                    if(!wizard.getBag().isGoldenSnitch()) {
                        place = new Azkaban(wizard);
                        break;
                    }else {
                        System.out.println("you already won the golden snitch!");
                        continue;
                    }
                case 3:
                    if(!wizard.getBag().isSortingHat()) {
                        place = new ChamberOfSecrets(wizard);
                        break;
                    }else {
                        System.out.println("you already won the sorting hat!");
                        continue;
                    }
                case 4:
                    if(!wizard.getBag().isMaraudersMap()) {
                        place = new ForbiddenForest(wizard);
                        break;
                    }else {
                        System.out.println("you already won the marauder's map!");
                        continue;
                    }
                case 5:
                    place = new DiagonAlley(wizard);
                    break;
                default:
                    place = new Hogwarts(wizard);
                    break;

            }

           if (!place.getPlace()) {
                System.out.println("game over");
                System.exit(0);
                break;
            }

        }
    }
    public boolean isAwardTaken() {
        if (wizard.getBag().isGoldenSnitch()) {
            System.out.println("you already cleaned the enemies at Azkaban...");
            return false;
        } else if (wizard.getBag().isSortingHat()) {
            System.out.println("you already cleaned the enemies at Chamber of Secrets...");
            return false;
        } else if (wizard.getBag().isMaraudersMap()) {
            System.out.println("you already cleaned the enemies at Forbidden Forest...");
            return false;
        } else
            return true;
    }
    public void playerLogin() {
        String username;
        int password;
        while (true) {
            try {
                System.out.print("Enter username: ");
                username = scanner.nextLine();
                System.out.print("Enter password: ");
                password = Integer.parseInt(scanner.nextLine());
                if (username.equals("nazli") && password == 1234) {
                    System.out.println("Login successful!");
                    break;
                } else {
                    throw new InputMismatchException();
                }

            } catch (InputMismatchException e) {
                System.out.println("An error occured.");
            }
        }
    }
    public void placeMenu() {
        System.out.println();
        System.out.println("----------------------PLACES---------------------------");
        System.out.println("1- Hogwarts : you are safe here ");
        System.out.println("2- Azkaban : you fight with Dementors"); //ruhemici
        System.out.println("3- Chamber of secrets : you fight with Basilisk ");
        System.out.println("4- Forbidden Forest : you fight with centaurs "); //horseman
        System.out.println("5- Diagon Alley : you can buy staff to get stronger");
        System.out.println();
    }
}
//overloading hogwarts showStatus
//overloading battlePlace show status afterHitStatus
//try catch
//hogwarts getPlace
//battlePlace fight selectCase
//game play playerLogin

