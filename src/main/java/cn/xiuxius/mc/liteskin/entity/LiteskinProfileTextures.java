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
 * 角色材质
 * </p>
 *
 * @author XiaoXiu
 * @since 2025-04-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("liteskin_profile_textures")
public class LiteskinProfileTextures implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 材质类型
     */
    @TableField("type")
    private String type;

    /**
     * 存储类型
     */
    @TableField("storageType")
    private String storageType;

    /**
     * 材质唯一id
     */
    @TableField("uuid")
    private String uuid;

    /**
     * 材质SHA-256摘要
     */
    @TableField("hash")
    private String hash;

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
