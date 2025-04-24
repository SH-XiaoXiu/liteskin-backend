package cn.xiuxius.mc.liteskin.dto;

import cn.hutool.core.codec.Base64;
import cn.hutool.json.JSONUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * @see <a href="https://github.com/yushijinhun/authlib-injector/wiki/Yggdrasil-%E6%9C%8D%E5%8A%A1%E7%AB%AF%E6%8A%80%E6%9C%AF%E8%A7%84%E8%8C%83#textures-%E6%9D%90%E8%B4%A8%E4%BF%A1%E6%81%AF%E5%B1%9E%E6%80%A7">textures 材质信息属性</a>
 * */

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class YggdrasilTexturesDTO {

    private long timestamp;

    private String profileId;

    private String profileName;

    private Map<String, Texture> textures;

    @Data
    @Accessors(chain = true)
    @EqualsAndHashCode
    public static class Texture {
        private String url;
        private Map<String, String> metadata;
    }
    public static YggdrasilTexturesDTO ofJson(@NotNull String json) {
        return JSONUtil.toBean(json, YggdrasilTexturesDTO.class);
    }

    public String toJson() {
        return JSONUtil.toJsonStr(this);
    }

    public String toBase64() {
        return Base64.encodeUrlSafe(toJson());
    }


}
