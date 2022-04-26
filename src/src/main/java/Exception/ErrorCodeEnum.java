package Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCodeEnum {
    ERROR_PRIMEIRAESTRUTURA_NOT_FOUND("error.primeiraestrutura.not.found"),
    ERROR_INVALID_PERIOD("error.invalid.period");

    private final String messageKey;
}
