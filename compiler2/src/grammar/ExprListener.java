package grammar;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExprParser}.
 */
public interface ExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ExprParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ExprParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#funcDecl}.
	 * @param ctx the parse tree
	 */
	void enterFuncDecl(ExprParser.FuncDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#funcDecl}.
	 * @param ctx the parse tree
	 */
	void exitFuncDecl(ExprParser.FuncDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(ExprParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(ExprParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(ExprParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(ExprParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#stat_expr}.
	 * @param ctx the parse tree
	 */
	void enterStat_expr(ExprParser.Stat_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#stat_expr}.
	 * @param ctx the parse tree
	 */
	void exitStat_expr(ExprParser.Stat_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#stat_assign}.
	 * @param ctx the parse tree
	 */
	void enterStat_assign(ExprParser.Stat_assignContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#stat_assign}.
	 * @param ctx the parse tree
	 */
	void exitStat_assign(ExprParser.Stat_assignContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#stat_loop}.
	 * @param ctx the parse tree
	 */
	void enterStat_loop(ExprParser.Stat_loopContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#stat_loop}.
	 * @param ctx the parse tree
	 */
	void exitStat_loop(ExprParser.Stat_loopContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#stat_for}.
	 * @param ctx the parse tree
	 */
	void enterStat_for(ExprParser.Stat_forContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#stat_for}.
	 * @param ctx the parse tree
	 */
	void exitStat_for(ExprParser.Stat_forContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#stat_do_while}.
	 * @param ctx the parse tree
	 */
	void enterStat_do_while(ExprParser.Stat_do_whileContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#stat_do_while}.
	 * @param ctx the parse tree
	 */
	void exitStat_do_while(ExprParser.Stat_do_whileContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#stat_if_else}.
	 * @param ctx the parse tree
	 */
	void enterStat_if_else(ExprParser.Stat_if_elseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#stat_if_else}.
	 * @param ctx the parse tree
	 */
	void exitStat_if_else(ExprParser.Stat_if_elseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#stat_return}.
	 * @param ctx the parse tree
	 */
	void enterStat_return(ExprParser.Stat_returnContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#stat_return}.
	 * @param ctx the parse tree
	 */
	void exitStat_return(ExprParser.Stat_returnContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#stat_func_call}.
	 * @param ctx the parse tree
	 */
	void enterStat_func_call(ExprParser.Stat_func_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#stat_func_call}.
	 * @param ctx the parse tree
	 */
	void exitStat_func_call(ExprParser.Stat_func_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#forInitializer}.
	 * @param ctx the parse tree
	 */
	void enterForInitializer(ExprParser.ForInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#forInitializer}.
	 * @param ctx the parse tree
	 */
	void exitForInitializer(ExprParser.ForInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(ExprParser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(ExprParser.ForUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#argList}.
	 * @param ctx the parse tree
	 */
	void enterArgList(ExprParser.ArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#argList}.
	 * @param ctx the parse tree
	 */
	void exitArgList(ExprParser.ArgListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(ExprParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(ExprParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(ExprParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(ExprParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ExprParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ExprParser.ExprContext ctx);
}