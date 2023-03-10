import java.util.Objects;

public class Number {
    public int num;

    public Number(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "" + num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return num == number.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }

    public Number add(Number obj){
        num += obj.num;
        return this;
    }

    public Number sub(Number obj){
        num -= obj.num;
        return this;
    }

    public Number multiply(Number obj){
        num *= obj.num;
        return this;
    }

    public Number div(Number obj){
        if (obj.num != 0)
            num /= obj.num;
        return this;
    }

    public void print(){
        System.out.println(this);
    }
}
