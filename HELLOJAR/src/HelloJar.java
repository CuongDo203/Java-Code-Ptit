import java.util.ArrayList;
import java.util.Scanner;

import view.InvoiceView;
import vn.edu.ptit.Invoice;
import vn.edu.ptit.Rule;
import vn.edu.ptit.Student;
import vn.edu.ptit.Subject;

public class HelloJar {
	public static void main(String[] args) {
        PaymentController pc = new PaymentController();
        //Output for test
        Invoice invoice = pc.getInvoice();
        InvoiceView.show(invoice);
    }
}

class PaymentController{
	public Invoice getInvoice() {
		
		Scanner sc = new Scanner(System.in);
		String code = sc.nextLine();
		String name = sc.nextLine();
		Student st = new Student(code, name);
		int soMonHoc = Integer.parseInt(sc.nextLine());
		ArrayList<Subject> lstMonHoc = new ArrayList<>();
		int tongSoTinChi = 0;
		for(int i = 1; i <= soMonHoc; i++) {
			String maMonHoc = sc.nextLine();
			String tenMonHoc = sc.nextLine();
			int soTinChi = Integer.parseInt(sc.nextLine());
			tongSoTinChi += soTinChi;
			Subject subject = new Subject(tenMonHoc, maMonHoc, soTinChi);
			lstMonHoc.add(subject);
		}
		String soQd = sc.nextLine();
		String tenQd = sc.nextLine();
		double soTien = Double.parseDouble(sc.nextLine());
		Rule rule = new Rule(soQd, tenQd, soTien);
		Invoice hoaDon = new Invoice(rule);
		hoaDon.setSt(st);
		hoaDon.setAlSubject(lstMonHoc);
		//hoaDon.setRule(rule);
		hoaDon.setAmount(tongSoTinChi*soTien);
		sc.close();
		return hoaDon;
	}
}

/*
 * 
B20DCCN001
Nguyễn Văn A
2
INT1155
Tin học cơ sở 2
2
INT1332
Lập trình hướng đối tượng
3
QD123
QD123 HP
550000
 * */
 