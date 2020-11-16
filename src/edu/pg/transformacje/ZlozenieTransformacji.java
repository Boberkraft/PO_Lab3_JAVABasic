package edu.pg.transformacje;

import java.util.Arrays;

public class ZlozenieTransformacji implements Transformacja {
    private final Transformacja[] transformacje;
    private int ilosc;

    public ZlozenieTransformacji() {
        this.transformacje = new Transformacja[10];
        this.ilosc = 0;
    }

    public ZlozenieTransformacji dodaj(Transformacja trans) {
        transformacje[ilosc] = trans;
        this.ilosc += 1;
        return this;
    }

    @Override
    public Punkt transformuj(Punkt p) {
        for (int i = 0; i < ilosc; i++) {
            p = transformacje[i].transformuj(p);
        }

        return p;
    }

    @Override
    public Transformacja getTransformacjaOdwrotna() {
        ZlozenieTransformacji odwrotna = new ZlozenieTransformacji();

        for (int i = 0; i < ilosc; i++) {
            odwrotna.dodaj(transformacje[ilosc - i - 1]);
        }

        return odwrotna;
    }

    @Override
    public String toString() {
        StringBuffer builder = new StringBuffer();
        builder.append("ZlozenieTransformacji {\n");
        for (int i = 0; i < ilosc; i++) {
            builder.append("  |> ").append(transformacje[i].toString()).append("\n");
        }
        builder.append("}");
        return builder.toString();
    }
}
