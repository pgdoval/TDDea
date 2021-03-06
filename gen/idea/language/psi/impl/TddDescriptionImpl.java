// This is a generated file. Not intended for manual editing.
package idea.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static idea.language.psi.TddTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import idea.language.psi.*;

public class TddDescriptionImpl extends ASTWrapperPsiElement implements TddDescription {

  public TddDescriptionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TddVisitor visitor) {
    visitor.visitDescription(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TddVisitor) accept((TddVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getString() {
    return findNotNullChildByType(STRING);
  }

}
