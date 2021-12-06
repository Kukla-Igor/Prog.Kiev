package ua.kiev.prog;
import java.lang.annotation.*;

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Test {
	int a();
	int b();

	}

