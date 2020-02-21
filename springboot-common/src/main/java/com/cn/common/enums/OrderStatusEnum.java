package com.cn.common.enums;

/**
 * @Author: wangying
 * @Date: 2019-10-26 8:52
 * @Version 1.0
 */
public enum  OrderStatusEnum {
    INVALID(-1,"失效"),
    NO_EFFECTIVE(0,"未生效"),
    EFFECTIVE(1,"生效"),
    NO_CONFIRM(2,"未确认");

    public Integer ordinal;
    public String describe;
    OrderStatusEnum(Integer ordinal,String describe){
        this.ordinal = ordinal;
        this.describe = describe;
    }

    public static OrderStatusEnum getOrderStatusEnum(int ord) {
        for(OrderStatusEnum orderStatusEnum : OrderStatusEnum.values()) {
            if(orderStatusEnum.ordinal == ord) {
                return orderStatusEnum;
            }
        }
        return NO_EFFECTIVE;
    }
}
