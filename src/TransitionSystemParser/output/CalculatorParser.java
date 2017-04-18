package TransitionSystemParser.output;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class CalculatorParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "NUM", "WS", "'('", "')'", "'*'", 
		"'+'", "'-'", "'/'"
	};
	public static final int EOF=-1;
	public static final int T__6=6;
	public static final int T__7=7;
	public static final int T__8=8;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int NUM=4;
	public static final int WS=5;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public CalculatorParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public CalculatorParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return CalculatorParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g"; }



	// $ANTLR start "start"
	// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:12:1: start returns [int value] : e= arith_expr EOF ;
	public final int start() throws RecognitionException {
		int value = 0;


		int e =0;

		try {
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:15:5: (e= arith_expr EOF )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:15:7: e= arith_expr EOF
			{
			pushFollow(FOLLOW_arith_expr_in_start111);
			e=arith_expr();
			state._fsp--;

			match(input,EOF,FOLLOW_EOF_in_start113); 
			 value = e; 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "start"



	// $ANTLR start "arith_expr"
	// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:19:1: arith_expr returns [int value] : e= mult_arith_expr ( '+' e= mult_arith_expr | '-' e= mult_arith_expr )* ;
	public final int arith_expr() throws RecognitionException {
		int value = 0;


		int e =0;

		try {
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:20:5: (e= mult_arith_expr ( '+' e= mult_arith_expr | '-' e= mult_arith_expr )* )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:20:13: e= mult_arith_expr ( '+' e= mult_arith_expr | '-' e= mult_arith_expr )*
			{
			pushFollow(FOLLOW_mult_arith_expr_in_arith_expr156);
			e=mult_arith_expr();
			state._fsp--;

			 value = e; 
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:21:7: ( '+' e= mult_arith_expr | '-' e= mult_arith_expr )*
			loop1:
			while (true) {
				int alt1=3;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==9) ) {
					alt1=1;
				}
				else if ( (LA1_0==10) ) {
					alt1=2;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:21:9: '+' e= mult_arith_expr
					{
					match(input,9,FOLLOW_9_in_arith_expr170); 
					pushFollow(FOLLOW_mult_arith_expr_in_arith_expr176);
					e=mult_arith_expr();
					state._fsp--;

					 value = value + e; 
					}
					break;
				case 2 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:22:9: '-' e= mult_arith_expr
					{
					match(input,10,FOLLOW_10_in_arith_expr190); 
					pushFollow(FOLLOW_mult_arith_expr_in_arith_expr196);
					e=mult_arith_expr();
					state._fsp--;

					 value = value - e; 
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
		return value;
	}
	// $ANTLR end "arith_expr"



	// $ANTLR start "mult_arith_expr"
	// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:26:1: mult_arith_expr returns [int value] : e= base_arith_expr ( '*' e= base_arith_expr | '/' e= base_arith_expr )* ;
	public final int mult_arith_expr() throws RecognitionException {
		int value = 0;


		int e =0;

		try {
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:27:5: (e= base_arith_expr ( '*' e= base_arith_expr | '/' e= base_arith_expr )* )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:27:13: e= base_arith_expr ( '*' e= base_arith_expr | '/' e= base_arith_expr )*
			{
			pushFollow(FOLLOW_base_arith_expr_in_mult_arith_expr235);
			e=base_arith_expr();
			state._fsp--;

			 value = e; 
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:28:7: ( '*' e= base_arith_expr | '/' e= base_arith_expr )*
			loop2:
			while (true) {
				int alt2=3;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==8) ) {
					alt2=1;
				}
				else if ( (LA2_0==11) ) {
					alt2=2;
				}

				switch (alt2) {
				case 1 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:28:9: '*' e= base_arith_expr
					{
					match(input,8,FOLLOW_8_in_mult_arith_expr251); 
					pushFollow(FOLLOW_base_arith_expr_in_mult_arith_expr257);
					e=base_arith_expr();
					state._fsp--;

					 value = value * e; 
					}
					break;
				case 2 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:29:9: '/' e= base_arith_expr
					{
					match(input,11,FOLLOW_11_in_mult_arith_expr273); 
					pushFollow(FOLLOW_base_arith_expr_in_mult_arith_expr279);
					e=base_arith_expr();
					state._fsp--;

					 value = value / e; 
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
		return value;
	}
	// $ANTLR end "mult_arith_expr"



	// $ANTLR start "base_arith_expr"
	// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:33:1: base_arith_expr returns [int value] : ( NUM | '(' e= arith_expr ')' );
	public final int base_arith_expr() throws RecognitionException {
		int value = 0;


		Token NUM1=null;
		int e =0;

		try {
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:35:5: ( NUM | '(' e= arith_expr ')' )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==NUM) ) {
				alt3=1;
			}
			else if ( (LA3_0==6) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:35:7: NUM
					{
					NUM1=(Token)match(input,NUM,FOLLOW_NUM_in_base_arith_expr345); 
					 value = Integer.parseInt(NUM1.getText()); 
					}
					break;
				case 2 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:36:7: '(' e= arith_expr ')'
					{
					match(input,6,FOLLOW_6_in_base_arith_expr379); 
					pushFollow(FOLLOW_arith_expr_in_base_arith_expr385);
					e=arith_expr();
					state._fsp--;

					match(input,7,FOLLOW_7_in_base_arith_expr387); 
					 value =e; 
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
		return value;
	}
	// $ANTLR end "base_arith_expr"

	// Delegated rules



	public static final BitSet FOLLOW_arith_expr_in_start111 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_start113 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mult_arith_expr_in_arith_expr156 = new BitSet(new long[]{0x0000000000000602L});
	public static final BitSet FOLLOW_9_in_arith_expr170 = new BitSet(new long[]{0x0000000000000050L});
	public static final BitSet FOLLOW_mult_arith_expr_in_arith_expr176 = new BitSet(new long[]{0x0000000000000602L});
	public static final BitSet FOLLOW_10_in_arith_expr190 = new BitSet(new long[]{0x0000000000000050L});
	public static final BitSet FOLLOW_mult_arith_expr_in_arith_expr196 = new BitSet(new long[]{0x0000000000000602L});
	public static final BitSet FOLLOW_base_arith_expr_in_mult_arith_expr235 = new BitSet(new long[]{0x0000000000000902L});
	public static final BitSet FOLLOW_8_in_mult_arith_expr251 = new BitSet(new long[]{0x0000000000000050L});
	public static final BitSet FOLLOW_base_arith_expr_in_mult_arith_expr257 = new BitSet(new long[]{0x0000000000000902L});
	public static final BitSet FOLLOW_11_in_mult_arith_expr273 = new BitSet(new long[]{0x0000000000000050L});
	public static final BitSet FOLLOW_base_arith_expr_in_mult_arith_expr279 = new BitSet(new long[]{0x0000000000000902L});
	public static final BitSet FOLLOW_NUM_in_base_arith_expr345 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_6_in_base_arith_expr379 = new BitSet(new long[]{0x0000000000000050L});
	public static final BitSet FOLLOW_arith_expr_in_base_arith_expr385 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_7_in_base_arith_expr387 = new BitSet(new long[]{0x0000000000000002L});
}
