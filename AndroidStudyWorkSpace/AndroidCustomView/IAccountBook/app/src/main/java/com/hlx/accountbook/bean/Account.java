package com.hlx.accountbook.bean;

import android.text.TextUtils;
import android.widget.TextView;

import com.hlx.accountbook.common.Constans;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {
    /**
     * 存在账单信息
     */
    public boolean isExist;
    /**
     * 本期账单
     */
    public String curAccount;
    /**
     * 到期还款日前
     */
    public String date;
    /**
     * 银行
     */
    public String bank;
    /**
     * 已还账单
     */
    public String dealAccount;

    /**
     * 已还款时间
     */
    public long dealDate;

    private long messageDate;
    /**
     * 尾号
     */
    public String cardNum;

    /**
     * 您的兴业信用卡8109本期账单人民币17759.32元，到期还款日05月23日，最低还款额5029.32元。若已还款请忽略[兴业银行]
     * 您个人信用卡06月账单￥19,164.55，还款日06月24日，点 cmbt.cn/BEMA639jaH910RI0 查账单明细[招商银行]
     * 【民生银行】您民生信用卡人民币账户6月应还人民币13096.00元，最后还款日7月1日。其中最多可申请11786.40元免息分期，回复FQZD3253即可分12期偿还，每期手续费仅为分期总额的0.67%，办理其他期数请关注民生信用卡微信号自助办理。
     * 您浦发个人信用卡账户本月账单人民币16743.38，最低还款额人民币4134.03。到期还款日07月01日。回复ZDFQ（空格）3138可将您本期账单分12期还款，有分期没烦恼，更多分期优惠见信用卡官网。【浦发银行】
     * 05月账单：您的炎黄信用卡金卡金卡最低应还816.20元，应还16323.93元。到期还款日06月06日。请在还款日前还清，避免产生息费。如您名下有多个账户，请按不同账户分别还款。如已还款，无需理会。查账还款可用阳光惠生活APP。[光大银行]
     * 个人信用卡账单提醒：6月账单RMB12446.90元，最低还款额RMB622.35元，到期还款日6月21日【平安银行】
     */
    public void parseAccount(String body, String number, Long date) {

        if (!TextUtils.isEmpty(body)) {
            if (TextUtils.equals(number, Constans._1_MINSHENG_NUM)) {
                String part = "【(.{4})】.*应还人民币(\\d+(\\.[0-9]+)?).*(\\d+月[0-9]+日).*";
                parseMINSHENG(body, date, part, Constans._1_MINSHENG_3253);
            } else if (TextUtils.equals(number, Constans._2_SPD_NUM)) {
                String part = ".*账单人民币(\\d+(\\.[0-9]+)?).*(\\d{2}月[0-9]{2}日).*【(.{4})】";
                parseCommon(body, date, part, Constans._2_SPD_3138);
            } else if (TextUtils.equals(number, Constans._3_CITIC_NUM)) {
                String part = ".*账单人民币(\\d+(\\.\\d+)?).*(\\d{2}月\\d{2}日).*-(\\S+)";
                parseCommon(body, date, part, Constans._3_CITIC_3912);
            } else if (TextUtils.equals(number, Constans._4_CGB_NUM)) {
                String part = ".*账单金额([\\d,]*(\\.[0-9]+)?).*(\\d{2}月[0-9]{2}日).*【(.{4})】";
                parseCommon(body, date, part, Constans._4_CGB_9022);
            } else if (TextUtils.equals(number, Constans._5_CEB_NUM)) {
                String part = ".*，应还(\\d+(\\.[0-9]+)?).*(\\d{2}月[0-9]{2}日).*\\[(.{4})]";
                parseCommon(body, date, part, Constans._5_CEB_6644);
                String dealpart = "光大卡尾号6644还款(\\d+(\\.[0-9]+)?)";
                parseDealAccount(body, date, dealpart);
            } else if (TextUtils.equals(number, Constans._6_CIB_NUM)) {
                String part = ".*账单人民币(\\d+(\\.[0-9]+)?).*(\\d{2}月[0-9]{2}日).*\\[(.{4})]";
                parseCommon(body, date, part, Constans._6_CIB_8109);
            } else if (TextUtils.equals(number, Constans._7_MERCHANTS_NUM)) {
                String part = ".*账单￥([\\d,]*(\\.[0-9]+)?).*(\\d{2}月[0-9]{2}日).*\\[(.{4})]";
                parseCommon(body, date, part, Constans._7_MERCHANTS_7795);
            } else if (TextUtils.equals(number, Constans._8_BOC_NUM)) {
//                String part = ".*人民币欠款(\\d+(\\.[0-9]+)?).*(\\d+月[0-9]+日).*【(.{4})】";
                String part = ".*账单结欠总计(\\d+(\\.[0-9]+)?).*(\\d+月[0-9]+日).*\\[(.{4})]";
                parseCommon(body, date, part, Constans._8_BOC_6410);
            } else if (TextUtils.equals(number, Constans._9_PAB_NUM)) {
                String part = ".*账单金额(\\d+(\\.\\d+)?).*(\\d+月[0-9]+日).*【(.{4})】";
                parseCommon(body, date, part, Constans._9_PAB_1058);
            }
        }

    }

    private void parseDealAccount(String body, Long date, String dealpart) {

        Pattern pattern = Pattern.compile(dealpart);
        Matcher matcher = pattern.matcher(body);
        if (matcher.find() && date > messageDate) {
            this.dealDate = date;
            this.dealAccount = matcher.group(1);
//            this.date = "已还清";
        }
    }

    /**
     * 解析兴业银行
     *
     * @param body
     * @param date
     * @param part
     * @param cardNum
     */
    private void parseCommon(String body, Long date, String part, String cardNum) {
        Pattern pattern = Pattern.compile(part);
        Matcher matcher = pattern.matcher(body);
        try {
            if (matcher.find() && date > messageDate) {
                this.messageDate = date;
                this.curAccount = parseDate(date) + "本期账单：" + matcher.group(1);
                if (date > dealDate) this.date = matcher.group(3);
                this.bank = matcher.group(4);
                this.cardNum = "尾号：" + cardNum;
            }
        } catch (Exception e) {

        }
    }

    private void parseMINSHENG(String body, Long date, String part, String cardNum) {
        Pattern pattern = Pattern.compile(part);
        Matcher matcher = pattern.matcher(body);
        try {
            if (matcher.find() && date > messageDate) {
                this.messageDate = date;
                this.bank = matcher.group(1);
                this.curAccount = parseDate(date) + "本期账单：" + matcher.group(2);
                if (date > dealDate) this.date = matcher.group(4);
                this.cardNum = "尾号：" + cardNum;
            }
        } catch (Exception e) {

        }
    }

    private String parseDate(long date) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("MM月");
            return formatter.format(new Date(date));
        } catch (Exception e) {
            return "";
        }
    }

}
