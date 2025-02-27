interface human
{
  public String getName();
  public int getAge();
}

class passanger
{
  int age;
  String name;
  public passanger(int pAge, String pName)
  {
    age = pAge;
    name = pName;
  }
  public String getName()
  {
    return name;
  }
  public int getAge()
  {
    return age;
  }
}

class driver
{
  int age;
  String name;
  int experience;
  public driver(int pAge, String pName, int pExperience)
  {
    age = pAge;
    name = pName;
    experience = pExperience;
  }
  public String getName()
  {
    return name;
  }
  public int getAge()
  {
    return age;
  }
  public int getExperience()
  {
    return experience;
  }
}

abstract class car
{
  driver employee;
  passanger[] clients;
  int index;
  int n;

  String model;
  String color;
  int year;
  public abstract String makesSound();

  public driver getEmployee()
  {
    return employee;
  }

  public passanger[] getClients()
  {
    return clients;
  }

  public String getColor()
  {
    return color;
  }

  public String getModel()
  {
    return model;
  }

  public int getYear()
  {
    return year;
  }

  public boolean addPassenger(passanger p)
  {
    clients[index]=p;
    index++;
    return true;
  }

  
}

class combustion extends car
{
  public String makesSound()
  {
    return "a little";
  }

  public boolean addPassenger(passanger p)
  {
    if (index >= n) return false;
    clients[index]=p;
    index++;
    return true;
  }
}

class electric extends car
{
  public String makesSound()
  {
    return "Not whatsoever.";
  }
}