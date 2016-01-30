import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationInterface {
	String author();
	int currentRevision() default 1;
	boolean checked() default true;
	Class<?>[] related();
}
