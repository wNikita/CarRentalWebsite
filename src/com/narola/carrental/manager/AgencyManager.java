package com.narola.carrental.manager;

import com.narola.carrental.common.Session;
import com.narola.carrental.dao.AgencyDAO;
import com.narola.carrental.exception.DAOException;
import com.narola.carrental.model.AgencyDetails;
import com.narola.carrental.view.AgencyView;


public class AgencyManager {

    private AgencyDAO agencyDAO = new AgencyDAO();
    private AddressManager addressManager = new AddressManager();
    private AgencyView agencyView = new AgencyView();

    public void addAgencyDetails() throws DAOException {
        AgencyDetails agencyDetails = agencyView.getAgencyInformation();
        agencyDAO.addAgency(Session.getCurrentUser().getUserId(), agencyDetails, addressManager.getAddress());
    }

    public AgencyDetails getAgencyProfileDetails() throws DAOException {
        AgencyDetails agencyDetails = agencyDAO.viewAgencyDetails(Session.getCurrentUser().getUserId());
        agencyView.viewAgencyProfile(agencyDetails,addressManager.getAddress1());

        return agencyDetails;
    }
}

