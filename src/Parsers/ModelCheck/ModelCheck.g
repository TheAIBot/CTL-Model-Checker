grammar ModelCheck;

options {
  language = Java;
}

@header {
package Parsers.ModelCheck.output;

import java.util.HashSet;
import check.Model;
import check.State;
}

@lexer::header {
package Parsers.ModelCheck.output;
}


check [Model model] returns [boolean b]
	: e = precedenceOr[model] EOF {b = model.checkIncludesInitialStates(e);}
	;
	
precedenceOr [Model model] returns [HashSet<State> phi]
	: e = precedenceAnd[model] {phi = e;}
	 ('or' right = precedenceAnd[model] {phi = model.unionOf(phi, right);})*
	;	
	
precedenceAnd [Model model] returns [HashSet<State> phi]
	: e = precedenceSingularArgument[model] {phi = e;}
	 ('and' right = precedenceSingularArgument[model] {phi = model.intersectionOf(phi, right);})*
	;	
	
precedenceSingularArgument [Model model] returns [HashSet<State> phi]
	: e = precedenceAP[model] {phi = e;}
	| 'not'e = precedenceSingularArgument[model] {phi = model.complementOf(e);}
	| 'AF' e = precedenceSingularArgument[model] {phi = model.AF(e);}
	| 'AG' e = precedenceSingularArgument[model] {phi = model.AG(e);}
	| 'AX' e = precedenceSingularArgument[model] {phi = model.AX(e);}
	| 'EX' e = precedenceSingularArgument[model] {phi = model.EX(e);}
	| 'EF' e = precedenceSingularArgument[model] {phi = model.EF(e);}
	| 'EG' e = precedenceSingularArgument[model] {phi = model.EG(e);}
	; 
	
precedenceAP [Model model] returns [HashSet<State> phi]
	: e = STRING {phi = model.getStatesWithLabel(e.getText());}
	| 'tt' {phi = model.trueForAll();}
	| '(' e1 = precedenceOr[model] ')' {phi = e1;}
	;
	
STRING : ('a'..'z'|'A'..'Z')+;

WS  :   (' '|'\t'|'\r'|'\n')+ { $channel = HIDDEN; } ;
