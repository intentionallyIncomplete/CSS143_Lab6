import java.awt.Graphics;

/**
 * Class Description:
 * @author Ian Bryan
 * @version 11/05/2018
 * 
 * This class represents a snowflake that is drawn on the canvas using
 * some recursive nature.
 */
public class FractalFlake extends Shape{
	/*Class level data members declared final so they are not changed*/
	private final int limit;
	private final int numBranches;

	/**
	 * @param size
	 * @param branches
	 */
	public FractalFlake(int x, int y, int size, int branches) {
		super(x,y);
		this.limit = size;
		this.numBranches = branches;
	}

	/**
	 * @param g - Represents a Graphics object
	 * Overrides the parent class draw() method.
	 * Makes a call to another draw() method which has a matching signature
	 * for the parameters given.
	 * */
	@Override
	public void draw(Graphics g) {
		draw(g,getX(), getY(),limit);
	}

	/**
	 * @param g
	 * @param x
	 * @param y
	 * @param limit
	 * 
	 * Takes in parameters given from the Overridden draw() method above. Each value
	 * is assigned and processed into a drawn output.
	 */
	private void draw(Graphics g, int x, int y, int limit) {
		if(limit>= 3) {
			for ( int i = 0; i < numBranches; i++ )
			{
				int x2 = x + (int) (limit *
						Math.cos( (2 * Math.PI / numBranches) * i ));
				int y2 = y - (int) (limit *
						Math.sin( (2 * Math.PI / numBranches) * i ));
				g.drawLine( x, y, x2, y2 );
				draw(g, x2, y2, limit/3);
			}
		}
	}
}//end class