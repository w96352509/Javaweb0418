package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ConnectionListener implements ServletContextListener {

	// Server 啟動時要執行的程式碼
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// DataBase 放置位置
		String db_path = "C:\\Users\\user\\git\\JavaWeb-20220418\\db";
		// DataBase 名稱
		String db_name = "webdb.db";
		// 建立 DataBase 連線參數
		String db_url = "jdbc:sqlite:" + db_path + "\\" + db_name;
		// DataBase 連線物件
		Connection conn = null;
		try {
			// 建立 driver(驅動)
			// Java JDBC 4.0一定版本可以不寫
			// jar 包取得 sql driver
			// 動態建立有利於更改版本更改("可變變數")
			Class.forName("org.sqlite.JDBC");
			// sqlite(無 username/password)
			conn = DriverManager.getConnection(db_url);
			// 將 conn 物件放到 context(Application) scope 中
			sce.getServletContext().setAttribute("conn", conn);
			System.out.println("已將 conn 物件放到 context(Application) scope 變數中");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	// Server 關閉時要執行的程式碼
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		Object connObj = sce.getServletContext().getAttribute("conn");
	    if(connObj !=null) {
	    	try {
	    		// 比對此物件是否為其他 class 的衍生
	    		//這是要測試某一物件 connObj 是否為某類別 (class)或其子類別 (subclass) 實例 (instance)，
	    		//或是 connObj 是不是某介面 (interface) 的實作。
				if(connObj instanceof Connection) {
					((Connection) connObj).close();
					System.out.println("conn物件 關閉");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	}

}
