package com.how2java.springboot.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class GlobalExceptionHandler
{

    /*===================start-以下两种错误处理方式都是可行的-start===============*/
//    @ExceptionHandler(value = Exception.class)
//    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e)
//        throws Exception
//    {
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e);
//        mav.addObject("url", req.getRequestURL());
//        mav.setViewName("exception/errorPage");
//        return mav;
//    }

    @ExceptionHandler(value = Exception.class)
    public String defaultErrorHandler(Model mav, HttpServletRequest req, Exception e)
            throws Exception
    {
        mav.addAttribute("exception", e);
        mav.addAttribute("url", req.getRequestURL());
        return "exception/errorPage";
    }
    /*===================end-以下两种错误处理方式都是可行的-end===============*/
    
}
