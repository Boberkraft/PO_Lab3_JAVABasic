package edu.pg.transformacje;

public class Skalowanie implements Transformacja {
    private final double skalaX, skalaY;

    public Skalowanie(double skalaX, double skalaY) {
        this.skalaX = skalaX;
        this.skalaY = skalaY;
    }

    @Override
    public Punkt transformuj(Punkt p) {
        return new Punkt(skalaX * p.getX(), skalaY * p.getY());
    }

    @Override
    public Transformacja getTransformacjaOdwrotna() throws BrakTransformacjiOdwrotnejException {
        if (skalaX == 0 || skalaY == 0) {
            throw new BrakTransformacjiOdwrotnejException("Jeden z czynników skalowania jest równy 0.");
        }
        return new Skalowanie(1 / skalaX, 1 / skalaY);
    }

    public double getSkalaX() {
        return skalaX;
    }

    public double getSkalaY() {
        return skalaY;
    }

    @Override
    public String toString() {
        return "Skalowanie(" + "skalaX=" + skalaX + ", skalaY=" + skalaY + ')';
    }
}
