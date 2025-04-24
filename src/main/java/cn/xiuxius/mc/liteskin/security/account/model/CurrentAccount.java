package cn.xiuxius.mc.liteskin.security.account.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class CurrentAccount {

    private Long id;
    private String email;

    public boolean isFull() {
        return id != null && email != null;
    }

}
