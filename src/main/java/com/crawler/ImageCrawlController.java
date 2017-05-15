package com.crawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class ImageCrawlController {
	 private static final Logger logger = LoggerFactory.getLogger(ImageCrawlController.class);

	    public static void main(String[] args) throws Exception {
//	        if (args.length < 3) {
//	            logger.info("Needed parameters: ");
//	            logger.info("\t rootFolder (it will contain intermediate crawl data)");
//	            logger.info("\t numberOfCralwers (number of concurrent threads)");
//	            logger.info("\t storageFolder (a folder for storing downloaded images)");
//	            return;
//	        }

	        String rootFolder = "E:/jiandan/gifroot";
	        int numberOfCrawlers = 5;
	        String storageFolder = "E:/jiandan/gifnew/1416";

	        CrawlConfig config = new CrawlConfig();

	        config.setCrawlStorageFolder(rootFolder);


	        config.setIncludeBinaryContentInCrawling(true);

	        String[] crawlDomains = new String[200];
//	        String[] crawlDomains ={"http://m.yaoqmhw.com/snmh/1416.html"};
	        for(int i=1; i<=40; i++) {
	        	crawlDomains[i-1] ="http://m.yaoqmhw.com/snmh/1416X_" + i + ".html";
	        }

	        PageFetcher pageFetcher = new PageFetcher(config);
	        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
	        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
	        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
	        for (String domain : crawlDomains) {
	            controller.addSeed(domain);
	        }
	        ImageCrawler.configure(crawlDomains, storageFolder);
	        controller.start(ImageCrawler.class, numberOfCrawlers);
	        controller.waitUntilFinish();
	    }
}
