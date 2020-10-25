package Main;

import Control.*;
import Graphic.*;

public class Main {
	
	public static void main(String[] args){
		Purchase purchase = new Purchase();
		ConsultPurchase query = new ConsultPurchase();
		FramePurchase frame = new FramePurchase();
		
		ConPurchase control = new ConPurchase(purchase,query,frame);
		control.start();
		frame.setVisible(true);
		
		
	}

}
