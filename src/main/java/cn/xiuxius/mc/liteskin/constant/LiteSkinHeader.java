package cn.xiuxius.mc.liteskin.constant;

import lombok.Getter;

@Getter
public enum LiteSkinHeader {

    LS_ACCOUNT_ID("ls-account-id"),
    LS_ACCOUNT_EMAIL("ls-account-email"),
    LS_ACCOUNT_DISPLAY_NAME("ls-account-name");


    LiteSkinHeader(String name) {
        this.name = name;
    }

    private final String name;

}
