// This is a generated file. Not intended for manual editing.
package idea.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static idea.language.psi.TddTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class TddParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == DESCRIPTION) {
      r = description(b, 0);
    }
    else if (t == KEY) {
      r = key(b, 0);
    }
    else if (t == METHOD) {
      r = method(b, 0);
    }
    else if (t == METHODS) {
      r = methods(b, 0);
    }
    else if (t == STATUS) {
      r = status(b, 0);
    }
    else if (t == TESTCASE) {
      r = testcase(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return tddFile(b, l + 1);
  }

  /* ********************************************************** */
  // LEFT_BRACKET string RIGHT_BRACKET
  public static boolean description(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "description")) return false;
    if (!nextTokenIs(b, LEFT_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LEFT_BRACKET, STRING, RIGHT_BRACKET);
    exit_section_(b, m, DESCRIPTION, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACKET number RIGHT_BRACKET
  public static boolean key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key")) return false;
    if (!nextTokenIs(b, LEFT_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LEFT_BRACKET, NUMBER, RIGHT_BRACKET);
    exit_section_(b, m, KEY, r);
    return r;
  }

  /* ********************************************************** */
  // letter+ DOT letter+
  public static boolean method(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method")) return false;
    if (!nextTokenIs(b, LETTER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = method_0(b, l + 1);
    r = r && consumeToken(b, DOT);
    r = r && method_2(b, l + 1);
    exit_section_(b, m, METHOD, r);
    return r;
  }

  // letter+
  private static boolean method_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LETTER);
    int c = current_position_(b);
    while (r) {
      if (!consumeToken(b, LETTER)) break;
      if (!empty_element_parsed_guard_(b, "method_0", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // letter+
  private static boolean method_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LETTER);
    int c = current_position_(b);
    while (r) {
      if (!consumeToken(b, LETTER)) break;
      if (!empty_element_parsed_guard_(b, "method_2", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_BRACKET (method (COMMA space? method)*)? RIGHT_BRACKET
  public static boolean methods(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methods")) return false;
    if (!nextTokenIs(b, LEFT_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_BRACKET);
    r = r && methods_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_BRACKET);
    exit_section_(b, m, METHODS, r);
    return r;
  }

  // (method (COMMA space? method)*)?
  private static boolean methods_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methods_1")) return false;
    methods_1_0(b, l + 1);
    return true;
  }

  // method (COMMA space? method)*
  private static boolean methods_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methods_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = method(b, l + 1);
    r = r && methods_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA space? method)*
  private static boolean methods_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methods_1_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!methods_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "methods_1_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA space? method
  private static boolean methods_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methods_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && methods_1_0_1_0_1(b, l + 1);
    r = r && method(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // space?
  private static boolean methods_1_0_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methods_1_0_1_0_1")) return false;
    consumeToken(b, SPACE);
    return true;
  }

  /* ********************************************************** */
  // LEFT_BRACKET letter RIGHT_BRACKET
  public static boolean status(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "status")) return false;
    if (!nextTokenIs(b, LEFT_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LEFT_BRACKET, LETTER, RIGHT_BRACKET);
    exit_section_(b, m, STATUS, r);
    return r;
  }

  /* ********************************************************** */
  // (testcase|line_comment)*
  static boolean tddFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tddFile")) return false;
    int c = current_position_(b);
    while (true) {
      if (!tddFile_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tddFile", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // testcase|line_comment
  private static boolean tddFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tddFile_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = testcase(b, l + 1);
    if (!r) r = consumeToken(b, LINE_COMMENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // key status description methods
  public static boolean testcase(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "testcase")) return false;
    if (!nextTokenIs(b, LEFT_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = key(b, l + 1);
    r = r && status(b, l + 1);
    r = r && description(b, l + 1);
    r = r && methods(b, l + 1);
    exit_section_(b, m, TESTCASE, r);
    return r;
  }

}
