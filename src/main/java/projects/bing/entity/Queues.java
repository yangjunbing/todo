package projects.bing.entity;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * Created by yang on 2017/2/18.
 */
public class Queues {
    private String id;
    private String name;
    private int rightnow;
    private int tail;
    private int isOpen;//默认1启用
    private String description;
    private String temp1;
    private String temp2;
    private String temp3;

    public String getId() {
        return id;
    }

    public void setId(String  id) {
        this.id = id ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRightnow() {
        return rightnow;
    }

/*    public void setRightnow(int rightnow) {
        this.rightnow = rightnow;
    }*/
    public void setRightnow(String rightnow) {
        if(NumberUtils.isNumber(rightnow)){
            this.rightnow = Integer.valueOf(rightnow);
        }
    }
    public int getTail() {
        return tail;
    }

/*    public void setTail(int tail) {
        this.tail = tail;
    }*/
    public void setTail(String tail) {
        if(NumberUtils.isNumber(tail)){
            this.tail = Integer.valueOf(tail);
        }
    }
    public int getIsOpen() {
        return isOpen;
    }

/*    public void setIsOpen(int isOpen) {
        this.isOpen = isOpen;
    }*/
    public void setIsOpen(String IsOpen) {
        if(NumberUtils.isNumber(IsOpen)){
            this.isOpen = Integer.valueOf(IsOpen);
        }
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    id bigint not null comment '队列id',
    name varchar(255) comment '队列名称',
    rightnow int comment '当前叫号',
    tail int comment '队尾号数',
    switch int  default 1 comment '是否开启   0关闭    1开启',
    description varchar(255) comment '描述',
    temp1 varchar(255) comment '预留字段1',
    temp2 varchar(255) comment '预留字段2',
    temp3 varchar(255) comment '预留字段3',*/

}
