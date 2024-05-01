public class Main {
    public static void main (String[] args) {
        Wizard wizard = new Wizard();
        Game game = new Game();
        game.playerLogin();
        game.login();
        /*if(wizard.getBag().isSortingHat() && wizard.getBag().isMaraudersMap() && wizard.getBag().isGoldenSnitch()) {
            game.play();
        }else {
            System.out.println("You won the awards...");
            System.exit(0);
        }*/
        game.play();
    }
}