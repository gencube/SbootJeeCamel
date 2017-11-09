package com.gencube.sbjc.dtos;


import static com.gencube.sbjc.utils.SpringVMUtils.toSuccessJson;
import com.gencube.utils.CommonValues.BlankValues;


/**
 *
 * @author gencube
 */
public interface EmptyDto {

    public static final String EMPTY_SUCCESS = toSuccessJson(BlankValues.BLANK_STRING);
    public static final String ZERO_SUCCESS = toSuccessJson("0");
}
