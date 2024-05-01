import java.util.Scanner;

public abstract class Place {
    Scanner scanner = new Scanner(System.in);
    public Wizard wizard;
    protected String name;

    Place(Wizard wizard) {
        this.wizard = wizard;
    }
    public abstract boolean getPlace();
    public Wizard getWizard() {
        return wizard;
    }
    public void setWizard(Wizard wizard) {
        this.wizard = wizard;
    }
    public String getName() {
        return name;
    }
    public void setName() {
        this.name = name;
    }
}
