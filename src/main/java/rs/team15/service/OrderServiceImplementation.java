package rs.team15.service;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import rs.team15.model.Bill;
import rs.team15.model.ClientOrder;
import rs.team15.model.OrderItem;
import rs.team15.model.Restaurant;
import rs.team15.repository.BillRepository;
import rs.team15.repository.ClientOrderRepository;
import rs.team15.repository.OrderItemRepository;

@Service
public class OrderServiceImplementation implements OrderService {

	@Autowired
	ClientOrderRepository orderRepository;
	
	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Autowired
	BillRepository billRepository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public ClientOrder create(ClientOrder order) {
		ClientOrder o = orderRepository.findOne();
		int i = 1;
		if(o == null){
			order.setOrderNumber(i);
		}
		else {
			i = o.getOrderNumber() + 1;
			logger.info("<< number: {}", i);
			order.setOrderNumber(i);
		}
		return orderRepository.save(order);
	}

	@Override
	public OrderItem addNew(OrderItem item) {
		OrderItem oi = orderItemRepository.findOne();
		int i = 1;
		if(oi == null){
			item.setItemNumber(i);
		}
		else {
			i = oi.getItemNumber() + 1;
			logger.info("<< number: {}", i);
			item.setItemNumber(i);
			logger.info("<< number: {}", item.getItemNumber());
		}
		return orderItemRepository.save(item);
	}

	@Override
	public ClientOrder update(ClientOrder order) {
		return orderRepository.save(order);
	}

	@Override
	public ClientOrder find(Integer id) {
		return orderRepository.findByOrderNumber(id);
	}

	@Override
	public Collection<ClientOrder> findByEmployee(String email) {
		return orderRepository.findByEmployee(email);
	}

	@Override
	public Collection<ClientOrder> findByRestaurant(String restaurant) {
		return orderRepository.findByRestaurant(restaurant);
	}

	@Override
	public OrderItem findItem(Integer id) {
		return orderItemRepository.findByItemNumber(id);
	}

	@Override
	public OrderItem updateItem(OrderItem item) {
		return orderItemRepository.save(item);
	}

	@Override
	public OrderItem delete(OrderItem item) {
		orderItemRepository.delete(item);
		return item;
	}

	@Override
	public Bill createBill(Bill bill) {
		return billRepository.save(bill);
	}

	@Override
	public Collection<ClientOrder> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public Collection<ClientOrder> findByStatusAndRestaurant(String status, Restaurant r) {
		return orderRepository.findByStatusAndRestaurant(status, r);
	}

	@Override
	public Collection<ClientOrder> findByReservationAndTable(Long r, Long t) {
		return orderRepository.findByReservation_RsidAndTable_Tid(r, t);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public OrderItem take(Integer id) {
		
		try{
			OrderItem item = orderItemRepository.findByItemNumber(id);
			OrderItem r = item;
			item.setState("in progress");
			
			logger.info("< take item: {}", item.getItemNumber());
			OrderItem updated = orderItemRepository.save(item);
			
			logger.info("< taken: {}", updated.getMenuItem().getName());
			ClientOrder order = item.getOrder();
			order.setStatus("in progress");
			
			logger.info("< size before: {}", order.getItems().size());
			order.getItems().remove(r);
			
			logger.info("< size after: {}", order.getItems().size());
			order.getItems().add(updated);
			
			logger.info("< size afterrrrr: {}", order.getItems().size());
			ClientOrder up = orderRepository.save(order);
			
			return updated;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public OrderItem deleteI(Integer id) {
		
		try {
			OrderItem item = orderItemRepository.findByItemNumber(id);
			logger.info("< deleting item {}", item.getItemNumber());
			
			orderItemRepository.delete(item);
			return item;
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
		
	}

}
