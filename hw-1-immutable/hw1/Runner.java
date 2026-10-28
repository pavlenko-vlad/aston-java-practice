package hw1;

public class Runner {
    public static void main(String args []) {
        MutableClass mutable = new MutableClass(1,2);
        ImmutableClass immutable = new ImmutableClass(mutable);
        System.out.println("x: " + mutable.getX() + " y: " + mutable.getY());

        System.out.println("x + y = " + immutable.add());       

        mutable.setX(10);
        mutable.setY(20);
        System.out.println("После изменения x и y в mutable объекте");
        System.out.println("x + y = " + immutable.add());
        
        System.out.println("Внутреннее поле immutable и исходный mutable - один объект? " +
            (immutable.getMutable() == mutable));
    }
}
