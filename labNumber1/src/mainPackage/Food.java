package mainPackage;

public class Food implements Consumable{
    private String name;

    public Food(String name){ 
        this.name = name;
    }

    public String getName(){ 
        return name;
    }

    public void setName(String name){ 
        this.name = name;
    }

    @Override
    public String toString(){ 
        return name;
    }

    public void consume() { 
        consume();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Food))
            return false;
        
        if (name == null || ((Food)obj).name == null)
            return false;
        
        return name.equals(((Food)obj).name);
    }
}
