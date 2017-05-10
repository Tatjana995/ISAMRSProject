package rs.team15.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "menu_items")
@JsonIgnoreProperties(value = {"restaurant"})
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "miid")
    private Integer mid;

    @Column(name = "info")
    private String info;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "type")
    private String type;

    @Column(name = "image")
    private String image;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "mi_restaurant_id")
    private Restaurant restaurant;

    @Column(name = "spec_type")
    private String specType;

    @Column(name = "deleted")
    private boolean deleted;

    
    public MenuItem() {
    }

    public Integer getMenuItemId() {
        return mid;
    }

    public void setMenuItemId(Integer menuItemId) {
        this.mid = menuItemId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public String getSpecType() {
        return specType;
    }

    public void setSpecType(String specType) {
        this.specType = specType;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
