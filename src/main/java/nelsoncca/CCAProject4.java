package nelsoncca;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import com.jme3.app.SimpleApplication;
import com.jme3.niftygui.NiftyJmeDisplay;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.controls.TextField;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import nelsoncca.CCAProject4;

public class CCAProject4 extends SimpleApplication implements ScreenController {

	private Nifty nifty;
	CCAProject5 cca5 = new CCAProject5();
	
	public static void main(String[] args) {
		
		CCAProject4 app = new CCAProject4();
		app.setPauseOnLostFocus(false);
		app.start();
		
	}

	@Override
	public void bind(Nifty nifty, Screen screen) {
		System.out.println("bind( " + screen.getScreenId() + ")");
	}

	@Override
	public void onStartScreen() {
		System.out.println("onStartScreen");
	}

	@Override
	public void onEndScreen() {
		System.out.println("onEndScreen");
	}
	
	public void quit() {
		System.out.println("quit");
	}

	@Override
	public void simpleInitApp() {

		NiftyJmeDisplay niftyDisplay = NiftyJmeDisplay.newNiftyJmeDisplay(assetManager, inputManager, audioRenderer,
				guiViewPort);
		nifty = niftyDisplay.getNifty();
		nifty.fromXml("FinalProject.xml", "start", this);

		guiViewPort.addProcessor(niftyDisplay);

		flyCam.setEnabled(false);
		flyCam.setDragToRotate(true);
		inputManager.setCursorVisible(true);
		
	}
	
	public void testMethod2() {
		String s = nifty.getCurrentScreen().findNiftyControl("nametextfield", TextField.class).getDisplayedText();
		System.out.println("test method test field, displayed text is " + s);
		System.out.println("testing");
		//cca5.starter(s);
	}
	
	public void testMethodbuttonCancel() {
		System.exit(0);
		
	}

}
