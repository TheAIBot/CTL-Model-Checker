// $ANTLR 3.5.1 C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g 2017-04-24 11:30:18

package Parsers.ModelCheck.output;

import java.util.HashSet;
import check.Model;
import check.State;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ModelCheckParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "STRING", "WS", "'('", "')'", 
		"'AF'", "'AG'", "'AX'", "'EF'", "'EG'", "'EX'", "'and'", "'not'", "'or'", 
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
	public static final int T__17=17;
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



	// $ANTLR start "check"
	// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:20:1: check[Model model] returns [boolean b] : e= precedenceOr[model] EOF ;
	public final boolean check(Model model) throws RecognitionException {
		boolean b = false;


		HashSet<State> e =null;

		try {
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:21:2: (e= precedenceOr[model] EOF )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:21:4: e= precedenceOr[model] EOF
			{
			pushFollow(FOLLOW_precedenceOr_in_check51);
			e=precedenceOr(model);
			state._fsp--;

			match(input,EOF,FOLLOW_EOF_in_check54); 
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
	// $ANTLR end "check"



	// $ANTLR start "precedenceOr"
	// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:24:1: precedenceOr[Model model] returns [HashSet<State> phi] : e= precedenceAnd[model] ( 'or' right= precedenceAnd[model] )* ;
	public final HashSet<State> precedenceOr(Model model) throws RecognitionException {
		HashSet<State> phi = null;


		HashSet<State> e =null;
		HashSet<State> right =null;

		try {
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:25:2: (e= precedenceAnd[model] ( 'or' right= precedenceAnd[model] )* )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:25:4: e= precedenceAnd[model] ( 'or' right= precedenceAnd[model] )*
			{
			pushFollow(FOLLOW_precedenceAnd_in_precedenceOr78);
			e=precedenceAnd(model);
			state._fsp--;

			phi = e;
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:26:3: ( 'or' right= precedenceAnd[model] )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==16) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:26:4: 'or' right= precedenceAnd[model]
					{
					match(input,16,FOLLOW_16_in_precedenceOr86); 
					pushFollow(FOLLOW_precedenceAnd_in_precedenceOr92);
					right=precedenceAnd(model);
					state._fsp--;

					phi = model.unionOf(phi, right);
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
	// $ANTLR end "precedenceOr"



	// $ANTLR start "precedenceAnd"
	// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:29:1: precedenceAnd[Model model] returns [HashSet<State> phi] : e= precedenceSingularArgument[model] ( 'and' right= precedenceSingularArgument[model] )* ;
	public final HashSet<State> precedenceAnd(Model model) throws RecognitionException {
		HashSet<State> phi = null;


		HashSet<State> e =null;
		HashSet<State> right =null;

		try {
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:30:2: (e= precedenceSingularArgument[model] ( 'and' right= precedenceSingularArgument[model] )* )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:30:4: e= precedenceSingularArgument[model] ( 'and' right= precedenceSingularArgument[model] )*
			{
			pushFollow(FOLLOW_precedenceSingularArgument_in_precedenceAnd120);
			e=precedenceSingularArgument(model);
			state._fsp--;

			phi = e;
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:31:3: ( 'and' right= precedenceSingularArgument[model] )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==14) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:31:4: 'and' right= precedenceSingularArgument[model]
					{
					match(input,14,FOLLOW_14_in_precedenceAnd128); 
					pushFollow(FOLLOW_precedenceSingularArgument_in_precedenceAnd134);
					right=precedenceSingularArgument(model);
					state._fsp--;

					phi = model.intersectionOf(phi, right);
					}
					break;

				default :
					break loop2;
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
	// $ANTLR end "precedenceAnd"



	// $ANTLR start "precedenceSingularArgument"
	// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:34:1: precedenceSingularArgument[Model model] returns [HashSet<State> phi] : (e= precedenceAP[model] | 'not' e= precedenceSingularArgument[model] | 'AF' e= precedenceSingularArgument[model] | 'AG' e= precedenceSingularArgument[model] | 'AX' e= precedenceSingularArgument[model] | 'EX' e= precedenceSingularArgument[model] | 'EF' e= precedenceSingularArgument[model] | 'EG' e= precedenceSingularArgument[model] );
	public final HashSet<State> precedenceSingularArgument(Model model) throws RecognitionException {
		HashSet<State> phi = null;


		HashSet<State> e =null;

		try {
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:35:2: (e= precedenceAP[model] | 'not' e= precedenceSingularArgument[model] | 'AF' e= precedenceSingularArgument[model] | 'AG' e= precedenceSingularArgument[model] | 'AX' e= precedenceSingularArgument[model] | 'EX' e= precedenceSingularArgument[model] | 'EF' e= precedenceSingularArgument[model] | 'EG' e= precedenceSingularArgument[model] )
			int alt3=8;
			switch ( input.LA(1) ) {
			case STRING:
			case 6:
			case 17:
				{
				alt3=1;
				}
				break;
			case 15:
				{
				alt3=2;
				}
				break;
			case 8:
				{
				alt3=3;
				}
				break;
			case 9:
				{
				alt3=4;
				}
				break;
			case 10:
				{
				alt3=5;
				}
				break;
			case 13:
				{
				alt3=6;
				}
				break;
			case 11:
				{
				alt3=7;
				}
				break;
			case 12:
				{
				alt3=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:35:4: e= precedenceAP[model]
					{
					pushFollow(FOLLOW_precedenceAP_in_precedenceSingularArgument162);
					e=precedenceAP(model);
					state._fsp--;

					phi = e;
					}
					break;
				case 2 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:36:4: 'not' e= precedenceSingularArgument[model]
					{
					match(input,15,FOLLOW_15_in_precedenceSingularArgument170); 
					pushFollow(FOLLOW_precedenceSingularArgument_in_precedenceSingularArgument175);
					e=precedenceSingularArgument(model);
					state._fsp--;

					phi = model.complementOf(e);
					}
					break;
				case 3 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:37:4: 'AF' e= precedenceSingularArgument[model]
					{
					match(input,8,FOLLOW_8_in_precedenceSingularArgument184); 
					pushFollow(FOLLOW_precedenceSingularArgument_in_precedenceSingularArgument190);
					e=precedenceSingularArgument(model);
					state._fsp--;

					phi = model.AF(e);
					}
					break;
				case 4 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:38:4: 'AG' e= precedenceSingularArgument[model]
					{
					match(input,9,FOLLOW_9_in_precedenceSingularArgument198); 
					pushFollow(FOLLOW_precedenceSingularArgument_in_precedenceSingularArgument204);
					e=precedenceSingularArgument(model);
					state._fsp--;

					phi = model.AG(e);
					}
					break;
				case 5 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:39:4: 'AX' e= precedenceSingularArgument[model]
					{
					match(input,10,FOLLOW_10_in_precedenceSingularArgument212); 
					pushFollow(FOLLOW_precedenceSingularArgument_in_precedenceSingularArgument218);
					e=precedenceSingularArgument(model);
					state._fsp--;

					phi = model.AX(e);
					}
					break;
				case 6 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:40:4: 'EX' e= precedenceSingularArgument[model]
					{
					match(input,13,FOLLOW_13_in_precedenceSingularArgument226); 
					pushFollow(FOLLOW_precedenceSingularArgument_in_precedenceSingularArgument232);
					e=precedenceSingularArgument(model);
					state._fsp--;

					phi = model.EX(e);
					}
					break;
				case 7 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:41:4: 'EF' e= precedenceSingularArgument[model]
					{
					match(input,11,FOLLOW_11_in_precedenceSingularArgument240); 
					pushFollow(FOLLOW_precedenceSingularArgument_in_precedenceSingularArgument246);
					e=precedenceSingularArgument(model);
					state._fsp--;

					phi = model.EF(e);
					}
					break;
				case 8 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:42:4: 'EG' e= precedenceSingularArgument[model]
					{
					match(input,12,FOLLOW_12_in_precedenceSingularArgument254); 
					pushFollow(FOLLOW_precedenceSingularArgument_in_precedenceSingularArgument260);
					e=precedenceSingularArgument(model);
					state._fsp--;

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
	// $ANTLR end "precedenceSingularArgument"



	// $ANTLR start "precedenceAP"
	// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:45:1: precedenceAP[Model model] returns [HashSet<State> phi] : (e= STRING | 'tt' | '(' e1= precedenceOr[model] ')' );
	public final HashSet<State> precedenceAP(Model model) throws RecognitionException {
		HashSet<State> phi = null;


		Token e=null;
		HashSet<State> e1 =null;

		try {
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:46:2: (e= STRING | 'tt' | '(' e1= precedenceOr[model] ')' )
			int alt4=3;
			switch ( input.LA(1) ) {
			case STRING:
				{
				alt4=1;
				}
				break;
			case 17:
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
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:46:4: e= STRING
					{
					e=(Token)match(input,STRING,FOLLOW_STRING_in_precedenceAP286); 
					phi = model.getStatesWithLabel(e.getText());
					}
					break;
				case 2 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:47:4: 'tt'
					{
					match(input,17,FOLLOW_17_in_precedenceAP293); 
					phi = model.trueForAll();
					}
					break;
				case 3 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:48:4: '(' e1= precedenceOr[model] ')'
					{
					match(input,6,FOLLOW_6_in_precedenceAP300); 
					pushFollow(FOLLOW_precedenceOr_in_precedenceAP306);
					e1=precedenceOr(model);
					state._fsp--;

					match(input,7,FOLLOW_7_in_precedenceAP309); 
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
	// $ANTLR end "precedenceAP"

	// Delegated rules



	public static final BitSet FOLLOW_precedenceOr_in_check51 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_check54 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_precedenceAnd_in_precedenceOr78 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_16_in_precedenceOr86 = new BitSet(new long[]{0x000000000002BF50L});
	public static final BitSet FOLLOW_precedenceAnd_in_precedenceOr92 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_precedenceSingularArgument_in_precedenceAnd120 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_14_in_precedenceAnd128 = new BitSet(new long[]{0x000000000002BF50L});
	public static final BitSet FOLLOW_precedenceSingularArgument_in_precedenceAnd134 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_precedenceAP_in_precedenceSingularArgument162 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_15_in_precedenceSingularArgument170 = new BitSet(new long[]{0x000000000002BF50L});
	public static final BitSet FOLLOW_precedenceSingularArgument_in_precedenceSingularArgument175 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_8_in_precedenceSingularArgument184 = new BitSet(new long[]{0x000000000002BF50L});
	public static final BitSet FOLLOW_precedenceSingularArgument_in_precedenceSingularArgument190 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_9_in_precedenceSingularArgument198 = new BitSet(new long[]{0x000000000002BF50L});
	public static final BitSet FOLLOW_precedenceSingularArgument_in_precedenceSingularArgument204 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_precedenceSingularArgument212 = new BitSet(new long[]{0x000000000002BF50L});
	public static final BitSet FOLLOW_precedenceSingularArgument_in_precedenceSingularArgument218 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_13_in_precedenceSingularArgument226 = new BitSet(new long[]{0x000000000002BF50L});
	public static final BitSet FOLLOW_precedenceSingularArgument_in_precedenceSingularArgument232 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_precedenceSingularArgument240 = new BitSet(new long[]{0x000000000002BF50L});
	public static final BitSet FOLLOW_precedenceSingularArgument_in_precedenceSingularArgument246 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_precedenceSingularArgument254 = new BitSet(new long[]{0x000000000002BF50L});
	public static final BitSet FOLLOW_precedenceSingularArgument_in_precedenceSingularArgument260 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_precedenceAP286 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_17_in_precedenceAP293 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_6_in_precedenceAP300 = new BitSet(new long[]{0x000000000002BF50L});
	public static final BitSet FOLLOW_precedenceOr_in_precedenceAP306 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_7_in_precedenceAP309 = new BitSet(new long[]{0x0000000000000002L});
}
