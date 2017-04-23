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
					b = true;
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
	// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:20:1: numberList returns [String s = \"\"] : (e= NUMBER ( ',' e= NUMBER )* |);
	public final String numberList() throws RecognitionException {
		String s =  "";


		Token e=null;

		try {
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:21:2: (e= NUMBER ( ',' e= NUMBER )* |)
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==NUMBER) ) {
				alt4=1;
			}
			else if ( (LA4_0==12) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:21:7: e= NUMBER ( ',' e= NUMBER )*
					{
					e=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberList142); 
					s  = e.getText();
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:22:2: ( ',' e= NUMBER )*
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( (LA3_0==8) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:22:3: ',' e= NUMBER
							{
							match(input,8,FOLLOW_8_in_numberList148); 
							e=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_numberList154); 
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
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:23:13: 
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
	// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:27:1: stringList returns [String s = \"\"] : (e= STRING ( ',' e= STRING )* |);
	public final String stringList() throws RecognitionException {
		String s =  "";


		Token e=null;

		try {
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:28:2: (e= STRING ( ',' e= STRING )* |)
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==STRING) ) {
				alt6=1;
			}
			else if ( (LA6_0==10) ) {
				alt6=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:28:7: e= STRING ( ',' e= STRING )*
					{
					e=(Token)match(input,STRING,FOLLOW_STRING_in_stringList207); 
					s  = e.getText();
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:29:2: ( ',' e= STRING )*
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( (LA5_0==8) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:29:3: ',' e= STRING
							{
							match(input,8,FOLLOW_8_in_stringList213); 
							e=(Token)match(input,STRING,FOLLOW_STRING_in_stringList219); 
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
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:30:13: 
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
	public static final BitSet FOLLOW_NUMBER_in_numberList142 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_8_in_numberList148 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_NUMBER_in_numberList154 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_STRING_in_stringList207 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_8_in_stringList213 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_STRING_in_stringList219 = new BitSet(new long[]{0x0000000000000102L});
}
