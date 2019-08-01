package com.issamdrmas.utils;

import javax.servlet.http.HttpServletRequest;

import com.issamdrmas.model.CartInfo;

public class Utils {
	
	public static CartInfo getCartInfoSession(HttpServletRequest request) {
		CartInfo cartInfo = (CartInfo) request.getSession().getAttribute("myCart");
		if (cartInfo==null) {
			cartInfo = new CartInfo();
			request.getSession().setAttribute("myCart", cartInfo);
		}
		return cartInfo;
	}
	public static void removeCartInSession(HttpServletRequest request) {
		request.getSession().getAttribute("myCart");
	}
	public static void storeLAstOrderedCartInSession(HttpServletRequest request, CartInfo cartInfo) {
		request.getSession().setAttribute("lastOrderedCart", cartInfo);
	}
	public static CartInfo getLastOrderedCartSession(HttpServletRequest request) {
		return (CartInfo) request.getSession().getAttribute("lastOrderedCart");
	}

}
