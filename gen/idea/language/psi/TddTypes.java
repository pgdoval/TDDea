// This is a generated file. Not intended for manual editing.
package idea.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import idea.language.psi.impl.*;

public interface TddTypes {

  IElementType DESCRIPTION = new TddElementType("DESCRIPTION");
  IElementType KEY = new TddElementType("KEY");
  IElementType METHOD = new TddElementType("METHOD");
  IElementType METHODS = new TddElementType("METHODS");
  IElementType STATUS = new TddElementType("STATUS");
  IElementType TESTCASE = new TddElementType("TESTCASE");

  IElementType BLOCK_COMMENT = new TddTokenType("block_comment");
  IElementType COMMA = new TddTokenType(",");
  IElementType DOT = new TddTokenType(".");
  IElementType ID = new TddTokenType("id");
  IElementType LEFT_BRACKET = new TddTokenType("[");
  IElementType LETTER = new TddTokenType("[a-zA-Z]");
  IElementType LINE_COMMENT = new TddTokenType("line_comment");
  IElementType NUMBER = new TddTokenType("number");
  IElementType RIGHT_BRACKET = new TddTokenType("]");
  IElementType SPACE = new TddTokenType("space");
  IElementType STRING = new TddTokenType("string");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == DESCRIPTION) {
        return new TddDescriptionImpl(node);
      }
      else if (type == KEY) {
        return new TddKeyImpl(node);
      }
      else if (type == METHOD) {
        return new TddMethodImpl(node);
      }
      else if (type == METHODS) {
        return new TddMethodsImpl(node);
      }
      else if (type == STATUS) {
        return new TddStatusImpl(node);
      }
      else if (type == TESTCASE) {
        return new TddTestcaseImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
