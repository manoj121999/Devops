package com.java.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddController {
	@RequestMapping("/for6")
public ModelAndView add(HttpServletRequest request,HttpServletResponse response) {
	
		//float s=Integer.parseInt(request.getParameter("t"));
		float I=Integer.parseInt(request.getParameter("t1"));
		float i=Integer.parseInt(request.getParameter("t2"));
		float J=Integer.parseInt(request.getParameter("t3"));
		float j=Integer.parseInt(request.getParameter("t4"));
		float K=Integer.parseInt(request.getParameter("t5"));
		float k=Integer.parseInt(request.getParameter("t6"));
		float L=Integer.parseInt(request.getParameter("t7"));
		float l=Integer.parseInt(request.getParameter("t8"));
		float M=Integer.parseInt(request.getParameter("t9"));
		float m=Integer.parseInt(request.getParameter("t10"));
		float N=Integer.parseInt(request.getParameter("t11"));
		float n=Integer.parseInt(request.getParameter("t12"));
	/*	int P=Integer.parseInt(request.getParameter("t13"));
		int p=Integer.parseInt(request.getParameter("t14"));
		int Q=Integer.parseInt(request.getParameter("t15"));
		int q=Integer.parseInt(request.getParameter("t16"));
		*/
float i1 =I*i;float i2 =J*j;float i3 =K*k;float i4 =L*l;float i5 =M*m;float i6 =N*n;//int i7 =P*p;int i8 =Q*q;
		
		//if(Count==6) {
		//	int i1 =I*i;int i2 =J*j;int i3 =K*k;int i4 =L*l;int i5 =M*m;int i6 =N*n;int i7 =P*p;int i8 =Q*q;
			float cs=i+j+k+l+m+n;
			float gc=i1+i2+i3+i4+i5+i6;
		   float sgpa=gc/cs;
		
		//}
		  //    else {
		  //	  int cs=i+j+k+l+m+n+p+q;
				//	int gc=i1+i2+i3+i4+i5+i6+i7+i8;
					//sgpa=gc/cs;
		      
		
		//int k = i*j;
		//int m=i+j;
		//int n =i-j;
		//float o=i/j;
		//for (int l=0;l<=1;l++) {
			//k=k+1;
		//}
		ModelAndView mv =new ModelAndView();
		mv.setViewName("display.jsp");
		//mv.addObject("Name",s);
		mv.addObject("mul",sgpa);
		//mv.addObject("add",m);
		//mv.addObject("sub",n);
		//mv.addObject("div",n);
	return mv;
		
}
	@RequestMapping("/for8")
	public ModelAndView for8(HttpServletRequest request,HttpServletResponse response) {
		
		
		float I=Integer.parseInt(request.getParameter("t1"));
		float i=Integer.parseInt(request.getParameter("t2"));
		float J=Integer.parseInt(request.getParameter("t3"));
		float j=Integer.parseInt(request.getParameter("t4"));
		float K=Integer.parseInt(request.getParameter("t5"));
		float k=Integer.parseInt(request.getParameter("t6"));
		float L=Integer.parseInt(request.getParameter("t7"));
		float l=Integer.parseInt(request.getParameter("t8"));
		float M=Integer.parseInt(request.getParameter("t9"));
		float m=Integer.parseInt(request.getParameter("t10"));
		float N=Integer.parseInt(request.getParameter("t11"));
		float n=Integer.parseInt(request.getParameter("t12"));
		float P=Integer.parseInt(request.getParameter("t13"));
		float p=Integer.parseInt(request.getParameter("t14"));
		float Q=Integer.parseInt(request.getParameter("t15"));
		float q=Integer.parseInt(request.getParameter("t16"));
		
float i1 =I*i;float i2 =J*j;float i3 =K*k;float i4 =L*l;float i5 =M*m;float i6 =N*n;float i7 =P*p;float i8 =Q*q;
float cs=i+j+k+l+m+n+p+q;
float gc=i1+i2+i3+i4+i5+i6+i7+i8;
float sgpa=gc/cs;
		ModelAndView mr =new ModelAndView();
		mr.setViewName("display1.jsp");
		mr.addObject("Name",sgpa);
		return mr;
}
}
