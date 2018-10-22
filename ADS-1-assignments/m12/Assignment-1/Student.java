class Student {
	private String name;
	private String dob;
	private int sub1;
	private int sub2;
	private int sub3;
	private int total;
	private String cat;
	private String inc = "n";
	Student(String name, String dob, int sub1, int sub2, int sub3, String cat) {
		this.name = name;
		this.sub1 = sub1;
		this.sub2 = sub2;
		this.sub3 = sub3;
		this.total = sub1 + sub2 + sub3;
		this.cat = cat;
		// System.out.println(name);
	}

	public String getName() {
		return name;
	}
	public String getDoB() {
		return dob;
	}
	public String getCat() {
		return cat;
	}
	public int getTotal() {
		return total;
	}
	public int getSub3() {
		return sub3;
	}
	public int getSub2() {
		return sub2;
	}
	public void setInc(String s) {
		inc = s;
	}
	public String getInc() {
		return inc;
	}
}