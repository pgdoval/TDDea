// This is a generated file. Not intended for manual editing.
package idea.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface TddTestcase extends PsiElement {

  @NotNull
  TddDescription getDescription();

  @NotNull
  TddKey getKey();

  @NotNull
  TddMethods getMethods();

  @NotNull
  TddStatus getStatus();

}
