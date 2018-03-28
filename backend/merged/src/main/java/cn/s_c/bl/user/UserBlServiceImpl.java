package cn.s_c.bl.user;

import cn.s_c.blservice.user.UserBlService;
import cn.s_c.dataservice.user.UserDataService;
import cn.s_c.vo.ResultMessage;
import cn.s_c.vo.user.UserAuthenVo;
import cn.s_c.vo.user.UserConfirmVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserBlServiceImpl implements UserBlService {

    @Autowired
    private UserDataService userDataService;

    @Value(value = "${wechat.url}")
    private String wechatUrl;

    @Value(value = "${wechat.id}")
    private String appId;

    @Value(value = "${wechat.secret}")
    private String appSecret;

    /**
     * authen user
     *
     * @param userAuthenVo the user info to be register
     * @return whether the operation is success or not
     */
    @Override
    public ResultMessage authen(UserAuthenVo userAuthenVo) {
        if (userDataService.isNumberExisted(userAuthenVo.getNumber())) {
            return ResultMessage.DataError;
        } else {
            boolean isStudent = true;
            return userDataService.bindWechatIdAndNumber(userAuthenVo.getWechatId(), userAuthenVo.getNumber(), isStudent);
        }
    }

    /**
     * get the state of the user
     *
     * @param wechatId the user's openid
     * @return the state of the user
     */
    @Override
    public UserConfirmVo confirmState(String wechatId) {
        return userDataService.getUserStateByWechat(wechatId);
    }

    /**
     * get user openid
     *
     * @param jsCode wechat js code
     * @return whether the operation is success or not
     */
    @Override
    public String getOpenId(String jsCode) {
        RestTemplate client = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> entity = new HttpEntity<String>("", headers);
        ResponseEntity<String> response = client.exchange(wechatUrl + appId + "&secret=" + appSecret + "&js_code=" + jsCode + "&grant_type=authorization_code", HttpMethod.GET, entity, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return "";
        }
    }
}
