public class SafePlace extends Place {
    SafePlace(Wizard wizard, String name) {
        super(wizard);
        this.name = name;
    }
    public boolean getPlace() {
        return true;
    }
    public Wizard getWizard() {
        return wizard;
    }
    public String getName() {
        return name;
    }

    @Override
    public void setWizard(Wizard wizard) {
        super.setWizard(wizard);
    }
    @Override
    public void setName() {
        super.setName();
    }
}
