
program ::= statement EOF;

statement ::= 'return' expression ';';

expression ::= primaryExpression;

primaryExpression ::= INTEGER_LITERAL;

INTEGER_LITERAL ::= [1-9] | [1-9]*;