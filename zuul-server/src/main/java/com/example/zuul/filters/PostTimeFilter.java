package com.example.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PostTimeFilter extends ZuulFilter {
	
	private static Logger log = LoggerFactory.getLogger(PostTimeFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest req = ctx.getRequest();
		log.info("%s entrando al post filter %s");
		
		Long initTime = (Long)req.getAttribute("initTime");
		
		log.info(String.format("initTime por attribute es: %s", initTime));
		
		Long endTime = System.currentTimeMillis();
		Long elapsedTime = endTime - initTime;
		log.info(String.format("Tiempo transcurrido en milisegundos %s ms.", elapsedTime));
		log.info(String.format("Tiempo transcurrido en segundos %s seg.", elapsedTime.doubleValue()/1000.00));
		log.info(String.format("Tiempo transcurrido en minuntos %s min.", elapsedTime.doubleValue()/10000.00));
		
		return null;
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
