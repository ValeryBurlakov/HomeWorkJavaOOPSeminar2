package withInterface;

public class Commode extends furnitureext{
    private Integer idCommode;
    private String color;

    public Commode(Integer idCommode, String color) {
        this.idCommode = idCommode;
        this.color = color;
    }

    public Integer getID() {
        return idCommode;
    }

    @Override
    public String getColor() {
        System.out.println("this color - " + color + " extends for example");
        return color;
    }

    @Override 
    public String toString() {
        return String.format(color, idCommode);
    }

}
