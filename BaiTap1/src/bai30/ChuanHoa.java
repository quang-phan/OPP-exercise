
package bai30;

public class ChuanHoa {
    private String s;

    public ChuanHoa(String s) {
        this.s = s;
    }

    public ChuanHoa() {
    }
    
    
    public String chuan(){
        String[] a = s.split(" ");
        String x = "";
        StringBuffer buffer;
        for (String string : a) {
            if(!string.isEmpty()){
                string = string.toLowerCase();
                buffer = new StringBuffer(string);
                string = string.toUpperCase();
                buffer.setCharAt(0, string.charAt(0));
                x += buffer.toString() + " ";
            }
        }
        return x;
    }
    
    public String chuan(String s){
        this.s = s;
        String[] a = s.split(" ");
        String x = "";
        StringBuffer buffer;
        for (String string : a) {
            if(!string.isEmpty()){
                string = string.toLowerCase();
                buffer = new StringBuffer(string);
                string = string.toUpperCase();
                buffer.setCharAt(0, string.charAt(0));
                x += buffer.toString() + " ";
            }
        }
        return x;
    }
}
