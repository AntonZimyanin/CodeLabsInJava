package mainPackage;

public class Main {
    public static void main(String[] args) {
        // Food potatoes = new Potatoes("жаренная");
        // Food apple = new Apple("большое");
        // Food cheese = new Cheese("Родной");

        // potatoes.consume();
        // apple.consume();
        // cheese.consume();
        Food[] breakfast = new Food[args.length];

        for (int i = 0; i < args.length; i++) {
            String[] parst = args[i].split("/");

            if (parst[0].equals("Cheese")) {
                breakfast[i] = new Cheese(parst[1]);
            } else if (parst[0].equals("Apple")) {
                breakfast[i] = new Apple(parst[1]);
            } else if (parst[0].equals("Potatoes")) {
                breakfast[i] = new Potatoes(parst[1]);
            }

        }

        for (Food i : breakfast) {
            i.consume();
        }

        Food food = new Cheese("Родной");
        System.out.println(food + ": " + countFoods(breakfast, food));
        printFoods(breakfast);
        System.out.println("Завтрак был отличным, увидимся на обеде!)");

    }

    static Integer countFoods(Food[] breakfast, Food food) {
        Integer count = 0;
        for (int i = 0; i < breakfast.length; i++) {
            if (food.equals(breakfast[i])) {
                count++;
            }
        }
        return count;
    }

    static void printFoods(Food[] breakfast) {
        int c = 0;
        int a = 0;
        int p = 0;

        for (int i = 0; i < breakfast.length; i++) {

            if (breakfast[i] instanceof Cheese) {
                c++;
            } else if (breakfast[i] instanceof Apple) {
                a++;
            } else if (breakfast[i] instanceof Potatoes) {
                p++;
            }
        }
        System.out.println("сыр - ".toUpperCase() + c);
        System.out.println("яблоко - ".toUpperCase() + a);
        System.out.println("бульба - ".toUpperCase() + p);
    }
}
