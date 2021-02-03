package common.exception;

import lombok.Getter;

@Getter
public class BusinessRulesExceptions extends RuntimeException {

    public BusinessRulesExceptions(String message){
        super(message);

    }

    public BusinessRulesExceptions(String message, Throwable e){
        super(message, e);
    }

    public BusinessRulesExceptions(Throwable e){
        super(e.getMessage());
    }
}
