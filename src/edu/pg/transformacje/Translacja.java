package edu.pg.transformacje;

public class Translacja implements Transformacja {
    private final double dX, dY;

    public Translacja(double dX, double dY) {
        this.dX = dX;
        this.dY = dY;
    }

    @Override
    public Punkt transformuj(Punkt p) {
        return new Punkt(p.getX() + dX, p.getY() + dY);
    }

    @Override
    public Transformacja getTransformacjaOdwrotna() throws BrakTransformacjiOdwrotnejException {
        return new Translacja(-dX, -dY);
    }

    public double getdX() {
        return dX;
    }

    public double getdY() {
        return dY;
    }

    @Override
    public String toString() {
        return "Translacja(" + "dX=" + dX +", dY=" + dY + ')';
    }
}
