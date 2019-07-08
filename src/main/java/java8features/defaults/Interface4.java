package java8features.defaults;

public interface Interface4 {

    default void methodA() {
        System.out.println("Inside Method A " + Interface1.class);
    }
}
