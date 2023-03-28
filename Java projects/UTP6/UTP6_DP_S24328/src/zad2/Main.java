/**
 *
 *  @author Dembicki Paweł S24328
 *
 */

package zad2;


public class Main {

    public static void main(String ... args) throws Exception  {
        String fname  = System.getProperty("user.home")+"/Test.java";
        Finder finder = new Finder(fname);
        int nif = finder.getIfCount();
        int nwar = finder.getStringCount("variant");
        System.out.println("Number of the if statements: " + nif);
        System.out.println("Number of variant strings: " + nwar);
    }

}
