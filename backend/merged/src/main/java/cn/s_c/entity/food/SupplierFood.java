package cn.s_c.entity.food;

import cn.s_c.entity.supplier.Supplier;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "supplierFood")
public class SupplierFood {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "url")
    private String url;

    @Column(name = "hasChoice")
    @Type(type = "yes_no")
    private boolean hasChoice;

    @Column(name = "choice")
    private String[] choice;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    public SupplierFood() {
    }

    public SupplierFood(String name, double price, String url, boolean hasChoice, String[] choice, Supplier supplier) {
        this.name = name;
        this.price = price;
        this.url = url;
        this.hasChoice = hasChoice;
        this.choice = choice;
        this.supplier = supplier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isHasChoice() {
        return hasChoice;
    }

    public void setHasChoice(boolean hasChoice) {
        this.hasChoice = hasChoice;
    }

    public String[] getChoice() {
        return choice;
    }

    public void setChoice(String[] choice) {
        this.choice = choice;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
