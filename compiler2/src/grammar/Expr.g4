grammar Expr;

prog: (funcDecl | stat)+ ;

funcDecl: 'func' ID '(' paramList? ')' block ;

paramList: ID (',' ID)* ;

stat
    : stat_expr
    | stat_assign
    | stat_loop
    | stat_for
    | stat_do_while
    | stat_if_else
    | stat_return
    | stat_func_call
    ;

stat_expr: expr NEWLINE ;

stat_assign: ID '=' expr NEWLINE ;

stat_loop: 'loop' '(' condition ')' block ;

stat_for: 'for' '(' forInitializer? ';' condition? ';' forUpdate? ')' block ;

stat_do_while: 'do' block 'while' '(' condition ')' NEWLINE ;

stat_if_else: 'if' '(' condition ')' block ('else' block)? ;

stat_return: 'return' expr NEWLINE ;

stat_func_call: ID '=' ID '(' argList? ')' NEWLINE ;

forInitializer: stat ;

forUpdate: stat ;

argList: expr (',' expr)* ;

block: '{' stat+ '}' ;

condition: expr ('<' | '>' | '==' | '!=' | '<=' | '>=') expr ;

expr
    : expr ('*'|'/') expr
    | expr ('+'|'-') expr
    | INT
    | ID
    | 'input' '(' ')'
    | 'print' '(' expr ')'
    | ID '(' argList? ')'
    | '(' expr ')'
    ;

NEWLINE : [\r\n]+ ;
ID      : [a-zA-Z]+ ;
INT     : [0-9]+ ;
WS      : [ \t]+ -> skip ;

