package idea.language.psi;

import com.intellij.psi.tree.IElementType;
import idea.language.TddLanguage;
import org.jetbrains.annotations.*;

public class TddTokenType extends IElementType {
    public TddTokenType(@NotNull @NonNls String debugName) {
        super(debugName, TddLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "TddTokenType." + super.toString();
    }
}