package projects.bing.entity;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.Date;

/**
 * Created by yang on 2017/2/18.
 */
public class Foods {
    private String  id;
    private Types type;
    private String name;
    private double price;
    private String description;
    private String imgsrc;
    private String temp1;
    private String temp2;
    private String temp3;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Types getType() {
        return this.type;
    }

    public void setType(Types  type) {
       this.type = type;
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

    public void setPrice(String price)
    {
        if(NumberUtils.isNumber(price)) {
            this.price = Double.valueOf(price);
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
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
* 	id bigint not null comment '菜品表id',
	typeid bigint comment '分类id',
	name varchar(255) comment '名称',
	price numeric(9,2) comment '价格',
	description varchar(255) comment '描述',
	imgsrc varchar(255) comment '图片位置',
 	temp1 varchar(255) comment '总价',
    temp2 varchar(255) comment '预留字段2',
    temp3 varchar(255) comment '预留字段3',

* */
}
