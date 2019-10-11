public class Main {


    public static void main(String[] args) {
        try {
            IniFile iniFile = new IniFile("test.ini");
            iniFile.show();
            iniFile.showSections();
            float a = iniFile.getValueFromSection(float.class, "NCMD", "kek");
            System.out.println(a);
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}