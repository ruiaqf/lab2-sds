package ro.tuc.dsrl.ds.handson.assig.two.client.communication;
import javax.swing.JOptionPane;
public class GUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String year, engineSize, price;
        int carYear, carEngineSize;
        double carPrice;

        year = JOptionPane.showInputDialog("Fabrication Year");
        carYear = Integer.parseInt(year);

        engineSize = JOptionPane.showInputDialog("Engine Size");
        carEngineSize = Integer.parseInt(engineSize);

        price = JOptionPane.showInputDialog("Purchasing Price");
        carPrice = Double.parseDouble(price);

        double tax = 0; 
        double sellingPrice = 0; 
        
        JOptionPane.showMessageDialog(null, "Tax value: " + tax + "\nSelling Price: " + sellingPrice, "Results", JOptionPane.PLAIN_MESSAGE);

        System.exit(0);
	}
}
