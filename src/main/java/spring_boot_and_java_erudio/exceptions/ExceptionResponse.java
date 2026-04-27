package spring_boot_and_java_erudio.exceptions;

import java.util.Date;

public record ExceptionResponse(Date timsestamp, String message, String details) {
}
