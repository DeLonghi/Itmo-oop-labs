import java.util.ArrayList;

public class Polinomyal {
    private ArrayList<Fraction> polinomCoe;
    private int power;
    private double[] polinom;

    public double[] getPolinom() {
        return polinom;
    }

    public Polinomyal(SetOfFraction sof, int p) {
        this.polinomCoe = (ArrayList<Fraction>) sof.getArray().clone();
        this.power = p;
        polinom = new double[polinomCoe.size()];
        for (int i = 0; i < polinomCoe.size(); i++)
            polinom[i] = Math.pow(polinomCoe.get(i).Value(), power + polinomCoe.size() - 1 - i);
    }

    public void show() {
        for (double X : polinom) {
            System.out.print(X + " ");
        }
        System.out.println();
    }

    public Polinomyal add(Polinomyal p) {
        int mSize = Math.min(polinom.length, p.getPolinom().length);
        double[] temp = polinom.length >= p.polinom.length ? polinom : p.polinom;
        for (int i = 0; i < mSize; i++)
            temp[i] = polinom[i] + p.polinom[i];
        polinom = temp;

        return this;
    }

}
