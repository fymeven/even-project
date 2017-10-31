//package com.even.exception;
//
//import org.springframework.web.servlet.HandlerExceptionResolver;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
///**
// *
//* 类名称：MyExceptionResolver.java
//* 类描述：
//* @author even
// */
//public class MyExceptionResolver implements HandlerExceptionResolver{
//
//	public ModelAndView resolveException(HttpServletRequest request,
//			HttpServletResponse response, Object handler, Exception ex) {
//		// TODO Auto-generated method stub
//		System.out.println("==============异常开始=============");
//		ex.printStackTrace();
//		System.out.println("==============异常结束=============");
//		ModelAndView mv = new ModelAndView("error");
//		mv.addObject("exception", ex.toString().replaceAll("\n", "<br/>"));
//		return mv;
//	}
//
//}
