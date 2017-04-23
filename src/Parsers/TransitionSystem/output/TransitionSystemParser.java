package Parsers.TransitionSystem.output;

import org.antlr.runtime.*;

import check.Model;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class TransitionSystemParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "NUMBER", "STRING", "WS", "'*'", 
		"','", "'['", "']'", "'{'", "'}'"
	};
	public static final int EOF=-1;
	public static final int T__7=7;
	public static final int T__8=8;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int NUMBER=4;
	public static final int STRING=5;
	public static final int WS=6;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public TransitionSystemParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public TransitionSystemParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return TransitionSystemParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g"; }



	// $ANTLR start "getModel"
	// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:9:1: getModel returns [Model model = new Model(null)] : ( '{' stateNumber= NUMBER isStartState= initialStar '[' atomProp= stringList ']' edges= numberList '}' )* EOF ;
	public final Model getModel() throws RecognitionException {
		Model model =  new Model(null);


		Token stateNumber=null;
		boolean isStartState =false;
		String atomProp =null;
		String edges =null;

		try {
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:10:2: ( ( '{' stateNumber= NUMBER isStartState= initialStar '[' atomProp= stringList ']' edges= numberList '}' )* EOF )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:10:4: ( '{' stateNumber= NUMBER isStartState= initialStar '[' atomProp= stringList ']' edges= numberList '}' )* EOF
			{
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:10:4: ( '{' stateNumber= NUMBER isStartState= initialStar '[' atomProp= stringList ']' edges= numberList '}' )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==11) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:10:5: '{' stateNumber= NUMBER isStartState= initialStar '[' atomProp= stringList ']' edges= numberList '}'
					{
					match(input,11,FOLLOW_11_in_getModel33); 
					stateNumber=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_getModel39); 
					pushFollow(FOLLOW_initialStar_in_getModel45);
					isStartState=initialStar();
					state._fsp--;

					match(input,9,FOLLOW_9_in_getModel47); 
					pushFollow(FOLLOW_stringList_in_getModel53);
					atomProp=stringList();
					state._fsp--;

					match(input,10,FOLLOW_10_in_getModel55); 
					pushFollow(FOLLOW_numberList_in_getModel61);
					edges=numberList();
					state._fsp--;

					match(input,12,FOLLOW_12_in_getModel63); 
					model.addState(Integer.parseInt(stateNumber.getText()), atomProp, edges, isStartState);
					}
					break;

				default :
					break loop1;
				}
			}

			match(input,EOF,FOLLOW_EOF_in_getModel71); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return model;
	}
	// $ANTLR end "getModel"



	// $ANTLR start "initialStar"
	// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:14:1: initialStar returns [boolean b] : (e= '*' |);
	public final boolean initialStar() throws RecognitionException {
		boolean b = false;


		Token e=null;

		try {
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:15:2: (e= '*' |)
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==7) ) {
				alt2=1;
			}
			else if ( (LA2_0==9) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:15:4: e= '*'
					{
					e=(Token)match(input,7,FOLLOW_7_in_initialStar92); 
					b = e.getText().length() > 0;
					}
					break;
				case 2 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:16:12: 
					{
					b = false;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return b;
	}
	// $ANTLR end "initialStar"



	// $ANTLR start "numberList"
	// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:20:1: numberList returns [String s = \"\"] : (e= NUMBER ',' e= NUMBER ( ',' e= NUMBER )* |e= NUMBER |);
	public final String numberList() throws RecognitionException {
		String s =  "";


		Token e=null;

		try {
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:21:2: (e= NUMBER ',' e= NUMBER ( ',' e= NUMBER )* |e= NUMBER |)
			int alt4=3;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==NUMBER) ) {
				int LA4_1 = input.LA(2);
				if ( (LA4_1==8) ) {
					alt4=1;
				}
				else if ( (LA4_1==12) ) {
					alt4=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 4, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA4_0==12) ) {
				alt4=3;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:21:4: e= NUMBER ',' e= NUMBER ( ',' e= NUMBER )*
					{
					e=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberList139); 
					s  = e.getText();
					match(input,8,FOLLOW_8_in_numberList142); 
					e=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberList152); 
					s += "," + e.getText();
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:22:41: ( ',' e= NUMBER )*
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( (LA3_0==8) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:22:42: ',' e= NUMBER
							{
							match(input,8,FOLLOW_8_in_numberList157); 
							e=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberList167); 
							s += "," + e.getText();
							}
							break;

						default :
							break loop3;
						}
					}

					}
					break;
				case 2 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:24:4: e= NUMBER
					{
					e=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberList180); 
					s  = e.getText();
					}
					break;
				case 3 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:25:10: 
					{
					s  = "";
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return s;
	}
	// $ANTLR end "numberList"



	// $ANTLR start "stringList"
	// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:29:1: stringList returns [String s = \"\"] : (e= STRING ',' e= STRING ( ',' e= STRING )* |e= STRING |);
	public final String stringList() throws RecognitionException {
		String s =  "";


		Token e=null;

		try {
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:30:2: (e= STRING ',' e= STRING ( ',' e= STRING )* |e= STRING |)
			int alt6=3;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==STRING) ) {
				int LA6_1 = input.LA(2);
				if ( (LA6_1==8) ) {
					alt6=1;
				}
				else if ( (LA6_1==10) ) {
					alt6=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 6, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA6_0==10) ) {
				alt6=3;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:30:4: e= STRING ',' e= STRING ( ',' e= STRING )*
					{
					e=(Token)match(input,STRING,FOLLOW_STRING_in_stringList225); 
					s  = e.getText();
					match(input,8,FOLLOW_8_in_stringList228); 
					e=(Token)match(input,STRING,FOLLOW_STRING_in_stringList238); 
					s += "," + e.getText();
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:31:41: ( ',' e= STRING )*
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( (LA5_0==8) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:31:42: ',' e= STRING
							{
							match(input,8,FOLLOW_8_in_stringList243); 
							e=(Token)match(input,STRING,FOLLOW_STRING_in_stringList253); 
							s += "," + e.getText();
							}
							break;

						default :
							break loop5;
						}
					}

					}
					break;
				case 2 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:33:4: e= STRING
					{
					e=(Token)match(input,STRING,FOLLOW_STRING_in_stringList266); 
					s  = e.getText();
					}
					break;
				case 3 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:34:10: 
					{
					s  = "";
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return s;
	}
	// $ANTLR end "stringList"

	// Delegated rules



	public static final BitSet FOLLOW_11_in_getModel33 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_NUMBER_in_getModel39 = new BitSet(new long[]{0x0000000000000280L});
	public static final BitSet FOLLOW_initialStar_in_getModel45 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_getModel47 = new BitSet(new long[]{0x0000000000000420L});
	public static final BitSet FOLLOW_stringList_in_getModel53 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_getModel55 = new BitSet(new long[]{0x0000000000001010L});
	public static final BitSet FOLLOW_numberList_in_getModel61 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_getModel63 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_EOF_in_getModel71 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_7_in_initialStar92 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_numberList139 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_numberList142 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_NUMBER_in_numberList152 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_8_in_numberList157 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_NUMBER_in_numberList167 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_NUMBER_in_numberList180 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_stringList225 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_8_in_stringList228 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_STRING_in_stringList238 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_8_in_stringList243 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_STRING_in_stringList253 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_STRING_in_stringList266 = new BitSet(new long[]{0x0000000000000002L});
}
