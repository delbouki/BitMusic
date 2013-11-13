/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.hmi.modules.accountcreation;

import bitmusic.hmi.api.ApiHmiImpl;
import bitmusic.hmi.mainwindow.WindowComponent;
import bitmusic.hmi.modules.connection.ConnectionController;
import bitmusic.hmi.modules.connection.ConnectionModel;
import bitmusic.hmi.modules.onlineusers.OnlineUsersComponent;
import bitmusic.hmi.patterns.AbstractController;
import bitmusic.profile.classes.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author unkedeuxke
 */
public final class AccountCreationController extends AbstractController<AccountCreationModel, AccountCreationView> {

    public AccountCreationController(final AccountCreationModel model, final AccountCreationView view) {
        super(model, view);
    }
    public class browseListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("---- Clic sur le bouton Parcourir");
            JFileChooser file = new JFileChooser();
            JLabel path = new JLabel();
            int returnVal = file.showSaveDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("---- OK");
            path.setText(file.getSelectedFile().getPath());
            }
        }
    }
    
    public class connectListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String login = AccountCreationController.super.getView().getloginField().getText();
            int pass = AccountCreationController.super.getView().getpasswordField().getPassword().length;
            int conf = AccountCreationController.super.getView().getconfirmationField().getPassword().length;
            String p1 = Arrays.toString(AccountCreationController.super.getView().getpasswordField().getPassword());
            String p2 = Arrays.toString(AccountCreationController.super.getView().getconfirmationField().getPassword());
            
            if(pass != 0 && !login.isEmpty() && conf != 0 && p1.equals(p2))
            {
                System.out.println("bouton connecté : conditions satisfaites");
        
            }
        }
    }
}
