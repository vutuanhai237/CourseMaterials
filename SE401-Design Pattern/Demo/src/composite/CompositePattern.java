package composite;


class Client {
    public static void main(String[] args) {
        Composite cityHCM = new Composite("TP.HCM");
        Leaf district1 = new Leaf("Quận 1");
        Leaf districtThuDuc = new Leaf("Quận Thủ Đức");
        cityHCM.addComponent(district1);
        cityHCM.addComponent(districtThuDuc);
        cityHCM.removeComponent(district1);

        Composite cityHaNoi = new Composite("Hà Nội");
        cityHaNoi.addComponent(new Leaf("Quận Hồ Tây"));

        Composite countryVN = new Composite("Việt Nam");
        countryVN.addComponent(cityHaNoi);
        countryVN.addComponent(cityHCM);

        System.out.println(countryVN.toString());
    }
}