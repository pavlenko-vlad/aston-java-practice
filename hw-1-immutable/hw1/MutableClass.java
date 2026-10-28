package hw1;

public class MutableClass {
    private int x;
    private int y;

    public MutableClass(int x, int y) {
        this.x = x;
        this.y = y;
    }

     public MutableClass copy() {
        return new MutableClass(x, y);
    } 

    public int getX() { 
        return x; 
    }

    public int getY() { 
        return y; 
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
