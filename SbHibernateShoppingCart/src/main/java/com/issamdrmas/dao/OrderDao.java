package com.issamdrmas.dao;

import java.util.Date;
import java.util.List;
import java.util.UUID;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.issamdrmas.entities.Order;
import com.issamdrmas.entities.OrderDetail;
import com.issamdrmas.entities.Product;
import com.issamdrmas.model.CartInfo;
import com.issamdrmas.model.CartLineInfo;
import com.issamdrmas.model.CustomerInfo;
import com.issamdrmas.model.OrderDetailInfo;
import com.issamdrmas.pagination.PaginationResult;
import com.issamdrmas.model.OrderInfo;

@Transactional
@Repository
public class OrderDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private ProductDao productDao;
	
	private int getMAxOrderNum() {
		String sqlString = "SELECT max(o.orderNum) from "+Order.class.getName() + " o ";
		Session session = this.sessionFactory.getCurrentSession();
		Query<Integer> query = session.createQuery(sqlString, Integer.class);
		Integer value = (Integer) query.getSingleResult();
		if (value == null) {
			return 0;
		}
		return value;
	}
	@Transactional(rollbackFor = Exception.class)
	public void saveOrder(CartInfo cartInfo) {
		Session session = this.sessionFactory.getCurrentSession();
		
		int orderNum = this.getMAxOrderNum() + 1;
		Order order = new Order();
		
		order.setId(UUID.randomUUID().toString());
		order.setOrderNum(orderNum);
		order.setOrderDate(new Date());
		order.setAmount(cartInfo.getAmountTotal());
		
		 CustomerInfo customerInfo = new CustomerInfo();
		 order.setCustomerName(customerInfo.getName());
		 order.setCustomerEmail(customerInfo.getEmail());
		 order.setCustomerPhone(customerInfo.getPhone());
		 order.setCustomerAddress(customerInfo.getAddress());
		 
		 session.persist(order);
		 
		 List<CartLineInfo> lineInfos = cartInfo.getCartLines();
		 
		 for (CartLineInfo line: lineInfos) {
			OrderDetail detail = new OrderDetail();
			detail.setId(UUID.randomUUID().toString());
			detail.setOrder(order);
			detail.setAmount(line.getAmount());
			detail.setPrice(line.getProductInfo().getPrice());
			detail.setQuantity(line.getQuantity());
			
			String code = line.getProductInfo().getCode();
			Product product = this.productDao.findProduct(code);
			detail.setProduct(product);
			session.persist(detail);
		}
		 
		 cartInfo.setOrderNum(orderNum);
		 session.flush();
		 
	}
	
	public PaginationResult<OrderInfo> listOrderInfo(int page, int maxResult, int maxNavigationPage){
	     String sql = "Select new " + OrderInfo.class.getName()//
	                + "(ord.id, ord.orderDate, ord.orderNum, ord.amount, "
	                + " ord.customerName, ord.customerAddress, ord.customerEmail, ord.customerPhone) " + " from "
	                + Order.class.getName() + " ord "//
	                + " order by ord.orderNum desc";
	     
	     Session session = this.sessionFactory.getCurrentSession();
	     Query<OrderInfo> query = session.createQuery(sql, OrderInfo.class);
		
		return new PaginationResult<OrderInfo>(query, page, maxResult, maxNavigationPage);
		
	}
	public Order findOrder(String orderId) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.find(Order.class, orderId);
		
	}
	public OrderInfo geOrderInfo(String orderId) {
		Order order = this.findOrder(orderId);
		if (order == null) {
			return null;
		}
		return new OrderInfo(order.getId(), order.getOrderDate(),
				order.getOrderNum(), order.getAmount(), order.getCustomerName(),
				order.getCustomerAddress(), order.getCustomerEmail(), order.getCustomerPhone());
	}
	public List<OrderDetailInfo> listOrderDetailInfos(String orderId){
	     String sql = "Select new " + OrderDetailInfo.class.getName() //
	                + "(d.id, d.product.code, d.product.name , d.quanity,d.price,d.amount) "//
	                + " from " + OrderDetail.class.getName() + " d "//
	                + " where d.order.id = :orderId ";
	     Session session = this.sessionFactory.getCurrentSession();
	     Query<OrderDetailInfo> query = session.createQuery(sql, OrderDetailInfo.class);
	     query.setParameter("orderId", orderId);
	     return query.getResultList();
	}

}
