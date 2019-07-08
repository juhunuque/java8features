package java8features.defaults;

public class ClientInterface14 implements Interface1, Interface4 {

    @Override
    public void methodA() {
        System.out.println("Inside Method A " + ClientInterface14.class);
    }

    public static void main(String[] args) {
        ClientInterface14 clientInterface14 = new ClientInterface14();
        clientInterface14.methodA();
    }
}
