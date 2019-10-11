
public class Main {


    public static void main(String[] args) {
        SetOfFraction t = new SetOfFraction();
        SetOfFraction s = new SetOfFraction();
        t.ReadFile("C:\\Users\\vinni\\OneDrive\\Документы\\j.txt");
        t.PrintSet();
//        Fraction x = new Fraction(2,1);
//        try {
//            t.AddFraction(x.clone());
//            t.AddFraction(x.clone());
//            t.AddFraction(x.clone());
//
//            Polinomyal p = new Polinomyal(t,1) ;
//            x.setM(3);
//            x.setN(1);
//            s.AddFraction(x.clone());
//            s.AddFraction(x.clone());
//            Polinomyal p1 = new Polinomyal(s, 1);
//            p.show();
//            p1.show();
//            p.add(p1);
//            p.show();
//
//
//        }
//        catch (CloneNotSupportedException e) {
//            System.out.println("Cloneable not implemented");
//        }
//        catch (Exception e) {
//            System.out.println("The set is empty");
//        }



      try  {
           Fraction x = new Fraction(0,0);
           x.setM(5);
           x.setN(3);
           t.AddFraction(x.clone());
           x.setM(6);
           x.setN(4);
           t.AddFraction(x.clone());
           t.PrintSet();
       }
       catch (CloneNotSupportedException e){
           System.out.println("Cloneable not implemented");
       }


        try
        {
        System.out.print(t.getMax().getM());
        }
        catch (Exception e) {
        }

        // write your code here
//    }
    }
}