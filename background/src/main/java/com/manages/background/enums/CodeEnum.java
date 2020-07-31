package com.manages.background.enums;

/**
 * @Author kzh
 * @Description 自定义错误状态码
 * @Date 19-3-1 下午5:54
 */
public enum CodeEnum {

    // 成功状态码
    SUCCESS(1, "请求成功"),

    // 参数错误状态码
    PARAMS_IS_NULL(10001, "参数不能为空"),
    PARAMS_NOT_COMPLETE(10002, "参数不全"),
    PARAMS_TYPE_ERROR(10003, "参数类型错误"),
    PARAMS_IS_INVALID(10004, "参数无效"),

    // 用户错误状态码
    USER_NOT_EXIST(20001, "用户不存在"),
    USER_NOT_LOGIN(20002, "用户未登录"),
    USER_ACCOUNT_ERROR(20003, "用户名或密码错误"),
    USER_ACCOUNT_FORBIDDEN(20004, "用户账户已经被禁用"),
    USER_ALREADY_EXIST(20005, "用户已经存在"),

    // 业务错误
    BUSSINESS_ERROR(30001, "系统业务错误"),

    // 系统错误
    SYSTEM_INTERNAL_ERROR(40001, "系统错误"),

    // 数据错误
    DATA_NOT_FOUND(50001, "数据未找到"),
    DATA_IS_WRONG(50002, "数据错误"),
    DATA_ALREADY_EXIST(50003, "数据已经存在"),
    DATA_IS_REFERENCED(50004, "数据被引用中"),

    // 接口请求错误
    INTERFACE_REQUEST_TIMEOUT(60001, "接口请求超时"),

    // 商品错误
    PRODUCT_STOCK_INSUFFICIENT(70001, "商品库存不足"),
    PRODUCT_OFFSALE(70002, "商品已经下架"),
    PRODUCT_CART_NUM_ERROR(70003, "购物车商品数量错误"),
    PRODUCT_IS_WRONG(70004, "商品信息错误"),
    PRODUCT_TIMEOUT(70005, "已经超过商品可下单时间"),
    CART_IS_EMPTY(70006, "购物车没有商品数据"),

    // redisson错误
    REDISSON_LOCK_ERROR(80001, "redisson锁错误"),
    REDISSON_LOCK_TIMEOUTE(80002, "redisson锁等待超时"),

    // 订单错误
    CREATE_CENTER_ORDER_ERROR(9001, "订单创建失败"),
    ORDER_PAY_STATUS_ERROR(90002, "支付状态错误")
    ;

    private Integer code;

    private String msg;

    CodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    CodeEnum() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
