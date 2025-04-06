package evaluate;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import grammar.ExprLexer;
import grammar.ExprParser;

import java.io.IOException;

public class Simulator {
    public static void main(String[] args) throws Exception {
        System.out.println("Enter your code:");
        CharStream input = CharStreams.fromStream(System.in);
        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        ParseTree tree = parser.prog();

        AssemblyCodeGenerator generator = new AssemblyCodeGenerator();
        generator.visit(tree);

        System.out.println("\nGenerated Assembly Code:");
        for (String line : generator.getAssembly()) {
            System.out.println(line);
        }
    }
}


