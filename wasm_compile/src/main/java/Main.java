import de.inetsoftware.jwebassembly.JWebAssembly;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("../../../../wasm_module/calc.wasm");
        JWebAssembly jWebAssembly = new JWebAssembly();

        jWebAssembly.addFile(new File("Calc.class"));
        jWebAssembly.compileToText(file);

    }


}
