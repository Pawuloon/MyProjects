/**
 *
 *  @author Dembicki Paweł S24328
 *
 */

package zad1;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        Letters letters = new Letters("ABCD");
        for (Thread t : letters.getThreads()) System.out.println(t.getName());
        for (Thread t : letters.getThreads())
        {
            t.start();
        }
        /*<- here run all the codes in threads
         *
         */

        Thread.sleep(5000);

        for (Thread t : letters.getThreads())
        {
            t.interrupt();
        }
        /*<- here you need to write a portion which terminates codes, which print the letters
         *
         */
        System.out.println("\nProgram finished working");
    }

}
