package jspbasic.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.http.Part;

public class SendmailServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Google 계정 정보
        String username = "dssiyun@gmail.com"; // 구글 계정명
        String password = "bepj xgst loib walc"; // 앱 비밀번호

        // SMTP 서버 설정
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true"); // SMTP 서버 인증 여부
        props.put("mail.smtp.starttls.enable", "true"); // TLS 서비스 사용 여부
        props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP 서버
        props.put("mail.smtp.port", "587"); // SMTP 서버 포트번호

        // 메일세션 (연결) 생성
        Session session = Session.getInstance(props, new Authenticator() {
            // 사용자 계정명, 앱 비밀번호로 사용자 인증
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        String sender = request.getParameter("sender");
        String receiver = request.getParameter("receiver");
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");

        // 첨부파일 처리 (getPart 사용)
        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName(); // 파일 이름

        try {
            // 이메일에 메세지 작성
            Message message = new MimeMessage(session);

            // 발신자 이메일 주소 작성
            message.setFrom(new InternetAddress(sender));

            // 수신자 이메일 주소 작성
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver));

            // 이메일 제목
            message.setSubject(subject);

            // 이메일 내용
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText(content);

            // 첨부파일 추가
            MimeBodyPart attachmentPart = new MimeBodyPart();
            if (filePart != null) {
                // 파일을 메일에 첨부
                attachmentPart.setFileName(fileName);
                attachmentPart.setContent(filePart.getInputStream(), "application/octet-stream");
            }

            // Multipart 객체로 본문과 첨부파일 결합
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);
            if (filePart != null) {
                multipart.addBodyPart(attachmentPart);
            }

            // 이메일 메시지에 Multipart 설정
            message.setContent(multipart);

            // 이메일 발송
            Transport.send(message);
            System.out.println("이메일 발송 완료!");

        } catch (MessagingException me) {
            me.printStackTrace();
        }
    }
}
