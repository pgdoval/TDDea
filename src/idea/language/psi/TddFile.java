package idea.language.psi;


import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import idea.language.*;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class TddFile extends PsiFileBase {
    public TddFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, TddLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return TddFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Tdd File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}