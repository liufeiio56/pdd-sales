package com.lora.pay.constants;

import cn.hutool.core.thread.ExecutorBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author lirp
 * @date 2020-04-15
 */
public interface CommonConstants {

    /**
     * 及时通信端
     */
    int CLIENT_DINGDING = 1;
    int CLIENT_WELINK = 2;
    int CLIENT_WORK_WX = 3;
    int CLIENT_IPSA = 4;
    int CLIENT_FEISHU = 5;

    /**
     * 是否开启同步通讯录权限：0-未开启；1-已开启
     */
    int SYNC_NOT_OPEN  = 0;
    int SYNC_OPEN = 1;

    /**
     * WELINK 初级部门编码一般为0
     */
    String WELINK_TOP_DEPT_CODE = "0";

    /**
     * KAKA 初级部门编码一般为0
     */
    String KAKA_TOP_DEPT_CODE = "-1";
    /**
     * KAKA 默认部门编号
     */
    String KAKA_DEFAULT_DEPT_CODE = "DEFAULT_DEPT";
    /**
     * KAKA 默认角色编号
     */
    String KAKA_DEFAULT_ROLE_CODE = "DEFAULT_COMMON_ROLE";

    /**
     * KAKA 成员写入标识
     */
    String ADD_SYNC = "sync";

    /**
     * KAKA 增量同步
     */
    String ADD_SYNC_CALLBACK = "sync_callback";

    /**
     * KAKA 增量同步key前缀
     */
    String SYNC_CB_KEY_PREFIX = ":sync_cb";

    /**
     * KAKA 成员默认密码
     */
    String KAKA_DEFAULT_PASSWORD = "Kk1qaz@4321";

    /**
     * 正常
     */
    String STATUS_NORMAL = "0";

    String NORMAL = "0";

    String WELINK_AC_TOKEN="access_token";

    String TREE_ROOT_ID = "-1";

    //成功或失败标志
    String SUCCESS_S = "S";
    String FAILTURE_F = "F";

    //成功或失败标志
    String SUCCESS_RE = "1";
    String FAILTURE_RE = "0";
    /**
     * WeLink同步通讯录线程池
     */
    ExecutorService WeLinkExecutor = ExecutorBuilder.create()
            .setCorePoolSize(10)
            .setMaxPoolSize(100)
            .setWorkQueue(new LinkedBlockingQueue<>(2048))
            .build();
    /**
     * 线程池
     */
    ExecutorService CALLBACK_EXECUTOR = ExecutorBuilder.create()
            .setCorePoolSize(10)
            .setMaxPoolSize(100)
            .setWorkQueue(new LinkedBlockingQueue<>(10240))
            .build();

    /**
     * WELINK access_token
     */
    String ACCESS_TOKEN_WELINK_KEY = "H5:ACCESS_TOKEN:WELINK:";

    String DATA_AYNC_INC_EMP_KEY = "data_sync:inc:emp:";
    String DATA_AYNC_INC_DEP_KEY = "data_sync:inc:dep:";

    /**
     * 全局缓存过期时长，提前10分钟结束
     */
    long GLOBAL_EXPIRES_IN_MINUS = 600;

    /**
     * 成功标记
     */
    Integer SUCCESS = 0;
    /**
     * 失败标记
     */
    Integer FAIL = 1;

    /**
     * 是否是编辑 0-可编辑， 1-不可编辑
     */
    String ALLOW_EDIT = "0";
    String NOT_EDIT = "1";

    /**
     * 是否是管理员 0-不是管理员， 1-是管理员
     */
    String IS_MANAGE = "1";
    String NOT_IS_MANAGE = "0";
}
