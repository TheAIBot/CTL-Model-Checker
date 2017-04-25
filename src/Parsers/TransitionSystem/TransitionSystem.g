// The grammar should be called as the filename (without extension)
grammar TransitionSystem;

// This is how we tell ANTLR to generate Java code
options {
  language = Java;
}

@header {
package Parsers.TransitionSystem.output;

import check.Model;
}

@lexer::header {
package Parsers.TransitionSystem.output;
}


getModel returns [Model model = new Model()] 
	: ('{' stateNumber = NUMBER isStartState = initialStar '[' atomProp = stringList ']' edges = numberList '}'
		{model.addState(Integer.parseInt(stateNumber.getText()), atomProp, edges, isStartState);})* EOF
	 ;
	
initialStar returns [boolean b]
	: '*' {b = true;}
	|     {b = false;}
	;
	
NUMBER : ('0'..'9')+;
numberList returns [String s = ""]
	:    e = NUMBER {s  = e.getText();}
	(',' e = NUMBER {s += "," + e.getText();})*
	| 	        {s  = "";}
	;
	
STRING : ('a'..'z')+;
stringList returns [String s = ""]
	:    e = STRING {s  = e.getText();}
	(',' e = STRING {s += "," + e.getText();})*
	| 	        {s  = "";}
	;

WS : (' '|'\t'|'\r'|'\n')+ { $channel = HIDDEN; } ;
