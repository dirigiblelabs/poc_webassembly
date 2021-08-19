import de.inetsoftware.jwebassembly.api.annotation.Export;
public class Calc {
    @Export
    static int add(int a, int b){
        return a+b;
    }
}
