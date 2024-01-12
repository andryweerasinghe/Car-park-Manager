/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 1/8/24

 */

package lk.ijse.carparkManager.dao;

import lk.ijse.carparkManager.dao.Custom.Impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){

    }
    public static DAOFactory getDaoFactory(){
        return (daoFactory == null)?daoFactory=new DAOFactory():daoFactory;
    }
    public enum DAOTypes{
        USER, VEHICLE, TICKET, RATES, PARKING_SPACE, TICKET_SPACE_DETAILS, VEHICLE_TICKET_DETAILS, PAYMENTS
    }
    public CrudDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case USER:
                return new UserDAOImpl();
            case VEHICLE:
                return new VehicleDAOImpl();
            case TICKET:
                return new TicketDAOImpl();
            case RATES:
                return new RatesDAOImpl();
            case PARKING_SPACE:
                return new ParkingSpaceDAOImpl();
            case TICKET_SPACE_DETAILS:
                return new TicketSpaceDetailsDAOImpl();
            case VEHICLE_TICKET_DETAILS:
                return new VehicleTicketDetailsDAOImpl();
            case PAYMENTS:
                return new PaymentsDAOImpl();
            default:
                return null;
        }
    }
}
