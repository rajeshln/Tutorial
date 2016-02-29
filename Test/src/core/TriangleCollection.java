package core;

import java.util.List;

public class TriangleCollection implements Shape {

	private List <Point> points;

	

	
	public List<Point> getPoints() {
		return points;
	}




	public void setPoints(List<Point> points) {
		this.points = points;
	}




	public void draw(){
		
		for (Point point:points){
		System.out.println(" The Corordinates are from collection :: "+" Point "+point.getX()+" "+point.getY());
		}
	}
}
