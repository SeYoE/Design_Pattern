package com.devcourse.abstract_factory;

import com.devcourse.abstract_factory.module.Nation;
import com.devcourse.abstract_factory.module.Order;
import com.devcourse.abstract_factory.module.factory.JapanMcDonaldFactory;
import com.devcourse.abstract_factory.module.factory.KoreanMcDonaldFactory;
import com.devcourse.abstract_factory.module.factory.McDonaldFactory;

import java.util.Optional;

public class Client {
    public static void main(String[] args) {
        Optional<Order> order = getOrder(Nation.CN);
        order.ifPresent(Order::cook);
    }

    private static Optional<Order> getOrder(Nation nation) {
        if (nation.equals(Nation.KR)) {
            McDonaldFactory factory = new KoreanMcDonaldFactory();
            return Optional.of(new Order(factory));
        } else if (nation.equals(Nation.JP)) {
            McDonaldFactory factory = new JapanMcDonaldFactory();
            return Optional.of(new Order(factory));
        }
        return Optional.empty();
    }
}