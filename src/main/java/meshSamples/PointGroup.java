package meshSamples;

import java.nio.FloatBuffer;
import java.util.Random;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.Node;
import com.jme3.scene.VertexBuffer;
import com.jme3.util.BufferUtils;

public class PointGroup {

	private int numberOfPoints;
	private Mesh mesh = new Mesh();

	private Vector3f[] lineVertices;
	private FloatBuffer floatBuffer;
	private Geometry geometry;
	private Node node;
	private Random randGen = new Random();

	public PointGroup(int numberOfPoints) {
		this.numberOfPoints = numberOfPoints;
		initLineVertices();
	}

	public void initLineVertices() {
		lineVertices = new Vector3f[numberOfPoints];
		for (int i = 0; i < numberOfPoints; ++i) {
			float x = randGen.nextFloat() - 0.5f;
			float y = randGen.nextFloat() - 0.5f;
			float z = randGen.nextFloat() - 0.5f;
			lineVertices[i] = new Vector3f(x, y, z);
		}
	}

	public Mesh getMesh() {
		return mesh;
	}

	public void setMesh(Mesh mesh) {
		this.mesh = mesh;
	}

	public FloatBuffer getFloatBuffer() {
		return floatBuffer;
	}

	public void setFloatBuffer(FloatBuffer floatBuffer) {
		this.floatBuffer = floatBuffer;
	}

	public Vector3f[] getLineVertices() {
		return lineVertices;
	}

	public void setupPoints(AssetManager assetManager, Node rootNode) {
		mesh.setMode(Mesh.Mode.Points);
		floatBuffer = BufferUtils.createFloatBuffer(lineVertices);

		mesh.setBuffer(VertexBuffer.Type.Position, 3, floatBuffer);

		geometry = new Geometry("Points", mesh);
		Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
		mat.setColor("Color", ColorRGBA.Green);
		geometry.setMaterial(mat);

		mesh.updateBound();
		mesh.updateCounts();
		rootNode.attachChild(geometry);

		node = new Node("a node name");

		// if you want, transform (move, rotate, scale) the geometry.
		rootNode.attachChild(node);
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}
}
