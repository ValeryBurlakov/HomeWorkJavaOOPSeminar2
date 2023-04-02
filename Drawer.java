public class Drawer {
    public Commode commode;
    public Drawers drawers;

    Drawer(Drawers drawers, Commode commode) {
        this.drawers = drawers;
        this.commode = commode;
    }
    
    @Override
    public String toString() {
        return "" + drawers;

    }
}
