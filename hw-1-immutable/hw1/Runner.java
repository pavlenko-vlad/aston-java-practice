package hw1;

public class Runner {
    public static void main(String args []) {
        MutableClass mutable = new MutableClass(1,2);
        ImmutableClass immutable = new ImmutableClass(mutable);

        MutableClass safeCopy1 = immutable.getMutable();
        System.out.println("x: " + safeCopy1.getX() + " y: " + safeCopy1.getY());
        System.out.println("x + y = " + (safeCopy1.getX() + safeCopy1.getY()));

        mutable.setX(10);
        mutable.setY(20);
        System.out.println("x: " + mutable.getX() + " y: " + mutable.getY() + " в mutable объекте");
        System.out.println("После изменения x и y в mutable объекте");
        
        MutableClass safeCopy2 = immutable.getMutable();
        System.out.println("x + y = " + (safeCopy2.getX() + safeCopy2.getY()));
        System.out.println("Внутреннее поле immutable и исходный mutable - один объект? " +
            (safeCopy2 == mutable));
    }
}
