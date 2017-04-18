package TransitionSystemParser.output;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class CalculatorLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public CalculatorLexer() {} 
	public CalculatorLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public CalculatorLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g"; }

	// $ANTLR start "T__6"
	public final void mT__6() throws RecognitionException {
		try {
			int _type = T__6;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:7:6: ( '(' )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:7:8: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__6"

	// $ANTLR start "T__7"
	public final void mT__7() throws RecognitionException {
		try {
			int _type = T__7;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:8:6: ( ')' )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:8:8: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__7"

	// $ANTLR start "T__8"
	public final void mT__8() throws RecognitionException {
		try {
			int _type = T__8;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:9:6: ( '*' )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:9:8: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__8"

	// $ANTLR start "T__9"
	public final void mT__9() throws RecognitionException {
		try {
			int _type = T__9;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:10:6: ( '+' )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:10:8: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__9"

	// $ANTLR start "T__10"
	public final void mT__10() throws RecognitionException {
		try {
			int _type = T__10;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:11:7: ( '-' )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:11:9: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__10"

	// $ANTLR start "T__11"
	public final void mT__11() throws RecognitionException {
		try {
			int _type = T__11;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:12:7: ( '/' )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:12:9: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__11"

	// $ANTLR start "NUM"
	public final void mNUM() throws RecognitionException {
		try {
			int _type = NUM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:40:5: ( '0' .. '9' )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUM"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:43:5: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:43:9: ( ' ' | '\\t' | '\\r' | '\\n' )+
			{
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:43:9: ( ' ' | '\\t' | '\\r' | '\\n' )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '\t' && LA1_0 <= '\n')||LA1_0=='\r'||LA1_0==' ') ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			 _channel = HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:1:8: ( T__6 | T__7 | T__8 | T__9 | T__10 | T__11 | NUM | WS )
		int alt2=8;
		switch ( input.LA(1) ) {
		case '(':
			{
			alt2=1;
			}
			break;
		case ')':
			{
			alt2=2;
			}
			break;
		case '*':
			{
			alt2=3;
			}
			break;
		case '+':
			{
			alt2=4;
			}
			break;
		case '-':
			{
			alt2=5;
			}
			break;
		case '/':
			{
			alt2=6;
			}
			break;
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			{
			alt2=7;
			}
			break;
		case '\t':
		case '\n':
		case '\r':
		case ' ':
			{
			alt2=8;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 2, 0, input);
			throw nvae;
		}
		switch (alt2) {
			case 1 :
				// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:1:10: T__6
				{
				mT__6(); 

				}
				break;
			case 2 :
				// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:1:15: T__7
				{
				mT__7(); 

				}
				break;
			case 3 :
				// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:1:20: T__8
				{
				mT__8(); 

				}
				break;
			case 4 :
				// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:1:25: T__9
				{
				mT__9(); 

				}
				break;
			case 5 :
				// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:1:30: T__10
				{
				mT__10(); 

				}
				break;
			case 6 :
				// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:1:36: T__11
				{
				mT__11(); 

				}
				break;
			case 7 :
				// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:1:42: NUM
				{
				mNUM(); 

				}
				break;
			case 8 :
				// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\calculator-project\\Calculator.g:1:46: WS
				{
				mWS(); 

				}
				break;

		}
	}



}
