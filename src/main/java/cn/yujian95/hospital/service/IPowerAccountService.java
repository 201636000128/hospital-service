package cn.yujian95.hospital.service;

import cn.yujian95.hospital.dto.param.PowerAccountRegisterParam;
import cn.yujian95.hospital.dto.param.PowerAccountStatusParam;
import cn.yujian95.hospital.dto.param.UserRegisterParam;
import cn.yujian95.hospital.entity.PowerAccount;
import cn.yujian95.hospital.entity.PowerPermission;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author YuJian95  clj9509@163.com
 * @date 2020/1/19
 */

public interface IPowerAccountService {

    /**
     * 获取帐号信息
     *
     * @param name 帐号名
     * @return 帐号信息
     */
    Optional<PowerAccount> getByName(String name);

    /**
     * 刷新token
     *
     * @param oldToken 原来的token
     * @return 新token
     */
    String refreshToken(String oldToken);

    /**
     * 获取帐号所有权限（包括角色权限和+-权限）
     *
     * @param accountId 账号编号
     * @return 权限列表
     */
    List<PowerPermission> listPermission(Long accountId);

    /**
     * 判断用户名是否已使用
     *
     * @param name 用户名
     * @return 是否存在
     */
    boolean count(String name);

    /**
     * 判断用户是否存在
     *
     * @param id 用户编号
     * @return 是否存在
     */
    boolean count(Long id);

    /**
     * 账号注册功能
     *
     * @param param 账号注册参数（账号，密码）
     * @return 是否成功
     */
    @Transactional
    boolean registerAdmin(PowerAccountRegisterParam param);

    /**
     * 注册普通用户账号
     *
     * @param param 用户账号注册参数（账号，密码）
     * @return 是否成功
     */
    @Transactional
    boolean registerUser(UserRegisterParam param);

    /**
     * 登录后返回 jwt 字符串
     *
     * @param name     帐号名
     * @param password 密码
     * @return 生成的JWT的token
     */
    Optional<String> login(String name, String password);

    /**
     * 更新密码
     *
     * @param accountId 帐号编号
     * @param password  密码
     * @return 更新结果
     */
    boolean updatePassword(Long accountId, String password);

    /**
     * 更新账号状态
     *
     * @param param 账号编号、账号状态（1：开启，0：关闭）
     * @return 是否成功
     */
    boolean updateStatus(PowerAccountStatusParam param);

    /**
     * 删除账号
     *
     * @param name 账号名
     * @return 是否成功
     */
    boolean delete(String name);

    /**
     * 修改用户角色关系
     *
     * @param accountId  帐号id
     * @param roleIdList 角色id列表
     * @return 成功记录
     */
    int updateRole(Long accountId, List<Long> roleIdList);

    /**
     * 修改用户的+-权限
     *
     * @param accountId        用户id
     * @param permissionIdList 权限列表
     * @return 成功记录
     */
    @Transactional
    int updatePermission(Long accountId, List<Long> permissionIdList);

    /**
     * 更新最后登录时间
     *
     * @param name 用户名称
     */
    void updateLoginTime(String name);

}
