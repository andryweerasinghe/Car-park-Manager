/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 1/8/24

 */

package lk.ijse.carparkManager.dao;

import lk.ijse.carparkManager.dao.Custom.Impl.RatesDAOImpl;
import lk.ijse.carparkManager.dao.Custom.Impl.TicketDAOImpl;
import lk.ijse.carparkManager.dao.Custom.Impl.UserDAOImpl;
import lk.ijse.carparkManager.dao.Custom.Impl.VehicleDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){

    }
    public static DAOFactory getDaoFactory(){
        return (daoFactory == null)?daoFactory=new DAOFactory():daoFactory;
    }
    public enum DAOTypes{
        USER, VEHICLE, TICKET, RATES
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
            default:
                return null;
        }
    }
}
