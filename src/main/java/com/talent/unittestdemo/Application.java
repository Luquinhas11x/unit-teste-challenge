package com.talent.unittestdemo;

import com.talent.unittestdemo.entity.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		Customer customer = new Customer("1", "Jonh Doe");
		Address address = new Address("Street 1", 10,"City 1", "State 1", "09122370");
		customer.changeAddress(address);
		customer.activate();


		Product product = new Product("1");

		List<OrderItem> items = List.of(
				new OrderItem("1", "Product 1", 10.0, product, 1 ),
				new OrderItem("2", "Product 2", 20.0, product, 2),
				new OrderItem("3", "Product 3", 50.0, product, 3)
		);

		Order order = new Order("1", "1", items);

		order.calculate25Percent(order.total());

		customer.setRewardPoints(order.calculateCustomerRewardPoints());

		System.out.println(order.toString());
		System.out.println("To address: " + customer.getAddress().toString());
		System.out.println("Reward Points: " + customer.getRewardPoints());
		if(order.total() >= 200){
			System.out.println("Your final price with 25% of discount: " + order.getTotalAfterDiscount());
		}
	}
}
