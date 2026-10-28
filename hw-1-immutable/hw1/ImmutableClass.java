package hw1;

public class ImmutableClass {
    private final MutableClass mutable;

    ImmutableClass(MutableClass mutable) {
        this.mutable = mutable.copy();
    }

    public MutableClass getMutable() {
        return mutable.copy();
    }

    public int add() {
        return mutable.getX() + mutable.getY();
    }
}
