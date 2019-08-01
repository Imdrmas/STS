package com.issamdrmas.model;

import java.util.ArrayList;
import java.util.List;


public class CartInfo {
    private int orderNum;
    
    private CustomerInfo customerInfo;
 
    private final List<CartLineInfo> cartLines = new ArrayList<CartLineInfo>();

	public CartInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	public List<CartLineInfo> getCartLines() {
		return cartLines;
	}
    
    private CartLineInfo findLineByCode(String code) {
    	for (CartLineInfo line: this.cartLines) {
			if (line.getProductInfo().getCode().equals(code)) {
				return line;
			}
		}
    	return null;
    }
    
    public void addProduct(ProductInfo productInfo, int quantity) {
    	CartLineInfo lineInfo = findLineByCode(productInfo.getCode());
    	
    	if (lineInfo == null) {
			lineInfo = new CartLineInfo();
			lineInfo.setQuantity(0);
			lineInfo.setProductInfo(productInfo);
			this.cartLines.add(lineInfo);
		}
    	int newQantity = lineInfo.getQuantity() + quantity;
    	if (newQantity <= 0) {
			this.cartLines.remove(lineInfo);
		}else {
			lineInfo.setQuantity(newQantity);
		}
    }
    
    public void validate() {
    	
    }
    public boolean isValidCustomer() {
    	return this.customerInfo != null && this.customerInfo.isValid();
    }
    public void updateProduct(String code, int quantity) {
    	CartLineInfo lineInfo = this.findLineByCode(code);
    	if (lineInfo!=null) {
			if (quantity<=0) {
				this.cartLines.remove(lineInfo);
			}else {
				lineInfo.setQuantity(quantity);
			}
		}
    }
    	public void removeProduct(ProductInfo productInfo) {
    		CartLineInfo cartLineInfo = this.findLineByCode(productInfo.getCode());
    		if (cartLineInfo!=null) {
				this.cartLines.remove(cartLineInfo);
			}
    	}
    	public boolean isEmpty() {
    		return this.cartLines.isEmpty();
    	}
    	public int getQuantityTotal() {
    		int quantity = 0;
    		for (CartLineInfo lineInfo: this.cartLines) {
				quantity += lineInfo.getQuantity();
			}
    		return quantity;
    	}
    	public double getAmountTotal() {
    		double total = 0;
    		for (CartLineInfo lineInfo: this.cartLines) {
                total += lineInfo.getAmount();
				
			}
    		return total;
    	}
    	public void updateQuantity(CartInfo cartInfo) {
    		if (cartInfo!=null) {
				List<CartLineInfo> lineInfos = cartInfo.getCartLines();
				for (CartLineInfo lineInfo: lineInfos) {
					this.updateProduct(lineInfo.getProductInfo().getCode(), lineInfo.getQuantity());
					
				}
			}
    	}

}
