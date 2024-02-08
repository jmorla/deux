
program ::= statement EOF;

statement ::= returnStatement;

returnStatement ::= 'return' expression ';'; 

expression ::= primaryExpression;

primaryExpression ::= NUMBER;

NUMBER ::= [1-9] | [1-9]*;