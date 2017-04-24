// $ANTLR 3.5.1 C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g 2017-04-23 17:22:38

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ModelCheckLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public ModelCheckLexer() {} 
	public ModelCheckLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public ModelCheckLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g"; }

	// $ANTLR start "T__6"
	public final void mT__6() throws RecognitionException {
		try {
			int _type = T__6;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:7:6: ( '(' )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:7:8: '('
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
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:8:6: ( ')' )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:8:8: ')'
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
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:9:6: ( 'AF(' )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:9:8: 'AF('
			{
			match("AF("); 

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
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:10:6: ( 'AG(' )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:10:8: 'AG('
			{
			match("AG("); 

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
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:11:7: ( 'AX(' )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:11:9: 'AX('
			{
			match("AX("); 

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
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:12:7: ( 'EF(' )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:12:9: 'EF('
			{
			match("EF("); 

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
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:13:7: ( 'EG(' )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:13:9: 'EG('
			{
			match("EG("); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__12"

	// $ANTLR start "T__13"
	public final void mT__13() throws RecognitionException {
		try {
			int _type = T__13;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:14:7: ( 'EX(' )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:14:9: 'EX('
			{
			match("EX("); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__13"

	// $ANTLR start "T__14"
	public final void mT__14() throws RecognitionException {
		try {
			int _type = T__14;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:15:7: ( 'and' )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:15:9: 'and'
			{
			match("and"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__14"

	// $ANTLR start "T__15"
	public final void mT__15() throws RecognitionException {
		try {
			int _type = T__15;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:16:7: ( 'not' )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:16:9: 'not'
			{
			match("not"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__15"

	// $ANTLR start "T__16"
	public final void mT__16() throws RecognitionException {
		try {
			int _type = T__16;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:17:7: ( 'tt' )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:17:9: 'tt'
			{
			match("tt"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__16"

	// $ANTLR start "STRING"
	public final void mSTRING() throws RecognitionException {
		try {
			int _type = STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:38:8: ( ( 'a' .. 'z' | 'A' .. 'Z' )+ )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:38:10: ( 'a' .. 'z' | 'A' .. 'Z' )+
			{
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:38:10: ( 'a' .. 'z' | 'A' .. 'Z' )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= 'A' && LA1_0 <= 'Z')||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:
					{
					if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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
	// $ANTLR end "STRING"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:40:5: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:40:9: ( ' ' | '\\t' | '\\r' | '\\n' )+
			{
			// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:40:9: ( ' ' | '\\t' | '\\r' | '\\n' )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '\t' && LA2_0 <= '\n')||LA2_0=='\r'||LA2_0==' ') ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:
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
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
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
		// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:1:8: ( T__6 | T__7 | T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | STRING | WS )
		int alt3=13;
		switch ( input.LA(1) ) {
		case '(':
			{
			alt3=1;
			}
			break;
		case ')':
			{
			alt3=2;
			}
			break;
		case 'A':
			{
			switch ( input.LA(2) ) {
			case 'F':
				{
				int LA3_10 = input.LA(3);
				if ( (LA3_10=='(') ) {
					alt3=3;
				}

				else {
					alt3=12;
				}

				}
				break;
			case 'G':
				{
				int LA3_11 = input.LA(3);
				if ( (LA3_11=='(') ) {
					alt3=4;
				}

				else {
					alt3=12;
				}

				}
				break;
			case 'X':
				{
				int LA3_12 = input.LA(3);
				if ( (LA3_12=='(') ) {
					alt3=5;
				}

				else {
					alt3=12;
				}

				}
				break;
			default:
				alt3=12;
			}
			}
			break;
		case 'E':
			{
			switch ( input.LA(2) ) {
			case 'F':
				{
				int LA3_13 = input.LA(3);
				if ( (LA3_13=='(') ) {
					alt3=6;
				}

				else {
					alt3=12;
				}

				}
				break;
			case 'G':
				{
				int LA3_14 = input.LA(3);
				if ( (LA3_14=='(') ) {
					alt3=7;
				}

				else {
					alt3=12;
				}

				}
				break;
			case 'X':
				{
				int LA3_15 = input.LA(3);
				if ( (LA3_15=='(') ) {
					alt3=8;
				}

				else {
					alt3=12;
				}

				}
				break;
			default:
				alt3=12;
			}
			}
			break;
		case 'a':
			{
			int LA3_5 = input.LA(2);
			if ( (LA3_5=='n') ) {
				int LA3_16 = input.LA(3);
				if ( (LA3_16=='d') ) {
					int LA3_25 = input.LA(4);
					if ( ((LA3_25 >= 'A' && LA3_25 <= 'Z')||(LA3_25 >= 'a' && LA3_25 <= 'z')) ) {
						alt3=12;
					}

					else {
						alt3=9;
					}

				}

				else {
					alt3=12;
				}

			}

			else {
				alt3=12;
			}

			}
			break;
		case 'n':
			{
			int LA3_6 = input.LA(2);
			if ( (LA3_6=='o') ) {
				int LA3_17 = input.LA(3);
				if ( (LA3_17=='t') ) {
					int LA3_26 = input.LA(4);
					if ( ((LA3_26 >= 'A' && LA3_26 <= 'Z')||(LA3_26 >= 'a' && LA3_26 <= 'z')) ) {
						alt3=12;
					}

					else {
						alt3=10;
					}

				}

				else {
					alt3=12;
				}

			}

			else {
				alt3=12;
			}

			}
			break;
		case 't':
			{
			int LA3_7 = input.LA(2);
			if ( (LA3_7=='t') ) {
				int LA3_18 = input.LA(3);
				if ( ((LA3_18 >= 'A' && LA3_18 <= 'Z')||(LA3_18 >= 'a' && LA3_18 <= 'z')) ) {
					alt3=12;
				}

				else {
					alt3=11;
				}

			}

			else {
				alt3=12;
			}

			}
			break;
		case 'B':
		case 'C':
		case 'D':
		case 'F':
		case 'G':
		case 'H':
		case 'I':
		case 'J':
		case 'K':
		case 'L':
		case 'M':
		case 'N':
		case 'O':
		case 'P':
		case 'Q':
		case 'R':
		case 'S':
		case 'T':
		case 'U':
		case 'V':
		case 'W':
		case 'X':
		case 'Y':
		case 'Z':
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
		case 'o':
		case 'p':
		case 'q':
		case 'r':
		case 's':
		case 'u':
		case 'v':
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			{
			alt3=12;
			}
			break;
		case '\t':
		case '\n':
		case '\r':
		case ' ':
			{
			alt3=13;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 3, 0, input);
			throw nvae;
		}
		switch (alt3) {
			case 1 :
				// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:1:10: T__6
				{
				mT__6(); 

				}
				break;
			case 2 :
				// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:1:15: T__7
				{
				mT__7(); 

				}
				break;
			case 3 :
				// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:1:20: T__8
				{
				mT__8(); 

				}
				break;
			case 4 :
				// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:1:25: T__9
				{
				mT__9(); 

				}
				break;
			case 5 :
				// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:1:30: T__10
				{
				mT__10(); 

				}
				break;
			case 6 :
				// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:1:36: T__11
				{
				mT__11(); 

				}
				break;
			case 7 :
				// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:1:42: T__12
				{
				mT__12(); 

				}
				break;
			case 8 :
				// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:1:48: T__13
				{
				mT__13(); 

				}
				break;
			case 9 :
				// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:1:54: T__14
				{
				mT__14(); 

				}
				break;
			case 10 :
				// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:1:60: T__15
				{
				mT__15(); 

				}
				break;
			case 11 :
				// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:1:66: T__16
				{
				mT__16(); 

				}
				break;
			case 12 :
				// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:1:72: STRING
				{
				mSTRING(); 

				}
				break;
			case 13 :
				// C:\\Users\\Andreas\\Documents\\GitHub\\CTL-Model-Checker\\src\\Parsers\\ModelCheck\\ModelCheck.g:1:79: WS
				{
				mWS(); 

				}
				break;

		}
	}



}
