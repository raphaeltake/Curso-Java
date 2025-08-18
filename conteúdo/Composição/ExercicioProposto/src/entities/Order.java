package entities;

import entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private LocalDateTime moment;
    private OrderStatus status;

    private Client client;
    private List<OrderItem> items = new ArrayList<>();

    public Order(){}

    public Order(LocalDateTime moment, Client client, OrderStatus status) {
        this.moment = moment;
        this.client = client;
        this.status = status;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addItem(OrderItem item){
        items.add(item);
    }

    public void removeItem(OrderItem item){
        items.remove(item);
    }

    public Double total(){
        Double sum = 0.0;
        for (OrderItem item : items) {
            sum += item.subTotal();
        }
        return sum;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: " + moment.format(dateTimeFormat) + "\n");
        sb.append("Order Status: " + status + "\n");
        sb.append("Client: " + client.getName() + " (" + client.getBirthDate().format(dateFormat) + ") - " + client.getEmail() + "\n");
        sb.append("Order items: \n");
        for (OrderItem orderItem : items){
            sb.append(orderItem.getProduct().getName() + ", $" +
                    String.format("%.2f", orderItem.getPrice()) + ", Quantity: " +
                    orderItem.getQuantity() + ", Subtotal: $" + String.format("%.2f", orderItem.subTotal()) + "\n");
        }
        sb.append("Total price: $" + String.format("%.2f", total()));
        return sb.toString();
    }
}
