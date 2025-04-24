package cn.xiuxius.mc.liteskin.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Schema(name = "YggdrasilProfilePropertiesVO", description = "Yggdrasil角色属性")
public class YggdrasilProfilePropertiesVO {

    private String name;

    private String value;

    private String signature;

}
