

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.*;

/**
 * Created by povishev on 04.09.2018.
 */

public class SetOfFraction implements Cloneable {
    private ArrayList<Fraction> M;
    private boolean max, min;
    private Fraction MaxValue;
    private Fraction MinValue;
    private Map<Fraction, Integer> LessThan;
    private Map<Fraction, Integer> MoreThan;

    public SetOfFraction() {
        M = new ArrayList<Fraction>();
        max = min = false;
        LessThan = MoreThan = new HashMap<Fraction, Integer>();
    }

    public void AddFraction(Fraction n) {
        M.add(n);
        max = min = false;
        MoreThan.clear();
        LessThan.clear();
    }

    public ArrayList<Fraction> getArray() {
        return M;
    }

    public int getSize() {
        return M.size();
    }

    public Fraction getMax() throws Exception {
        if (max) return MaxValue.clone();
        if (M.size() == 0) throw new Exception();
        MaxValue = M.get(0).clone();
        for (int i = 0; i < M.size(); i++) {
            if (MaxValue.Value() < M.get(i).Value()) MaxValue = M.get(i).clone();
        }
        max = true;
        return MaxValue.clone();
    }

    public Fraction getMin() throws Exception {
        if (min) return MinValue.clone();
        if (M.size() == 0) throw new Exception();
        MinValue = M.get(0).clone();
        for (int i = 0; i < M.size(); i++) {
            if (MinValue.Value() < M.get(i).Value()) MinValue = M.get(i).clone();
        }
        min = true;
        return MinValue.clone();
    }

    public int lessThan(Fraction v) throws Exception {
        if (LessThan.containsKey(v)) return (int) LessThan.get(v);
        int lt = 0;
        if (M.size() == 0) throw new Exception();
        for (int i = 0; i < M.size(); i++) {
            if (v.Value() > M.get(i).Value()) lt++;
        }
        LessThan.put(v, lt);
        return lt;
    }

    public int moreThan(Fraction v) throws Exception {
        if (MoreThan.containsKey(v)) return (int) MoreThan.get(v);
        int mt = 0;
        if (M.size() == 0) throw new Exception();
        for (int i = 0; i < M.size(); i++) {
            if (v.Value() < M.get(i).Value()) mt++;
        }
        LessThan.put(v, mt);
        return mt;
    }


    public void PrintSet() {
        for (int i = 0; i < M.size(); i++) {
            System.out.println("[" + i + "]");
            System.out.print(M.get(i).getM());
            System.out.print(" / ");
            System.out.println(M.get(i).getN());
        }
    }

    public void ReadFile(String FileName) {
        try {
            FileReader reader = new FileReader(FileName);
            Scanner scan = new Scanner(reader);
            // читаем посимвольно
            int m, n;
            while (scan.hasNextInt()) {
                m = scan.nextInt();
                n = scan.nextInt();
                System.out.print("m=");
                System.out.println(m);
                System.out.print("n=");
                System.out.println(n);
                System.out.println("-----------");
                M.add(new Fraction(m, n));
            }
            scan.close();
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

}
