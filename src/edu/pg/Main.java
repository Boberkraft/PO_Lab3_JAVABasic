package edu.pg;

import edu.pg.transformacje.*;

import java.lang.Math;

public class Main {

    static void main1() {
        Punkt a = new Punkt(1, 0);
        System.out.println(a);
        System.out.println(a.getX());
        System.out.println(a.getY());
        System.out.println(Punkt.O);
        System.out.println(Punkt.E_X);
        System.out.println(Punkt.E_Y);
        System.out.println(Punkt.E_X.equals(new Punkt(1, 0)));
        System.out.println(Punkt.E_X.equals(new Punkt(0, 1)));

    }

    static void main2() {
        try {
            Punkt p1 = Punkt.E_X;
            System.out.println(p1);
            Transformacja tr = new Translacja(5, 6);
            System.out.println(tr);
            Punkt p2 = tr.transformuj(p1);
            System.out.println(p2);
            Transformacja trr = tr.getTransformacjaOdwrotna();
            System.out.println(trr);
            Punkt p3 = trr.transformuj(p2);
            System.out.println(p3);
        } catch (BrakTransformacjiOdwrotnejException ex) {
            ex.printStackTrace();
        }
        System.out.println();

        try {
            Punkt p1 = new Punkt(2, 2);
            System.out.println(p1);
            Transformacja tr2 = new Skalowanie(5, 4);
            System.out.println(tr2);
            Punkt p2 = tr2.transformuj(p1);
            System.out.println(p2);
            Transformacja trr2 = tr2.getTransformacjaOdwrotna();
            System.out.println(trr2);
            Punkt p3 = trr2.transformuj(p2);
            System.out.println(p3);
        } catch (BrakTransformacjiOdwrotnejException ex) {
            ex.printStackTrace();
        }
        System.out.println();
        try {
            Punkt p1 = new Punkt(2, 2);
            Transformacja tr2 = new Skalowanie(5, 0);
            System.out.println(tr2);
            System.out.println(p1);
            Punkt p2 = tr2.transformuj(p1);
            System.out.println(p2);
            Transformacja trr2 = tr2.getTransformacjaOdwrotna();
            System.out.println(trr2);
            Punkt p3 = trr2.transformuj(p2);
            System.out.println(p3);
        } catch (BrakTransformacjiOdwrotnejException ex) {
            ex.printStackTrace();
        }
        System.out.println();
    }

    public static void main3() {
        Punkt p1 = new Punkt(2, 2);
        Transformacja obrotnik = new Obrot(Math.toRadians(90));
        Punkt pr2 = obrotnik.transformuj(p1);
        System.out.println(pr2);
        try {
            Punkt pr3 = obrotnik.getTransformacjaOdwrotna().transformuj(p1);
            System.out.println(pr3);
        } catch (BrakTransformacjiOdwrotnejException ex) {
            ex.printStackTrace();
        }
    }

    public static void main4() {
        Punkt p1;
        ZlozenieTransformacji agregator, agregatorOdwrotny;
        p1 = new Punkt(10, 0);

        agregator = new ZlozenieTransformacji();
        agregator.dodaj(new Translacja(10,0));
        agregator.dodaj(new Skalowanie(2,2));
        agregator.dodaj(new Obrot(Math.toRadians(90)));

        agregatorOdwrotny = (ZlozenieTransformacji) agregator.getTransformacjaOdwrotna();

        System.out.println(agregator);
        System.out.println(agregatorOdwrotny);

        System.out.println(agregator.transformuj(p1));
        System.out.println(agregatorOdwrotny.transformuj(p1));
    }

    public static void main(String[] args) {
//        main1();
//        main2();
//        main3();
        main4();
    }
}
