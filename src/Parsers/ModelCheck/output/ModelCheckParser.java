// $ANTLR 3.5.1 C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g 2017-04-23 17:22:38

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ModelCheckParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "STRING", "WS", "'('", "')'", 
		"'AF('", "'AG('", "'AX('", "'EF('", "'EG('", "'EX('", "'and'", "'not'", 
		"'tt'"
	};
	public static final int EOF=-1;
	public static final int T__6=6;
	public static final int T__7=7;
	public static final int T__8=8;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int STRING=4;
	public static final int WS=5;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public ModelCheckParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public ModelCheckParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return ModelCheckParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g"; }



	// $ANTLR start "start"
	// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:8:1: start[Model model] returns [boolean b] : e= precedence1[model] EOF ;
	public final boolean start(Model model) throws RecognitionException {
		boolean b = false;


		HashSet<State> e =null;

		try {
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:9:2: (e= precedence1[model] EOF )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:9:4: e= precedence1[model] EOF
			{
			pushFollow(FOLLOW_precedence1_in_start36);
			e=precedence1(model);
			state._fsp--;

			match(input,EOF,FOLLOW_EOF_in_start39); 
			b = model.checkIncludesInitialStates(e);
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
	// $ANTLR end "start"



	// $ANTLR start "precedence1"
	// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:12:1: precedence1[Model model] returns [HashSet<State> phi] : e= precedence2[model] ( 'and' right= precedence2[model] )* ;
	public final HashSet<State> precedence1(Model model) throws RecognitionException {
		HashSet<State> phi = null;


		HashSet<State> e =null;
		HashSet<State> right =null;

		try {
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:13:2: (e= precedence2[model] ( 'and' right= precedence2[model] )* )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:13:4: e= precedence2[model] ( 'and' right= precedence2[model] )*
			{
			pushFollow(FOLLOW_precedence2_in_precedence163);
			e=precedence2(model);
			state._fsp--;

			phi = e;
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:14:3: ( 'and' right= precedence2[model] )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==14) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:14:4: 'and' right= precedence2[model]
					{
					match(input,14,FOLLOW_14_in_precedence171); 
					pushFollow(FOLLOW_precedence2_in_precedence177);
					right=precedence2(model);
					state._fsp--;

					phi = model.intersectionOf(phi, right);
					}
					break;

				default :
					break loop1;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return phi;
	}
	// $ANTLR end "precedence1"



	// $ANTLR start "precedence2"
	// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:17:1: precedence2[Model model] returns [HashSet<State> phi] : (e= precedence3[model] | 'not' e= precedence2[model] );
	public final HashSet<State> precedence2(Model model) throws RecognitionException {
		HashSet<State> phi = null;


		HashSet<State> e =null;

		try {
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:18:2: (e= precedence3[model] | 'not' e= precedence2[model] )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==STRING||LA2_0==6||(LA2_0 >= 8 && LA2_0 <= 13)||LA2_0==16) ) {
				alt2=1;
			}
			else if ( (LA2_0==15) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:18:4: e= precedence3[model]
					{
					pushFollow(FOLLOW_precedence3_in_precedence2104);
					e=precedence3(model);
					state._fsp--;

					phi = e;
					}
					break;
				case 2 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:19:4: 'not' e= precedence2[model]
					{
					match(input,15,FOLLOW_15_in_precedence2112); 
					pushFollow(FOLLOW_precedence2_in_precedence2118);
					e=precedence2(model);
					state._fsp--;

					phi = model.complementOf(e);
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
		return phi;
	}
	// $ANTLR end "precedence2"



	// $ANTLR start "precedence3"
	// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:22:1: precedence3[Model model] returns [HashSet<State> phi] : (e= precedence4[model] | 'AF(' e= precedence1[model] ')' | 'AG(' e= precedence1[model] ')' | 'AX(' e= precedence1[model] ')' | 'EX(' e= precedence1[model] ')' | 'EF(' e= precedence1[model] ')' | 'EG(' e= precedence1[model] ')' );
	public final HashSet<State> precedence3(Model model) throws RecognitionException {
		HashSet<State> phi = null;


		HashSet<State> e =null;

		try {
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:23:2: (e= precedence4[model] | 'AF(' e= precedence1[model] ')' | 'AG(' e= precedence1[model] ')' | 'AX(' e= precedence1[model] ')' | 'EX(' e= precedence1[model] ')' | 'EF(' e= precedence1[model] ')' | 'EG(' e= precedence1[model] ')' )
			int alt3=7;
			switch ( input.LA(1) ) {
			case STRING:
			case 6:
			case 16:
				{
				alt3=1;
				}
				break;
			case 8:
				{
				alt3=2;
				}
				break;
			case 9:
				{
				alt3=3;
				}
				break;
			case 10:
				{
				alt3=4;
				}
				break;
			case 13:
				{
				alt3=5;
				}
				break;
			case 11:
				{
				alt3=6;
				}
				break;
			case 12:
				{
				alt3=7;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:23:4: e= precedence4[model]
					{
					pushFollow(FOLLOW_precedence4_in_precedence3143);
					e=precedence4(model);
					state._fsp--;

					phi = e;
					}
					break;
				case 2 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:24:4: 'AF(' e= precedence1[model] ')'
					{
					match(input,8,FOLLOW_8_in_precedence3151); 
					pushFollow(FOLLOW_precedence1_in_precedence3157);
					e=precedence1(model);
					state._fsp--;

					match(input,7,FOLLOW_7_in_precedence3160); 
					phi = model.AF(e);
					}
					break;
				case 3 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:25:4: 'AG(' e= precedence1[model] ')'
					{
					match(input,9,FOLLOW_9_in_precedence3167); 
					pushFollow(FOLLOW_precedence1_in_precedence3173);
					e=precedence1(model);
					state._fsp--;

					match(input,7,FOLLOW_7_in_precedence3176); 
					phi = model.AG(e);
					}
					break;
				case 4 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:26:4: 'AX(' e= precedence1[model] ')'
					{
					match(input,10,FOLLOW_10_in_precedence3183); 
					pushFollow(FOLLOW_precedence1_in_precedence3189);
					e=precedence1(model);
					state._fsp--;

					match(input,7,FOLLOW_7_in_precedence3192); 
					phi = model.AX(e);
					}
					break;
				case 5 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:27:4: 'EX(' e= precedence1[model] ')'
					{
					match(input,13,FOLLOW_13_in_precedence3199); 
					pushFollow(FOLLOW_precedence1_in_precedence3205);
					e=precedence1(model);
					state._fsp--;

					match(input,7,FOLLOW_7_in_precedence3208); 
					phi = model.EX(e);
					}
					break;
				case 6 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:28:4: 'EF(' e= precedence1[model] ')'
					{
					match(input,11,FOLLOW_11_in_precedence3215); 
					pushFollow(FOLLOW_precedence1_in_precedence3221);
					e=precedence1(model);
					state._fsp--;

					match(input,7,FOLLOW_7_in_precedence3224); 
					phi = model.EF(e);
					}
					break;
				case 7 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:29:4: 'EG(' e= precedence1[model] ')'
					{
					match(input,12,FOLLOW_12_in_precedence3231); 
					pushFollow(FOLLOW_precedence1_in_precedence3237);
					e=precedence1(model);
					state._fsp--;

					match(input,7,FOLLOW_7_in_precedence3240); 
					phi = model.EG(e);
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
		return phi;
	}
	// $ANTLR end "precedence3"



	// $ANTLR start "precedence4"
	// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:32:1: precedence4[Model model] returns [HashSet<State> phi] : (e= STRING | 'tt' | '(' e1= precedence1[model] ')' );
	public final HashSet<State> precedence4(Model model) throws RecognitionException {
		HashSet<State> phi = null;


		Token e=null;
		HashSet<State> e1 =null;

		try {
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:33:2: (e= STRING | 'tt' | '(' e1= precedence1[model] ')' )
			int alt4=3;
			switch ( input.LA(1) ) {
			case STRING:
				{
				alt4=1;
				}
				break;
			case 16:
				{
				alt4=2;
				}
				break;
			case 6:
				{
				alt4=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:33:4: e= STRING
					{
					e=(Token)match(input,STRING,FOLLOW_STRING_in_precedence4264); 
					phi = model.getStatesWithLabel(e.getText());
					}
					break;
				case 2 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:34:4: 'tt'
					{
					match(input,16,FOLLOW_16_in_precedence4271); 
					phi = model.trueForAll();
					}
					break;
				case 3 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:35:4: '(' e1= precedence1[model] ')'
					{
					match(input,6,FOLLOW_6_in_precedence4278); 
					pushFollow(FOLLOW_precedence1_in_precedence4284);
					e1=precedence1(model);
					state._fsp--;

					match(input,7,FOLLOW_7_in_precedence4287); 
					phi = e1;
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
		return phi;
	}
	// $ANTLR end "precedence4"

	// Delegated rules



	public static final BitSet FOLLOW_precedence1_in_start36 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_start39 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_precedence2_in_precedence163 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_14_in_precedence171 = new BitSet(new long[]{0x000000000001BF50L});
	public static final BitSet FOLLOW_precedence2_in_precedence177 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_precedence3_in_precedence2104 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_15_in_precedence2112 = new BitSet(new long[]{0x000000000001BF50L});
	public static final BitSet FOLLOW_precedence2_in_precedence2118 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_precedence4_in_precedence3143 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_8_in_precedence3151 = new BitSet(new long[]{0x000000000001BF50L});
	public static final BitSet FOLLOW_precedence1_in_precedence3157 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_7_in_precedence3160 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_9_in_precedence3167 = new BitSet(new long[]{0x000000000001BF50L});
	public static final BitSet FOLLOW_precedence1_in_precedence3173 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_7_in_precedence3176 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_precedence3183 = new BitSet(new long[]{0x000000000001BF50L});
	public static final BitSet FOLLOW_precedence1_in_precedence3189 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_7_in_precedence3192 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_13_in_precedence3199 = new BitSet(new long[]{0x000000000001BF50L});
	public static final BitSet FOLLOW_precedence1_in_precedence3205 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_7_in_precedence3208 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_precedence3215 = new BitSet(new long[]{0x000000000001BF50L});
	public static final BitSet FOLLOW_precedence1_in_precedence3221 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_7_in_precedence3224 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_precedence3231 = new BitSet(new long[]{0x000000000001BF50L});
	public static final BitSet FOLLOW_precedence1_in_precedence3237 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_7_in_precedence3240 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_precedence4264 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_16_in_precedence4271 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_6_in_precedence4278 = new BitSet(new long[]{0x000000000001BF50L});
	public static final BitSet FOLLOW_precedence1_in_precedence4284 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_7_in_precedence4287 = new BitSet(new long[]{0x0000000000000002L});
}
