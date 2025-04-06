package evaluate;

import java.util.HashMap;
import java.util.Map;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import grammar.ExprBaseVisitor;
import grammar.ExprParser;

public class EvalVisitor extends ExprBaseVisitor<Integer> {

    // Variable memory
    private final Map<String, Integer> memory = new HashMap<>();

    @Override
    public Integer visitProg(ExprParser.ProgContext ctx) {
        for (ExprParser.StatContext statCtx : ctx.stat()) {
            visit(statCtx);
        }
        return 0;
    }

    @Override
    public Integer visitStat_loop(ExprParser.Stat_loopContext ctx) {
        while (visitCondition(ctx.condition()) == 1) {
        	System.out.println("Loop condition true, memory: "+memory);
            visit(ctx.block());
        }
        System.out.println("Loop exited, final memory : "+memory);
        return 0;
    }

    @Override
    public Integer visitBlock(ExprParser.BlockContext ctx) {
        for (ExprParser.StatContext statCtx : ctx.stat()) {
            visit(statCtx);
        }
        return 0;
    }

    @Override
    public Integer visitStat_expr(ExprParser.Stat_exprContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Integer visitStat_assign(ExprParser.Stat_assignContext ctx) {
        String id = ctx.ID().getText();
        int value = visit(ctx.expr());
        memory.put(id, value);
        return 0;
    }

    @Override
    public Integer visitStat_return(ExprParser.Stat_returnContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Integer visitStat_func_call(ExprParser.Stat_func_callContext ctx) {
        // You can implement function calling here later
        return 0;
    }

    @Override
    public Integer visitStat_if_else(ExprParser.Stat_if_elseContext ctx) {
        if (visitCondition(ctx.condition()) == 1) {
            visit(ctx.block(0));
        } else if (ctx.block(1) != null) {
            visit(ctx.block(1));
        }
        return 0;
    }

    @Override
    public Integer visitStat_do_while(ExprParser.Stat_do_whileContext ctx) {
        do {
            visit(ctx.block());
        } while (visitCondition(ctx.condition()) == 1);
        return 0;
    }

    @Override
    public Integer visitCondition(ExprParser.ConditionContext ctx) {
        int left = visit(ctx.expr(0));
        int right = visit(ctx.expr(1));
        String op = ctx.getChild(1).getText();

        return switch (op) {
            case "==" -> (left == right) ? 1 : 0;
            case "!=" -> (left != right) ? 1 : 0;
            case "<" -> (left < right) ? 1 : 0;
            case ">" -> (left > right) ? 1 : 0;
            case "<=" -> (left <= right) ? 1 : 0;
            case ">=" -> (left >= right) ? 1 : 0;
            default -> 0;
        };
    }

    @Override
    public Integer visitExpr(ExprParser.ExprContext ctx) {
        if (ctx.INT() != null) {
            return Integer.parseInt(ctx.INT().getText());
        } else if (ctx.ID() != null && ctx.getChildCount() == 1) {
            String id = ctx.ID().getText();
            return memory.getOrDefault(id, 0);
        } else if (ctx.getChildCount() == 3 && ctx.getChild(0).getText().equals("(")) {
            return visit(ctx.expr(0));
        } else if (ctx.getChildCount() == 3) {
            int left = visit(ctx.expr(0));
            int right = visit(ctx.expr(1));
            String op = ctx.getChild(1).getText();

            return switch (op) {
                case "+" -> left + right;
                case "-" -> left - right;
                case "*" -> left * right;
                case "/" -> right != 0 ? left / right : 0;
                default -> 0;
            };
        } else if (ctx.getText().startsWith("input")) {
            System.out.print("Input: ");
            try {
                return new java.util.Scanner(System.in).nextInt();
            } catch (Exception e) {
                return 0;
            }
        } else if (ctx.getText().startsWith("print")) {
            int value = visit(ctx.expr(0));
            System.out.println(value);
            return 0;
        }

        return 0;
    }
    
    public Map<String,Integer> getMemory(){
    	return memory;
    }
}

