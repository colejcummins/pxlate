import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PixelMaker {
	private Color[] palette;
	private int pixelSize, newWidth, newHeight;
	private BufferedImage readImage, writeImage;
	
	public PixelMaker(File readFile, int pixelSize, Color[] palette) {
		this.pixelSize = pixelSize;
		this.palette = palette;
		try {
			readImage = ImageIO.read(readFile);
		} catch (IOException e) {
			System.out.println("Could not read file");
		} 
		newWidth = (int)readImage.getWidth()/pixelSize;
		newHeight = (int)readImage.getHeight()/pixelSize;
		writeImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_3BYTE_BGR);
		drawBufferedImage();
		File out = new File(readFile.getName().substring(0,readFile.getName().length()-3) +"pxl.png");
		try {
			ImageIO.write(writeImage,"png",out);
		} catch(IOException e) {
			System.out.println("Could not write file");
		}
	}
	
	public void drawBufferedImage() {
		for(int i = 0; i<newWidth; i++) {
			for(int j = 0; j<newHeight; j++) {
				Color c = getOneSquare(i*pixelSize,j*pixelSize);
				writeImage.setRGB(i,j,c.getRGB());
			}
		}
	}
	
	public Color getOneSquare(int x, int y) {
		int redAverage = 0;
		int greenAverage = 0;
		int blueAverage = 0;
		int sqr = (int)Math.pow(pixelSize, 2);
		for(int k = x; k<(x+pixelSize);k++) {
			for(int h = y; h<(y+pixelSize); h++) {
				int rgb = readImage.getRGB(k, h);
				redAverage += ((rgb & 0x00ff0000) >> 16)/sqr;
				greenAverage += ((rgb & 0x0000ff00) >> 8)/sqr;
				blueAverage += (rgb & 0x000000ff)/sqr;
			}
		}
		return convertToPalette(new Color(redAverage, greenAverage, blueAverage));
	}
	
	public Color convertToPalette(Color c) {
		double shortDist = Double.MAX_VALUE;
		double dist = 0.0;
		Color save = Color.black;
		for(int i = 0; i<palette.length; i++) {
			Color c2 = palette[i];
			dist = Math.sqrt(Math.pow(c.getRed()-c2.getRed(),2)+Math.pow(c.getGreen()-c2.getGreen(),2)
					+ Math.pow(c.getBlue()-c2.getBlue(),2));
			if(dist<shortDist) {
				shortDist = dist;
				save = c2;
			}
		}
		return save;
	}
	
	public BufferedImage getWriteImage() {
		return writeImage;
	}
	
	public BufferedImage getReadImage() {
		return readImage;
	}
	
	public int getPixelSize() {
		return pixelSize;
	}
}