package top.syy.Config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author 小c
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "ccc.sms.ccp")
public class CloopenConfig {
    private String serverIp;
    private String port;
    private String accountSId;
    private String accountToken;
    private String appId;
    private String templateId;
}
