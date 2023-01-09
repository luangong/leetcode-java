grammar Graph;

start: '{' (edge ('#' edge)*)? '}' ;
edge : node (',' node)* ;
node : INT ;

INT : '-'? [0-9]+ ;
WS  : [ \t\r\n]+ -> skip ;
