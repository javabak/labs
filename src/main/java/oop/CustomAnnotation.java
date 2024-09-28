package oop;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Builder
public @interface CustomAnnotation {
}
