interface human {
  public String getName();

  public int getAge();

  public void print_info();
}

class passanger {
  int age;
  String name;

  public passanger(int pAge, String pName) {
    age = pAge;
    name = pName;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public void print_info() {
    System.out.print("mister " + name +
        " - " + Integer.toString(age) + " ");
  }
}

class driver {
  int age;
  String name;
  int experience;

  public driver(int pAge, String pName, int pExperience) {
    age = pAge;
    name = pName;
    experience = pExperience;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public int getExperience() {
    return experience;
  }

  public void print_info() {
    System.out.println("mister " + name +
        " - " + Integer.toString(age) + " - years of experience: " +
        Integer.toString(experience));
  }
}

abstract class car {
  driver employee;
  passanger[] clients;
  int index;
  final int n = 100;

  String model;
  String color;
  int year;

  int start_point, arrival_point;

  public abstract String makesSound();

  public driver getEmployee() {
    return employee;
  }

  public passanger[] getClients() {
    return clients;
  }

  public String getColor() {
    return color;
  }

  public String getModel() {
    return model;
  }

  public int getYear() {
    return year;
  }

  public void addDriver(driver d) {
    employee = d;
  }

  public boolean addPassenger(passanger p) {
    clients[index] = p;
    index++;
    return true;
  }

  public car(String pModel, String pColor, int pYear,
      int pstart_point, int parrival_point) {

    clients = new passanger[n];
    index = 0;

    model = pModel;
    color = pColor;
    year = pYear;

    start_point = pstart_point;
    arrival_point = parrival_point;
  }

  private int get_payment() {
    return arrival_point - start_point;
  }

  public void present_information() {
    employee.print_info();
    for (int i = 0; i < index; i++)
      clients[i].print_info();
    System.out.println(Integer.toString(get_payment()));
  }
}

class combustion extends car {
  public String makesSound() {
    return "a little";
  }

  public boolean addPassenger(passanger p) {
    if (index >= n)
      return false;
    clients[index] = p;
    index++;
    return true;
  }

  public combustion(String pModel, String pColor, int pYear,
      int pstart_point, int parrival_point) {
    super(pModel, pColor, pYear, pstart_point, parrival_point);
  }

  private int get_payment() {
    return 2 * (arrival_point - start_point);
  }

  public void present_information() {
    employee.print_info();
    for (int i = 0; i < index; i++)
      clients[i].print_info();
    System.out.println(Integer.toString(get_payment()));
  }
}

class electric extends car {
  public String makesSound() {
    return "Not whatsoever.";
  }

  public electric(String pModel, String pColor, int pYear,
      int pstart_point, int parrival_point) {
    super(pModel, pColor, pYear, pstart_point, parrival_point);
  }
}

class master {
  public static void main(String[] args) {
    electric e0 = new electric("bmw", "roz", 2018, 0, 1);
    electric e1 = new electric("ford", "albastra", 2017, 5, 6);

    combustion c0 = new combustion("dacia", "gri", 1000, 5, 6);
    combustion c1 = new combustion("pacia", "neagra", 2001, 5, 6);

    passanger p0 = new passanger(24, "petru");
    passanger p1 = new passanger(25, "bogdan");
    passanger p2 = new passanger(32, "cosmin");
    passanger p3 = new passanger(42, "andreea");

    passanger p4 = new passanger(52, "vlad");
    passanger p5 = new passanger(24, "denisa");
    passanger p6 = new passanger(25, "mircea");
    passanger p7 = new passanger(32, "costica");

    driver d0 = new driver(12, "vasile", 13);
    driver d1 = new driver(50, "ioniche", 20);
    driver d2 = new driver(32, "vasile", 1);
    driver d3 = new driver(41155, "calin", 2);

    e0.addDriver(d0);
    e0.addPassenger(p0);
    e0.addPassenger(p1);

    e1.addDriver(d1);
    e1.addPassenger(p2);
    e1.addPassenger(p3);

    c0.addDriver(d2);
    c0.addPassenger(p4);
    c0.addPassenger(p5);

    c1.addDriver(d3);
    c1.addPassenger(p6);
    c1.addPassenger(p7);

    e0.present_information();
    e1.present_information();
    c0.present_information();
    c1.present_information();
  }
}
