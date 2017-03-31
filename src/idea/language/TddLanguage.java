package idea.language;

import com.intellij.lang.Language;

/**
 * Created by pablo on 31/03/17.
 */
public class TddLanguage extends Language {


    public static final TddLanguage INSTANCE = new TddLanguage();

    private TddLanguage() {
        super("Simple");
    }
}
