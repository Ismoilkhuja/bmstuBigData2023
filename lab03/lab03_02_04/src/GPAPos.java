public class GPAPos {
    public float gpa;

    public int pos;

    public GPAPos(float gpa, int pos){
        this.gpa = gpa;
        this.pos = pos;
    }

    @Override
    public String toString() {
        return "GPAPos{" +
                "gpa=" + gpa +
                ", pos=" + pos +
                '}';
    }

}
