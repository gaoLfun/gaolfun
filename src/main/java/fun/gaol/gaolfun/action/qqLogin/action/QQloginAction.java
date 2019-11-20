package fun.gaol.gaolfun.action.qqLogin.action;

import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.oauth.Oauth;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class QQloginAction {
    /**
     * 页面重定向到qq第三方的登录页面。
     */
    @RequestMapping(value = "/qqLogin")
    public void qqLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        ServletActionContext.getResponse().setHeader("Access-Control-Allow-Origin", "*");
        try {
            response.sendRedirect(new Oauth().getAuthorizeURL(request));
        } catch (QQConnectException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取QQ账号信息 redirect_URI是值使用第三方登录页面登录成功后的跳转地址
     *
     * @return
     */
    @RequestMapping(value = "/QQCallback")
    public void QQCallback(HttpServletRequest request, HttpSession session) throws Exception {
        ServletActionContext.getResponse().setHeader("Access-Control-Allow-Origin", "*");
        AccessToken accessTokenObj = (new Oauth()).getAccessTokenByRequest(request);
        String accessToken = null, openID = null;

        // 用户授权的时候取消了，跳转到首页吧
        if (accessTokenObj.getAccessToken().equals("")) {
            System.out.print("没有获取到响应参数");
        }
        accessToken = accessTokenObj.getAccessToken();// 相当于密码(没有什么叼用)

        // 用户QQ的个人信息
        OpenID openIDObj = new OpenID(accessToken);
        openID = openIDObj.getUserOpenID(); // onpenId是QQ用户的唯一标示
        UserInfo qzoneUserInfo = new UserInfo(accessToken, openID);
        UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();
        System.out.println(userInfoBean);
        JSONObject jobj = JSONObject.fromObject(userInfoBean);
        String result = jobj.toString();
        System.out.println(result);
        responseText(result);
    }
    public static void responseText(String repText) throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("html/txt");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.getWriter().write(repText.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }

}
