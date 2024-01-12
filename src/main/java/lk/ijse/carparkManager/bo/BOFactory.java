/*
 * Author  : Mr.electrix
 * Project : carparkManager
 * Date    : 1/11/24

 */

package lk.ijse.carparkManager.bo;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){

    }
    public static BOFactory getBoFactory(){ return (boFactory == null)?boFactory=new BOFactory():boFactory;}
    public enum BOTypes{
        ADD_VEHICLE, VEHICLES_IN
    }
    public SuperBO getBO(BOTypes boTypes) {
        switch (boTypes) {
            case ADD_VEHICLE:
                return new AddVehicleBoImpl();
            case VEHICLES_IN:
                return new InVehiclesBoImpl();
            default:
                return null;
        }
    }
}
