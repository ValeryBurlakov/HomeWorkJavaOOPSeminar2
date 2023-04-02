
public class Commode {
    private Integer idCommode;
    private String color;

    public Commode(Integer idCommode, String color) {
        this.idCommode = idCommode;
        this.color = color;
    }

    public Integer getID() {
        return idCommode;
    }
    public String getColor() {
        return color;
    }

    @Override 
    public String toString() {
        return String.format(color, idCommode);
    }

}
