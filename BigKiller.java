

public class BigKiller extends KillerObj {
	public int SIZE;
    public static int INIT_POS_X = 0;
    public static int INIT_POS_Y = 0;
    public static int INIT_VEL_X = 0;
    public static int INIT_VEL_Y = 2;

	public BigKiller(int courtWidth, int courtHeight, int size) {
		super(INIT_VEL_X, INIT_VEL_Y, INIT_POS_X, INIT_POS_Y, size, size, courtWidth, courtHeight);
		INIT_POS_X += 50;
    	if(INIT_POS_X >= courtWidth){
    		INIT_POS_X = 0;
    	}
    	this.SIZE = size;
	}
    
	public int getSize(){
		return this.SIZE;
	}
	
	@Override
	public void resize(int factor) {
		this.SIZE = this.SIZE * factor;
      
	}
	

}
