// The grammar should be called as the filename (without extension)
grammar Calculator;

// This is how we tell ANTLR to generate Java code
options {
  language = Java;
}

// Start rules that end with EOF (End Of File) are useful to detect end of input
// All the rules in this grammar return an integer
// We call the return value just "value"
start returns [int value]
                                  // We update the return value to the value
                                  // obtained from parsing arith_expr
    : e = arith_expr EOF          { $value = e; }
    ;

// These are the productions for arithtmetic expresssion (least precedence level)
arith_expr returns [int value]
    :       e = mult_arith_expr   { $value = e; }
      ( '+' e = mult_arith_expr   { $value = $value + e; }
      | '-' e = mult_arith_expr   { $value = $value - e; } )*
    ;

// These are the productions for arithtmetic expresssion (middle precedence level)
mult_arith_expr returns [int value]
    :       e = base_arith_expr     { $value = e; }
      ( '*' e = base_arith_expr     { $value = $value * e; }
      | '/' e = base_arith_expr     { $value = $value / e; } )*
    ;

// These are the productions for arithtmetic expresssion (greatest precedence level)
base_arith_expr returns [int value]
                                  // We need to cast strings into intergers
    : NUM                         { $value = Integer.parseInt($NUM.getText()); }
    | '(' e = arith_expr ')'      { $value=e; }
    ;

// Declare NUM tokens for numbers as a regular expression
NUM : '0'..'9' ;

// This clause is pretty standard and tells ANTLR to ignore blamnk spaces
WS  :   (' '|'\t'|'\r'|'\n')+ { $channel = HIDDEN; } ;
