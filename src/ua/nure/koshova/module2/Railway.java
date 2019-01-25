package ua.nure.koshova.module2;

/**
 * Class railway to represent the railway station
 */
public class Railway{

    private String name;
    private RailType type;

    public Railway(String name, RailType type) {
        this.name = name;
        this.type = type;
    }

    public RailType getType() {
        return type;
    }

    public void setType(RailType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "Station " + name + " terminal " + type;
    }

}
