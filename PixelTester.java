import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PixelTester extends JPanel {
	private static final long serialVersionUID = 1L;
	private PixelMaker pixelMaker;
	private File file;
	private BufferedImage image;
	private int x,y;
	
	public PixelTester(File file, int width) {
		this.file = file;
		pixelMaker = new PixelMaker(file, width, NES.NES_PALETTE);
		image = pixelMaker.getWriteImage();
		x = image.getWidth()*2;
		y = image.getHeight()*2;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon icon = new ImageIcon(image);
		Image img = icon.getImage();
		g.drawImage(img, 0, 0, x, y, null);
	}
	
	public static void main(String[] args){
		JFrame test = new JFrame("test");
		
		Scanner scan = new Scanner(System.in);
		File base;
		do {
			System.out.print("Enter a file name: ");
			base = new File(scan.nextLine());
		} while(!base.canRead());
		int width;
		while(true) {
			System.out.print("Enter a pixel width: ");
			try {
				width = scan.nextInt();
				break;
			} catch(InputMismatchException e){ }
		}
		
		PixelTester panel = new PixelTester(new File("pagemillview.jpg"), 6);
		System.out.print("Width: " + panel.image.getWidth() + "   Height: " + panel.image.getHeight());
		test.setSize(panel.x,panel.y);
		test.setLocation(0,0);
		test.setBackground(Color.BLACK);
		test.setContentPane(panel);
		test.setResizable(false);
		test.setVisible(true);
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}