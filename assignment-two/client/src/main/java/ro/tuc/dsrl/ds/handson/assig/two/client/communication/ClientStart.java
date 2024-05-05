package ro.tuc.dsrl.ds.handson.assig.two.client.communication;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import ro.tuc.dsrl.ds.handson.assig.two.common.entities.Car;
import ro.tuc.dsrl.ds.handson.assig.two.common.serviceinterfaces.ITaxService;
import ro.tuc.dsrl.ds.handson.assig.two.rpc.Naming;

import java.io.IOException;
import javax.swing.JOptionPane;
/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems,
 *          http://dsrl.coned.utcluj.ro/
 * @Module: assignment-two-client
 * @Since: Sep 24, 2015
 * @Description: Starting point of the Client application.
 */
public class ClientStart {
	
	private static final Log LOGGER = LogFactory.getLog(ClientStart.class);

	private ClientStart() {
	}
	
	public static void main(String[] args) throws IOException {
		String year, engineSize, price;
        int carYear, carEngineSize;
        double carPrice;
        
		year = JOptionPane.showInputDialog("Fabrication Year");
        carYear = Integer.parseInt(year);
        
        engineSize = JOptionPane.showInputDialog("Engine Size");
        carEngineSize = Integer.parseInt(engineSize);
        
        
        price = JOptionPane.showInputDialog("Purchasing Price");
        carPrice = Double.parseDouble(price);
        
		ITaxService taxService = null;
		try {
			taxService = Naming.lookup(ITaxService.class,
					ServerConnection.getInstance());

			Car c;
			c = new Car(carYear, carEngineSize,carPrice);
			double tax = taxService.computeTax(c);
			double sellingPrice = taxService.sellingPrice(c);

			ServerConnection.getInstance().closeAll();
	        JOptionPane.showMessageDialog(null, "Tax value: " + tax + "\nSelling Price: " + sellingPrice + "€", "Results", JOptionPane.PLAIN_MESSAGE);

		} catch (Exception e) {
			LOGGER.error("",e);
			ServerConnection.getInstance().closeAll();
		}
	}
}
