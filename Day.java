public class Day implements Cloneable, Comparable<Day>{
	 
	private int year;
	private int month;
	private int day;

    private static final String MonthNames = "JanFebMarAprMayJunJulAugSepOctNovDec";
	
	//Constructor
	public Day(String sDay) {
        set(sDay);
    }
    public void set(String sDay) {
        String[] sDayParts = sDay.split("-");
        day = Integer.parseInt(sDayParts[0]);
        month = MonthNames.indexOf(sDayParts[1]) / 3 + 1;
        year = Integer.parseInt(sDayParts[2]);
    }
	
	// check if a given year is a leap year
	static public boolean isLeapYear(int y)
	{
		if (y%400==0)
			return true;
		else if (y%100==0)
			return false;
		else if (y%4==0)
			return true;
		else
			return false;
	}
	
	// check if y,m,d valid
	static public boolean valid(int y, int m, int d)
	{
		if (m<1 || m>12 || d<1) return false;
		switch(m){
			case 1: case 3: case 5: case 7:
			case 8: case 10: case 12:
					 return d<=31; 
			case 4: case 6: case 9: case 11:
					 return d<=30; 
			case 2:
					 if (isLeapYear(y))
						 return d<=29; 
					 else
						 return d<=28; 
		}
		return false;
	}

	// Return a string for the day like dd MMM yyyy
	@Override
    public String toString() {
        return day + "-" + MonthNames.substring((month-1)*3, (month)*3) + "-" + year;
    }

    @Override
    public Day clone() {
        Day copy = null;
        try {
            copy = (Day) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return copy;
    }

	@Override
	public int hashCode() {
		return year * 10000 + month * 100 + day;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (this.getClass() != obj.getClass()) return false;
		Day another = (Day) obj;
		return year == another.year && month == another.month && day == another.day;
	}

	@Override
	public int compareTo(Day another) {
		if (year != another.year) return year - another.year;
		if (month != another.month) return month - another.month;
		return day - another.day;
	}


}