package cn.food.boot.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.nio.file.FileSystem;

@Component
public class MailUtil {

    @Value("${spring.mail.username}")
    private String sendFrom;

    @Resource
    private TemplateEngine templateEngine;

    @Resource
    private JavaMailSender mailSender;

    public void sendSimpleMail(String sendTo, String subject, String content) throws Exception {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(sendTo);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        mailMessage.setFrom(sendFrom);
        mailMessage.setFrom(sendFrom);
        mailSender.send(mailMessage);
    }

    /**
     * 发送html格式的邮件
     * @param sendTo 收信人
     * @param subject 主题
     * @param content 内容
     */
    public void sendHtmlMail(String sendTo, String subject, String content) throws Exception {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);

        messageHelper.setFrom(sendFrom);
        messageHelper.setTo(sendTo);
        messageHelper.setSubject(subject);
        messageHelper.setText(content, true);

        mailSender.send(message);

    }

    /**
     *
     * @param sentTo 收信人
     * @param subject 主题
     * @param content 内容
     * @param isHtml 是否html
     * @param fileName 文件名
     * @param file 文件句柄
     * @throws Exception
     */
    public void sendAttachmentFileEmail(String sentTo, String subject, String content, boolean isHtml, String fileName, File file)
            throws Exception {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);

        messageHelper.setFrom(sendFrom);
        messageHelper.setTo(sentTo);
        messageHelper.setSubject(subject);
        messageHelper.setText(content, isHtml);
        messageHelper.addAttachment(fileName, file);

        mailSender.send(message);
    }

    /**
     *
     * @param sentTo 收信人
     * @param subject 主题
     * @param content 内容
     * @param rscPath 图片路径
     * @param rscId 图片id
     * @throws MessagingException
     * @desc "<h1>this html 文本</h1>\n" + "<img src=\'cid:" + rscId + "\'</img>"
     */
    public void sendInLineResourceMail(String sentTo, String subject, String content, String rscPath, String rscId) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);

        messageHelper.setFrom(sendFrom);
        messageHelper.setTo(sentTo);
        messageHelper.setSubject(subject);
        messageHelper.setText(content, true);

        FileSystemResource res = new FileSystemResource(new File(rscPath));
        messageHelper.addInline(rscId, res);
        mailSender.send(message);

    }

    /**
     * 发送html格式的邮件
     * @param sendTo 收信人
     * @param subject 主题
     */
    public void sendTemplateMail(String sendTo, String subject) throws Exception {

        Context context = new Context();
        context.setVariable("id", "586");

        String content = templateEngine.process("emailTemplate", context);

        this.sendHtmlMail(sendTo, subject, content);
    }


}
