# Java-Based Compiler with ANTLR Integration

This project is a compiler built in Java that supports loop constructs and simulates the execution of generated assembly-like instructions. It leverages **ANTLR (Another Tool for Language Recognition)** for lexical and syntactic analysis. Designed as an academic and learning-focused initiative, the project demonstrates fundamental concepts of compiler design.

---

## Features

- Lexical and syntax analysis using **ANTLR v4**
- Support for basic programming constructs: `while` and `for` loops
- Generation of intermediate and assembly-like instructions
- Simulation of instruction execution
- Modular, extensible architecture
- Basic error handling and reporting

---

## Technologies Used

- Java (JDK 21)
- ANTLR v4
- Eclipse
- Object-Oriented Programming principles

---

## Project Structure

```
CompilerProject/
├── src/
│   ├── grammar/             # ANTLR grammar definitions (.g4)
│   ├── lexer/               # Generated lexer classes
│   ├── parser/              # Generated parser classes
│   ├── codegen/             # Code generation logic
│   ├── simulator/           # Execution engine
│   └── Main.java            # Program entry point
├── test_programs/           # Sample input programs
├── assets/                  # Screenshots or related assets
│   └── output.png
├── README.md
└── build/                   # Compiled files (optional)
```

---

## ANTLR Setup

1. **Download the ANTLR tool:**
   ```bash
   curl -O https://www.antlr.org/download/antlr-4.13.0-complete.jar
   ```

2. **(Optional) Set up aliases for convenience:**
   ```bash
   export CLASSPATH=".:antlr-4.13.0-complete.jar:$CLASSPATH"
   alias antlr4='java -jar antlr-4.13.0-complete.jar'
   alias grun='java org.antlr.v4.gui.TestRig'
   ```

3. **Generate lexer and parser files:**
   ```bash
   cd src/grammar
   antlr4 Expr.g4 -o ../parser
   ```

---

## Sample Input Program

```c
int i = 0;
while (i < 5) {
    print(i);
    i = i + 1;
}
```

---

## Sample Output

```
0
1
2
3
4
```

---

## Output Screenshot


---

## How to Clone and Run

1. **Clone the repository:**
   ```bash
   git clone https://github.com/lakshitaaaaaa/compiler-project.git
   cd compiler-project
   ```

2. **Follow the steps in the [ANTLR Setup](#antlr-setup) section** to generate the lexer and parser.

3. **Open the project in** Eclipse or IntelliJ IDEA.

4. **Ensure the ANTLR runtime is added** to your project build path.

5. **Run** `Main.java` as a Java application.

6. **Input source code** can be typed directly or loaded from files in the `test_programs/` directory.

---

## About ANTLR

[ANTLR](https://www.antlr.org/) (Another Tool for Language Recognition) is a powerful parser generator used for reading, processing, translating, and executing structured text or binary input. In this project, ANTLR is used to:

- Define the grammar of the custom programming language.
- Automatically generate the lexer and parser.
- Simplify the process of syntax analysis.

---

## Future Enhancements

- Support for conditional statements (`if`, `else`)
- Enhanced error handling and reporting
- Optimized code generation
- GUI interface for code input and output

---

## Author

**Lakshita Chandrakar**  
Second Year, Computer Science and Engineering  
National Institute of Technology, Raipur  
GitHub: [github.com/lakshitaaaaaa](https://github.com/lakshitaaaaaa)

---

## License

This project is licensed under the [MIT License](LICENSE).
