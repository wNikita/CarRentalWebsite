package com.narola.carrental.manager;

import com.narola.carrental.common.Constant;
import com.narola.carrental.common.Session;
import com.narola.carrental.dao.UserDAO;
import com.narola.carrental.exception.DAOException;
import com.narola.carrental.operation.AdminOperation;
import com.narola.carrental.operation.CustomerOperation;

public class RoleManager {
    private AgencyManager agencyManager = new AgencyManager();
    private CustomerOperation customerOperation = new CustomerOperation();
    private AdminOperation adminOperation = new AdminOperation();
    private UserDAO userDAO = new UserDAO();

    public void manageRole() throws DAOException {
        if (Session.getCurrentUser().getRoleId() == Constant.ROLE_CAR_AGENCY) {
            if (!Session.getCurrentUser().isLogged()) {
                agencyManager.addAgencyDetails();
                userDAO.manageLoginStatus(Session.getCurrentUser().getEmailId(), true);
            }
            adminOperation.adminMenu();
        }
        if (Session.getCurrentUser().getRoleId() == Constant.ROLE_SYSTEM_USER) {
            userDAO.manageLoginStatus(Session.getCurrentUser().getEmailId(), true);
            customerOperation.customerMenu();
        }
    }
}

