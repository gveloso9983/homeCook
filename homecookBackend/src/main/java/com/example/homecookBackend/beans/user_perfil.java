package com.example.homecookBackend.beans;
import com.example.homecookBackend.classes.baker.Baker;
import com.example.homecookBackend.classes.baker.BakerDAO;
import com.example.homecookBackend.classes.client.Client;
import com.example.homecookBackend.classes.client.ClientDAO;
import com.example.homecookBackend.classes.MyUser;
import org.orm.PersistentException;

public class user_perfil {

    public static boolean email_in_use(String email) throws PersistentException {
        Client[] clients;
        clients = ClientDAO.listClientByQuery("Email = '" + email + "'",null);

        if(clients.length > 0) {

            return true;
        }
        Baker[] bakers = BakerDAO.listBakerByQuery("Email = '" + email + "'",null);
        if(bakers.length >0) {
            return true;
        }

        return false;
    }
    public static MyUser currentClient(String email) throws PersistentException {
        Client[] clients = ClientDAO.listClientByQuery("Email = '" + email + "'",null);
        return new MyUser(clients[0].getEmail(), clients[0].getFirstName(), clients[0].getLastName(), clients[0].getPhoneNumber(), clients[0].getBirthDate(), clients[0].getId());
    }

    public static MyUser currentBaker(String email) throws PersistentException {
        Baker[] bakers = BakerDAO.listBakerByQuery("Email = '" + email + "'",null);
        return new MyUser(bakers[0].getEmail(), bakers[0].getFirstName(), bakers[0].getLastName(), bakers[0].getPhoneNumber(), bakers[0].getBirthDate(), bakers[0].getId());
    }


}
