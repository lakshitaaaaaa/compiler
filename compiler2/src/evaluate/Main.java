package evaluate;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import grammar.ExprLexer;
import grammar.ExprParser;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            // 1. Read input
//            System.out.println("Enter your code:");
        	String str = """
        			a = 5
        			b = 3
        			print(a + b)
        			if (a > b) {
        				print(a)
        			} else {
        				print(b)
        			}

        			loop (a < 10) {
        				a = a + 1
        				print(a)
        			}

        			for (i = 0; i < 3; i = i + 1) {
        				b = b + 1
        				print(b)
        			}

        			do {
        				a = a - 1
        				print(a)
        			} while (a > 7)

        			func add(x, y) {
        				result = x + y
        				print(result)
        				return result
        			}

        			c = add(4, 6)


        			""";
            CharStream input = CharStreams.fromString(str);

            // 2. Lexer and Parser setup
            ExprLexer lexer = new ExprLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            ExprParser parser = new ExprParser(tokens);

            // 3. Parse the code
            ParseTree tree = parser.prog();

            // 4. Evaluate the code
            EvalVisitor evaluator = new EvalVisitor();
            evaluator.visit(tree);

            // 5. Print evaluation result
            System.out.println("\nEvaluation Result (Variable Memory):");
            Map<String, Integer> memory = evaluator.getMemory();
            for (Map.Entry<String, Integer> entry : memory.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }

            // 6. Generate assembly code
            AssemblyCodeGenerator generator = new AssemblyCodeGenerator();
            generator.visit(tree);

            // 7. Print the generated code
            System.out.println("\nGenerated Assembly Code:");
            List<String> assembly = generator.getAssembly();
            for (String line : assembly) {
                System.out.println(line);
            }

        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
