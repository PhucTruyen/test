/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Cart.product;

import java.util.Objects;
import java.math.BigDecimal;
import java.math.RoundingMode;
import com.google.gson.Gson;

public class Product {
    private String name;
    private double price;
    private int quantity;
    
      // Thêm phương thức chuyển đối tượng thành JSON
    public String toJSON() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
    
    public Product() {
        name = "";
        price = 0.0;
        quantity = 0;
    }

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        double totalPrice = this.quantity * this.price;
        // Làm tròn tổng giá trị về 2 chữ số sau dấu chấm
        BigDecimal bd = new BigDecimal(totalPrice).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Product product = (Product) obj;
            return Objects.equals(name, product.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
}
