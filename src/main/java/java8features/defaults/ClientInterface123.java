package java8features.defaults;

public class ClientInterface123 implements Interface1, Interface2, Interface3 {

    public void methodA() {
        System.out.println("Inside Method A " + ClientInterface123.class);
    }

    public static void main(String[] args) {
        ClientInterface123 clientInterface123 = new ClientInterface123();
        clientInterface123.methodA();
        clientInterface123.methodB();
        clientInterface123.methodC();

    }
}
