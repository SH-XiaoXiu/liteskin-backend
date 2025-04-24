package cn.xiuxius.mc.liteskin.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@Schema(name = "YggdrasilProfileVO", description = "Yggdrasil角色")
public class YggdrasilProfileVO {

    @Schema(description = "角色UUID")
    private String id;

    @Schema(description = "角色名称")
    private String name;

    @Schema(description = "角色属性")
    private List<YggdrasilProfilePropertiesVO> properties;


}
