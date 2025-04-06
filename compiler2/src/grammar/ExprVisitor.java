// Generated from Expr.g4 by ANTLR 4.13.2
package grammar;


import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExprParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(ExprParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#funcDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDecl(ExprParser.FuncDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(ExprParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(ExprParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#stat_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_expr(ExprParser.Stat_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#stat_assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_assign(ExprParser.Stat_assignContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#stat_loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_loop(ExprParser.Stat_loopContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#stat_for}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_for(ExprParser.Stat_forContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#stat_do_while}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_do_while(ExprParser.Stat_do_whileContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#stat_if_else}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_if_else(ExprParser.Stat_if_elseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#stat_return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_return(ExprParser.Stat_returnContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#stat_func_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat_func_call(ExprParser.Stat_func_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#forInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInitializer(ExprParser.ForInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#forUpdate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdate(ExprParser.ForUpdateContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#argList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgList(ExprParser.ArgListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(ExprParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(ExprParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(ExprParser.ExprContext ctx);
}