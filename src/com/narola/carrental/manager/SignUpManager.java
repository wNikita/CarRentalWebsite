package com.narola.carrental.manager;

import com.narola.carrental.common.EmailService;
import com.narola.carrental.common.Utility;
import com.narola.carrental.dao.UserDAO;
import com.narola.carrental.exception.DAOException;
import com.narola.carrental.model.User;
import com.narola.carrental.view.SignUpView;


public class SignUpManager {

    private SignUpView signUpView = new SignUpView();
    private UserDAO userDAO = new UserDAO();
    private EmailService emailService = new EmailService();

    public void doSignUp() throws DAOException {
        User user = signUpView.getSignUpInfo();
        try {
            String code = Utility.generateVerificationCode();
            user.setVerificationCode(code);
            userDAO.addUser(user);
            sendMail(user);
            signUpView.displaySignUpSuccessMessage();
        } catch (DAOException ex) {
            signUpView.displaySignUpErrorMessage("Ops, Something went wrong while account creation" + ex);
        }
    }

    private void sendMail(User user) {
        StringBuilder mailContent = new StringBuilder();
        mailContent.append("<H1>")
                .append("Hi, ").append(user.getFirstName()).append(" ").append(user.getLastName())
                .append("</H1>")
                .append("Your verification code :").append(user.getVerificationCode());
        emailService.sendMail(user.getEmailId(), "Zoom Car:Account verification code", mailContent.toString());
    }
}
