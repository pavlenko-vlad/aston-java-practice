package hw1;

public final class ImmutableClass {
    private final MutableClass mutable;

    public ImmutableClass(MutableClass mutable) {
        this.mutable = new MutableClass(mutable);
    }

    public MutableClass getMutable() {
        return new MutableClass(mutable);
    }

}
