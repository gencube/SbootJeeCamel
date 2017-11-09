package com.gencube.sbjc.utils;

import com.gencube.sbjc.dtos.ErrorDto;
import com.gencube.sbjc.dtos.SuccessDto;
import com.gencube.utils.FlatternUtils;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author gencube
 */
public abstract class SpringVMUtils {

    public static <T> String toSuccessJson(List<T> messages) {
        SuccessDto<T> newSuccess = new SuccessDto<>();
        newSuccess.setMessages(messages);
        return FlatternUtils.toJson(newSuccess);
    }

    public static <T> String toSuccessJson(T message) {
        List<T> messages = new LinkedList<>();
        messages.add(message);
        return toSuccessJson(messages);
    }

    public static String toNoErrJson(String message) {
        ErrorDto obj = new ErrorDto();
        obj.setError(false); // No Error.
        obj.setCode("200");
        obj.setMessage(message); // only error messages
        return FlatternUtils.toJson(obj);
    }

    public static String toErrJson(String message, String code) {
        ErrorDto obj = new ErrorDto();
        obj.setCode(code);
        obj.setMessage(message); // only error messages
        return FlatternUtils.toJson(obj);
    }

    public static String toErrJson(String message) {
        ErrorDto obj = new ErrorDto();
        obj.setMessage(message); // only error messages
        return FlatternUtils.toJson(obj);
    }

    public static String toErrJson(String message, Throwable ex, String code) {
        ErrorDto obj = new ErrorDto();
        obj.setCode(code);
        obj.setMessage(message); // only error messages
        obj.setStackTrace(FlatternUtils.toString(ex));
        return FlatternUtils.toJson(obj);
    }

    public static String toErrJson(String message, Throwable ex) {
        ErrorDto obj = new ErrorDto();
        obj.setMessage(message); // only error messages
        obj.setStackTrace(FlatternUtils.toString(ex));
        return FlatternUtils.toJson(obj);
    }

}
