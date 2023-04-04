package withInterface;

public class OpenDrawer {
    private Drawers drawers;
    private Commode commode;
    private PersonInterface person;

    OpenDrawer(PersonInterface person, Drawers drawers, Commode commode) {
        this.drawers = drawers;
        this.commode = commode;
        this.person = person;
    }
    OpenDrawer(PersonInterface person, Commode commode) {
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
        if (drawers == Drawers.one) {
            return person.getName() + " у комода " + commode.getID() + " цвета " + commode.getColor() + " открыл/ла ящик " + Drawers.one;
        }
        if (drawers == Drawers.two) {
            return person.getName() + " у комода " + commode.getID() + " цвета " + commode.getColor() + " открыл/ла ящик " + Drawers.two;
        }
        if (drawers == Drawers.three) {
            return person.getName() + " у комода " + commode.getID() + " цвета " + commode.getColor() + " открыл/ла ящик " + Drawers.three;
        }
        if (drawers == Drawers.four) {
            return person.getName() + " у комода " + commode.getID() + " цвета " + commode.getColor() + " открыл/ла ящик " + Drawers.four;
        }
        if (drawers == Drawers.all) {
            return person.getName() + " ЗВЕРЬ" + " у комода " + commode.getID() + " цвета " + commode.getColor() + " открыл/ла все ящики ";
        }
        return "none";
        
    }
}
