package cn.xiuxius.mc.liteskin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serial;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 账户认证
 * </p>
 *
 * @author A_XiaoXiu
 * @since 2025-04-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("liteskin_account_authentication")
public class LiteskinAccountAuthentication implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 账户id
     */
    @TableField("account_id")
    private Long accountId;

    /**
     * 认证类型
     */
    @TableField("type")
    private String type;

    /**
     * 身份
     */
    @TableField("principal")
    private String principal;

    /**
     * 凭证
     */
    @TableField("credential")
    private String credential;

    /**
     * 使用范围
     */
    @TableField("scope")
    private String scope;

    /**
     * 是否为默认认证方式
     */
    @TableField("is_default")
    private Boolean isDefault;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;


}
