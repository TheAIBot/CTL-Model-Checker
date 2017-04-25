// $ANTLR 3.5.1 C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g 2017-04-25 07:52:40

package Parsers.TransitionSystem.output;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class TransitionSystemLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public TransitionSystemLexer() {} 
	public TransitionSystemLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public TransitionSystemLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g"; }

	// $ANTLR start "T__7"
	public final void mT__7() throws RecognitionException {
		try {
			int _type = T__7;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:11:6: ( '*' )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:11:8: '*'
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
	// $ANTLR end "T__7"

	// $ANTLR start "T__8"
	public final void mT__8() throws RecognitionException {
		try {
			int _type = T__8;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:12:6: ( ',' )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:12:8: ','
			{
			match(','); 
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
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:13:6: ( '[' )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:13:8: '['
			{
			match('['); 
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
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:14:7: ( ']' )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:14:9: ']'
			{
			match(']'); 
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
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:15:7: ( '{' )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:15:9: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__11"

	// $ANTLR start "T__12"
	public final void mT__12() throws RecognitionException {
		try {
			int _type = T__12;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:16:7: ( '}' )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:16:9: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__12"

	// $ANTLR start "NUMBER"
	public final void mNUMBER() throws RecognitionException {
		try {
			int _type = NUMBER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:30:8: ( ( '0' .. '9' )+ )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:30:10: ( '0' .. '9' )+
			{
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:30:10: ( '0' .. '9' )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:
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
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUMBER"

	// $ANTLR start "STRING"
	public final void mSTRING() throws RecognitionException {
		try {
			int _type = STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:37:8: ( ( 'a' .. 'z' )+ )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:37:10: ( 'a' .. 'z' )+
			{
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:37:10: ( 'a' .. 'z' )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:
					{
					if ( (input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:44:4: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:44:6: ( ' ' | '\\t' | '\\r' | '\\n' )+
			{
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:44:6: ( ' ' | '\\t' | '\\r' | '\\n' )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '\t' && LA3_0 <= '\n')||LA3_0=='\r'||LA3_0==' ') ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:
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
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
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
		// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:1:8: ( T__7 | T__8 | T__9 | T__10 | T__11 | T__12 | NUMBER | STRING | WS )
		int alt4=9;
		switch ( input.LA(1) ) {
		case '*':
			{
			alt4=1;
			}
			break;
		case ',':
			{
			alt4=2;
			}
			break;
		case '[':
			{
			alt4=3;
			}
			break;
		case ']':
			{
			alt4=4;
			}
			break;
		case '{':
			{
			alt4=5;
			}
			break;
		case '}':
			{
			alt4=6;
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
			alt4=7;
			}
			break;
		case 'a':
		case 'b':
		case 'c':
		case 'd':
		case 'e':
		case 'f':
		case 'g':
		case 'h':
		case 'i':
		case 'j':
		case 'k':
		case 'l':
		case 'm':
		case 'n':
		case 'o':
		case 'p':
		case 'q':
		case 'r':
		case 's':
		case 't':
		case 'u':
		case 'v':
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			{
			alt4=8;
			}
			break;
		case '\t':
		case '\n':
		case '\r':
		case ' ':
			{
			alt4=9;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 4, 0, input);
			throw nvae;
		}
		switch (alt4) {
			case 1 :
				// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:1:10: T__7
				{
				mT__7(); 

				}
				break;
			case 2 :
				// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:1:15: T__8
				{
				mT__8(); 

				}
				break;
			case 3 :
				// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:1:20: T__9
				{
				mT__9(); 

				}
				break;
			case 4 :
				// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:1:25: T__10
				{
				mT__10(); 

				}
				break;
			case 5 :
				// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:1:31: T__11
				{
				mT__11(); 

				}
				break;
			case 6 :
				// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:1:37: T__12
				{
				mT__12(); 

				}
				break;
			case 7 :
				// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:1:43: NUMBER
				{
				mNUMBER(); 

				}
				break;
			case 8 :
				// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:1:50: STRING
				{
				mSTRING(); 

				}
				break;
			case 9 :
				// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\TransitionSystem\\TransitionSystem.g:1:57: WS
				{
				mWS(); 

				}
				break;

		}
	}



}
