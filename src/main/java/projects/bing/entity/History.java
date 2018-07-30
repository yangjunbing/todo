package projects.bing.entity;

import java.util.Date;

/**
 * Created by yang on 2017/2/18.
 */
public class History {
    private String id;
    private long userid;
    private long foodid;
    private String foodName;
    private int times;
    private String temp1;
    private String temp2;
    private String temp3;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public long getFoodid() {
        return foodid;
    }

    public void setFoodid(long foodid) {
        this.foodid = foodid;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
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
* id bigint not null comment 'id',
	userid bigint comment '用户id',
	fooid bigint comment '菜品id',
	food_name varchar(255) comment '菜名',
	times int comment '次数',
	temp1 varchar(255) comment '预留字段1',
    temp2 varchar(255) comment '预留字段2',
    temp3 varchar(255) comment '预留字段3',

* */
}
