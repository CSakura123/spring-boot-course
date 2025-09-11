package top.ccc.boot.week1.service.impl;

import com.cloopen.rest.sdk.BodyType;
import com.cloopen.rest.sdk.CCPRestSmsSDK;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.ccc.boot.week1.service.SmsService;
import top.ccc.boot.week1.config.Configmss;

import java.util.HashMap;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author 小c
 */
@Slf4j
@Service
public class SmsServiceImpl implements SmsService {
    @Resource
    private Configmss configmss;
    @Override
    public void sendSms(String phone) {
    int code= ThreadLocalRandom.current().nextInt(1000,9999);
    log.info("发送短信验证码:{}",code);
    String serverIp=configmss.getServerIp();
    String serverport=configmss.getPort();
    String accountSId=configmss.getAccountSId();
    String accountToken=configmss.getAccountToken();
    String appId=configmss.getAppId();
    String templateId=configmss.getTemplateId();
        CCPRestSmsSDK sdk =new CCPRestSmsSDK();
        sdk.init(serverIp,serverport);
        sdk.setAccount(accountSId,accountToken);
        sdk.setAppId(appId);
        sdk.setBodyType(BodyType.Type_JSON);
        String[] datas ={String.valueOf(code),"1"};
        HashMap<String,Object> reslt=sdk.sendTemplateSMS(phone,templateId,datas,"1234", UUID.randomUUID().toString());
        if("000000".equals(reslt.get("statusCode"))){
            HashMap<String,Object> data=(HashMap<String, Object>) reslt.get("data");
            Set<String> keySet = reslt.keySet();
            for (String key : keySet) {
                Object object=data.get(key);
                log.info("{}={}",key,object);
            }
        }else{
            log.error("错误码={} 错误信息={}",reslt.get("statusCode"),reslt.get("statusMsg"));
        }
    }
}
