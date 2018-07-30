package projects.bing.entity;

import java.util.Date;

/**
 * Created by yang on 2017/2/18.
 */

public class User {
    private String id;
    private String wxid;
    private String  nickname;
    private int totalScore;
    private int times;
    private int mynumber;
    private int  stageScore;
    private int rewardFlag;
    private int rewards;
    private Date numberTime;
    private String  temp1;
    private String  temp2;
    private String  temp3;

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getMynumber() {
        return mynumber;
    }

    public void setMynumber(int mynumber) {
        this.mynumber = mynumber;
    }

    public int getStageScore() {
        return stageScore;
    }

    public void setStageScore(int stageScore) {
        this.stageScore = stageScore;
    }

    public int getReward_flag() {
        return rewardFlag;
    }

    public void setReward_flag(int reward_flag) {
        this.rewardFlag = reward_flag;
    }

    public int getRewards() {
        return rewards;
    }

    public void setRewards(int rewards) {
        this.rewards = rewards;
    }

    public Date getNumberTime() {
        return numberTime;
    }

    public void setNumberTime(Date numberTime) {
        this.numberTime = numberTime;
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
    /*    id bigint not null  comment '用户表id',
    wxid varchar(255) comment 'wxid',
    nickname varchar(255) comment '昵称',
    total_score int comment '总积分',
    times int comment '消费次数',
    mynumber int comment '我的排号' ,
    stage_score int comment '阶段积分   每xx获得一次奖励  获得后-xx积分',
    reward_flag int default 200 comment '多少分获得一次奖励',
    rewards int default 0 comment '剩余奖励次数',
    number_time timestamp comment '取号时间',
    temp1 varchar(255) comment '预留字段1/tableNumber',
    temp2 varchar(255) comment '预留字段2',
    temp3 varchar(255) comment '预留字段3',*/
}
