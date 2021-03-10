import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class MidProjectLnT {
Scanner scan = new Scanner(System.in);
ArrayList<String> kodekaryawanArr = new ArrayList<>();
ArrayList<String> namakaryawanArr = new ArrayList<>();
ArrayList<String> jeniskelaminArr = new ArrayList<>();
ArrayList<String> jabatanArr = new ArrayList<>();
ArrayList<Double> gajiArr = new ArrayList<>();
ArrayList<Double> bonusArr = new ArrayList<>();
String nama = "";
String jeniskelamin = "";
String jabatan = "";
double bonusgaji = 0;
String id = "";
double gaji = 0;
int menu = 0;
	public MidProjectLnT() {
		do {
			System.out.println("PT. Mentol");
			System.out.println("1. Insert data karyawan");
			System.out.println("2. View data karyawan");
			System.out.println("3. Update data karyawan");
			System.out.println("4. Delete data karyawan");
			System.out.println("5. Exit");
			System.out.println(">>");
			try {
				menu = scan.nextInt();
			}catch (Exception e) {
				menu = -1;
			}scan.nextLine();
			
			switch (menu) {
			case 1 :
				insert();
				break;
				
			case 2 :
				view();
				break;
				
			case 3 :
				update();
				break;
				
			case 4 :
				delete();
				break;
			}
		}while (menu!=5);
	}

	private void insert() {
		int manager = 0;
		int admin = 0;
		int supervisor = 0;
		
		do {
			System.out.println("Input nama karyawan [>= 3]:");
			nama = scan.nextLine();
		}while (nama.length() < 3);
		
		do {
			System.out.println("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive):");
			jeniskelamin = scan.nextLine();
		}while (!jeniskelamin.equals("Laki-laki") &&
				!jeniskelamin.equals("Perempuan"));
		
		do {
			System.out.println("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive):");
			jabatan = scan.nextLine();
		}while (!jabatan.equals("Manager") &&
				!jabatan.equals("Supervisor") &&
				!jabatan.equals("Admin"));
		
		if (jabatan.equals("Manager")) {
			gaji = 8000000;
		}else if (jabatan.equals("Supervisor")) {
			gaji = 6000000;
		}else if (jabatan.equals("Admin")) {
			gaji = 4000000;
		}
		
		Random rand = new Random();
		
		id = "" + (char) (rand.nextInt(26)+65)+(char)(rand.nextInt(25)+65)+ "-"+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10);
		System.out.println("Berhasil menambahkan karyawan dengan id " + id);
		jabatanArr.add(jabatan);
		kodekaryawanArr.add(id);
		namakaryawanArr.add(nama);
		jeniskelaminArr.add(jeniskelamin);
		gajiArr.add(gaji);

   		   int Manager = 0;
		   int Supervisor = 0;
		   int Admin = 0;
		   
		   for (int i = 0; i < jabatanArr.size(); i++) {
		    if (jabatanArr.get(i).contains("Manager")) {
		     Manager += 1;
		    }
		    else if (jabatanArr.get(i).contains("Supervisor")) {
		     Supervisor += 1;
		    }
		    else if (jabatanArr.get(i).contains("Admin")) {
		     Admin += 1;
		    }
		   }
		   
		   if ((Manager - 1)/3 != 0 && (Manager - 1 ) % 3 == 0) {
		    System.out.print("Bonus Sebesar 10% Telah diberikan Kepada Karyawan Dengan ID: ");
		   int temp = (Manager - 1) / 3 * 3;
		   for (int i = 0; i < jabatanArr.size(); i++) {
		    if (jabatanArr.get(i).contains("Manager") && temp != 0) {
		     System.out.print(kodekaryawanArr.get(i) + " ");
		     gajiArr.set(i, gajiArr.get(i)+ gajiArr.get(i) * 0.1);
		     temp--;
		    }
		   }
		   System.out.println();
		   }
	}

	private void view() {
		sorting();
			 System.out.println("===========================================================================================================================");
			  System.out.printf("| %-4s | %-20s | %-30s | %-20s | %-15s | %-15s |\n", "No", "Kode Karyawan", "Nama Karyawan", "Jenis Kelamin", "Jabatan", "Gaji Karyawan");
			  System.out.println("===========================================================================================================================");
			  for (int i = 0; i < namakaryawanArr.size(); i++) {
			  System.out.printf("| %-4s | %-20s | %-30s | %-20s | %-15s | %-15s |\n", i + 1, kodekaryawanArr.get(i), namakaryawanArr.get(i), jeniskelaminArr.get(i), jabatanArr.get(i), gajiArr.get(i));
		  }
		  System.out.println("===========================================================================================================================\n");
		 }

	private void sorting() {
		for (int i = 0; i < namakaryawanArr.size() - 1; i++) {
			for (int j = 0; j < namakaryawanArr.size() - i - 1; j++) {
				if (namakaryawanArr.get(j).compareTo(namakaryawanArr.get(j + 1)) > 0) {
					
					String tempA = kodekaryawanArr.get(j);
					kodekaryawanArr.set(j, kodekaryawanArr.get(j + 1));
					kodekaryawanArr.set(j + 1, tempA);
					
					String tempB = namakaryawanArr.get(j);
					namakaryawanArr.set(j, namakaryawanArr.get(j + 1));
					namakaryawanArr.set(j + 1, tempB);
					
					String tempC = jeniskelaminArr.get(j);
					jeniskelaminArr.set(j, jeniskelaminArr.get(j + 1));
					jeniskelaminArr.set(j + 1, tempC);
					
					String tempD = jabatanArr.get(j);
					jabatanArr.set(j, jabatanArr.get(j + 1));
					jabatanArr.set(j + 1, tempD);
					
					Double tempE = gajiArr.get(j);
					gajiArr.set(j, gajiArr.get(j + 1));
					gajiArr.set(j + 1, tempE);
			}
		}
			
		}
		
	}

	private void update() {
	view();
	int update;
	do {
		System.out.println("Input angka dari list data yang ingin di update:");
	try {
		update = scan.nextInt();
	}catch (Exception e) {
		update = -1; 
	}scan.nextLine();
	
	}while (update < 1 || update > namakaryawanArr.size());
	
	do {
		System.out.println("Input nama karyawan [>= 3]:");
		nama = scan.nextLine();
	}while (nama.length() < 3);
	
	do {
		System.out.println("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive):");
		jeniskelamin = scan.nextLine();
	}while (!jeniskelamin.equals("Laki-laki") &&
			!jeniskelamin.equals("Perempuan"));
	
	do {
		System.out.println("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive):");
		jabatan = scan.nextLine();
	}while (!jabatan.equals("Manager") &&
			!jabatan.equals("Supervisor") &&
			!jabatan.equals("Admin"));
	
	if (jabatan.equals("Manager")) {
		gaji = 8000000;
	}else if (jabatan.equals("Supervisor")) {
		gaji = 6000000;
	}else if (jabatan.equals("Admin")) {
		gaji = 4000000;
	}
	
	Random rand = new Random();
	
	id = "" + (char) (rand.nextInt(26)+65)+(char)(rand.nextInt(25)+65)+ "-"+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10)+rand.nextInt(10);
	System.out.println("Berhasil menambahkan karyawan dengan id " + id);
	kodekaryawanArr.set(update-1, id);
	namakaryawanArr.set(update-1, nama);
	jeniskelaminArr.set(update-1, jeniskelamin);
	jabatanArr.set(update-1, jabatan);
	}

	private void delete() {
		view();
		int delete;
		do {
			System.out.println("Input angka dari list data yang ingin di delete:");
			try {
				delete = scan.nextInt();
			}catch (Exception e) {
			    delete = -1;
		}scan.nextLine();
		}while (delete < 1 || delete > namakaryawanArr.size());
		
		kodekaryawanArr.remove(delete-1);
		namakaryawanArr.remove(delete-1);
		jeniskelaminArr.remove(delete-1);
		jabatanArr.remove(delete-1);
		gajiArr.remove(delete-1);
		
	}

	public static void main(String[] args) {
		new MidProjectLnT();

	}

}
