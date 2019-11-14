package fun.gaol.gaolfun.action.index.action;

import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.oauth.Oauth;
import com.qq.connect.utils.json.JSONObject;
import fun.gaol.gaolfun.action.index.bo.IndexManager;
import fun.gaol.gaolfun.model.UOpenUserEntity;
import fun.gaol.gaolfun.utils.JdbcTool;
import fun.gaol.gaolfun.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

@Controller
public class IndexAction {
    @Autowired
    private IndexManager indexManager;
    @RequestMapping("/Index")
    public String home(Model model) {
        List<Map<String, Object>> list_article = indexManager.getArticle();
        model.addAttribute("list_article",list_article);
        return "Index";
    }
    @RequestMapping(value = "/qqLogin")
    public void qqLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        try {
            response.sendRedirect(new Oauth().getAuthorizeURL(request));//将页面重定向到qq第三方的登录页面
        } catch (QQConnectException e) {
            e.printStackTrace();
        }
    }

    //获取登录者的基础信息
    @RequestMapping(value = "/QQCallback")
    public JSONObject QQAfterlogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        JSONObject jsonObject = new JSONObject();
        System.out.println("AfterLogin=======================================================");
        response.setContentType("text/html; charset=utf-8");  // 响应编码
        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()){
            String parameterName = parameterNames.nextElement();//code
            System.out.println(parameterName+":"+request.getParameter(parameterName));//state
        }
        try {
            // 获取AccessToken(AccessToken用于获取OppendID)
            AccessToken accessTokenObj = (new Oauth()).getAccessTokenByRequest(request);

            System.out.println("accessTokenObj:"+accessTokenObj);
            // 用于接收AccessToken
            String accessToken   = null,
                    openID        = null;
            long tokenExpireIn = 0L; // AccessToken有效时长

            if (accessTokenObj.getAccessToken().equals("")) {
                System.out.print("没有获取到响应参数");
            } else {
                accessToken = accessTokenObj.getAccessToken();  // 获取AccessToken
                tokenExpireIn = accessTokenObj.getExpireIn();

//                request.getSession().setAttribute("demo_access_token", accessToken);
//                request.getSession().setAttribute("demo_token_expirein", String.valueOf(tokenExpireIn));

                // 利用获取到的accessToken 去获取当前用的openid -------- start
                OpenID openIDObj =  new OpenID(accessToken);
                // 通过对象获取[OpendId]（OpendID用于获取QQ登录用户的信息）
                openID = openIDObj.getUserOpenID();
                request.getSession().setAttribute("demo_openid", openID);
                // 通过OpenID获取QQ用户登录信息对象(Oppen_ID代表着QQ用户的唯一标识)
                UserInfo qzoneUserInfo = new UserInfo(accessToken, openID);
                // 存储登陆人信息
                UOpenUserEntity user = new UOpenUserEntity();
                UuidUtil uuidUtil = null;
                user.setJlid(uuidUtil.getUuid());
                user.setOpenId(openID);
                user.setSysTime(new Timestamp(new Date().getTime()));
                user.setOpenType("QQ");
                // 获取用户信息对象(只获取nickename与Gender)
                UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();
                if (userInfoBean.getRet() == 0) {
                    user.setNickname(userInfoBean.getNickname());
                    user.setGender(userInfoBean.getGender());
                } else {
                    System.out.println("很抱歉，我们没能正确获取到您的信息，原因是： " + userInfoBean.getMsg());
                }
                JdbcTool jdbcTool = null;

                //返回登录数据
                jsonObject.put("nickname",userInfoBean.getNickname());
                jsonObject.put("gender",userInfoBean.getGender());
                jsonObject.put("success","true");
            }
        } catch (QQConnectException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
