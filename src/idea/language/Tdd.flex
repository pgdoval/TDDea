package idea.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import idea.language.psi.TddTypes;
import com.intellij.psi.TokenType;

%%

%class TddLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF=\R
WHITE_SPACE=[\ \n\t\f]
END_OF_LINE_COMMENT="//"[^\r\n]*

LEFT_BRACKET=\[
RIGHT_BRACKET=\]
NUMBER=[0-9]+
LETTER="[a-zA-Z]"
STRING=({NUMBER}|{LETTER}|{WHITE_SPACE})+

COMMA=,
DOT=\.

METHOD= {LETTER}+ {DOT} {LETTER}+
%state KEY
%state STATUS
%state DESCRIPTION
%state METHODS

%%

<YYINITIAL> {END_OF_LINE_COMMENT}                           { yybegin(YYINITIAL); return TddTypes.LINE_COMMENT; }

<YYINITIAL> {LEFT_BRACKET}                                  { yybegin(KEY); return TddTypes.LEFT_BRACKET; }


<KEY> {RIGHT_BRACKET}                                       { yybegin(KEY); return TddTypes.RIGHT_BRACKET; }

<KEY> {WHITE_SPACE}+                                        { yybegin(KEY); return TokenType.WHITE_SPACE; }

<KEY> {NUMBER}                                              { yybegin(KEY); return TddTypes.KEY; }

<KEY> {LEFT_BRACKET}                                        { yybegin(STATUS); return TddTypes.LEFT_BRACKET; }


<STATUS> {RIGHT_BRACKET}                                    { yybegin(STATUS); return TddTypes.RIGHT_BRACKET; }

<STATUS> {WHITE_SPACE}+                                     { yybegin(STATUS); return TokenType.WHITE_SPACE; }

<STATUS> {LETTER}                                           { yybegin(STATUS); return TddTypes.STATUS; }

<STATUS> {LEFT_BRACKET}                                     { yybegin(DESCRIPTION); return TddTypes.LEFT_BRACKET; }


<DESCRIPTION> {RIGHT_BRACKET}                               { yybegin(DESCRIPTION); return TddTypes.RIGHT_BRACKET; }

<DESCRIPTION> {WHITE_SPACE}+                                { yybegin(DESCRIPTION); return TokenType.WHITE_SPACE; }

<DESCRIPTION> {STRING}                                      { yybegin(DESCRIPTION); return TddTypes.DESCRIPTION; }

<DESCRIPTION> {LEFT_BRACKET}                                { yybegin(METHODS); return TddTypes.LEFT_BRACKET; }


<METHODS> {RIGHT_BRACKET}                                   { yybegin(METHODS); return TddTypes.RIGHT_BRACKET; }

<METHODS> {WHITE_SPACE}+                                    { yybegin(METHODS); return TokenType.WHITE_SPACE; }

<METHODS> {METHOD}                                          { yybegin(METHODS); return TddTypes.METHOD; }

<METHODS> {COMMA}                                           { yybegin(METHODS); return TddTypes.COMMA; }

<METHODS> {LEFT_BRACKET}                                    { yybegin(METHODS); return TddTypes.LEFT_BRACKET; }


({CRLF}|{WHITE_SPACE})+                                     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

.                                                           { return TokenType.BAD_CHARACTER; }