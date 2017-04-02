package idea.language;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.*;

import javax.swing.*;

public class TddFileType extends LanguageFileType {
    public static final TddFileType INSTANCE = new TddFileType();

    private TddFileType() {
        super(TddLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Tdd file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Tdd language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "tdd";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return TddIcons.FILE;
    }
}