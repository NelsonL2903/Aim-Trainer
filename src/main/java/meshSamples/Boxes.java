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
import com.jme3.system.AppSettings;

public class Boxes extends SimpleApplication {
	CameraNode camNode;

	Box boxMesh;
	int N = 4;
	Geometry[] boxGeo = new Geometry[N];
	Material[] materials = new Material[N];
	Node node;
	int timeIndex = 0;
	float boxX = 0;

	public static void main(String[] args) {
		//

		Boxes app = new Boxes();
		AppSettings gameSettings = null;
		gameSettings = new AppSettings(false);
		gameSettings.setResolution(1280, 720);
		gameSettings.setFullscreen(false);
		gameSettings.setVSync(false);
		gameSettings.setTitle("Draw some points");
		gameSettings.setUseInput(true);
		// gameSettings.setFrameRate(500);
		gameSettings.setSamples(0);
		// gameSettings.setRenderer(â€œLWJGL-OpenGL2â€�);
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

		// This mode means that camera copies the movements of the target:
		camNode.setControlDir(ControlDirection.SpatialToCamera);
		// Attach the camNode to the target:
		node = new Node("a node name");

		node.attachChild(camNode);
		// Move camNode, e.g. behind and above the target:
		camNode.setLocalTranslation(new Vector3f(0, 0, -10));
		// Rotate the camNode to look at the target:
		camNode.lookAt(node.getLocalTranslation(), Vector3f.UNIT_Y);

		Material myMaterial = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		myMaterial.getAdditionalRenderState().setWireframe(true);

		myMaterial.setColor("Color", ColorRGBA.Magenta);

		for (int i = 0; i < N; ++i) {
			// create a box
			float scale = (float) i / N + 0.3f;
			boxMesh = new Box(.5f * scale, .2f * scale, 0.3f * scale);
			boxMesh.setMode(Mesh.Mode.LineStrip);

			boxGeo[i] = new Geometry("box", boxMesh);
			materials[i] = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
			materials[i].getAdditionalRenderState().setWireframe(true);

			materials[i].setColor("Color", ColorRGBA.randomColor());
			boxGeo[i].setMaterial(materials[i]);

			node.attachChild(boxGeo[i]);
		}

		rootNode.attachChild(node);
	}

	@Override
	public void simpleUpdate(float tpf) {

		// move the sphere in this function

		float t = timeIndex / 1000f;

		for (int i = 0; i < N; ++i) {
			// some equations to set the x,y position of the sphere
			// these equations will move the sphere along a 3 petal rose pattern
			float r = 1.0f;
			float angle = (float) (t + (float) (i) / (N - 1) / (Math.PI / 4f));
			float x = r * (float) (2 * r * Math.cos(angle));
			float y = r * (float) (2 * r * Math.sin(angle));
			float z = (float) Math.sin(angle * 3);

			Vector3f trans = new Vector3f(x, y, z);
			boxGeo[i].setLocalTranslation(trans);

			// add a rotation to the sphere
			Quaternion q = new Quaternion();

			boxGeo[i].setLocalRotation(q.fromAngles(angle, angle / 2, angle / 4));
			boxGeo[i].setLocalTranslation(trans);
		}
		++timeIndex;
	}
}
