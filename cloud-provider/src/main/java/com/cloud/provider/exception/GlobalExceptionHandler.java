package com.cloud.provider.exception;

import com.cloud.provider.utils.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice()
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(SessionNotFoundException.class)
    public ErrorMessage<Object> sessionNotFoundExceptionHandler(HttpServletRequest request, SessionNotFoundException exception) throws Exception {
        return handleErrorInfo(request, exception);
    }

    @ExceptionHandler(NullOrEmptyException.class)
    public ErrorMessage<Object> nullOrEmptyExceptionHandler(HttpServletRequest request, NullOrEmptyException exception) throws Exception {
        return handleErrorInfo(request, exception);
    }

    @ExceptionHandler(IllegalPropertiesException.class)
    public ErrorMessage<Object> illegalPropExceptionHandler(HttpServletRequest request, IllegalPropertiesException exception) throws Exception {
        return handleErrorInfo(request, exception);
    }

    @ExceptionHandler(Exception.class)
    public ErrorMessage<Object> exceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
        return handleErrorInfo(request, exception);
    }

    private ErrorMessage<Object> handleErrorInfo(HttpServletRequest request, Exception exception) {
        ErrorMessage<Object> errorMessage = new ErrorMessage<>();
        errorMessage.setMessage(exception.getMessage());
        errorMessage.setCode(ErrorMessage.ERROR);
        errorMessage.setData(exception.getStackTrace());
        errorMessage.setUrl(request.getRequestURL().toString());
        log.info("================【开始打印异常信息】================");
        log.error("具体错误信息:【"+exception.getMessage()+"】");
        //只打印15行的错误堆栈
        int count = 0;
        for (StackTraceElement stackTraceElement : exception.getStackTrace()) {
            log.error(stackTraceElement.toString());
            if (count++ > 20) { break; }
        }
        log.info("================【异常信息打印完毕】================");
        return errorMessage;
    }
}
