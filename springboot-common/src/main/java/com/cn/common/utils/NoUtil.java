package com.cn.common.utils;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;

/**
 * @author EDZ
 * @version 1.0
 * @since 2020/1/14 13:57
 * 订单生成规则
 */
public class NoUtil {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

    /**
     * 创建不连续的订单号
     *
     * @param no
     *            数据中心编号
     * @return 唯一的、不连续订单号
     */
    public static String getOrderNoByUuid(String no) {
        synchronized(NoUtil.class){
            //uuid的hashcode值，可能为负值，也可能为正值，可能是9位数，也可能是10位数。
            int uuidHashCode = UUID.randomUUID().toString().hashCode();
            //如果为负值，转正。
            if (uuidHashCode < 0) {
                uuidHashCode = uuidHashCode * (-1);
            }
            //当前时间，总计8位数字
            String date = LocalDate.now().format(FORMATTER);
            //随机生成0-9999的数字，如果不够4位数，前面补齐，如数字为50，那么就会0050
            String code = String.format("%04d",new Random().nextInt(9999));
            //这里的参数no可以不要，如果排除no的话，那么订单号码总共有8+10+4=22位
            return no + date + String.format("%010d",uuidHashCode) + code;
        }
    }

    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }
}
