package aim_trainer_game;

import com.jme3.asset.AssetManager;
import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.ui.Picture;

public class Background {

	AssetManager assetManager;
	Node guiNode;
	BitmapFont guiFont;
	Node setNode;
	
	public Background(AssetManager assetManager, Node guiNode, BitmapFont guiFont, Node setNode) {
		this.assetManager = assetManager;
		this.guiNode = guiNode;
		this.guiFont = guiFont;
		this.setNode = setNode;
	}

	//initializes the text on screen which doen't change and the background/setting
	public void init() {
	
	//creates the picture of the crosshair on screen
	Picture pic2 = new Picture("HUD Picture");
	pic2.setImage(assetManager, "crosshair.png", true);
	pic2.setWidth(50);
	pic2.setHeight(50);
	pic2.setPosition(935, 515);
	guiNode.attachChild(pic2);
	
	//prints out the text "Most Recent Score" on screen
	BitmapText mostrecent = new BitmapText(guiFont, false);
	mostrecent.setSize(30);
	mostrecent.setColor(ColorRGBA.Red);
	mostrecent.setText("Most Recent Score");
	mostrecent.setLocalTranslation(50, 300, 0);
	guiNode.attachChild(mostrecent);
	
	//prints out the text "Highscores" on screen
	BitmapText highscore = new BitmapText(guiFont, false);
	highscore.setSize(30);
	highscore.setColor(ColorRGBA.Red);
	highscore.setText("Highscores");
	highscore.setLocalTranslation(50, 700, 0);
	guiNode.attachChild(highscore);
	
	//prints out the text "Personal Best" on screen
	BitmapText pb = new BitmapText(guiFont, false);
	pb.setSize(30);
	pb.setColor(ColorRGBA.Red);
	pb.setText("Personal Best");
	pb.setLocalTranslation(50, 400, 0);
	guiNode.attachChild(pb);
	
	//the next few blocks of code print out the controls on screen
	BitmapText shoot = new BitmapText(guiFont, false);
	shoot.setSize(20);
	shoot.setColor(ColorRGBA.Black);
	shoot.setText("Left-Click = Shoot");
	shoot.setLocalTranslation(50, 1000, 0);
	guiNode.attachChild(shoot);
	
	BitmapText forward = new BitmapText(guiFont, false);
	forward.setSize(20);
	forward.setColor(ColorRGBA.Black);
	forward.setText("W = Move Forward");
	forward.setLocalTranslation(50, shoot.getLocalTranslation().getY() - 30, 0);
	guiNode.attachChild(forward);
	
	BitmapText backward = new BitmapText(guiFont, false);
	backward.setSize(20);
	backward.setColor(ColorRGBA.Black);
	backward.setText("S = Move Backward");
	backward.setLocalTranslation(50, forward.getLocalTranslation().getY() - 30, 0);
	guiNode.attachChild(backward);
	
	BitmapText left = new BitmapText(guiFont, false);
	left.setSize(20);
	left.setColor(ColorRGBA.Black);
	left.setText("A = Move Left");
	left.setLocalTranslation(50, backward.getLocalTranslation().getY() - 30, 0);
	guiNode.attachChild(left);
	
	BitmapText right = new BitmapText(guiFont, false);
	right.setSize(20);
	right.setColor(ColorRGBA.Black);
	right.setText("D = Move Right");
	right.setLocalTranslation(50, left.getLocalTranslation().getY() - 30, 0);
	guiNode.attachChild(right);
	
	BitmapText reload = new BitmapText(guiFont, false);
	reload.setSize(20);
	reload.setColor(ColorRGBA.Black);
	reload.setText("R = Reload");
	reload.setLocalTranslation(50, right.getLocalTranslation().getY() - 30, 0);
	guiNode.attachChild(reload);
	
	BitmapText crouch = new BitmapText(guiFont, false);
	crouch.setSize(20);
	crouch.setColor(ColorRGBA.Black);
	crouch.setText("Shift = Crouch");
	crouch.setLocalTranslation(50, reload.getLocalTranslation().getY() - 30, 0);
	guiNode.attachChild(crouch);
	
	BitmapText reset = new BitmapText(guiFont, false);
	reset.setSize(20);
	reset.setColor(ColorRGBA.Black);
	reset.setText("F = Reset");
	reset.setLocalTranslation(50, crouch.getLocalTranslation().getY() - 30, 0);
	guiNode.attachChild(reset);
	
	BitmapText pistolt = new BitmapText(guiFont, false);
	pistolt.setSize(20);
	pistolt.setColor(ColorRGBA.Black);
	pistolt.setText("1 = Equip Pistol");
	pistolt.setLocalTranslation(50, reset.getLocalTranslation().getY() - 30, 0);
	guiNode.attachChild(pistolt);
	
	BitmapText riflet = new BitmapText(guiFont, false);
	riflet.setSize(20);
	riflet.setColor(ColorRGBA.Black);
	riflet.setText("2 = Equip Rifle");
	riflet.setLocalTranslation(50, pistolt.getLocalTranslation().getY() - 30, 0);
	guiNode.attachChild(riflet);
	
	//the next few blocks of code create the background/setting of the game
	Box a = new Box(new Vector3f(0,-5,0), 10, 0.5f, 10);
	Geometry floor = new Geometry("Box", a);
    Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
    mat.setTexture("ColorMap", assetManager.loadTexture("floor.jpg"));
	mat.setColor("Color", ColorRGBA.White);
	floor.setMaterial(mat);
	setNode.attachChild(floor);
	
	Box b = new Box(new Vector3f(10,5,0), 0.5f, 10f, 10f);
	Geometry wall = new Geometry("Box", b);
    Material mat2 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
    mat2.setTexture("ColorMap", assetManager.loadTexture("woodpanelling.jpg"));
	mat2.setColor("Color", ColorRGBA.White);
	wall.setMaterial(mat2);
	setNode.attachChild(wall);

	Box c = new Box(new Vector3f(-10,5,0), 0.5f, 10f, 10f);
	Geometry wall2 = new Geometry("Box", c);
    Material mat3 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
    mat3.setTexture("ColorMap", assetManager.loadTexture("woodpanelling.jpg"));
	mat3.setColor("Color", ColorRGBA.White);
	wall2.setMaterial(mat3);
	setNode.attachChild(wall2);
	
	Box d = new Box(new Vector3f(0,5,10), 10f, 10f, 0.5f);
	Geometry wall3 = new Geometry("Box", d);
    Material mat4 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
    mat4.setTexture("ColorMap", assetManager.loadTexture("woodpanelling.jpg"));
	mat4.setColor("Color", ColorRGBA.White);
	wall3.setMaterial(mat4);
	setNode.attachChild(wall3);
	
	Box e = new Box(new Vector3f(0,15,0), 10f, 0.5f, 10f);
	Geometry roof = new Geometry("Box", e);
    Material mat5 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
    mat5.setTexture("ColorMap", assetManager.loadTexture("sheetm.jpg"));
	mat5.setColor("Color", ColorRGBA.White);
	roof.setMaterial(mat5);
	setNode.attachChild(roof);
	
	Box f = new Box(new Vector3f(0,-3.5f,-10), 10f, 1.5f, 0.5f);
	Geometry counter = new Geometry("Box", f);
    Material mat6 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
    mat6.setTexture("ColorMap", assetManager.loadTexture("cc.jpg"));
	mat6.setColor("Color", ColorRGBA.White);
	counter.setMaterial(mat6);
	setNode.attachChild(counter);
	
	Box g = new Box(new Vector3f(0,-3,-75), 100f, 100f, 0.5f);
	Geometry background = new Geometry("Box", g);
    Material mat7 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
    mat7.setTexture("ColorMap", assetManager.loadTexture("concrete.jpg"));
	mat7.setColor("Color", ColorRGBA.White);
	background.setMaterial(mat7);
	setNode.attachChild(background);
	
	Box h = new Box(new Vector3f(0, 100, 0), 100f, 0.5f, 100f);
	Geometry sky = new Geometry("Box", h);
    Material mat8 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
    mat8.setTexture("ColorMap", assetManager.loadTexture("concrete.jpg"));
	mat8.setColor("Color", ColorRGBA.White);
	sky.setMaterial(mat8);
	setNode.attachChild(sky);
	
	Box i = new Box(new Vector3f(75, -3, 0), 0.5f, 100f, 100f);
	Geometry background2 = new Geometry("Box", i);
    Material mat9 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
    mat9.setTexture("ColorMap", assetManager.loadTexture("concrete.jpg"));
	mat9.setColor("Color", ColorRGBA.White);
	background2.setMaterial(mat9);
	setNode.attachChild(background2);
	
	Box j = new Box(new Vector3f(-75, -3, 0), 0.5f, 100f, 100f);
	Geometry background3 = new Geometry("Box", j);
    Material mat10 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
    mat10.setTexture("ColorMap", assetManager.loadTexture("concrete.jpg"));
	mat10.setColor("Color", ColorRGBA.White);
	background3.setMaterial(mat10);
	setNode.attachChild(background3);

	}
}
