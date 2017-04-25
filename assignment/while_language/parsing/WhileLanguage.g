grammar WhileLanguage;

options {
  language = Java;
}

@header {
package while_language.parsing;

import while_language.ast.*;

}

@lexer::header {
package while_language.parsing;

}

program returns [Statement value]
    : s=statement EOF { $value = s; }
    ;

statement returns [Statement value]
    : s=base_statement       { $value = s; }
      ( ';' s=base_statement { $value = new SeqStatement($value,s); } )*
    ;

base_statement returns [Statement value]
    : ID ':=' e=arith_expr                        { $value = new AssignStatement($ID.getText(), e); }
    | 'if' c=bool_expr 'then' s1=base_statement
      'else' s2=base_statement                    { $value = new IfStatement(c,s1,s2); }
    | '{' s=statement '}'                         { $value = s; }
	 | 'while' c=bool_expr 'do' s=base_statement   { $value = new WhileStatement(c,s);}         //Added by questiong 3.
    ;

bool_expr returns [BoolExpr value]					//Changed from && to ||, and the link to conj_bool_expr as part of question 4.
    : e=conj_bool_expr        { $value = e; }
      ( '||' e=conj_bool_expr { $value = new NotExpr(new AndExpr(new NotExpr($value), new NotExpr(e))); } )*
    ;


conj_bool_expr returns [BoolExpr value]											//Changed name from bool_expr to conj_bool_expr as part of question 4.
     : e=literal       { $value = e; }		
      ( '&&' e=literal { $value = new AndExpr($value,e); } )*
    ;


literal returns [BoolExpr value]
    : e=base_bool_expr    { $value = e; }
    | '!' e=literal { $value = new NotExpr(e); }
    ;

base_bool_expr returns [BoolExpr value]
    : 'true'                             { $value = new BoolValueExpr(true); }
    | 'false'                            { $value = new BoolValueExpr(false); }
    | e1=arith_expr '='  e2=arith_expr   { $value = new EqualsExpr(e1,e2); }
	 | e1=arith_expr '<=' e2=arith_expr   { $value = new LessThanOrEqualsExpr(e1,e2);}    	  //Added by question 2
	 | e1=arith_expr '!=' e2=arith_expr   { $value = new NotExpr(new EqualsExpr(e1,e2));}       //Added by question 2
    ;

arith_expr returns [ArithExpr value]
    : e=mult_arith_expr       { $value = e; }
      ( '+' e=mult_arith_expr { $value = new PlusExpr($value,e); } 
      | '-' e=mult_arith_expr { $value = new MinusExpr($value,e); } )*
    ;

mult_arith_expr returns [ArithExpr value]
    : e=base_arith_expr       { $value = e; }
      ( '*' e=base_arith_expr { $value = new MultExpr($value,e); } )*
    ;

base_arith_expr returns [ArithExpr value]
    : NUM { $value = new NumExpr(Integer.parseInt($NUM.getText())); }
    | ID  { $value = new IdExpr($ID.getText()); }
    ;
    
NUM : '0'..'9'+ ;
ID  : ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9')* ;

WS  :   (' '|'\t'|'\r'|'\n')+ { $channel = HIDDEN; } ; 


