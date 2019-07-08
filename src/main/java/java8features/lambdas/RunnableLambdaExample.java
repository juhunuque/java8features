package java8features.lambdas;

public class RunnableLambdaExample {

    public static void main(String[] args) {
        /**
         * Prior Java 8
         */

        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("Inside Runnable 1");
            }
        };

        new Thread(runnable).start();

        /**
         * Java 8 Lambda
         */


        Runnable runnableLambda = () -> {
            System.out.println("Inside Runnable 2");
        };

        new Thread(runnableLambda).start();

        Runnable runnableLambda1 = () -> System.out.println("Inside Runnable 3");

        new Thread(runnableLambda1).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Runnable 3.1");
            }
        }).start();

        new Thread(() -> System.out.println("Inside Runnable 4")).start();

    }


}
