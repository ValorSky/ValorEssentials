package fr.kalipso.hexael.utils.command.annotations;

import org.eclipse.sisu.Priority;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Command
{
	String permissionNode() default "";

	String[] name() default {};

	boolean isConsole() default false;
}
