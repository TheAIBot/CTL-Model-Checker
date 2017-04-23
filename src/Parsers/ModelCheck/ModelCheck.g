grammar ModelCheck;

options {
  language = Java;
}


start [Model model] returns [boolean b]
	: e = precedence1[model] EOF {b = model.checkIncludesInitialStates(e);}
	;

precedence1 [Model model] returns [HashSet<State> phi]
	: e = precedence2[model] {phi = e;}
	| 'AF(' e = precedence2[model] ')' {phi = model.AF(e)}
	| 'AG(' e = precedence2[model] ')' {phi = model.AG(e)}
	| 'AX(' e = precedence2[model] ')' {phi = model.AX(e)}
	| 'EX(' e = precedence2[model] ')' {phi = model.EX(e)}
	| 'EF(' e = precedence2[model] ')' {phi = model.EF(e)}
	| 'EG(' e = precedence2[model] ')' {phi = model.EG(e)}
	;
	
precedence2 [Model model] returns [HashSet<State> phi]
	: e = precedence3[model] {phi = e;}
	| '(' left = precedence3[model] 'and' right = precedence3[model] ')' {phi = model.intersectionOf(left, right);}
	;
	
precedence3 [Model model] returns [HashSet<State> phi]
	: e = precedence4[model] {phi = e;}
	| 'not(' e = precedence4[model] ')' {phi = model.complementOf(e);}
	;
	
precedence4 [Model model] returns [HashSet<State> phi]
	: e = STRING {phi = model.getStatesWithLabel(e.gettext());}
	| 'tt' {phi = model.trueForAll();}
	| '(' e1 = precedence1[model] ')' {phi = e1;}
	;
	
STRING : ('a'..'z'|'A'..'Z')+;

WS  :   (' '|'\t'|'\r'|'\n')+ { $channel = HIDDEN; } ;
