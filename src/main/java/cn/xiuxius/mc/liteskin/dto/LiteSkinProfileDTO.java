package cn.xiuxius.mc.liteskin.dto;

import cn.xiuxius.mc.liteskin.entity.LiteskinProfile;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class LiteSkinProfileDTO {

    private Long id;

    private String uuid;

    private String name;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


    public static LiteSkinProfileDTO of(@NotNull LiteskinProfile entity) {
        return new LiteSkinProfileDTO()
                .setId(entity.getId())
                .setUuid(entity.getUuid())
                .setName(entity.getName())
                .setCreateTime(entity.getCreateTime())
                .setUpdateTime(entity.getUpdateTime());
    }


}
