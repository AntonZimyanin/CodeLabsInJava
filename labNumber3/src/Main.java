import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Double[] b = new Double[args.length];
        for (int i = 0; i < args.length; i++){
            b[i] = Double.parseDouble(args[i]);
        }
        Double[] polynomialСoeff = {1., 5., 4., 3., 2., 1.};

        HornersScheme frame = new HornersScheme(polynomialСoeff);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
