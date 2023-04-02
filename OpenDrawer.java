public class OpenDrawer {
    private Drawers drawers;
    private Commode commode;
    private Person person;

    OpenDrawer(Person person, Drawers drawers, Commode commode) {
        this.drawers = drawers;
        this.commode = commode;
        this.person = person;
    }
    OpenDrawer(Person person, Commode commode) {
        this.commode = commode;
        this.person = person;
    }

    public Drawers getDrawer() {
        return drawers;
    }

    @Override
    public String toString() {
        if (drawers == null) {
            return person.getName() + " у комода " + commode.getID() + " цвета " + commode.getColor() + " ничего не открыла ";
        }
        if (drawers == Drawers.all) {
            return person.getName() + " ЗВЕРЬ" + " у комода " + commode.getID() + " цвета " + commode.getColor() + " открыл/ла все ящики ";
        }
        return "none";
        
    }
}
