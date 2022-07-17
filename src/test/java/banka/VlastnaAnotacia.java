package banka;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Tag("api")
@Tag("sanity")
@Timeout(value = 5, unit = TimeUnit.SECONDS)
@ParameterizedTest
@ValueSource(ints = {4500, 5000, 6000})
public @interface VlastnaAnotacia {

}
