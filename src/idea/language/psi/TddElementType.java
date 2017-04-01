package idea.language.psi;

import com.intellij.psi.tree.IElementType;
import idea.language.TddLanguage;
import org.jetbrains.annotations.*;

public class TddElementType extends IElementType {
    public TddElementType(@NotNull @NonNls String debugName) {
        super(debugName, TddLanguage.INSTANCE);
    }
}
