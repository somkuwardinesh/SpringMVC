package spring.inter.intercepters;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TheDayIntercepter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		Calendar calendar = Calendar.getInstance();
		int dayInWeek = calendar.get(calendar.DAY_OF_WEEK);
		if (dayInWeek == 1) {
			response.sendRedirect("sunday");
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		System.out
				.println("Spring MVC : Call the post Handle Method after processing the request to controller");
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out
				.println("Spring MVC : Call the AfterCompletion  Method after display the view page to User");
	}

}
