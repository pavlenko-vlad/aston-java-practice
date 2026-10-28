package hw1;

public final class ImmutableClass {
    private final MutableClass mutable;

    public ImmutableClass(MutableClass mutable) {
        this.mutable = mutable.copy();
    }

    public MutableClass getMutable() {
        return mutable.copy();
    }

    public int add() {
        return mutable.getX() + mutable.getY();
    }
}
