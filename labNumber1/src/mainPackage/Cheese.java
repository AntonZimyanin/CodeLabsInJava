package mainPackage;


public class Cheese extends Food {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Cheese(String type) {
        super("Сыр");
        this.type = type;
    }

    @Override
    public void consume() {
        System.out.println(this + " съеден");
    }

    @Override
    public String toString() {
        return super.toString() + " '" + type.toUpperCase() + "'";
    }
}