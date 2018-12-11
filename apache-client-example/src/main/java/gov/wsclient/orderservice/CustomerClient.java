package gov.wsclient.orderservice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class CustomerClient {

	public static void main(String[] args) {

		try {
			CustomerOrderService csService = new CustomerOrderService(
					new URL("http://localhost:8080/ApacheFisrtProject/services/customerOrders?wsdl"));
			CustomerOrdersPortType port = csService.getCustomerOrdersPort();
			GetOrderRequest getOrderRequest = new GetOrderRequest();
			getOrderRequest.setCustomerId(1);
			GetOrderResponse orders = port.getOrders(getOrderRequest);
			List<Orders> orderss = orders.getOrders();
			for (Orders order : orderss) {
				List<Product> products =order.getProduct();
				for(Product product:products) {
					System.out.println("Prod Description"+ product.getDescription());
					System.out.println("Prod quantity"+ product.getQuantity());
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
