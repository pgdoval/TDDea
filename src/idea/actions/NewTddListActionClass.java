package idea.actions;

import com.intellij.ide.IdeBundle;
import com.intellij.ide.actions.CreateFileFromTemplateDialog;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.ui.popup.PopupChooserBuilder;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiElement;
import idea.language.TddIcons;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.stream.Stream;

/**
 * Created by pablo on 31/03/17.
 */
public class NewTddListActionClass extends com.intellij.ide.actions.CreateFileAction {
    //
//    public NewTddListActionClass() {
//        super("dddd", "eeeee", TddIcons.FILE);
//    }
//
//    @Override
//    protected void buildDialog(Project project, PsiDirectory directory, CreateFileFromTemplateDialog.Builder builder) {
//        builder
//                .setTitle("bbbbbb")
//                .addKind("cccc", TddIcons.FILE, "Dddart File");
//    }
//
//    @Override
//    protected String getActionName(PsiDirectory psiDirectory, String s, String s1) {
//        return "aaaaa";
//    }
    @Override
    @NotNull
    protected PsiElement[] invokeDialog(final Project project, PsiDirectory directory) {
        MyInputValidator validator = new TddValidator(project, directory);
        if (ApplicationManager.getApplication().isUnitTestMode()) {
            try {
                return validator.create("test");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            String s = Messages.showInputDialog(project, IdeBundle.message("prompt.enter.new.file.name"),
                    IdeBundle.message("title.new.file"), Messages.getQuestionIcon(), null, validator);
            return validator.getCreatedElements();
        }
    }

    private class TddValidator extends MyValidator {

        public TddValidator(Project project, PsiDirectory directory) {
            super(project, directory);
        }

        @Override
        public boolean checkInput(String inputString) {
            if (inputString.endsWith(".tdd"))
                return super.checkInput(inputString);
            else
                return super.checkInput(inputString + ".tdd");
        }

        @Override
        public PsiElement[] create(String newName) throws Exception {
            if (newName.endsWith(".tdd"))
                return super.create(newName);
            else
                return super.create(newName + ".tdd");
        }

        @Override
        public boolean canClose(final String inputString) {
            if (inputString.endsWith(".tdd"))
                return super.canClose(inputString);
            else
                return super.canClose(inputString + ".tdd");
        }
    }
}
