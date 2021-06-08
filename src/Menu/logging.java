package Menu;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class logging{
	LogManager manage;
	Logger log;
	FileHandler filehandler;
	
	public logging(String filename) {
		try {
			manage = LogManager.getLogManager();
			log = manage.getLogger(Logger.GLOBAL_LOGGER_NAME);		
			filehandler = new FileHandler(filename,true);
			filehandler.setFormatter(new SimpleFormatter());
			log.addHandler(filehandler);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void Writelog(String str){	
		log.info(str);
	}
}
