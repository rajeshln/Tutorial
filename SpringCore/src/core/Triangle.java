package core;
public class Triangle {

	private Point pointA,pointB,pointC;

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	
	public void draw(){
		System.out.println(" The Corordinates are :: "+" Point A "+pointA.getX()+" "+pointA.getY());
		System.out.println(" The Corordinates are :: "+" Point B "+pointB.getX()+" "+pointA.getY());
		System.out.println(" The Corordinates are :: "+" Point C "+pointC.getX()+" "+pointA.getY());
	}
}
