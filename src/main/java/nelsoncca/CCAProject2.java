package nelsoncca;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.jme3.app.SimpleApplication;
import com.jme3.audio.AudioNode;
import com.jme3.collision.CollisionResult;
import com.jme3.collision.CollisionResults;
import com.jme3.font.BitmapText;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Ray;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;
import com.jme3.ui.*;

public class CCAProject2 extends SimpleApplication implements ActionListener{
	//TODO reload sounds
	//TODO shooting sounds
	
	Node setNode = new Node("Setting Node");
	float x;
	float y;
	float z;
	Boolean left = false;
	Boolean lshift = false;
	Boolean croucht = false;
	Boolean pistol = false;
	Boolean rifle = false;
	Boolean f = false;
	Boolean r = false;
	private Node shootables;
	int secondones = 0;
	int secondtens = 0;
	int minuteones = 0;
	int minutetens = 0;
	int milisecondones = 0;
	int milisecondtens = 0;
	BitmapText timer;
	BitmapText rscore;
	BitmapText topscores;
	BitmapText topscores2;
	BitmapText topscores3;
	BitmapText topscores4;
	BitmapText topscores5;
	BitmapText pbscore;
	Picture pic;
	Picture pic3;
	int bcount;
	int rbcount;
	int i;
	Random randomGenerator = new Random();
    int xlow = -15;
    int xhigh = 19;
    int ylow = -2;
    int yhigh = 16;
    int zlow = -55;
    int zhigh = -24;
    Geometry shot;
    Picture pic4;
    int target1c = 0;
    int target2c = 0;
    int target3c = 0;
    int target4c = 0;
    int target5c = 0;
    int target6c = 0;
    int target7c = 0;
    int target8c = 0;
    int gun = 1;
    static String name;
    private List<String> scores = new ArrayList<String>();
    private List<String> nscores = new ArrayList<String>();
    private List<String> lgscores = new ArrayList<String>();
    static Path path = Paths.get("highscores.txt");
	
	public static void main(final String[] args) {
		final CCAProject2 app = new CCAProject2();
		System.out.println("Please enter your name, then click enter to begin the game! If you have played previously, please use the same name as before.");
		Scanner keyboard = new Scanner(System.in);
		name = keyboard.nextLine();
		keyboard.close();
		app.start();
	}

	@Override
	public void simpleInitApp() {
		
		rootNode.attachChild(setNode);
		shootables = new Node("Shootables");
	    rootNode.attachChild(shootables);
	    shootables.attachChild(Targetbox("target1",
	    		randomGenerator.nextInt(xhigh - xlow) + xlow,
	    		randomGenerator.nextInt(yhigh - ylow) + ylow,
	    		randomGenerator.nextInt(zhigh - zlow) + zlow));
	    shootables.attachChild(Targetbox("target2",
	    		randomGenerator.nextInt(xhigh - xlow) + xlow,
	    		randomGenerator.nextInt(yhigh - ylow) + ylow,
	    		randomGenerator.nextInt(zhigh - zlow) + zlow));
	    shootables.attachChild(Targetbox("target3",
	    	    randomGenerator.nextInt(xhigh - xlow) + xlow,
	    		randomGenerator.nextInt(yhigh - ylow) + ylow,
	    		randomGenerator.nextInt(zhigh - zlow) + zlow));
	    shootables.attachChild(Targetbox("target4",
	    	    randomGenerator.nextInt(xhigh - xlow) + xlow,
	    		randomGenerator.nextInt(yhigh - ylow) + ylow,
	    		randomGenerator.nextInt(zhigh - zlow) + zlow));
	    shootables.attachChild(Targetbox("target5",
	    	    randomGenerator.nextInt(xhigh - xlow) + xlow,
	    		randomGenerator.nextInt(yhigh - ylow) + ylow,
	    		randomGenerator.nextInt(zhigh - zlow) + zlow));
	    shootables.attachChild(Targetbox("target6",
	    	    randomGenerator.nextInt(xhigh - xlow) + xlow,
	    		randomGenerator.nextInt(yhigh - ylow) + ylow,
	    		randomGenerator.nextInt(zhigh - zlow) + zlow));
	    shootables.attachChild(Targetbox("target7",
	    	    randomGenerator.nextInt(xhigh - xlow) + xlow,
	    		randomGenerator.nextInt(yhigh - ylow) + ylow,
	    		randomGenerator.nextInt(zhigh - zlow) + zlow));
	    shootables.attachChild(Targetbox("target8",
	    	    randomGenerator.nextInt(xhigh - xlow) + xlow,
	    		randomGenerator.nextInt(yhigh - ylow) + ylow,
	    		randomGenerator.nextInt(zhigh - zlow) + zlow));
		
		initKeys();
		Background back = new Background(assetManager, guiNode, guiFont, setNode);
		back.init();
		
		flyCam.setMoveSpeed(15);
		setDisplayStatView(false);
		setDisplayFps(false);
		
		pic = new Picture("HUD Picture");
		pic.setImage(assetManager, "nerfgun (1).png", true);
		pic.setWidth(settings.getWidth()/2);
		pic.setHeight(settings.getHeight()/2);
		pic.setPosition(1250, 100);
		guiNode.attachChild(pic);
		
		pic3 = new Picture("HUD Picture");
		pic3.setImage(assetManager, "Output.png", true);
		pic3.setWidth(150);
		pic3.setHeight(100);
		pic3.setPosition(1300, 175);
		guiNode.attachChild(pic3);
		
		pic4 = new Picture("HUD Picture");
		pic4.setImage(assetManager, "bcount6.png", true);
		pic4.setWidth(150);
		pic4.setHeight(200);
		pic4.setPosition(1300, 25);
		guiNode.attachChild(pic4);
		
		timer = new BitmapText(guiFont, false);
		timer.setSize(50);
		timer.setColor(ColorRGBA.Red);
		timer.setText("" + minutetens + minuteones + ":" + secondtens + secondones
				+ ":" + milisecondtens + milisecondones);
		timer.setLocalTranslation(50, timer.getLineHeight(), 0);
		guiNode.attachChild(timer);
		
		rscore = new BitmapText(guiFont, false);
		rscore.setSize(30);
		rscore.setColor(ColorRGBA.Black);
		rscore.setText("" + minutetens + minuteones + ":" + secondtens + secondones
				+ ":" + milisecondtens + milisecondones);
		rscore.setLocalTranslation(50, 250, 0);
		guiNode.attachChild(rscore);
		
		BitmapText loggedin = new BitmapText(guiFont, false);
		loggedin.setSize(30);
		loggedin.setColor(ColorRGBA.Red);
		loggedin.setText("Logged in as " + name);
		loggedin.setLocalTranslation(50, 1050, 0);
		guiNode.attachChild(loggedin);
		
		try {
			lgscores = Files.readAllLines(path);
				} catch (IOException e) {
					e.printStackTrace();
				}
		Collections.sort(lgscores);
		
		pbscore = new BitmapText(guiFont, false);
		pbscore.setSize(30);
		pbscore.setColor(ColorRGBA.Black);
		pbscore.setText("");
		pbscore.setLocalTranslation(50, 350, 0);
		guiNode.attachChild(pbscore);
		
		int k = 0;
		for (String i : lgscores) {
			if (i.substring(6).equals(name)) {
				pbscore.setText(lgscores.get(k).substring(0,2) + ":"
					+ lgscores.get(k).substring(2,4)
					+ ":" + lgscores.get(k).substring(4,6));
				break;
		}
			++k;
		}
		
		topscores = new BitmapText(guiFont, false);
		topscores.setSize(30);
		topscores.setColor(ColorRGBA.Black);
		topscores.setText(lgscores.get(0).substring(6)
				+ " " + lgscores.get(0).substring(0,2) + ":"
				+ lgscores.get(0).substring(2,4)
				+ ":" + lgscores.get(0).substring(4,6));;
		topscores.setLocalTranslation(50, 650, 0);
		guiNode.attachChild(topscores);
		
		topscores2 = new BitmapText(guiFont, false);
		topscores2.setSize(30);
		topscores2.setColor(ColorRGBA.Black);
		topscores2.setText(lgscores.get(1).substring(6)
				+ " " + lgscores.get(1).substring(0,2) + ":"
				+ lgscores.get(1).substring(2,4)
				+ ":" + lgscores.get(1).substring(4,6));
		topscores2.setLocalTranslation(50, 600, 0);
		guiNode.attachChild(topscores2);
		
		topscores3 = new BitmapText(guiFont, false);
		topscores3.setSize(30);
		topscores3.setColor(ColorRGBA.Black);
		topscores3.setText(lgscores.get(2).substring(6)
				+ " " + lgscores.get(2).substring(0,2) + ":"
				+ lgscores.get(2).substring(2,4)
				+ ":" + lgscores.get(2).substring(4,6));
		topscores3.setLocalTranslation(50, 550, 0);
		guiNode.attachChild(topscores3);
		
		topscores4 = new BitmapText(guiFont, false);
		topscores4.setSize(30);
		topscores4.setColor(ColorRGBA.Black);
		topscores4.setText(lgscores.get(3).substring(6)
				+ " " + lgscores.get(3).substring(0,2) + ":"
				+ lgscores.get(3).substring(2,4)
				+ ":" + lgscores.get(3).substring(4,6));
		topscores4.setLocalTranslation(50, 500, 0);
		guiNode.attachChild(topscores4);
		
		topscores5 = new BitmapText(guiFont, false);
		topscores5.setSize(30);
		topscores5.setColor(ColorRGBA.Black);
		topscores5.setText(lgscores.get(4).substring(6)
				+ " " + lgscores.get(4).substring(0,2) + ":"
				+ lgscores.get(4).substring(2,4)
				+ ":" + lgscores.get(4).substring(4,6));
		topscores5.setLocalTranslation(50, 450, 0);
		guiNode.attachChild(topscores5);
		
		bcount = 6;
		rbcount = 6;
		
		cam.setLocation(new Vector3f(0,0,5));
		getCamera().lookAt(Vector3f.ZERO, Vector3f.UNIT_Y);
		cam.lookAtDirection(new Vector3f(0,0,-10), new Vector3f(0,0,0));
        
	}
	
	private void initKeys() {
		inputManager.addMapping("Shoot", new MouseButtonTrigger(MouseInput.BUTTON_LEFT));
		inputManager.addMapping("Crouch", new KeyTrigger(KeyInput.KEY_LSHIFT));
		inputManager.addMapping("Reset", new KeyTrigger(KeyInput.KEY_F));
		inputManager.addMapping("Reload", new KeyTrigger(KeyInput.KEY_R));
		inputManager.addMapping("Pistol", new KeyTrigger(KeyInput.KEY_1));
		inputManager.addMapping("Rifle", new KeyTrigger(KeyInput.KEY_2));
		inputManager.addListener(this, "Shoot");
		inputManager.addListener(this, "Crouch");
		inputManager.addListener(this, "Reset");
		inputManager.addListener(this, "Reload");
		inputManager.addListener(this, "Pistol");
		inputManager.addListener(this, "Rifle");
	}

	@Override
	public void onAction(String binding, boolean isPressed, float tpf) {
		if (binding.equals("Shoot")) {
			left = isPressed;
		} else if (binding.equals("Crouch")) {
			lshift = isPressed;
		} else if (binding.equals("Reset")) {
			f = isPressed;
		} else if (binding.equals("Reload")) {
			r = isPressed;
		} else if (binding.equals("Pistol")) {
			pistol = isPressed;
		} else if (binding.equals("Rifle")) {
			rifle = isPressed;
		}
	}
	
	protected Geometry Targetbox(String name, float x, float y, float z) {
	    Box box = new Box(1, 1, 0.025f);
	    Geometry cube = new Geometry(name, box);
	    cube.setLocalTranslation(x, y, z);
	    Material mat1 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
	    mat1.setTexture("ColorMap", assetManager.loadTexture("target.png"));
	    mat1.setColor("Color", ColorRGBA.White);
	    cube.setMaterial(mat1);
	    return cube;
	  }
	
	public void simpleUpdate(float tpf) {
		
		if (cam.getLocation().getX() > 8) {
			cam.setLocation(new Vector3f(7.9f, cam.getLocation().getY(), cam.getLocation().getZ()));
		}
		
		if (cam.getLocation().getX() < -8) {
			cam.setLocation(new Vector3f(-7.9f, cam.getLocation().getY(), cam.getLocation().getZ()));
		}
		
		if (cam.getLocation().getZ() < -8) {
			cam.setLocation(new Vector3f(cam.getLocation().getX(), cam.getLocation().getY(), -7.9f));
		}
		
		if (cam.getLocation().getZ() > 8) {
			cam.setLocation(new Vector3f(cam.getLocation().getX(), cam.getLocation().getY(), 7.9f));
		}
		
		if (left) {
			left = false;
			if (bcount > 0 && gun == 1) {
				Sphere sphere = new Sphere(5, 5, 0.2f);
			    shot = new Geometry("shoot", sphere);
			    Material shotmat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
			    shotmat.setColor("Color", ColorRGBA.Black);
			    shot.setMaterial(shotmat);
			    
			    AudioNode shotnoise = new AudioNode(assetManager, "pew.wav");
			    shotnoise.setVolume(1000);
			    shotnoise.play();
			    
			    bcount = bcount - 1;
			    
			CollisionResults results = new CollisionResults();
			Ray ray = new Ray(cam.getLocation(), cam.getDirection());
			shootables.collideWith(ray, results);
			for (i = 0; i < results.size(); i++) {
			results.getCollision(i).getGeometry().getMaterial().setColor("Color", ColorRGBA.Green);
			switch (results.getCollision(i).getGeometry().getName()) {
			case "target1": 
				target1c = 1;
				break;
			case "target2": 
				target2c = 1;
				break;
			case "target3": 
				target3c = 1;
				break;
			case "target4": 
				target4c = 1;
				break;
			case "target5": 
				target5c = 1;
				break;
			case "target6": 
				target6c = 1;
				break;
			case "target7": 
				target7c = 1;
				break;
			case "target8": 
				target8c = 1;
				break;
			default:
				break;
			}
			
			}
			if (results.size() > 0) {
				 CollisionResult closest = results.getClosestCollision();
				 shot.setLocalTranslation(closest.getContactPoint());
		          rootNode.attachChild(shot);
		        } else {
		          rootNode.detachChild(shot);
		}
		
	} else if (rbcount > 0 && gun == 2) {

		Sphere sphere = new Sphere(5, 5, 0.2f);
	    shot = new Geometry("shoot", sphere);
	    Material shotmat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
	    shotmat.setColor("Color", ColorRGBA.Black);
	    shot.setMaterial(shotmat);
	    
	    AudioNode shotnoise = new AudioNode(assetManager, "pew.wav");
	    shotnoise.setVolume(1000);
	    shotnoise.play();
	    
	    rbcount = rbcount - 1;
	    
	CollisionResults results = new CollisionResults();
	Ray ray = new Ray(cam.getLocation(), cam.getDirection());
	shootables.collideWith(ray, results);
	for (i = 0; i < results.size(); i++) {
	results.getCollision(i).getGeometry().getMaterial().setColor("Color", ColorRGBA.Green);
	switch (results.getCollision(i).getGeometry().getName()) {
	case "target1": 
		target1c = 1;
		break;
	case "target2": 
		target2c = 1;
		break;
	case "target3": 
		target3c = 1;
		break;
	case "target4": 
		target4c = 1;
		break;
	case "target5": 
		target5c = 1;
		break;
	case "target6": 
		target6c = 1;
		break;
	case "target7": 
		target7c = 1;
		break;
	case "target8": 
		target8c = 1;
		break;
	default:
		break;
	}
	
	}
	if (results.size() > 0) {
		 CollisionResult closest = results.getClosestCollision();
		 shot.setLocalTranslation(closest.getContactPoint());
          rootNode.attachChild(shot);
        } else {
          rootNode.detachChild(shot);
}


	}
		}
		
		if (lshift) {
			lshift = false;
			if (croucht == true) {
				croucht = false;
			} else {
				croucht = true;
			}
		}
		if (croucht == true) {
			cam.setLocation(new Vector3f(cam.getLocation().getX(), -2f, cam.getLocation().getZ()));
			flyCam.setMoveSpeed(5);
		} else {
			cam.setLocation(new Vector3f(cam.getLocation().getX(), 0f, cam.getLocation().getZ()));
			flyCam.setMoveSpeed(15);
		}
		
		try {
			TimeUnit.MILLISECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		milisecondones = milisecondones + 1;
		if (milisecondones == 10) {
			milisecondones = milisecondones - 10;
			milisecondtens = milisecondtens + 1;
			if (milisecondtens == 10) {
				milisecondtens = milisecondtens - 10;
				secondones = secondones + 1;
				if (secondones == 10) {
					secondones = secondones - 10;
					secondtens = secondtens + 1;
					if (secondtens == 6) {
						secondtens = secondtens - 6;
						minuteones = minuteones + 1;
						if (minuteones == 10) {
							minuteones = minuteones - 10;
							minutetens = minutetens + 1;
						}}}}}
		
		timer.setText("" + minutetens + minuteones + ":" + secondtens + secondones
				+ ":" + milisecondtens + milisecondones);
		
		if (r == true) {
			r = false;
			bcount = 6;
			rbcount = 6;
		}
		
		if (f == true) {
			f = false;
			
			target1c = 0;
		    target2c = 0;
		    target3c = 0;
		    target4c = 0;
		    target5c = 0;
		    target6c = 0;
		    target7c = 0;
		    target8c = 0;
			
			secondones = 0;
			secondtens = 0;
			minuteones = 0;
			minutetens = 0;
			milisecondones = 0;
			milisecondtens = 0;
			
			bcount = 6;
			rbcount = 6;
			
			rootNode.detachAllChildren();
			rootNode.attachChild(shootables);
			rootNode.attachChild(setNode);
			
			shootables.detachAllChildren();
			shootables.attachChild(Targetbox("target1",
		    		randomGenerator.nextInt(xhigh - xlow) + xlow,
		    		randomGenerator.nextInt(yhigh - ylow) + ylow,
		    		randomGenerator.nextInt(zhigh - zlow) + zlow));
		    shootables.attachChild(Targetbox("target2",
		    		randomGenerator.nextInt(xhigh - xlow) + xlow,
		    		randomGenerator.nextInt(yhigh - ylow) + ylow,
		    		randomGenerator.nextInt(zhigh - zlow) + zlow));
		    shootables.attachChild(Targetbox("target3",
		    	    randomGenerator.nextInt(xhigh - xlow) + xlow,
		    		randomGenerator.nextInt(yhigh - ylow) + ylow,
		    		randomGenerator.nextInt(zhigh - zlow) + zlow));
		    shootables.attachChild(Targetbox("target4",
		    	    randomGenerator.nextInt(xhigh - xlow) + xlow,
		    		randomGenerator.nextInt(yhigh - ylow) + ylow,
		    		randomGenerator.nextInt(zhigh - zlow) + zlow));
		    shootables.attachChild(Targetbox("target5",
		    	    randomGenerator.nextInt(xhigh - xlow) + xlow,
		    		randomGenerator.nextInt(yhigh - ylow) + ylow,
		    		randomGenerator.nextInt(zhigh - zlow) + zlow));
		    shootables.attachChild(Targetbox("target6",
		    	    randomGenerator.nextInt(xhigh - xlow) + xlow,
		    		randomGenerator.nextInt(yhigh - ylow) + ylow,
		    		randomGenerator.nextInt(zhigh - zlow) + zlow));
		    shootables.attachChild(Targetbox("target7",
		    	    randomGenerator.nextInt(xhigh - xlow) + xlow,
		    		randomGenerator.nextInt(yhigh - ylow) + ylow,
		    		randomGenerator.nextInt(zhigh - zlow) + zlow));
		    shootables.attachChild(Targetbox("target8",
		    	    randomGenerator.nextInt(xhigh - xlow) + xlow,
		    		randomGenerator.nextInt(yhigh - ylow) + ylow,
		    		randomGenerator.nextInt(zhigh - zlow) + zlow));
		    
		}
		
		if (pistol) {
			pistol = false;
			gun = 1;
			pic.setImage(assetManager, "nerfgun (1).png", true);
			pic.setWidth(settings.getWidth()/2);
			pic.setHeight(settings.getHeight()/2);
			pic.setPosition(1250, 100);
			
			pic3.setImage(assetManager, "Output.png", true);
			pic3.setWidth(150);
			pic3.setHeight(100);
			pic3.setPosition(1300, 175);
			
		} else if (rifle) {
			rifle = false;
			gun = 2;
			pic.setImage(assetManager, "arifle2.png", true);
			pic.setWidth(settings.getWidth()/2);
			pic.setHeight(settings.getHeight()/2);
			pic.setPosition(1300, 175);
			
			pic3.setImage(assetManager, "Output (3).png", true);
			pic3.setWidth(175);
			pic3.setHeight(125);
			pic3.setPosition(1310, 175);
		}
		
		if (gun == 1) {
		if (bcount == 0) {
			pic4.setImage(assetManager, "bcount0.png", true);
		} else if (bcount == 1) {
			pic4.setImage(assetManager, "bcount1.png", true);
		} else if (bcount == 2) {
			pic4.setImage(assetManager, "bcount2.png", true);
		} else if (bcount == 3) {
			pic4.setImage(assetManager, "bcount3.png", true);
		} else if (bcount == 4) {
			pic4.setImage(assetManager, "bcount4.png", true);
		} else if (bcount == 5) {
			pic4.setImage(assetManager, "bcount5.png", true);
		} else if (bcount == 6) {
			pic4.setImage(assetManager, "bcount6.png", true);
		}
		} else if (gun == 2){
			if (rbcount == 0) {
				pic4.setImage(assetManager, "bcount0.png", true);
			} else if (rbcount == 1) {
				pic4.setImage(assetManager, "bcount1.png", true);
			} else if (rbcount == 2) {
				pic4.setImage(assetManager, "bcount2.png", true);
			} else if (rbcount == 3) {
				pic4.setImage(assetManager, "bcount3.png", true);
			} else if (rbcount == 4) {
				pic4.setImage(assetManager, "bcount4.png", true);
			} else if (rbcount == 5) {
				pic4.setImage(assetManager, "bcount5.png", true);
			} else if (rbcount == 6) {
				pic4.setImage(assetManager, "bcount6.png", true);
			}
		}
		if (target1c + target2c + target3c + target4c + target5c + target6c + target7c + target8c == 8) {
			rscore.setText("" + minutetens + minuteones + ":" + secondtens + secondones
				+ ":" + milisecondtens + milisecondones);
			String fscore = "" + minutetens + minuteones + secondtens + secondones
							+ milisecondtens + milisecondones + name;
			
			try {
				scores = Files.readAllLines(path);
					} catch (IOException e) {
						e.printStackTrace();
					}
			scores.add(fscore);
			try {
				Files.write(path, scores);
				} catch (IOException e) {
					e.printStackTrace();
				}
		
			nscores.clear();
			for (String j : scores) {
				nscores.add(j);
			}
			Collections.sort(nscores);
			
			int k = 0;
			for (String i : nscores) {
				if (i.substring(6).equals(name)) {
					pbscore.setText(nscores.get(k).substring(0,2) + ":"
						+ nscores.get(k).substring(2,4)
						+ ":" + nscores.get(k).substring(4,6));
					break;
			}
				++k;
			}
			
			topscores.setText(nscores.get(0).substring(6)
					+ " " + nscores.get(0).substring(0,2) + ":"
					+ nscores.get(0).substring(2,4)
					+ ":" + nscores.get(0).substring(4,6));
			topscores2.setText(nscores.get(1).substring(6)
					+ " " + nscores.get(1).substring(0,2) + ":"
					+ nscores.get(1).substring(2,4)
					+ ":" + nscores.get(1).substring(4,6));
			topscores3.setText(nscores.get(2).substring(6)
					+ " " + nscores.get(2).substring(0,2) + ":"
					+ nscores.get(2).substring(2,4)
					+ ":" + nscores.get(2).substring(4,6));
			topscores4.setText(nscores.get(3).substring(6)
					+ " " + nscores.get(3).substring(0,2) + ":"
					+ nscores.get(3).substring(2,4)
					+ ":" + nscores.get(3).substring(4,6));
			topscores5.setText(nscores.get(4).substring(6)
					+ " " + nscores.get(4).substring(0,2) + ":"
					+ nscores.get(4).substring(2,4)
					+ ":" + nscores.get(4).substring(4,6));
			
			f = true;
		}
		
}
}
