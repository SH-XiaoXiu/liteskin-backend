package cn.xiuxius.mc.liteskin.vo.liteskin;

import cn.xiuxius.mc.liteskin.dto.LiteSkinProfileDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@Schema(description = "LiteSkin角色")
public class LiteSkinProfileVO {


    @Schema(description = "角色ID")
    private Long id;

    @Schema(description = "角色UUID")
    private String uuid;

    @Schema(description = "角色名称")
    private String name;

    @Schema(description = "角色创建时间")
    private LocalDateTime createTime;


    @Schema(description = "角色更新时间")
    private LocalDateTime updateTime;


    public static LiteSkinProfileVO of(LiteSkinProfileDTO dto) {
        return new LiteSkinProfileVO()
                .setId(dto.getId())
                .setUuid(dto.getUuid())
                .setName(dto.getName())
                .setCreateTime(dto.getCreateTime())
                .setUpdateTime(dto.getUpdateTime());
    }


}
