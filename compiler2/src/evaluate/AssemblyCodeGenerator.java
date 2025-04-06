package evaluate;

import java.util.*;

import grammar.ExprBaseVisitor;
import grammar.ExprParser;

public class AssemblyCodeGenerator extends ExprBaseVisitor<String> {
    private final List<String> assembly = new ArrayList<>();
    private int labelCount = 0;
    private int registerCount = 0;
    private final Map<String, String> variableRegisters = new HashMap<>();
    private final Stack<String> availableRegisters = new Stack<>();
    private static final int NUM_REGISTERS = 10; // Example number of registers

    public AssemblyCodeGenerator() {
        for (int i = NUM_REGISTERS - 1; i >= 0; i--) {
            availableRegisters.push("r" + i);
        }
    }

    private String newLabel() {
        return "L" + (labelCount++);
    }

    private String getRegister() {
        if (availableRegisters.isEmpty()) {
            // Simple spill-to-memory would be needed in a real compiler
            throw new RuntimeException("Out of registers!");
        }
        return availableRegisters.pop();
    }

    private void releaseRegister(String reg) {
        if (!availableRegisters.contains(reg)) {
            availableRegisters.push(reg);
        }
    }

    public List<String> getAssembly() {
        return assembly;
    }

    @Override
    public String visitProg(ExprParser.ProgContext ctx) {
        for (ExprParser.StatContext stat : ctx.stat()) {
            visit(stat);
        }
        return null;
    }

    @Override
    public String visitStat_assign(ExprParser.Stat_assignContext ctx) {
        String exprReg = visit(ctx.expr());
        String varName = ctx.ID().getText();
        if (!variableRegisters.containsKey(varName)) {
            variableRegisters.put(varName, varName); // For simplicity, variables are directly used as memory locations for now
        }
        assembly.add("STORE " + variableRegisters.get(varName) + ", " + exprReg);
        releaseRegister(exprReg);
        return null;
    }

    @Override
    public String visitStat_expr(ExprParser.Stat_exprContext ctx) {
        String resultReg = visit(ctx.expr());
        releaseRegister(resultReg);
        return null;
    }

    @Override
    public String visitStat_loop(ExprParser.Stat_loopContext ctx) {
        String start = newLabel();
        String end = newLabel();

        assembly.add(start + ":");
        String condReg = visit(ctx.condition());
        assembly.add("JZ " + end + ", " + condReg);
        releaseRegister(condReg);
        visit(ctx.block());
        assembly.add("JMP " + start);
        assembly.add(end + ":");

        return null;
    }

    @Override
    public String visitStat_do_while(ExprParser.Stat_do_whileContext ctx) {
        String start = newLabel();
        assembly.add(start + ":");
        visit(ctx.block());
        String condReg = visit(ctx.condition());
        assembly.add("JNZ " + start + ", " + condReg);
        releaseRegister(condReg);
        return null;
    }

    @Override
    public String visitStat_if_else(ExprParser.Stat_if_elseContext ctx) {
        String elseLabel = newLabel();
        String endLabel = newLabel();

        String condReg = visit(ctx.condition());
        assembly.add("JZ " + elseLabel + ", " + condReg);
        releaseRegister(condReg);
        visit(ctx.block(0));
        assembly.add("JMP " + endLabel);
        assembly.add(elseLabel + ":");
        if (ctx.block(1) != null) visit(ctx.block(1));
        assembly.add(endLabel + ":");

        return null;
    }

    @Override
    public String visitBlock(ExprParser.BlockContext ctx) {
        for (ExprParser.StatContext stat : ctx.stat()) {
            visit(stat);
        }
        return null;
    }

    @Override
    public String visitExpr(ExprParser.ExprContext ctx) {
        if (ctx.INT() != null) {
            String reg = getRegister();
            assembly.add("LOADI " + reg + ", " + ctx.INT().getText());
            return reg;
        } else if (ctx.ID() != null && ctx.getChildCount() == 1) {
            String varName = ctx.ID().getText();
            String reg = getRegister();
            if (!variableRegisters.containsKey(varName)) {
                variableRegisters.put(varName, varName); // Treat as memory location
            }
            assembly.add("LOAD " + reg + ", " + variableRegisters.get(varName));
            return reg;
        } else if (ctx.getChildCount() == 3 && ctx.expr().size() == 2) {
            String leftReg = visit(ctx.expr(0));
            String rightReg = visit(ctx.expr(1));
            String resultReg = getRegister();
            switch (ctx.getChild(1).getText()) {
                case "+" -> assembly.add("ADD " + resultReg + ", " + leftReg + ", " + rightReg);
                case "-" -> assembly.add("SUB " + resultReg + ", " + leftReg + ", " + rightReg);
                case "*" -> assembly.add("MUL " + resultReg + ", " + leftReg + ", " + rightReg);
                case "/" -> assembly.add("DIV " + resultReg + ", " + leftReg + ", " + rightReg);
            }
            releaseRegister(leftReg);
            releaseRegister(rightReg);
            return resultReg;
        } else if (ctx.getText().startsWith("print")) {
            String printReg = visit(ctx.expr(0));
            assembly.add("PRINT " + printReg);
            releaseRegister(printReg);
            return null; // Print doesn't return a value in a register
        } else if (ctx.getText().startsWith("input")) {
            String reg = getRegister();
            assembly.add("INPUT " + reg);
            return reg;
        } else if (ctx.getChildCount() == 3 && ctx.getChild(0).getText().equals("(")) {
            return visit(ctx.expr(0));
        }
        return null; // Should not happen
    }

    @Override
    public String visitCondition(ExprParser.ConditionContext ctx) {
        String leftReg = visit(ctx.expr(0));
        String rightReg = visit(ctx.expr(1));
        String resultReg = getRegister();
        String operation = ctx.getChild(1).getText();

        assembly.add("CMP " + leftReg + ", " + rightReg);
        releaseRegister(leftReg);
        releaseRegister(rightReg);

        switch (operation) {
            case "<":
                assembly.add("SETLT " + resultReg);
                break;
            case ">":
                assembly.add("SETGT " + resultReg);
                break;
            case "==":
                assembly.add("SETEQ " + resultReg);
                break;
            case "!=":
                assembly.add("SETNE " + resultReg);
                break;
            case "<=":
                assembly.add("SETLE " + resultReg);
                break;
            case ">=":
                assembly.add("SETGE " + resultReg);
                break;
            default:
                throw new RuntimeException("Unknown comparison operator: " + operation);
        }
        return resultReg;
    }
}

