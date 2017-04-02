package idea.language;

import com.intellij.lexer.FlexAdapter;
import java.io.Reader;

public class TddLexerAdapter extends FlexAdapter {
    public TddLexerAdapter() {
        super(new TddLexer((Reader) null));
    }
}