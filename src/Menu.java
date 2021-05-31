import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		MoneyManage manage = loadObj("moneymanage.ser");
		if(manage == null) {
			manage = new MoneyManage(input);
		}
		menuselect(input,manage);
		saveObj(manage,"moneymanage.ser");
		
	}
	
	public static void menuselect(Scanner input,MoneyManage manage) {	
		logging log = new logging("log.txt");	
		int num = 0;
		while(num != 5) {
			System.out.println("1.관리 항목 추가");
			System.out.println("2.목록 수정");
			System.out.println("3.목록 삭제");
			System.out.println("4.목록 확인");
			System.out.println("5.프로그램 종료");
			try {
				num = input.nextInt();
				switch(num){
				case 1:
					manage.add();
					log.Writelog("Add money list");
					continue;
				case 2:
					manage.edit();	
					log.Writelog("Edit money list");	
					continue;
				case 3:
					manage.delete();
					log.Writelog("Delete money list");
					continue;
				case 4:
					manage.view();
					log.Writelog("View money list");
					continue;
				case 5:
					manage.Exit();
					log.Writelog("Exit program");
					break;
				}
			}catch(InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
				input = new Scanner(System.in);
				num = 0;
			}
			
		}
	}
	
	public static MoneyManage loadObj(String filename) {		
		MoneyManage manage = null;
		try {
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream obj = new ObjectInputStream(file);
			manage = (MoneyManage)obj.readObject();			
			obj.close();
			file.close();
		}catch(FileNotFoundException e) {
			return manage;
		}catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return manage;
	}
	
	public static void saveObj(MoneyManage manage,String filename) {
		try {
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream obj = new ObjectOutputStream(file);
			obj.writeObject(manage);
			obj.close();
			file.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
