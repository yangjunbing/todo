package projects.bing.entity;

/**
 * Created by yang on 2017/2/18.
 */
public class OrderFoods {
    private String id;
    private long orderid;
    private long foodid;
    private int num;
    private double price;
    private double countPrice;
    private String temp1;
    private String temp2;
    private String temp3;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getOrderid() {
        return orderid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }

    public long getFoodid() {
        return foodid;
    }

    public void setFoodid(long foodid) {
        this.foodid = foodid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCountPrice() {
        return countPrice;
    }

    public void setCountPrice(double countPrice) {
        this.countPrice = countPrice;
    }

    public String getTemp1() {
        return temp1;
    }

    public void setTemp1(String temp1) {
        this.temp1 = temp1;
    }

    public String getTemp2() {
        return temp2;
    }

    public void setTemp2(String temp2) {
        this.temp2 = temp2;
    }

    public String getTemp3() {
        return temp3;
    }

    public void setTemp3(String temp3) {
        this.temp3 = temp3;
    }
    /*
    * id bigint not null comment  'id',
	orderid bigint comment '订单id',
	foodid bigint comment '菜品id',
	num int comment '份数',
	price numeric(9,2) comment '单价',
	count_price numeric(9,2) comment '小计',
 	temp1 varchar(255) comment '预留字段1',
    temp2 varchar(255) comment '预留字段2',
    temp3 varchar(255) comment '预留字段3',

    * */
}
