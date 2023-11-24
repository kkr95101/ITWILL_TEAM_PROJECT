package com.danaga.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.danaga.dao.OrderDao;
import com.danaga.entity.Orders;
import com.danaga.service.MailService;
import com.danaga.service.OrderService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;
    private final OrderDao orderDao;
//    @GetMapping("/mailpage")
//    public String MailPage(){
//        return "Mail";
//    }
    @ResponseBody
    @PostMapping("/emailauthentication")
    public String joinMailSend(String mail){

       int number = mailService.joinSendMail(mail);

       String num = "" + number;

       return num;
    }
    @ResponseBody
    @PostMapping("/findpassemailauthentication")
    public Map findPassMailSend(String mail) throws Exception{
    	
    	String randomPass = null;
		randomPass = mailService.findPassSendMail(mail);
		HashMap map=new HashMap<>();
    	map.put("newPass", randomPass);
    	
    	return map;
    }
    @ResponseBody
    @PostMapping("/findidemailauthentication")
    public Map findidMailSend(String mail) throws Exception{
    	
    	String id = null;
		id = mailService.findIdSendMail(mail);
    	HashMap map=new HashMap<>();
    	map.put("sendId", id);
    	return map;
    }
    @ResponseBody
    @PostMapping("/sendOrderIdemailauthentication")
    public Map sendOrderIdMailSend(String mail, @RequestParam String orderId) throws Exception{
    	
    	String id = null;
    	id = mailService.findOrderIdSendMail(mail, orderId);
    	HashMap map=new HashMap<>();
    	map.put("orderId", id);
    	if(orderId!=null) {
    		
    		Orders orders= orderDao.findById(Long.parseLong(orderId));
    		if(orders.getMember().getRole().equals("Guest")) {
    			orders.getMember().setEmail(null);
    		}
    		orderDao.save(orders);
    		return map;
    	}else {
    		throw new Exception("주문번호가 없습니다.");
    	}
    }

}