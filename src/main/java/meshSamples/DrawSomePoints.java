package meshSamples;

//TODO
//options screen
//binary galaxy orbit
//save initial settings
//pan camera around center of mass

import java.nio.FloatBuffer;
import java.util.Random;

import com.jme3.app.SimpleApplication;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.CameraNode;
import com.jme3.scene.VertexBuffer;
import com.jme3.scene.control.CameraControl.ControlDirection;
import com.jme3.system.AppSettings;
import com.jme3.util.BufferUtils;

public class DrawSomePoints extends SimpleApplication {

	private FloatBuffer floatBuffer;
	public Random randGen = new Random();

	int numberOfPoints = 100000;
	PointGroup pointGroup = new PointGroup(numberOfPoints);
	float randomAngle[] = new float[numberOfPoints];

	CameraNode camNode;
	float cameraMoveStep = 0.1f;

	static int timeIndex = 0;

	public static void main(String[] args) {
		//

		DrawSomePoints app = new DrawSomePoints();
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

		pointGroup.setupPoints(assetManager, rootNode);

		// This mode means that camera copies the movements of the target:
		camNode.setControlDir(ControlDirection.SpatialToCamera);
		// Attach the camNode to the target:
		pointGroup.getNode().attachChild(camNode);
		// Move camNode, e.g. behind and above the target:
		camNode.setLocalTranslation(new Vector3f(0, 0, -2));
		// Rotate the camNode to look at the target:
		camNode.lookAt(pointGroup.getNode().getLocalTranslation(), Vector3f.UNIT_Y);

		// choose an initial random direction of movement for each particle
		for (int i = 0; i < numberOfPoints; ++i) {
			randomAngle[i] = (float) (randGen.nextFloat() * 2 * Math.PI);
		}

	}

	@Override
	public void simpleUpdate(float tpf) {
		if (timeIndex % 50 == 0) {
			for (int i = 0; i < numberOfPoints; ++i) {
				// choose a new direction every 50 steps
				randomAngle[i] += (float) (randGen.nextFloat() * 2 * Math.PI - Math.PI) / 4f;
			}
		}
		++timeIndex;

		// move the points in some random direction
		for (int i = 0; i < numberOfPoints; ++i) {
			Vector3f vertex = pointGroup.getLineVertices()[i];
			float dx = 0.0005f * (float) Math.cos(randomAngle[i]);
			float dy = 0.0005f * (float) Math.sin(randomAngle[i]);
			vertex.setX(vertex.getX() + dx);
			vertex.setY(vertex.getY() + dy);
		}
	}

	@Override
	public void simpleRender(RenderManager rm) {
		floatBuffer = BufferUtils.createFloatBuffer(pointGroup.getLineVertices());
		pointGroup.getMesh().setBuffer(VertexBuffer.Type.Position, 3, floatBuffer);
		pointGroup.getMesh().updateBound();
	}
}