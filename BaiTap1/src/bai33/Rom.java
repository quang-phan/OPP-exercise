
package bai33;


public class Rom {
    private int[] a = {1000,900, 500, 400,100,90, 50, 40, 10, 9, 5, 4, 1};
    private String[] r = {"M","CM","D","CD","C","XC","L","XL","X","IX","V",
        "IV","I"};
    private int n = 0;
    private String s;

    public Rom() {
    }

    public Rom(String s) {
        this.s = s;
        chuyen();
    }

    public void setS(String s) {
        this.s = s;
        chuyen();
    }
    
    private void chuyen(){
        String x;
        s += '#';
        int z;
        for(int i = 0; i < s.length(); i++){
            x = ""+s.charAt(i);
            switch(x){
                case "C":{
                    if(s.charAt(i+1) == 'M' || s.charAt(i+1) == 'D'){
                        i++;
                        x += s.charAt(i);
                    }
                    break;
                }
                case "X":{
                    if(s.charAt(i+1) == 'C' || s.charAt(i+1) == 'L'){
                        i++;
                        x += s.charAt(i);
                    }
                    break;
                }
                case "I":{
                    if(s.charAt(i+1) == 'X' || s.charAt(i+1) == 'V'){
                        i++;
                        x += s.charAt(i);
                    }
                    break;
                }
            }
            z = search(x);
            if(z != -1) n += a[z];
        }
    }
    
    private int search(String x){
        for(int i = 0; i < r.length; i++) if(r[i].equals(x)) return i;
        return -1;
    }
    
    public void show(){
        System.out.println(n);
    }
    
    

    @Override
    public String toString() {
        return ""+n;
    }
}
