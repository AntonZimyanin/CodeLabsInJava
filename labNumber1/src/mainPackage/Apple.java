package mainPackage;

public class Apple extends Food {
    private String size;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Apple(String size) {
        super("Яблоко");
        this.size = size;
    }

    @Override
    public void consume() {
        System.out.println(this + " съедено");
    }

    @Override
    public String toString() {
        return super.toString() + " размера '" + size.toUpperCase() + "'";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj))
            return false;
        if (!(obj instanceof Apple))
            return false;
        return size.equals(((Apple) obj).size);
    }
}