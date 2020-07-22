/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eventorg.controller;

/**
 *
 * @author aishw
 */
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
public class EventMailController {
    public static boolean sendEmail(String from, String to, String msgBody, String title) {
        try {
            Email email = new SimpleEmail();
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("evento2494@gmail.com", "eve@4942"));
            email.setSSLOnConnect(true);
            email.setFrom("evento2494@gmail.com"); // This user email does not
            email.setSubject(title);
            email.setMsg(msgBody); // Retrieve email from the DAO and send this
            email.addTo(to);
            email.send();
            return true;
        } catch (EmailException e) {
            System.out.println("Email cannot be sent");
        }
        return false;
    }
}
