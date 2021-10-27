package com.testingshastra.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import com.testingshastraa.keywords.UIkeywords;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TestListner implements ITestListener {
	private static final Logger LOG = Logger.getLogger(TestListner.class);

	@Override

	public void onTestFailure(ITestResult result) {

		AShot ashot = new AShot();
		LOG.info("Test failed ,Taking screenshot");
		ashot.shootingStrategy(ShootingStrategies.viewportPasting(200));
		Screenshot sc = ashot.takeScreenshot(UIkeywords.getInstance().driver);
		BufferedImage img = sc.getImage();
		String dir = System.getProperty("user.dir");
		{
			try {
				ImageIO.write(img, "png", new File(dir + "Screenshots/" + result.getName() + ".png"));
				LOG.info("Scrrenshot is captured Successfully");
			} catch (IOException e) {
				LOG.info("unable to take scrrenshot");

				e.printStackTrace();
			}
		}
	}
}