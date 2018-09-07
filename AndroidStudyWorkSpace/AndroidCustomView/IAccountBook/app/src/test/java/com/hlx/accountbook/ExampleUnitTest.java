package com.hlx.accountbook;

import org.junit.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void testLongNUll(){
        String nul = "-1";
        Long loon = new Long(nul);

        System.out.println(loon);
        parserDate("-1");
        parserDate("0");
        parserDate("");
        parserDate(null);
    }

    private void parserDate(String date) {
        if(date == null || date.trim() == "")
            date = "-1";
        Long longDate = new Long(date);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dates = formatter.format(new Date(longDate));
        System.out.println(dates);

    }

    @Test
    public void testMatche(){
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
        } else {
            System.out.println("NO MATCH");
        }
    }

    @Test
    public void testT(){
        String sr = "dada ada adad adsda ad asdda 000 adr3 fas daf fas fdsf 234 adda";
        Pattern pet = Pattern.compile("\\b(\\w{3}) *(\\w{4})\\b");
        Matcher match = pet.matcher(sr);
        MatchResult ms = null;
        while (match.find()) {
            ms = match.toMatchResult();
            System.out.print("匹配对象的组结果：");
            for (int i = 0; i < ms.groupCount(); i++) {
                System.out.print(String.format("\n\t第%s组的结果是:%s",i+1,ms.group(i + 1)));
            }
            System.out.print("\n匹配的整个结果:");
            System.out.println(ms.group());
        }
    }

    @Test
    public void testT2(){
        //以空格分割
        String str1 = "1 2 3          4 54       5 6";
        String[] numbers = str1.split(" +");
        for (String temp : numbers) {
            System.out.println(temp);
        }

        // 替换，替换所有的数字为*
        String str2 = "abd123:adad46587:asdadasadsfgi#%^^9090";
        System.out.println(str2.replaceAll("[0-9]", "*"));
        System.out.println(str2.replaceAll("\\d", "*"));

        // 匹配匹配邮箱
        String mail1 = "ababc@asa.com";
        String mail2 = "ababc@asa.com.cn";
        String mail3 = "ababc@asa";
        //        String mainRegex = "[0-9a-zA-Z_]+@[0-9a-zA-Z_]++(\\.[0-9a-zA-Z_]+{2,4})+";
        String mainRegex = "\\w+@\\w+(\\.\\w{2,4})+";

        System.out.println(mail1.matches(mainRegex));//true
        System.out.println(mail2.matches(mainRegex));//true
        System.out.println(mail3.matches(mainRegex));//false
    }

    @Test
    public void testT3(){
        // 匹配出3个字符的字符串
        String str = "abc 124 ewqeq qeqe   qeqe   qeqe  aaaa  fs fsdfs d    sf sf sf  sf sfada dss dee ad a f s f sa a'lfsd;'l 666";
        Pattern pt = Pattern.compile("\\b\\w{3}\\b");
        Matcher match = pt.matcher(str);
        while (match.find()) {
            System.out.println(match.group());
        }
        System.out.println();
        // 匹配出邮箱地址
        String str2 = "dadaadad   da da   dasK[PWEOO-123- DASJAD@DHSJK.COM DADA@DAD.CN =0KFPOS9IR23J0IS ADHAJ@565@ADA.COM.CN shuqi@162.com UFSFJSFI-SI- ";
        Pattern pet2 = Pattern.compile("\\b\\w+@\\w+(\\.\\w{2,4})+\\b");
        Matcher match2 = pet2.matcher(str2);
        while (match2.find()) {
            System.out.println(match2.group());
        }
    }

    @Test
    public void parseAccountTest(){
        /*
         * 您的兴业信用卡8109本期账单人民币17759.32元，到期还款日05月23日，最低还款额5029.32元。若已还款请忽略[兴业银行]
         * 您个人信用卡06月账单￥19,164.55，还款日06月24日，点 cmbt.cn/BEMA639jaH910RI0 查账单明细[招商银行]
         *【民生银行】您民生信用卡人民币账户6月应还人民币13096.00元，最后还款日7月1日。其中最多可申请11786.40元免息分期，回复FQZD3253即可分12期偿还，每期手续费仅为分期总额的0.67%，办理其他期数请关注民生信用卡微信号自助办理。
         * 您浦发个人信用卡账户本月账单人民币16743.38，最低还款额人民币4134.03。到期还款日07月01日。回复ZDFQ（空格）3138可将您本期账单分12期还款，有分期没烦恼，更多分期优惠见信用卡官网。【浦发银行】
         * 05月账单：您的炎黄信用卡金卡金卡最低应还816.20元，应还16323.93元。到期还款日06月06日。请在还款日前还清，避免产生息费。如您名下有多个账户，请按不同账户分别还款。如已还款，无需理会。查账还款可用阳光惠生活APP。[光大银行]
         * 个人信用卡账单提醒：6月账单RMB12446.90元，最低还款额RMB622.35元，到期还款日6月21日【平安银行】
         * 06月账单：您的炎黄信用卡金卡金卡最低应还259.97元，应还5199.33元。到期还款日07月07日。请在还款日前还清，避免产生息费。如您名下有多个账户，请按不同账户分别还款。如已还款，无需理会。查账还款可用阳光惠生活APP。[光大银行]
         *温馨提示:您的信用卡6410本期账单截至2018年5月24日人民币欠款1794.00元，到期还款日为2018年5月30日,请提前办理还款或检查您的自动还款账户余额。如未及时还款，您的逾期信息将被报送至人民银行个人征信数据库。如您已还款，请忽略此短信。【中国银行】
//         * 您尾号9022广发卡05月人民币账单金额2,734.64元，最低还款137.00元，还款到期06月07日 。点 95508.com/CACFYELSyJKsf 即可极速办理账单分期，万元分期日费用最低1.4元。【广发银行】
         *
         *
         * 光大卡尾号6644还款5200元。如果您有多个账户，请区分账户、币种分别还款。竞猜世界杯，瓜分百亿积分。详见阳光惠生活APP[光大银行]
         *
         */
//        String body = "您的兴业信用卡8109本期账单人民币17759.32元，到期还款日05月23日，最低还款额5029.32元。若已还款请忽略[兴业银行]";
//        String body = "06月账单：您的炎黄信用卡金卡金卡最低应还259.97元，应还5199.33元。到期还款日07月07日。请在还款日前还清，避免产生息费。如您名下有多个账户，请按不同账户分别还款。如已还款，无需理会。查账还款可用阳光惠生活APP。[光大银行]";
//        String body = "光大卡尾号6644还款5200元。如果您有多个账户，请区分账户、币种分别还款。竞猜世界杯，瓜分百亿积分。详见阳光惠生活APP[光大银行]";
//        String body = "您个人信用卡06月账单￥19,164.55，还款日06月24日，点 cmbt.cn/BEMA639jaH910RI0 查账单明细[招商银行]";
//        String body = "个人信用卡账单提醒：6月账单RMB12446.90元，最低还款额RMB622.35元，到期还款日6月21日【平安银行】";
//        String body = "温馨提醒，您本期账单金额43196.9元，07月20日前回复ZDFQ0101可申请将本期账单中41037.05元分24期还，每期2054.75元(含手续费)，若申请成功本期仅需还2159.85元。更多金额期数可点击pingan.com/zdfq517 申请【平安银行】";
//        String body = "您浦发个人信用卡账户本月账单人民币16743.38，最低还款额人民币4134.03。到期还款日07月01日。回复ZDFQ（空格）3138可将您本期账单分12期还款，有分期没烦恼，更多分期优惠见信用卡官网。【浦发银行】";
//        String body = "【民生银行】您民生信用卡人民币账户6月应还人民币13096.00元，最后还款日7月1日。其中最多可申请11786.40元免息分期，回复FQZD3253即可分12期偿还，每期手续费仅为分期总额的0.67%，办理其他期数请关注民生信用卡微信号自助办理。";
//        String body = "温馨提示:您的信用卡6410本期账单截至2018年5月24日人民币欠款1794.00元，到期还款日为2018年5月30日,请提前办理还款或检查您的自动还款账户余额。如未及时还款，您的逾期信息将被报送至人民银行个人征信数据库。如您已还款，请忽略此短信。【中国银行】";

//        String body = "您尾号9022广发卡05月人民币账单金额2,734.64元，最低还款137.00元，还款到期06月07日 。点 95508.com/CACFYELSyJKsf 即可极速办理账单分期，万元分期日费用最低1.4元。【广发银行】";

//        String body = "您尾号3912信用卡本期账单人民币8006.49，请于07月28日前还款。温馨提示：最高可将账单中人民币5100.00元分12期，月费率0.73%，成功后本期仅需还人民币2906.49元。07月27日前回FQ+卡末四位办理。-中信信用卡";

        String body = "您的中国银行信用卡07月账单结欠总计372.73元人民币,每张卡欠款需分别还款,最小还款额总计38.00元人民币,最后还款日为07月30日。若查询单张卡账单明细账单详情请点击：https://jf365.boc.cn/a/YSwuuy7es2pj6.h 。[中国银行]";

//        System.out.println(body.indexOf("本期账单人民币"));
//        System.out.println(body.indexOf("元"));
//        System.out.println(body.substring(18,26));
//        System.out.println(body.indexOf("还款日"));
//        System.out.println(body.substring(33,39));

//        String part = ".*账单￥(\\d+,\\d+(\\.[0-9]+)?).*(\\d{2}月[0-9]{2}日).*\\[(.{4})]";
//        String part = ".*账单￥([\\d,]*(\\.[0-9]+)?).*(\\d{2}月[0-9]{2}日).*\\[(.{4})]";
//        String part = ".*账单RMB(\\d+(\\.[0-9]+)?).*(\\d{2}月[0-9]{2}日).*【(.{4})】";
//        String part = ".*账单金额(\\d+(\\.\\d+)?).*(\\d+月[0-9]+日).*【(.{4})】";
//        String part = ".*人民币欠款(\\d+(\\.[0-9]+)?).*(\\d+月[0-9]+日).*【(.{4})】";
//        String part = ".*账单金额([\\d,]*(\\.[0-9]+)?).*(\\d{2}月[0-9]{2}日).*【(.{4})】";
//        String part = "光大卡尾号6644还款(\\d+(\\.[0-9]+)?)";

//        String part =".*账单人民币(\\d+(\\.\\d+)?).*(\\d{2}月\\d{2}日).*-(\\S+)";

        String part = ".*账单结欠总计(\\d+(\\.[0-9]+)?).*(\\d+月[0-9]+日).*\\[(.{4})]";

        Pattern pattern = Pattern.compile(part);
        Matcher matcher =pattern.matcher(body);
        MatchResult ms = null;
        while(matcher.find()){
            ms = matcher.toMatchResult();
            System.out.println(ms.group());

            System.out.println("group count : "+ms.groupCount());
            for (int i = 0; i < ms.groupCount();i++) {
                System.out.println(ms.group(i+1));
            }
        }

    }

    @Test
    public void rxjavaTest_01(){
        Observable.just("1","2")
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        System.out.println("onSubscribe ");
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("onNext : "+s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {

            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Test
    public void rxjavaTest_02(){
        Flowable.just("1","2")
                .onBackpressureDrop()
                .subscribe(new FlowableSubscriber<String>() {
                    @Override
                    public void onSubscribe(Subscription s) {
//                        s.request(2);
                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("onNext : "+s);
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println("onError");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });


    }

    public void rxjavaTest_03(){
        Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> emitter) throws Exception {

            }
        }, BackpressureStrategy.DROP).subscribe(new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}