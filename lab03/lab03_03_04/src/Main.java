public class Main {
    public static void main(String[] args) {
        Number rt = new Number(1);
        Number er = new Number(123);
        Number we = new Number(123);
        if (rt.equals(er))
            System.out.println("rt equals er");
        else if (er.equals(we))
            System.out.println("er equals we");
        else
            System.out.println("none equals");

        Fraction df = new Fraction(1, 2);
        Fraction dz = new Fraction(1, 2);
        Fraction dt = new Fraction(3, 4);

        System.out.println(df.getNum());
        System.out.println(df.getDenom());

        if (dz.equals(dt))
            System.out.println("dz equals dt");
        if (dz.equals(df))
            System.out.println("dz equals df");
        if (dz.equals(rt))
            System.out.println("dz equals rt");

//        df.add(rt);
        System.out.println(df);
        df.print();

        dz.div(dt);
        dz.print();


    }
}