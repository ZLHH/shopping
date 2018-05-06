package com.example.controller;

import com.example.utils.PaymentUtil;
import com.example.utils.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by zhanglh on 2018/5/6.
 */
@RestController
@RequestMapping("/pay")
public class PayController {

    private final Integer pageSize = 5;

    private Logger logger = LoggerFactory.getLogger(PayController.class);


    /**
     * 支付订单
     *
     * @throws IOException
     */
    @RequestMapping("/payOrder")
    public String payOrder(String pd_FrpIds, HttpServletResponse response) throws IOException {
        // 完成付款:
        // 付款需要的参数:
        String p0_Cmd = "Buy"; // 业务类型:
        String p1_MerId = "10001126856";// 商户编号:
        String p2_Order = UUIDUtil.getUUID();// 订单编号:
        String p3_Amt = "0.01"; // 付款金额:
        String p4_Cur = "CNY"; // 交易币种:
        String p5_Pid = ""; // 商品名称:
        String p6_Pcat = ""; // 商品种类:
        String p7_Pdesc = ""; // 商品描述:
        String p8_Url = "http://localhost:8081/deposit/callBack"; // 商户接收支付成功数据的地址:
        String p9_SAF = ""; // 送货地址:
        String pa_MP = ""; // 商户扩展信息:
        String pd_FrpId = pd_FrpIds;// 支付通道编码:
        String pr_NeedResponse = "1"; // 应答机制:
        String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl"; // 秘钥
        String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP, pd_FrpId,
                pr_NeedResponse, keyValue); // hmac

        // 向易宝发送请求:
        StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
        sb.append("p0_Cmd=").append(p0_Cmd).append("&");
        sb.append("p1_MerId=").append(p1_MerId).append("&");
        sb.append("p2_Order=").append(p2_Order).append("&");
        sb.append("p3_Amt=").append(p3_Amt).append("&");
        sb.append("p4_Cur=").append(p4_Cur).append("&");
        sb.append("p5_Pid=").append(p5_Pid).append("&");
        sb.append("p6_Pcat=").append(p6_Pcat).append("&");
        sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
        sb.append("p8_Url=").append(p8_Url).append("&");
        sb.append("p9_SAF=").append(p9_SAF).append("&");
        sb.append("pa_MP=").append(pa_MP).append("&");
        sb.append("pd_FrpId=").append(pd_FrpId).append("&");
        sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
        sb.append("hmac=").append(hmac);

        // 重定向易宝
        response.sendRedirect(sb.toString());
        return null;
    }

    @RequestMapping("/callBack")
    public String callBack(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        System.out.println("-------充值成功--------");
//        Deposit deposit = new Deposit();
//        deposit.setChargeDate(new Date());
//        deposit.setChargeMoney(new BigDecimal(100));
//        Integer organiser = (Integer) session.getAttribute("identity");
//        deposit.setOrganiser(organiser);
//        if (organiser == 1) {
//            Student student = (Student) session.getAttribute("student");
//            student.setBalance(new BigDecimal(100).add(student.getBalance() == null ? new BigDecimal(0) : student.getBalance()));
//            studentService.updateByPrimaryKeySelective(student);
//            deposit.setOrganiserId(student.getId());
//            deposit.setStatus(0);
//            depositService.insertSelective(deposit);
//            return "redirect:/my?url=student_chongzhi";
//        } else {
//            Teacher teacher = (Teacher) session.getAttribute("teacher");
//            teacher.setBalance(new BigDecimal(100).add(teacher.getBalance() == null ? new BigDecimal(0) : teacher.getBalance()));
//            teacherService.updateByPrimaryKeySelective(teacher);
//            deposit.setOrganiserId(teacher.getId());
//            deposit.setStatus(0);
//            depositService.insertSelective(deposit);
//            return "redirect:/my?url=teacher_chongzhi";
//        }

        return null;
    }
}
