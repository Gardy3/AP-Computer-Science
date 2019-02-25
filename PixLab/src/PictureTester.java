/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  public static void testZeroRed()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroRed();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  public static void convertToBlackAndWhite(){
	  Picture pic = new Picture("femaleLionAndHall.jpg");
	  pic.explore();
	  Pixel[][] pixelArray = pic.getPixels2D();
	  for(Pixel[] rowArray : pixelArray){
		  for(Pixel pixObj : rowArray){
			  int average = (int)pixObj.getAverage();
			  pixObj.setBlue(average);
			  pixObj.setRed(average);
			  pixObj.setGreen(average);
		  }
	  }
	  pic.explore();
  }
  
  public static void adjustBrightness(double factor){
	  Picture pic = new Picture("koala.jpg");
	  pic.explore();
	  Pixel[][] pixelArray = pic.getPixels2D();
	  for(Pixel[] rowArray : pixelArray){
		  for(Pixel pixObj : rowArray){
			  double newFactor = factor;
			  int brightest = Math.max(pixObj.getBlue(), pixObj.getRed());
			  brightest = Math.max(brightest, pixObj.getGreen());
			  if(brightest * factor > 255){
				  newFactor = 255.0/brightest;
			  }
			  pixObj.setBlue((int)(newFactor * pixObj.getBlue()));
			  pixObj.setRed((int)(newFactor * pixObj.getRed()));
			  pixObj.setGreen((int)(newFactor * pixObj.getGreen()));
		  }
	  }
	  pic.explore();
  }
  
  public static void verticalMirror(){
	  Picture pic = new Picture("redMotorcycle.jpg");
	  pic.explore();
	  Pixel[][] pixArray = pic.getPixels2D();
	  for(int row = 0; row < pixArray.length; row++){
		  for(int column = 0; column < pixArray[row].length/2; column++){
			  pixArray[row][pixArray[row].length - column - 1].setBlue(pixArray[row][column].getBlue());
			  pixArray[row][pixArray[row].length - column - 1].setRed(pixArray[row][column].getRed());
			  pixArray[row][pixArray[row].length - column - 1].setGreen(pixArray[row][column].getGreen());
			  pixArray[row][pixArray[row].length - column - 1].setAlpha(pixArray[row][column].getAlpha());
		  }
	  }
	  pic.explore();
  }
  
  public static void horizontalMirror(){
	  Picture pic = new Picture("redMotorcycle.jpg");
	  pic.explore();
	  Pixel[][] pixArray = pic.getPixels2D();
	  for(int row = 0; row < pixArray.length / 2; row++){
		  for(int column = 0; column < pixArray[row].length; column++){
			  
		  }
	  }
	  pic.explore();
  }
  
  public static void flipHorizontal(){
	  Picture pic1 = new Picture("butterfly1.jpg");
	  Picture pic2 = new Picture("butterfly1.jpg");
	  pic1.explore();
	  Pixel[][] pixels1 = pic1.getPixels2D();
	  Pixel[][] pixels2 = pic2.getPixels2D();
	  for(int row = 0; row < pixels1.length; row++){
		  for(int column = 0; column < pixels1[row].length; column++){
			  pixels2[row][pixels2[row].length - column - 1].setBlue(pixels1[row][column].getBlue());
			  pixels2[row][pixels2[row].length - column - 1].setRed(pixels1[row][column].getRed());
			  pixels2[row][pixels2[row].length - column - 1].setGreen(pixels1[row][column].getGreen());
			  pixels2[row][pixels2[row].length - column - 1].setAlpha(pixels1[row][column].getAlpha());
		  }
	  }
	  pic2.explore();
  }
  public static void flipVertical(){
	  Picture pic1 = new Picture("butterfly1.jpg");
	  Picture pic2 = new Picture("butterfly1.jpg");
	  pic1.explore();
	  Pixel[][] pixels1 = pic1.getPixels2D();
	  Pixel[][] pixels2 = pic2.getPixels2D();
	  for(int row = 0; row < pixels1.length; row++){
		  for(int column = 0; column < pixels2[row].length; column++){
			  pixels2[pixels2.length - row - 1][column].setBlue(pixels1[row][column].getBlue());
			  pixels2[pixels2.length - row - 1][column].setRed(pixels1[row][column].getRed());
			  pixels2[pixels2.length - row - 1][column].setGreen(pixels1[row][column].getGreen());
			  pixels2[pixels2.length - row - 1][column].setAlpha(pixels1[row][column].getAlpha());
	
		  }
	  }
	  pic2.explore();
	  
  }
  
  public static void diagonalMirror(){
	  Picture pic1 = new Picture("butterfly1.jpg");
	  pic1.explore();
	  Pixel[][] pixels = pic1.getPixels2D();
	  double slope = -(double)pixels.length/pixels[0].length;
	  for(int row = 0; row < pixels.length; row++){
		  for(int column = 0; column < pixels[row].length; column++){
			  if((pixels.length - row) < slope * column + pixels.length){
				  pixels[pixels.length - row][pixels[row].length - column - 1].setBlue(pixels[row][column].getBlue());
				  pixels[pixels.length - row][pixels[row].length - column - 1].setRed(pixels[row][column].getRed());
				  pixels[pixels.length - row][pixels[row].length - column - 1].setGreen(pixels[row][column].getGreen());
				  pixels[pixels.length - row][pixels[row].length - column - 1].setAlpha(pixels[row][column].getAlpha());
			  }
		  }
	  }
	  pic1.explore();
	  
  }
  
  public static void repairTemple(){
	  Picture pic = new Picture("temple.jpg");
	  pic.explore();
	  Pixel[][] pixArray = pic.getPixels2D();
	  for(int row = 27; row <= 96; row++){
		  for(int column = 13; column <= 275; column++){
			  pixArray[row][552 - column].setRed(pixArray[row][column].getRed());
			  pixArray[row][552 - column].setGreen(pixArray[row][column].getGreen());
			  pixArray[row][552 - column].setBlue(pixArray[row][column].getBlue());
			  pixArray[row][552 - column].setAlpha(pixArray[row][column].getAlpha());
		  }
	  }
	  pic.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
	//testZeroRed();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
	//convertToBlackAndWhite();
	//adjustBrightness(6);
	  //verticalMirror();
	  //horizontalMirror();
	 //flipHorizontal();
	  //flipVertical()
	  //diagonalMirror();
	  //repairTemple();
	  testCollage();
  }
}