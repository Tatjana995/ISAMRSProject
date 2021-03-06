package rs.team15.model;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;
import java.io.Serializable;

@Entity
@Table(name = "order_items")
public class OrderItem implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "oiid")
    private Long oiid;

    @Column(name = "state")
    private String state; 

    @ManyToOne()
    @JoinColumn(name = "oid")
    private ClientOrder order; 

    @OneToOne()
    @JoinColumn(name = "miid")
    private MenuItem menuItem; 

    @Column(name = "amount")
    private Integer amount; 
    
    @Column(name = "price")
    private double price;

    @Version
    @Column(name = "version")
    private long version ;

    public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	@Column(name = "restaurant_id")
    private Long restaurantId; 


    @Column(name = "oi_table_id")
    private Integer tableId;
    
    @Column(name = "item_number")
    private Integer itemNumber;

    public OrderItem(){
    	//this.version=0;
    }
    
    /*public OrderItem(String state, MenuItem menuItem, Integer amount) {
		super();
		this.state = state;
		this.menuItem = menuItem;
		this.amount = amount;
	}*/

	public Long getItemId() {
        return oiid;
    }

    public void setItemId(Long itemId) {
        this.oiid = itemId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @JsonBackReference
    public ClientOrder getOrder() {
        return order;
    }

    //@JsonIgnore
    public void setOrder(ClientOrder order) {
        this.order = order;
    }

    //@JsonProperty
    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /*public Integer getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }*/

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

	public Long getOiid() {
		return oiid;
	}

	public void setOiid(Long oiid) {
		this.oiid = oiid;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

	public Integer getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(Integer itemNumber) {
		this.itemNumber = itemNumber;
	}

	public OrderItem(Long oiid, String state, ClientOrder order, MenuItem menuItem, Integer amount, double price,
			long version, Long restaurantId, Integer tableId) {

		super();
		this.oiid = oiid;
		this.state = state;
		this.order = order;
		this.menuItem = menuItem;
		this.amount = amount;
		this.price = price;
		//this.version = 0;
		this.restaurantId = restaurantId;
		this.tableId = tableId;
	}
    
}

