package edu.pg.transformacje;

import java.lang.Math;

public class Obrot implements Transformacja {
    private final double angle;

    public Obrot(double angle) {
        this.angle = angle;
    }

    @Override
    public Punkt transformuj(Punkt p) {
        double newX = p.getX() * Math.cos(angle) - p.getY() * Math.sin(angle);
        double newY = p.getX() * Math.sin(angle) + p.getY() * Math.cos(angle);
        return new Punkt(newX, newY);
    }

    @Override
    public Transformacja getTransformacjaOdwrotna() {
        return new Obrot(-angle);
    }

    @Override
    public String toString() {
        return "Obrot(" + "radians=" + angle + ')';
    }
}
