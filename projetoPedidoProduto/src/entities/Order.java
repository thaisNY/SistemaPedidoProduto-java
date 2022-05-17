package entities;
import entities.enums.OrderStatus;
import java.util.ArrayList; //coleção
import java.util.Calendar;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import entities.Client;
import entities.OrderItem;

public class Order {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date moment;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> items = new ArrayList<>();

    public Order(){

    }
    public Order(Date moment, OrderStatus status, Client client){
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment(){
        return moment;
    }
    public void setMoment(Date moment){
        this.moment = moment;
    }
    private OrderStatus getStatus(OrderStatus status){
        return status;
    }
    public void setStatus(OrderStatus status) { //<-----
        this.status = status;
    }
    private Client getClient(Client client){ //<-----
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    private OrderItem getOrderItem(OrderItem items){ //<----
        return items;
    }

    public void addItem(OrderItem item){
        items.add(item);
    }
    public void removeItem(OrderItem item){
        items.remove(item);
    }

    public Double total(){;
        double sum = 0.0;
        for (OrderItem it : items){
            sum = sum + it.subTotal(it.getQuantity(), it.getPrice());
        }
        return sum;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ");
        sb.append(sdf.format(moment) + "\n");
        sb.append("Order status: ");
        sb.append(status + "\n");
        sb.append("Client: ");
        sb.append(client + "\n");
        sb.append("Order items:\n");
        for (OrderItem item : items) {
            sb.append(item + "\n");
        }
        sb.append("Total price: $");
        sb.append(String.format("%.2f", total()));
        return sb.toString();
    }

}