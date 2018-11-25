package cn.food.boot;

import cn.food.boot.utils.MailUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailTest {

    @Resource
    private MailUtil mailUtil;

    @Test
    public void testSendMail() throws Exception {
        mailUtil.sendSimpleMail("2264267413@qq.com", "hello你", "你还好吗？a");
    }

    @Test
    public void testSendHtmlMail() throws Exception {
        String subject = "this is 个主题";
        String content = "<h1>this html 文本</h1>";

        mailUtil.sendHtmlMail("2264267413@qq.com", subject, content);
    }

    @Test
    public void testSendAttachmentMail() throws Exception {
        String subject = "this is 个主题";
        String content = "<h1>this html 文本</h1>";

        File file = new File("test.txt");

        mailUtil.sendAttachmentFileEmail("2264267413@qq.com", subject, content, true, "测试文件.txt", file);
    }

    @Test
    public void testSendInLineResourceMail() throws Exception {
        String subject = "this is 个主题";
        String rscId = "test";
        String content = "<h1>this html 文本</h1>\n" +
                        "<img src=\'cid:" + rscId + "\'</img>";

        mailUtil.sendInLineResourceMail("2264267413@qq.com", subject, content, "test.jpg", rscId);
    }

    public boolean printChar(Character character) {
        System.out.print(character);
        return true;
    }

    public void testTemplate() throws Exception {
        String subject = "this is 个主题";
        mailUtil.sendTemplateMail("2264267413@qq.com", subject);

    }


}
