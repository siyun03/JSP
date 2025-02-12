package jspbasic.servlet;

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
        System.out.println("수신자 이메일: " + receiver); // 콘솔에서 확인

        String subject = request.getParameter("subject");
        String content = request.getParameter("content");

        // Null 체크
        if (sender == null) sender = "";
        if (receiver == null || receiver.trim().isEmpty()) {
            throw new ServletException("수신자 이메일이 입력되지 않았습니다.");
        }
        if (subject == null) subject = "";
        if (content == null) content = "";

        // 이메일 주소 유효성 검사
        try {
            InternetAddress emailAddr = new InternetAddress(receiver);
            emailAddr.validate();
        } catch (AddressException e) {
            throw new ServletException("유효하지 않은 이메일 주소입니다: " + receiver);
        }


        try {
            // 이메일에 메세지 작성
            Message message = new MimeMessage(session);

            // 발신자 이메일 주소 작성
            message.setFrom(new InternetAddress(username)); // Gmail 계정으로 설정

            // 수신자 이메일 주소 작성
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver));

            // 이메일 제목
            message.setSubject(subject);

            // 이메일 본문
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText(content);

            // 첨부파일 처리
            Part filePart = request.getPart("file");
            MimeBodyPart attachmentPart = new MimeBodyPart();
            boolean hasAttachment = false; // 첨부파일 존재 여부 체크

            if (filePart != null && filePart.getSize() > 0) {
            	String fileName = (filePart != null) ? filePart.getSubmittedFileName() : "";
                attachmentPart.setFileName(fileName);
                attachmentPart.setContent(filePart.getInputStream(), "application/octet-stream");
                hasAttachment = true;
            }

            // Multipart 객체 생성 및 본문 추가
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);
            
            // 첨부파일이 있을 경우 추가
            if (hasAttachment) {
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
