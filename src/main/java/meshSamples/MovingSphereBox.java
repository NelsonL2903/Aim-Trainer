package meshSamples;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.CameraNode;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.Node;
import com.jme3.scene.control.CameraControl.ControlDirection;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;
import com.jme3.system.AppSettings;

public class MovingSphereBox extends SimpleApplication {
	CameraNode camNode;
	Sphere sphereMesh;
	Geometry sphereGeo;
	Box boxMesh;
	Geometry boxGeo;
	Node node;
	float direction = .001f;
	int timeIndex = 0;
	float boxX = 0;

	public static void main(String[] args) {
		//

		MovingSphereBox app = new MovingSphereBox();
		AppSettings gameSettings = null;
		gameSettings = new AppSettings(false);
		gameSettings.setResolution(1280, 720);
		gameSettings.setFullscreen(false);
		gameSettings.setVSync(false);
		gameSettings.setTitle("Draw some points");
		gameSettings.setUseInput(true);
		// gameSettings.setFrameRate(500);
		gameSettings.setSamples(0);
		// gameSettings.setRenderer(“LWJGL-OpenGL2”);
		app.settings = gameSettings;
		// app.setShowSettings(false);
		app.start();
	}

	@Override
	public void simpleInitApp() {
		flyCam.setEnabled(false);
		setDisplayStatView(false);
		setDisplayFps(false);

		// create the camera Node
		camNode = new CameraNode("Camera Node", cam);

		initializePoints();

	}

	public void initializePoints() {
		rootNode.detachAllChildren();

		// create a sphere
		sphereMesh = new Sphere(16, 16, 1f);
		sphereMesh.setMode(Mesh.Mode.Lines);

		sphereGeo = new Geometry("sphere", sphereMesh);
		Material myMaterial = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		myMaterial.getAdditionalRenderState().setWireframe(true);

		myMaterial.setColor("Color", ColorRGBA.Magenta);
		sphereGeo.setMaterial(myMaterial);

		// create a box
		boxMesh = new Box(.5f, .2f, 0.3f);
		boxMesh.setMode(Mesh.Mode.LineStrip);

		boxGeo = new Geometry("box", boxMesh);
		Material boxMaterial = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		boxMaterial.getAdditionalRenderState().setWireframe(true);

		boxMaterial.setColor("Color", ColorRGBA.Cyan);
		boxGeo.setMaterial(boxMaterial);

		// This mode means that camera copies the movements of the target:
		camNode.setControlDir(ControlDirection.SpatialToCamera);
		// Attach the camNode to the target:
		node = new Node("a node name");

		node.attachChild(camNode);
		// Move camNode, e.g. behind and above the target:
		camNode.setLocalTranslation(new Vector3f(0, 0, -10));
		// Rotate the camNode to look at the target:
		camNode.lookAt(node.getLocalTranslation(), Vector3f.UNIT_Y);

		node.attachChild(sphereGeo);
		node.attachChild(boxGeo);

		rootNode.attachChild(node);

	}

	@Override
	public void simpleUpdate(float tpf) {

		// move the sphere in this function

		float t = timeIndex / 5000f;

		// some equations to set the x,y position of the sphere
		// these equations will move the sphere along a 3 petal rose pattern
		float r = (float) Math.sin(3 * t);
		float angle = 3 * t;
		float x = r * (float) (2 * r * Math.cos(angle));
		float y = r * (float) (2 * r * Math.sin(angle));

		Vector3f trans = new Vector3f(x, y, 0);
		sphereGeo.setLocalTranslation(trans);

		// add a rotation to the sphere
		Quaternion q = new Quaternion();
		sphereGeo.setLocalRotation(q.fromAngles(angle / 3, angle / 10, angle / 50));

		// move the box
		boxX += direction;
		// System.out.println(boxX);

		float z = (float) Math.sin(angle * 3);

		if (boxX > 6 || boxX < -6) {
			direction = -direction;
		}
		Vector3f boxTrans = new Vector3f(boxX, 0f, z);

		boxGeo.setLocalRotation(q.fromAngles(angle / 3, angle / 10, angle / 50));
		boxGeo.setLocalTranslation(boxTrans);
		++timeIndex;
	}
}
