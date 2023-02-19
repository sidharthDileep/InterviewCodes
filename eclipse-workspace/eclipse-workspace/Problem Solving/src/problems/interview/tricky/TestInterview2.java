package problems.interview.tricky;

public class TestInterview2 {

	public static void main(String[] args) {
		Tester tester = new Tester();
		tester.get();

		// OuterClass.InnerClass inner = new OuterClass.InnerClass();
		OuterClass outer = new OuterClass();

		Users.VipUsers vip = new Users.VipUsers();

		// Users.NormalUsers nu = new Users.NormalUsers();

		Users users = new Users();
		Users.NormalUsers nu = users.new NormalUsers();
		//Users.NormalUsers nu2 = new Users.NormalUsers();
	}

}

class OuterClass {
	class InnerClass {
		public void foo() {
			System.out.println("Inner class");
		}
	}
}

class Users {
	static class VipUsers {
		public void displayVipUsers() {
			System.out.println("Welcome Vip User");
		}
	}

	class NormalUsers {
		public void displayNormalUsers() {
			System.out.println("Welcome Normal User");
		}
	}
}