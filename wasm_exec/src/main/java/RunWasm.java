import org.wasmer.Instance;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class RunWasm {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        Path wasmPath = Paths.get("../../../../wasm_module/calc.wasm");

        // Reads the WebAssembly module as bytes.
        byte[] wasmBytes = Files.readAllBytes(wasmPath);

        // Instantiates the WebAssembly module.
        Instance instance = new Instance(wasmBytes);
        System.out.println("Enter first integer:   ");
        int a = scanner.nextInt();
        System.out.println("Enter second integer:   ");
        int b = scanner.nextInt();


        // Calls an exported function, and returns an object array.
        Object[] results = instance.exports.getFunction("add").apply(a, b);

        System.out.println( "Result: "+ results[0]); // 42

        // Drops an instance object p""ointer which is stored in Rust.
        instance.close();
    }
}
