"use strict";
const fs = require('fs');
const ps = require("prompt-sync");
const prompt = ps();

async function main() {
  // Read the wasm file.
  const buf = fs.readFileSync('../wasm_module/calc.wasm')

  // Create a WebAssembly instance from the wasm.
  const res = await WebAssembly.instantiate(buf,{})
  
  // Get the function to call.
  const { add } = res.instance.exports
  
 
  let a = prompt("Enter first integer : ");
  let b = prompt("Enter second integer : ");

   // Call the function
  const result = add(a, b)
  console.log(`${a} + ${b} = ${result}`);
}

main().then(() => console.log('Done'))