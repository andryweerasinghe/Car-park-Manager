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
        PLACE_ORDER
    }
    public SuperBO getBO(BOTypes boTypes) {
        switch (boTypes) {
            case PLACE_ORDER:
                return new AddVehicleBoImpl();
            default:
                return null;
        }
    }
}
