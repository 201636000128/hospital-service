package cn.yujian95.base.common.api;

/**
 * @author YuJian95  clj9509@163.com
 * @date 2020/1/18
 */

public interface IErrorCode {

    /**
     * 获取结果码
     *
     * @return 结果码
     */
    long getCode();

    /**
     * 返回结果信息
     *
     * @return 结果信息
     */
    String getMessage();
}