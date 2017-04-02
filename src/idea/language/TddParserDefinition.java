package idea.language;

import com.intellij.lang.*;
        import com.intellij.lexer.Lexer;
        import com.intellij.openapi.project.Project;
        import com.intellij.psi.*;
        import com.intellij.psi.tree.*;
        import idea.language.parser.TddParser;
        import idea.language.psi.*;
        import org.jetbrains.annotations.NotNull;

public class TddParserDefinition implements ParserDefinition {
    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    public static final TokenSet COMMENTS = TokenSet.create(TddTypes.LINE_COMMENT);

    public static final IFileElementType FILE = new IFileElementType(TddLanguage.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new TddLexerAdapter();
    }

    @NotNull
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @NotNull
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    public PsiParser createParser(final Project project) {
        return new TddParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    public PsiFile createFile(FileViewProvider viewProvider) {
        return new TddFile(viewProvider);
    }

    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }

    @NotNull
    public PsiElement createElement(ASTNode node) {
        return TddTypes.Factory.createElement(node);
    }
}