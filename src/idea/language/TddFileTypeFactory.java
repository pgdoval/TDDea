package idea.language;


import com.intellij.openapi.fileTypes.*;
import org.jetbrains.annotations.NotNull;

public class TddFileTypeFactory extends FileTypeFactory {
    @Override
    public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer) {
        fileTypeConsumer.consume(TddFileType.INSTANCE, "tdd");
    }
}
