package dao;

import dto.OrderDto;

import java.util.List;

public interface OrderDao {
    public long createOrder(OrderDto orderDto) throws Exception;
    public List<OrderDto> findOrders() throws Exception;
    public boolean findOrderById(OrderDto orderDto)throws Exception;
    public void cancelOrder(OrderDto orderDto )throws Exception;
    public OrderDto findDataOrder(OrderDto orderDto) throws Exception;
}
