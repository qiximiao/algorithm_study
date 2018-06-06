public class LCS2 {

    public void hehe(){
        String arr1="jianghu";
        String arr2="anghuniu";
        int x=arr1.length();
        int y=arr2.length();
        int[][] opt=new int[x+1][y+1];//两侧皆0
        for(int i=1;i<=x;i++){
            for(int j=1;j<=y;j++){
                if(arr1.charAt(i-1)==arr2.charAt(j-1)){
                    opt[i][j]=opt[i-1][j-1]+1;
                }else{
                    opt[i][j]=Math.max(opt[i][j-1],opt[i-1][j]);
                }
            }
        }
        //[x+1][y+1]为最长串值
        //从最后反推结果
        int i=x;
        int j=y;

        StringBuffer sb=new StringBuffer();

        while(0!=i&&0!=j){
            if(arr1.charAt(i-1)==arr2.charAt(j-1)){

            }
        }

    }
}
