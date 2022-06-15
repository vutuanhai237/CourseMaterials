package bai3;

public class NgayThang {

	private int year;
	private int month;
	private int day;
	public NgayThang()
	{
		this.year = 0;
		this.month = 0;
		this.day = 0;
	}
	public NgayThang(int _year, int _month, int _day)
	{
		this.year = _year;
		this.month = _month;
		this.day = _day;
	}
	
	public boolean LaNamNhuan(int year)
    {
        if (year % 4 != 0) return false;
        if (year % 100 != 0) return true;
        if (year % 400 != 0) return false;
        return true;
    }

    public int SoNgayTrongNam(int Nyear)
    {
        if (LaNamNhuan(year)) return 366;
        return (365);
    }

    public int SoNgayTruocNam(int year)
    {
        int TongSoNgayTruoc = 0;
        for (int i = 1; i < year; i += 1)
            TongSoNgayTruoc += SoNgayTrongNam(i);
        return TongSoNgayTruoc;
    }

    public int SoNgayTrongThang(int year, int month)
    {
        switch (month)
        {
            case 4:
            case 6:
            case 9:
            case 11: return 30;
            case 2:
                {
                    if (LaNamNhuan(month)) return 29;
                    return 28;
                }
            default: return 31;
        }
    }

    int SoNgayTruocThang(int year, int month)
    {
        int SoNgay=0;
        for (int i = 1; i < month; i += 1)
            SoNgay += SoNgayTrongThang(year, i);
        return SoNgay;
    }

    public int TongSoNgay(int year, int month, int day)
    {
        return SoNgayTruocNam(year) + SoNgayTruocThang(year, month) + day;
    }

    public int NgayTrongTuan(int Nam, int Thang, int Ngay)
    {
        switch (TongSoNgay(Nam,Thang,Ngay)%7)
        {
            case 0: return 7;
            case 1: return 8;
            case 2: return 2;
            case 3: return 3;
            case 4: return 4;
            case 5: return 5;
            default: return 6;
        }
    }
	
}
