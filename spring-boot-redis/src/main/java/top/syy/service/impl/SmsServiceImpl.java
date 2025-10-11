package top.syy.service.impl;

import com.cloopen.rest.sdk.BodyType;
import com.cloopen.rest.sdk.CCPRestSmsSDK;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.syy.Config.CloopenConfig;
import top.syy.cache.RedisCache;
import top.syy.cache.RedisKeys;
import top.syy.enums.ErrorCode;
import top.syy.exception.ServerException;
import top.syy.service.SmsService;
import top.syy.utils.CommonUtils;

import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

/**
 * @author 小c
 */
@Slf4j
@Service
@AllArgsConstructor
public class SmsServiceImpl implements SmsService {

    private final CloopenConfig cloopenConfig;
    private final RedisCache redisCache;

    /**
     * 发送短信验证码
     *
     * @param phone 手机号
     * @return 发送成功返回 true，失败返回 false
     */
    @Override
    public boolean sendSms(String phone) {
        // 1. 校验手机号
        if (!CommonUtils.checkPhone(phone)) {
            throw new ServerException(ErrorCode.PHONE_ERROR);
        }

        // 2. 生成验证码，并存入 Redis，60 秒有效
        int code = CommonUtils.generateCode();
        redisCache.set(RedisKeys.getSmsKey(phone), code, 60);
        log.info("发送短信验证码：{}", code);

        boolean flag = true;
//        flag = send(phone, code);
        return flag;
    }

    private boolean send(String phone, int code) {
        // 2. 获取到配置信息
        String serverIp   = cloopenConfig.getServerIp();
        String serverPort = cloopenConfig.getPort();
        String accountSId = cloopenConfig.getAccountSId();
        String accountToken = cloopenConfig.getAccountToken();
        String appId    = cloopenConfig.getAppId();
        String templateId = cloopenConfig.getTemplateId();

        // 3. 创建 sdk 对象
        CCPRestSmsSDK sdk = new CCPRestSmsSDK();
        sdk.init(serverIp, serverPort);
        sdk.setAccount(accountSId, accountToken);
        sdk.setAppId(appId);
        sdk.setBodyType(BodyType.Type_JSON);

        String[] datas = {String.valueOf(code), "1"};

        // 发送短信
        HashMap<String, Object> result = sdk.sendTemplateSMS(
                phone, templateId, datas, "1234", UUID.randomUUID().toString());

        if ("000000".equals(result.get("statusCode"))) {
            // 正常返回输出 data 包体信息（map）
            HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
            Set<String> keySet = data.keySet();
            for (String key : keySet) {
                Object object = data.get(key);
                log.info("{} = {}", key, object);
            }
        } else {
            // 异常返回输出错误码和错误信息
            log.error("错误码={} 错误信息= {}", result.get("statusCode"), result.get("statusMsg"));
            return false;
        }
        return true;
    }
}