package com.codewithmosh.store.services;

import com.codewithmosh.store.dtos.OrderDto;
import com.codewithmosh.store.exceptions.OrderNotFoundExeption;
import com.codewithmosh.store.mapper.OrderMapper;
import com.codewithmosh.store.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final AuthService authService;
    private final OrderMapper orderMapper;

    public List<OrderDto> getAllOrders(){
        var user = authService.getCurentUser();
        var orders = orderRepository.getOrderByCustomer(user);
        return orders.stream().map(orderMapper::toDto).toList();
    }

    public OrderDto getOrder(Long orderId){
        var order = orderRepository.getOrderWithItems(orderId)
                .orElseThrow(OrderNotFoundExeption::new);

        var user = authService.getCurentUser();
        if(!order.isPlacedBy(user)){
            throw new AccessDeniedException("You do not have permission to access this order");
        }

        return orderMapper.toDto(order);
    }
}
