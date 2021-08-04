package com.bitcamp.firstSpring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.firstSpring.member.domain.OrderCommand;

@Controller
@RequestMapping("/order/order")
public class OrderController {

	@RequestMapping(method = RequestMethod.GET)
	public String getOrderFrom() {
		return "order/orderForm";  //  /WEB-INF/views/orders/orderForm.jsp
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String order(
			OrderCommand orderCommand
			) {
		System.out.println(orderCommand);
		
		return "order/order";
	}
	
}
