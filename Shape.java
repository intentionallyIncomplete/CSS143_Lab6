import java.awt.*;
/**
 * Class Description:
 * @author Ian Bryan
 * @version 10/29/2018
 * 
 * Super class to all shapes created from this structure.
 */
class Shape extends Object {
	/*Class instance data members*/
	private int x = 0;
	private int y = 0;
	Color myColor = new Color(214,21,37);
	
	/**
	 * @param a
	 * @param b
	 * 
	 * Assigns x,y values from handed a,b coordinate plane.
	 */
	public Shape( int a, int b ) {
		x = a;
		y = b;
	}
	
	/**
	 * @return
	 * Returns -1 and is overridden by subclasses to generate
	 * a value for the subclass's shape.
	 */
	public double getArea(){ return -1; }
	
	/**
	 * @param g
	 * Used to override and draw graphics on screen in JPanel.
	 */
	public void draw( Graphics g ){}
	
	/*Getters for values of X and Y*/
	public int getX() { return x; }
	public int getY() { return y; }
	
	/*Setters for X and Y values*/
	public void setX(int x) {	this.x = x;	}
	public void setY(int y) {	this.y = y;	}
}