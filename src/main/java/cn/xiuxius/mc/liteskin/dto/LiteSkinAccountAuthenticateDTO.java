package cn.xiuxius.mc.liteskin.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class LiteSkinAccountAuthenticateDTO {

    private Long accountId;

    private String displayName;

    private String email;

    private String lsToken;


}
