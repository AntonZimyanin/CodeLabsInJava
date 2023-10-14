package mainPackage;

public class Potatoes extends Food {
    private String type;

    public Potatoes(String type) {
        super("Картошка");
        this.type = type;
    }

    @Override
    public void consume() {
        System.out.println(this.toString() + " " +  type.toUpperCase() + " съедена");
    }


}

