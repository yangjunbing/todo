package projects.bing.entity;

import java.util.Date;

/**
 * Created by yang on 2017/2/18.
 */
public class Orders {

    private String id;
    private String wxid;
    private double totalPrice;
    private int state; //订单状态  0已提交  1生效   2已支付
    private String notes;//备注
    private int score; //评分 1-10
    private String opinion;
    private Date orderDate; //下单时间
    private Date payDate;//支付时间
    private String payid; //支付交易单号
    private int table;
    private String temp1;
    private String temp2;
    private String temp3;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWxid() {
        return wxid;
    }

    public void setWxid(String wxid) {
        this.wxid = wxid;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public String getPayid() {
        return payid;
    }

    public void setPayid(String payid) {
        this.payid = payid;
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

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

    /*    id bigint not null comment  '订单id',
    wxid varchar(255) not null  comment '用户id',
    total_price numeric(9,2)  comment '订单价格',
    state int default 0 comment '订单状态  0已提交  1生效   2已支付' ,
    notes varchar(255) comment '订单备注',
    score int comment  '订单评分1-10',
    opinion varchar(255) comment '订单意见',
    order_date timestamp DEFAULT CURRENT_TIMESTAMP comment '下单时间',
    pay_date timestamp comment '支付时间',
    payid varchar(255) comment '支付凭证id',
    temp1 varchar(255) comment '预留字段1',
    temp2 varchar(255) comment '预留字段2',
    temp3 varchar(255) comment '预留字段3',*/
}
