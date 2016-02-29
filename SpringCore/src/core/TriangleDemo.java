package core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TriangleDemo {

	
	public static void main(String args[]){
		
		ApplicationContext context = new ClassPathXmlApplicationContext();
		Triangle triangle = (Triangle) context.getBean("triangleBean");
		triangle.draw();
	}
}
