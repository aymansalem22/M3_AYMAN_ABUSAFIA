package entity;

public class test {

	public static void main(String[] args) {
		
		Address adrees1=new Address("rio escudo", 3933,"palestine");
		adrees1.setId(1l);
	User user=new User("ali", "salm", 33, "dffd", "dfd", "ssd", "ww", adrees1);
	System.out.println(user.toString());
	}

}
