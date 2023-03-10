import java.util.Objects;

public class Fraction extends Number{
    public int denom;

    public Fraction(int num, int denom) {
        super(num);
        if (denom != 0)
            this.denom = denom;
    }

    public int getDenom() {
        return denom;
    }

    public void setDenom(int denom) {
        this.denom = denom;
    }
    @Override
    public String toString() {
        return num + "/" + denom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Fraction fraction = (Fraction) o;
        return denom == fraction.denom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), denom);
    }

    public Fraction add(Fraction obj){
        this.num = (obj.denom * this.num) + (this.denom * obj.num);
        this.denom = this.denom * obj.denom;
        return this;
    }

    public Fraction sub(Fraction obj){
        this.num = (obj.denom * this.num) - (this.denom * obj.num);
        this.denom = this.denom * obj.denom;
        return this;
    }

    public Fraction multiply(Fraction obj){
        this.num = this.num * obj.num;
        this.denom = this.denom * obj.denom;
        return this;
    }

    public Fraction div(Fraction obj) {
        this.num = this.num * obj.denom;
        this.denom = this.denom * obj.num;
        return this;
    }
}
