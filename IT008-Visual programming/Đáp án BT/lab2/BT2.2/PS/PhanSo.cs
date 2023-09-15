using System;


namespace PS
{
    public class PhanSo : IComparable
    {
        protected int TuSo;
        protected int MauSo;

        public PhanSo(int TuSo, int MauSo)
        {
            this.TuSo = TuSo;
            this.MauSo = MauSo;
        }
        public PhanSo(int n)
        {
            this.TuSo = n;
            this.MauSo = 1;
        }
        public int Tu
        {
            get { return this.TuSo; }
            set { TuSo = value; }
        }
        public int Mau
        {
            get { return this.MauSo; }
            set { if (value != 0) MauSo = value; else MauSo = 1; }
        }

       public static implicit operator PhanSo(int n)
        {
            return new PhanSo(n);
        }
        public static explicit operator float (PhanSo ps)
        {
            return (float)ps.TuSo / ps.MauSo;
        }
        public int Ucln(int a, int b)
        {
            while (a != b)
            {
                if (a > b) a = a - b;
                else b = b - a;
            }
            return a;
        }
        public PhanSo RutGon()
        {
            int i = Ucln(this.TuSo, this.MauSo);
            this.TuSo = this.TuSo / i;
            this.MauSo = this.MauSo / i;
            return new PhanSo(this.TuSo, this.MauSo);
        }
        
       

        public static bool operator ==(PhanSo ps1, PhanSo ps2)
        {
            if (ps1.TuSo * ps2.MauSo - ps2.TuSo * ps1.MauSo == 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        public static bool operator !=(PhanSo ps1, PhanSo ps2)
        {
            return !(ps1 == ps2);
        }
        public static bool operator >(PhanSo ps1, PhanSo ps2)
        {
            if (ps1.TuSo * ps2.MauSo - ps2.TuSo * ps1.MauSo > 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        public static bool operator <(PhanSo ps1, PhanSo ps2)
        {
            return !(ps1 > ps2);
        }
        public static PhanSo operator +(PhanSo ps1, PhanSo ps2)
        {
            PhanSo ketqua = new PhanSo(ps1.TuSo * ps2.MauSo + ps2.TuSo * ps1.MauSo, ps1.MauSo * ps2.MauSo);
            return ketqua.RutGon();
        }
        public static PhanSo operator -(PhanSo ps1, PhanSo ps2)
        {
            PhanSo ketqua = new PhanSo(ps1.TuSo * ps2.MauSo - ps2.TuSo * ps1.MauSo, ps1.MauSo * ps2.MauSo);
            return ketqua.RutGon();
        }
        public static PhanSo operator *(PhanSo ps1, PhanSo ps2)
        {
            PhanSo ketqua = new PhanSo(ps1.TuSo * ps2.TuSo, ps1.MauSo * ps2.MauSo);
            return ketqua.RutGon();
        }
        public static PhanSo operator /(PhanSo ps1, PhanSo ps2)
        {
            PhanSo ketqua = new PhanSo(ps1.TuSo * ps2.MauSo, ps1.MauSo * ps2.TuSo);
            return ketqua.RutGon();
        }
        public override bool Equals(object obj)
        {
            if (!(obj is PhanSo))
            {
                return false;
            }
            else
            {
                return (this == (PhanSo)obj);
            }
        }
        public int CompareTo(PhanSo ps)
        {
            if ((float)this > (double)ps)
            {
                return 1;
            }
            if ((float)this < (double)ps)
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }
        public override string ToString()
        {
            string s = TuSo.ToString() + "/" + MauSo.ToString();
            return s;
        }
        public int CompareTo(object obj)
        {
            PhanSo ps = (PhanSo)obj;
            return this.CompareTo(ps);
        }
    }
}
