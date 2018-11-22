package cn.food.boot.controller;

import cn.food.boot.exception.ErrorInfo;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;


@Api(hidden = true)
// @ControllerAdvice
public class GlobalExceptionController {

    static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorInfo<String> ajaxException(HttpServletRequest req, Exception e){
        ErrorInfo<String> errInfo = new ErrorInfo<String>();
        errInfo.setCode(ErrorInfo.ERROR);
        errInfo.setMessage(e.getMessage());
        errInfo.setUrl(req.getRequestURI().toString());
        JSONArray jsonArray = new JSONArray(e.getStackTrace());
        errInfo.setData(jsonArray.toString());
        logger.error("debug message");
        logger.error(errInfo);
        return errInfo;
    }






}
