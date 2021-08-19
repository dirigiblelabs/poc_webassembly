## Compiling java program to .wasm and using the .wasm module in other project.

This example runs on Ubuntu 20.04. 
There is some problem in wasmer library for macOs.

1. Clone the repository
```  
git clone https://github.com/vanolincikus/webassembly_example.git
```
2. Go to folder 
```
cd webassembly_example
```
### Here you can see three folders: 

`wasm_compile` - folder with java program which will compile our java program to .wasm 

`wasm_module` - folder with compiled .wasm module(now its empty)

`wasm_exec` - folder with java program which will run our .wasm module.

3. Go to wasm_compile directory, to :
```
cd wasm_compile/src/main/java/
```
4.Now we need to download two libraries for compiling out java code to .wasm. You can use `culr` for downloading libraries as well, like this `culr -O <url>`:

``` 
wget https://repo1.maven.org/maven2/de/inetsoftware/jwebassembly-compiler/0.3/jwebassembly-compiler-0.3.jar

```
```
wget https://repo1.maven.org/maven2/de/inetsoftware/jwebassembly-api/0.3/jwebassembly-api-0.3.jar
```
5. Now lets compile Calc.java 
``` 
javac -cp jwebassembly-api-0.3.jar Calc.java
```

6.Now lets generate out `.wasm` module
```
java -cp jwebassembly-api-0.3.jar:jwebassembly-compiler-0.3.jar Main.java
```
7. Now lets check our `wasm_module` folder, if everything is ok, we should see there our .wasm file - `calc.wasm`
```
cd ../../../../wasm_module
```
8.Lets run our program!Go to our `wasm_exec`:
```
cd ../wasm_exec/src/main/java
```
9. Now we need to download library which will help us compiles and instantiate our WebAssembly module.

For Linux:
```
wget https://github.com/wasmerio/wasmer-java/releases/download/0.3.0/wasmer-jni-amd64-linux-0.3.0.jar
```
For Mac:
```
wget https://github.com/wasmerio/wasmer-java/releases/download/0.3.0/wasmer-jni-amd64-darwin-0.3.0.jar
```
10.Lets execute the program:

for Linux:
``` 
java -cp wasmer-jni-amd64-linux-0.3.0.jar RunWasm.java
```
for Mac:
```
java -Dos.arch=amd64 -cp wasmer-jni-amd64-darwin-0.3.0.jar RunWasm.java
```
If everything runs well we should see this:
```
Enter first integer: 
```



