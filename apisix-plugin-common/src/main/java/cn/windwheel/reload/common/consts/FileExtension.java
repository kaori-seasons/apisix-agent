package cn.windwheel.reload.common.consts;

import javax.tools.JavaFileObject;

/**
 * @author windwheel
 */
public interface FileExtension {

    String CLASS_FILE_EXTENSION = JavaFileObject.Kind.CLASS.extension;

    String JAVA_FILE_EXTENSION = JavaFileObject.Kind.SOURCE.extension;

    String CLASS_FILE_EXT = "class";
    String JAVA_FILE_EXT = "java";


}
