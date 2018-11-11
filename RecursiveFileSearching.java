import java.io.File;

/**
 * Class Description:
 * @author Ian Bryan
 * @version 11/05/2018
 * 
 * This class examples the use of a linear and recursive search
 * for a file by name when it is provided a path to start looking in.
 */
public class RecursiveFileSearching {
	/*Class level data members*/

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(recursiveSearch(new File("p:\\"), "someFile.txt"));
	}

	/**
	 * @param path
	 * @param target
	 * @return Returns the location of a file given some location.
	 * Works recursively by moving all the way into a directory
	 * and moving up its hierarchy, then over into the next directory
	 * if one is available.
	 */
	public static String recursiveSearch(File path, String target) {
		String somePathName = "";
		if(path.isDirectory()) {
			for(File refs : path.listFiles()) {
				System.out.println("in the for-each::: " + refs);
				if(refs.isFile()) {
					if(refs.getName().equalsIgnoreCase(target)){
						somePathName = refs.getAbsolutePath();
						return somePathName;
					}
				}else if(refs.isDirectory()) {
					recursiveSearch(refs,target);
				}
			}
		}else {
			return "invalid path provided";
		}
		return somePathName;
	}//end method
}