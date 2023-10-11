package tester;
import interfaceBasic.*;
import static interfaceBasic.Printer.speeed;
public class TestInterface {
    public static void main(String[] args) {
        Printer p = new ConsolePrint();
        p.print();
        p = new FilePrint();
        p.print();
        p = new NetworkPrint();
        p.print();
        System.out.println(speeed);

        Printer[] p1 = {new ConsolePrint(), new NetworkPrint(), new FilePrint()};

        for (Printer x : p1){
            System.out.println(speeed);
            x.print();
        }
    }
}
